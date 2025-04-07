package edu.e_g.service;

import edu.e_g.dto.User;

public interface UserService {
    Boolean addUser(User user);
    boolean updateUser(User user);
    User getUser();
    User getLastUser();
}
