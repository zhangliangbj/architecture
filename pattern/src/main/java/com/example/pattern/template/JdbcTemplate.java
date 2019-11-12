package com.example.pattern.template;

import javax.sql.DataSource;
import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangliang
 * @date 2019/11/12 18:50
 */
public class JdbcTemplate {

    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource){
        this.dataSource = dataSource;
    }

    private Connection getConnection() throws  SQLException{
        return this.dataSource.getConnection();
    }

    private PreparedStatement createPreparedStatement(Connection conn,String sql) throws SQLException{
        return conn.prepareStatement(sql);
    }

    private ResultSet executeQuery(PreparedStatement psmt,Object[] values) throws SQLException{
        for (int i = 0; i < values.length ; i++) {
            psmt.setObject(i,values[i]);
        }
        return psmt.executeQuery();
    }

    private void closeStatement(Statement statement) throws SQLException{
        statement.close();
    }

    private void closeResult(ResultSet resultSet) throws SQLException{
        resultSet.close();
    }

    private void closeConnection(Connection connection) throws SQLException{
        connection.close();
    }

    private List<?> parseResultSet(ResultSet rs,RowMapper rowMapper) throws Exception{
        List<Object> result = new ArrayList<Object>();
        int rowNum = 1;
        while (rs.next()){
            result.add(rowMapper.maoRow(rs,rowNum ++));
        }
        return result;
    }

    public List<?> executeQuery(String sql,RowMapper<?> rowMapper,Object[] values){
        try {
            //1.获取链接
            Connection conn = this.getConnection();
            //2.创建语句集
            PreparedStatement pstmt = this.createPreparedStatement(conn,sql);
            //3.执行语句集，并获得结果集
            ResultSet rs = this.executeQuery(pstmt,values);
            //4.解析语句集
            List<?> result = this.parseResultSet(rs,rowMapper);
            //5.关闭结果集
            this.closeResult(rs);
            //6.关闭语句集
            this.closeStatement(pstmt);
            //7.关闭链接
            this.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
