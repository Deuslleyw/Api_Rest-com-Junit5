package com.deusley.api_rest.services.impl;

import com.deusley.api_rest.domain.User;
import com.deusley.api_rest.dto.UserDTO;
import com.deusley.api_rest.exceptions.DataIntegratyViolationException;
import com.deusley.api_rest.exceptions.ObjectNotFoundException;
import com.deusley.api_rest.repositories.UserRepository;
import com.deusley.api_rest.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository rep;

    @Autowired
    private ModelMapper mapper;

    @Override
    public User findById(Integer id) {
        Optional<User> obj = rep.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Não Encontrado,Tente Novamente!"));
    }

    public List<User> findAll(){
        return rep.findAll();
    }

    @Override
    public User create(UserDTO obj) {
        findByEmail(obj);
        return rep.save(mapper.map(obj, User.class));
    }

    @Override
    public User update(UserDTO obj) {
        findByEmail(obj);
        return rep.save(mapper.map(obj,User.class));
    }

    private void findByEmail(UserDTO obj){
        Optional<User> user = rep.findByEmail(obj.getEmail());
        if(user.isPresent() && !user.get().getId().equals(obj.getId())){
            throw new DataIntegratyViolationException("Esse email ja existe");
        }
    }

}
