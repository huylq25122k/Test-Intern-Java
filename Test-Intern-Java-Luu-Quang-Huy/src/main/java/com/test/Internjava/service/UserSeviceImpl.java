package com.test.Internjava.service;

import com.test.Internjava.entity.User;
import com.test.Internjava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserSeviceImpl implements UserSevice{

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(Long id,User user) {
        if (user!=null) {
            User users = userRepository.getById(id);
            if (users != null) {
                users.setFirstName(user.getFirstName());
                users.setLastName(user.getLastName());
                users.setAddress(user.getAddress());
                users.setAge(user.getAge());
                users.setDescription(user.getDescription());
                return userRepository.save(users);
            }
        }
        return null;
    }


    @Override
    public boolean deleteUser(Long id) {
        User users = userRepository.getById(id);
        userRepository.delete(users);
        return true;
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return Optional.empty();
    }
}
