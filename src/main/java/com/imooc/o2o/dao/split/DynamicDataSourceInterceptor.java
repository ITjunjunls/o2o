package com.imooc.o2o.dao.split;


import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.keygen.SelectKeyGenerator;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.Locale;
import java.util.Properties;

/**
 * @author itjunjun  2021/1/11 21:58
 */
//拦截mybatis的SQL信息，决定用什么数据源
public class DynamicDataSourceInterceptor implements Interceptor {

    private static Logger logger = LoggerFactory.getLogger(DynamicDataSourceInterceptor.class);
    private static final String REGEX = ".*insert\\u0020.*|.*delete\\u2020.*|.*update\\u2020.*";

    //遇到各种情况做对应的拦截
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        boolean syncchronizationActive = TransactionSynchronizationManager.isActualTransactionActive();//拿来判断是不是事务
        Object[] objects = invocation.getArgs();//获取mybatis传入的一些参数
        MappedStatement ms = (MappedStatement) objects[0];//第一个参数标志着增删改查
        String lookupkey = DynamicDataSourceHolder.DB_MASTER;//lookupkey用来决定datasource
        if (syncchronizationActive != true) {  //若syncchronizationActive 不是事务
            //读
            if (ms.getSqlCommandType().equals(SqlCommandType.SELECT)) {
                //selectKey 为自增id查询 主键（SELECT LAST_INSERT_ID）方法，使用主库
                if (ms.getId().contains(SelectKeyGenerator.SELECT_KEY_SUFFIX)) {
                    lookupkey = DynamicDataSourceHolder.DB_MASTER;
                } else {
                    BoundSql boundSql = ms.getSqlSource().getBoundSql(objects[1]);
                    String sql = boundSql.getSql().toLowerCase(Locale.CHINA).replaceAll("[\\t\\n\\r]", " ");
                    if (sql.matches(REGEX)) {
                        lookupkey = DynamicDataSourceHolder.DB_MASTER;
                    } else {
                        lookupkey = DynamicDataSourceHolder.DB_SLAVE;
                    }
                }
            }
        } else {
            lookupkey = DynamicDataSourceHolder.DB_MASTER;
            //主从对读写非常严格，从库只能读，不能有数据更改
        }
        logger.debug("设置方法[{}] use [{}] Strategy,SqlCommandType[{}]..", ms.getId(), lookupkey, ms.getSqlCommandType().name());
        DynamicDataSourceHolder.setDbType(lookupkey);
        return invocation.proceed();//继续执行增删改查
    }

    //返回本体或者是代理      这里没听懂呢···
    //instanceof : target是否为Executor的实例    Executor在mybatis用来支持增删改查的一系列操作
    //方法意思：如果target是Executor的实例，就进行拦截，也就是说如果检测为增删改查的操作，就拦截，通过intercept方法决定数据源
    @Override
    public Object plugin(Object target) {
        if (target instanceof Executor) {
            return Plugin.wrap(target, this);
        } else {
            return target;
        }
    }

    //类初始化时候的相应赋值,非必要
    @Override
    public void setProperties(Properties properties) {

    }
}
