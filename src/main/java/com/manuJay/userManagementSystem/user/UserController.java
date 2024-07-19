package com.manuJay.userManagementSystem.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> findAllUsers()
    {
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK) ;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody User user)
    {
        userService.addUser(user);
        return new ResponseEntity<>("Job added successfully",HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id)
    {
        User job = userService.getUserById(id);
        if (job != null)
        {
            return new ResponseEntity<>(job , HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id)
    {
        boolean deleted = userService.deleteUserById(id);
        if(deleted)
        {
            return new ResponseEntity<>("User deleted Successfully", HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody User updatedUser)
    {
        boolean updated = userService.updateUser(id , updatedUser);
        if (updated)
        {
            return new ResponseEntity<>("User Updated Successfully" , HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
