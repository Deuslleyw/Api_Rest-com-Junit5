package com.deusley.api_rest.controllers;

import com.deusley.api_rest.domain.User;
import com.deusley.api_rest.dto.UserDTO;
import com.deusley.api_rest.services.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class UserControllerTest {

    public static final Integer ID = 1;
    public static final String NAME = "Deusley Diego";
    public static final String EMAIL = "diegoTeste@teste.com";
    public static final String PASSWORD = "123";
    public static final int INDEX = 0;

    @InjectMocks
    private UserController controller;

    @Mock
    private UserServiceImpl service;

    @Mock
    private ModelMapper mapper;

    private User user;
    private UserDTO userDTO;

    UserControllerTest() {
    }


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUsers();
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    private void startUsers(){
        user = new User(ID, NAME, EMAIL, PASSWORD);
        userDTO = new UserDTO(ID,NAME,EMAIL,PASSWORD);
}}