package com.dim.beginspring.dao.Impl;

import com.dim.beginspring.dal.domain.UserPO;
import com.dim.beginspring.dao.UserDao;
import com.dim.beginspring.model.User;
import com.dim.beginspring.util.MybatisUtil;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserDaoImpl implements UserDao {
    @Override
    public List<UserPO> selectUser(User user) {
        return MybatisUtil.getSqlSession().selectList("query", user);
    }

    @Override
    public List<UserPO> selectUser() {
        return MybatisUtil.getSqlSession().selectList("query");
    }
}
