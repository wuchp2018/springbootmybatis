package com.open.service;

import com.open.model.User;
import org.springframework.stereotype.Service;

public interface UserService {

    int insert(User record);

    User selectByPrimaryKey(Long id);
}
