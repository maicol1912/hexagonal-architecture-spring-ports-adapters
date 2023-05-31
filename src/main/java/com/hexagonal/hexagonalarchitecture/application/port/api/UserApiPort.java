package com.hexagonal.hexagonalarchitecture.application.port.api;

import com.hexagonal.hexagonalarchitecture.domain.User;
import com.hexagonal.hexagonalarchitecture.infraestructure.annotation.Port;

import java.util.List;
import java.util.Optional;

@Port
public interface UserApiPort {

    Optional<User> getUserById(Long id);
    User saveUser(User user);
    List<User>getAllUser();
    User updateUser(User user);
}
