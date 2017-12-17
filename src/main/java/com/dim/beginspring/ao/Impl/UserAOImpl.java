package com.dim.beginspring.ao.Impl;

import com.dim.beginspring.ao.UserAO;
import com.dim.beginspring.dal.domain.UserPO;
import com.dim.beginspring.dao.UserDao;
import com.dim.beginspring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAOImpl implements UserAO{

    @Autowired
    private UserDao userDao;

    @Override
    public List<UserPO> getUser() {
        return userDao.selectUser();
    }

    @Override
    public List<UserPO> selectUserByNameAndAge(User user) {
        return userDao.selectUser(user);
    }
}
