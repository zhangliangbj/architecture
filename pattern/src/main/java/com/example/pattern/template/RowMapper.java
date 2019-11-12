package com.example.pattern.template;

import java.sql.ResultSet;

/**
 * @author zhangliang
 * @date 2019/11/12 19:07
 */
public interface RowMapper<T> {

    public T maoRow(ResultSet rs,int rowNum) throws Exception;

}
