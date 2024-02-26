package com.jbarranzuela.prueba.tecnica.users.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jbarranzuela.prueba.tecnica.users.dto.request.UserDtoRequest;
import com.jbarranzuela.prueba.tecnica.users.helper.UserHelper;
import com.jbarranzuela.prueba.tecnica.users.service.IUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @MockBean
    private IUserService userService;

    @Autowired
    private MockMvc mockMvc;


    protected static ObjectMapper om = new ObjectMapper();

    @BeforeEach
    public void setUp() throws Exception {
        ObjectMapper om = new ObjectMapper();
        om.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        JacksonTester.initFields(this, om);
    }

    @Test
    public void createUserTest() throws Exception {

        UserDtoRequest userDtoRequest = UserHelper.userDtoRequest();

        mockMvc.perform(
                        post("/api/v1/user").content(om.writeValueAsBytes(userDtoRequest)).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().isCreated());
    }


    @Test
    public void enabledOrDisabledUserTest() throws Exception {

        mockMvc.perform(
                        patch("/api/v1/user").param("email","joejoel0512@gmail.com").contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void getAllUsersTest() throws Exception {

        mockMvc.perform(
                        get("/api/v1/user").contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().isOk());
    }
}
