package com.hexagonal.hexagonalarchitecture.application.service;

import com.hexagonal.hexagonalarchitecture.adapter.persistence.model.UserEntity;
import com.hexagonal.hexagonalarchitecture.adapter.persistence.repository.UserRepository;
import com.hexagonal.hexagonalarchitecture.infraestructure.config.MapStructClassMapper;
import com.hexagonal.hexagonalarchitecture.application.usecase.UserUseCasePort;
import com.hexagonal.hexagonalarchitecture.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserUseCasePort {


    private UserRepository userRepository;
    private MapStructClassMapper mapper;
    @Override
    public Optional<User> getUserById(Long id) {

        return (Optional.ofNullable(mapper.mapperClass(userRepository.findById(id), User.class)));
    }

    @Override
    public User saveUser(User user) {
        UserEntity userEntity = mapper.mapperClass(user,UserEntity.class);
        return mapper.mapperClass(userRepository.save(userEntity),User.class);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll().stream()
                .map(user-> mapper.mapperClass(user,User.class)).collect(Collectors.toList());
    }

    @Override
    public User updateUser(User user) {
        UserEntity userEntity = mapper.mapperClass(user,UserEntity.class);
        return mapper.mapperClass(userRepository.save(userEntity),User.class);
    }

    @Override
    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "User deleted success";
    }
}
