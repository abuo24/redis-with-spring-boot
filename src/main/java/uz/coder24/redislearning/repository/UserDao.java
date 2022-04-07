package uz.coder24.redislearning.repository;

import uz.coder24.redislearning.model.User;

import java.util.List;

public interface UserDao {
    User save(User user);

    List<User> findAll();

    List<User> findAllByAnnotation();

    User findById(Long id);

    void delete(Long id);
}
