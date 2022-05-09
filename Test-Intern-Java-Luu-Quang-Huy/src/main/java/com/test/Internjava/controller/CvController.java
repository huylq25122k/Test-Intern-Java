package com.test.Internjava.controller;

import com.test.Internjava.entity.User;
import com.test.Internjava.repository.UserRepository;
import com.test.Internjava.service.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CvController {

    @Autowired
    private UserSevice userSevice;

    @GetMapping("/getUser")
    public List<User> getAll(){
        List<User> users = userSevice.getAll();
        return users;
    }
    @PostMapping
    public User create(@RequestBody User user) {
       return userSevice.create(user);
    }

    @PutMapping("/update")
    public User update(@RequestParam("id") long id, @RequestBody User user){
        return userSevice.update(id,user);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        return userSevice.deleteUser(id);
    }
}
