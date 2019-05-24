package com.kk.learn.ssm.chapter3.main;

import com.kk.learn.ssm.chapter3.mapper.RoleMapper;
import com.kk.learn.ssm.chapter3.pojo.Role;
import com.kk.learn.ssm.chapter3.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

/**
 * @author kaikanwu
 * @date 5/23/2019
 */
public class Chapter3Main {
    public static void main(String[] args) {
        Logger log = Logger.getLogger(Chapter3Main.class);
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = roleMapper.getRole(2L);
            log.info(role.getRoleName());
            System.err.println(role.getRoleName());
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
