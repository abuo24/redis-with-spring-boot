package uz.coder24.redislearning.service;

import uz.coder24.redislearning.model.User;

import java.util.List;

public interface UserService {
    User save(User user);

    void delete(Long id);

    User findById(Long id);

    List<User> findAll();
}
