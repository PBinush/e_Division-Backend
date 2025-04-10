package edu.e_g.service;

import edu.e_g.dto.User;

import java.util.List;

public interface UserService {
    boolean saveUser(User user);
    boolean updateUser(User user);
    User getUserByEmail(String email);
    List<User> getAllUsers();
}
