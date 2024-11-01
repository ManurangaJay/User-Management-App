package com.manuJay.userManagementSystem.user;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();
    void addUser(User user);

    User getUserById(Long id);

    boolean deleteUserById(Long id);

    boolean updateUser(Long id, User updatedUser);
}
