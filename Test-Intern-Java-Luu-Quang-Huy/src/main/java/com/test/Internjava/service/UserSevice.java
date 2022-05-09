package com.test.Internjava.service;

import com.test.Internjava.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserSevice {
    List<User> getAll();

    User create(User user);

    User update(Long id, User user);

    boolean deleteUser(Long id);

    Optional<User> findUserById(Long id);
}
