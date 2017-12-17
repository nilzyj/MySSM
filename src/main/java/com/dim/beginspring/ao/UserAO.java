package com.dim.beginspring.ao;

import com.dim.beginspring.dal.domain.UserPO;
import com.dim.beginspring.model.User;

import java.util.List;

public interface UserAO {
    List<UserPO> getUser();
    List<UserPO> selectUserByNameAndAge(User user);
}
