package com.example.pattern.template.dao;

import com.example.pattern.template.JdbcTemplate;
import com.example.pattern.template.RowMapper;
import com.example.pattern.template.entity.Member;

import java.sql.ResultSet;
import java.util.List;

/**
 * @author zhangliang
 * @date 2019/11/12 19:57
 */
public class MemberDao {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(null);

    public List<?> query(){
        String sql = "select * from t_member";
        return jdbcTemplate.executeQuery(sql, new RowMapper<Member>() {
            @Override
            public Member maoRow(ResultSet rs, int rowNum) throws Exception {
                Member member = new Member();
                member.setName("");
                member.setAddre("");
                member.setPhone("");
                member.setSex("");
                return member;
            }
        },null);
    }

}
