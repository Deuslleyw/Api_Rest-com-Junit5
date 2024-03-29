package com.deusley.api_rest.controllers;

import com.deusley.api_rest.dto.UserDTO;
import com.deusley.api_rest.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/v1/user")
public class UserController {

    public static final String ID = "/{id}";

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserService service;

    @GetMapping(value = ID)
    public ResponseEntity<UserDTO> findById(@PathVariable Integer id){

        var  user = service.findById(id);
        var responseMapper = mapper.map(user, UserDTO.class);

        return ResponseEntity.ok().body(responseMapper);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {

       var response =  service.findAll().stream().map(x ->mapper.map
                       (x,UserDTO.class)).collect(Collectors.toList());

               return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO obj){
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path(ID).buildAndExpand(service.create(obj).getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = ID)
    public ResponseEntity<UserDTO> update(@PathVariable Integer id, @RequestBody UserDTO obj){
        obj.setId(id);

        var user = service.update(obj);
        var responseMapper = mapper.map((obj), UserDTO.class);

        return ResponseEntity.ok().body(obj);

    }
    @DeleteMapping(value = ID)
    public ResponseEntity<UserDTO> delete(@PathVariable Integer id){
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
