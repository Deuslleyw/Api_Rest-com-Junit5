package com.deusley.api_rest.services;

import com.deusley.api_rest.domain.User;

import java.util.List;

public interface UserService {

    User findById(Integer id);

    List<User> findAll();

}
