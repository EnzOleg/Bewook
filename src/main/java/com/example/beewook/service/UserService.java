package com.example.beewook.service;

import com.example.beewook.dto.UserDTO;
import com.example.beewook.model.User;
import com.example.beewook.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public List<UserDTO> getAllUsers() {
        return repo.findAll().stream()
                .map(user -> new UserDTO(user.getId(), user.getCreatedAt()))
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(Long id) {
        var user = repo.findById(id).orElseThrow();
        return new UserDTO(user.getId(), user.getCreatedAt());
    }

    public UserDTO createUser() {
        User user = new User();
        user = repo.save(user);
        return new UserDTO(user.getId(), user.getCreatedAt());
    }
}
