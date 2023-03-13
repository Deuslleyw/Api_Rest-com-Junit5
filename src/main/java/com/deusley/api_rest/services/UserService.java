package com.deusley.api_rest.services;

import com.deusley.api_rest.domain.User;
import com.deusley.api_rest.dto.UserDTO;

import java.util.List;

public interface UserService {

    User findById(Integer id);
    List<User> findAll();
    User create(UserDTO obj);

    User update(UserDTO obj);

    void delete(Integer id);

}
