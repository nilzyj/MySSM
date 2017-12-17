package com.dim.beginspring.dao;

import com.dim.beginspring.dal.domain.UserPO;
import com.dim.beginspring.model.User;

import java.util.List;

public interface UserDao {
    List<UserPO> selectUser(User user);

    List<UserPO> selectUser();
}
