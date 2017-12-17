package com.dim.beginspring.test;

import com.dim.beginspring.model.User;
import com.dim.beginspring.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserTest {

    private SqlSession sqlSession;

    @Test
    public void insertPerson() {
        sqlSession = MybatisUtil.getSqlSession();
        String name = "test";
        String sex = "boy";
        int age = 18;

        User user = new User();
        user.setName(name);
        user.setSex(sex);
        user.setAge(age);

        try {
            sqlSession.insert("insertPerson", user);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(sqlSession);
        }

    }

    @Test
    public void queryById() {
        sqlSession = MybatisUtil.getSqlSession();
        int id = 1;
        try {
            User user = sqlSession.selectOne("queryById", id);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(sqlSession);
        }

    }

    @Test
    public void updateById() {
        sqlSession = MybatisUtil.getSqlSession();
        int id = 2;
        try {
            String name = "update";
            String sex = "男";
            int age = 1;

            User user = new User();
            user.setId(id);
            user.setName(name);
            user.setSex(sex);
            user.setAge(age);

            sqlSession.update("updatePerson", user);
            sqlSession.commit();
            queryById();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(sqlSession);
        }
    }
}