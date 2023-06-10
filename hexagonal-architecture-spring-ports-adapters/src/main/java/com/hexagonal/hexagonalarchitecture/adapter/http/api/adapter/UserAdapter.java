package com.hexagonal.hexagonalarchitecture.adapter.http.api.adapter;

import com.hexagonal.hexagonalarchitecture.application.port.api.UserApiPort;
import com.hexagonal.hexagonalarchitecture.application.service.UserServiceImpl;
import com.hexagonal.hexagonalarchitecture.application.usecase.UserUseCasePort;
import com.hexagonal.hexagonalarchitecture.domain.User;
import com.hexagonal.hexagonalarchitecture.infraestructure.annotation.Adapter;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Adapter
@AllArgsConstructor
public class UserAdapter implements UserApiPort {

    private UserServiceImpl userService;
    @Override
    public Optional<User> getUserById(Long id) {
        return userService.getUserById(id);
    }

    @Override
    public User saveUser(User user) {
        return userService.saveUser(user);
    }

    @Override
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @Override
    public User updateUser(User user) {
        return userService.updateUser(user);
    }

    @Override
    public String deleteUser(Long id) {
        return userService.deleteUser(id);
    }
}
