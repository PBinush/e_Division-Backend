package edu.e_g.service.impl;

import edu.e_g.dto.User;
import edu.e_g.entity.UserEntity;
import edu.e_g.repository.UserRepository;
import edu.e_g.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    final ModelMapper mapper;
    final UserRepository userRepository;
    @Override
    public boolean saveUser(User user) {
        if (user == null || user.getUsername() == null || user.getUsername().isEmpty()) {
            throw new IllegalArgumentException("Invalid user");
        }
        return Optional.ofNullable(
                        mapper.map(userRepository.save(mapper.map(user, UserEntity.class)), User.class)
                ).map(User::getUsername)
                .filter(username -> !username.isEmpty())
                .isPresent();
    }

    @Override
    public boolean updateUser(User user) {
        if (user == null || user.getUsername() == null || user.getUsername().isEmpty()) {
            throw new IllegalArgumentException("Invalid user");
        }
        return userRepository.findById(user.getUserId())
                .map(existing -> userRepository.save(mapper.map(user, UserEntity.class)))
                .map(saved -> mapper.map(saved, User.class))
                .map(User::getUsername)
                .filter(username -> !username.isEmpty())
                .isPresent();
    }

    @Override
    public User getUserByEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Invalid email");
        }
        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        return mapper.map(user,User.class);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userEntity -> mapper.map(userEntity, User.class))
                .toList();
    }
}