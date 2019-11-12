package com.example.pattern.template;

import com.example.pattern.template.dao.MemberDao;

/**
 * @author zhangliang
 * @date 2019/11/12 20:07
 */
public class MemberDaoTest {

    public static void main(String[] args) {
        MemberDao memberDao = new MemberDao();
        memberDao.query();
    }
}
