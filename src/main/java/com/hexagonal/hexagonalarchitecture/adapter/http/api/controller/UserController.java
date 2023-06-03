package com.hexagonal.hexagonalarchitecture.adapter.http.api.controller;

import com.hexagonal.hexagonalarchitecture.adapter.http.api.adapter.UserAdapter;
import com.hexagonal.hexagonalarchitecture.adapter.http.api.model.UserDTO;
import com.hexagonal.hexagonalarchitecture.domain.User;
import com.hexagonal.hexagonalarchitecture.infraestructure.config.MapStructClassMapper;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
@PreAuthorize("hasAnyRole('ADMIN')")
@AllArgsConstructor

public class UserController{

    private UserAdapter userAdapter;
    private MapStructClassMapper mapper;

    @GetMapping
    public ResponseEntity<List<UserDTO>>getAllUser(){
        return ResponseEntity.ok(userAdapter.getAllUser().stream()
                .map(user -> mapper.mapperClass(user, UserDTO.class)).toList());

    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Optional<UserDTO>>getUser(@PathVariable("id")Long id){
        return ResponseEntity.ok(Optional.ofNullable(mapper
                .mapperClass(userAdapter.getUserById(id), UserDTO.class)));
    }

    @PostMapping("/create")
    public ResponseEntity<UserDTO>saveUser(@Valid @RequestBody UserDTO userDTO){
        User user = mapper.mapperClass(userDTO,User.class);
        return ResponseEntity.ok(mapper.mapperClass(userAdapter.saveUser(user),UserDTO.class));
    }

    @PutMapping("/user")
    public ResponseEntity<UserDTO>updateUser(@RequestBody UserDTO userDTO){
        User user = mapper.mapperClass(userDTO,User.class);
        return ResponseEntity.ok(mapper.
                mapperClass(userAdapter.updateUser(user),UserDTO.class));

    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String>deleteUser(@PathVariable("id")Long id){
        return ResponseEntity.ok(userAdapter.deleteUser(id));
    }
}
