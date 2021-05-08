package com.imooc.o2o.util;

/**
 * @author itjunjun  2021/1/17 9:56
 */
public class PageCalculator {
    /**
     * 这个方法的意思是，对第几行开始选取多少条数据进行处理
     * 例如pageIndex为1，大于0，则（pageIndex-1）*pageSize等于0，最终意思就是从第0行开始选取pageSize行数据，也就是一夜pageSize条数据
     * 如果pageIndex为2，大于0，则（pageIndex-1）*pageSize等于pageSize，最终意思就是从pageSize开始选取pageSize行数据
     * 举例子，pageIndex=2，pageSize=5，这样就是从5到9，第二页的数据
     *
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public static int calculatorRowIndex(int pageIndex, int pageSize) {
        return (pageIndex > 0) ? (pageIndex - 1) * pageSize : 0;
    }
}
