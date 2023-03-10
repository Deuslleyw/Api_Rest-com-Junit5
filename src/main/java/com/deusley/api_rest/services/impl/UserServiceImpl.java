package com.deusley.api_rest.services.impl;

import com.deusley.api_rest.domain.User;
import com.deusley.api_rest.exceptions.ObjectNotFoundException;
import com.deusley.api_rest.repositories.UserRepository;
import com.deusley.api_rest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository rep;

    @Override
    public User findById(Integer id) {
        Optional<User> obj = rep.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Não Encontrado,Tente Novamente!"));
    }

    public List<User> findAll(){
        return rep.findAll();
    }
}
