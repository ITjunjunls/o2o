package com.imooc.o2o.dao.split;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author itjunjun  2021/1/11 21:44
 */
public class DynamicDataSourceHolder {

    private static Logger logger = LoggerFactory.getLogger(DynamicDataSourceHolder.class);
    private static ThreadLocal<String> contextHolder = new ThreadLocal<String>();
    public static final String DB_MASTER = "master";
    public static final String DB_SLAVE = "slave";

    //获取线程的db type
    public static String getDbType() {
        String db = contextHolder.get();
        if (db == null) {
            db = DB_MASTER;
        }
        return db;
    }

    //设置线程的DB type
    public static void setDbType(String str) {
        logger.debug("所使用的过数据源为:" + str);
        contextHolder.set(str);
    }

    //清理连接类型
    public static void clearDBType() {
        contextHolder.remove();
    }
}
