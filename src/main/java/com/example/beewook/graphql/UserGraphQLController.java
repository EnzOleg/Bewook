package com.example.beewook.graphql;

import com.example.beewook.dto.UserDTO;
import com.example.beewook.service.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class UserGraphQLController {

    private final UserService service;

    public UserGraphQLController(UserService service) {
        this.service = service;
    }

    @QueryMapping
    public UserDTO user(@Argument Long id) {
        return service.getUserById(id);
    }

    @MutationMapping
    public UserDTO createUser(@Argument String name) {
        return service.createUser(name);
    }

}
