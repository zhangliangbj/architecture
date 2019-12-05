package com.example.spring_source_code.helper;

import java.sql.Connection;

/**
 * @author zhangliang
 * @date 2019/11/27 17:05
 */
public class Test {

    dataSource.getConnection().createStatement();

    //事务的回滚
    dataSource.getConnection().rollback();

    //默认的话是自动提交
    dataSource.getConnection().setAutoCommit(false);

    //只读事务
    dataSource.getConnection().setReadOnly(true);

    //事务的提交
    dataSource.getConnection().commit();

    Connection



}
