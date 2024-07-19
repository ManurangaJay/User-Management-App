package com.manuJay.userManagementSystem.user.impl;

import com.manuJay.userManagementSystem.user.User;
import com.manuJay.userManagementSystem.user.UserRepository;
import com.manuJay.userManagementSystem.user.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return (User) userRepository.findById(id).orElse(null);    }

    @Override
    public boolean deleteUserById(Long id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateUser(Long id, User updatedUser) {
        Optional<User> jobOptional = userRepository.findById(id);
        if (jobOptional.isPresent())
        {
            User job = jobOptional.get();
            job.setUserName(updatedUser.getUserName());
            job.setName(updatedUser.getName());
            job.setAddress(updatedUser.getAddress());
            userRepository.save(job);
            return true;
        }
        return false;
    }
}
