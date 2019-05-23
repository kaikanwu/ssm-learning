package com.kk.learn.ssm.chapter3.controller;

import com.kk.learn.ssm.chapter3.mapper.RoleMapper;
import com.kk.learn.ssm.chapter3.pojo.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author kaikanwu
 * @date 5/22/2019
 */
public class BaseController {


    public static void main(String[] args) {

        // 通过 XML 构建 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = null;
        String resource = "mybatis-config.xml";
        InputStream inputStream;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // SqlSession 事务控制伪代码
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            // some code
            sqlSession.commit();
        } catch (Exception ex) {
            sqlSession.rollback();
        }finally {
            // 关闭资源
            if (sqlSession != null) {
                sqlSession.close();
            }
        }



        // 方法1： SqlSession 直接发送 SQL ；
        // Role role = (Role) sqlSession.selectOne("com.kk.learn.ssm.chapter3.mapper.RoleMapper.getRole", 1L); 如果 MyBatis 中只有一个 id 为 getRole 的 SQL， 可以简写
        Role role = (Role) sqlSession.selectOne("getRole", 1L);

        // 方法2：用 SqlSession 获取 Mapper 接口发送 SQL
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
        Role role1 = roleMapper.getRole(1L);

    }
}
