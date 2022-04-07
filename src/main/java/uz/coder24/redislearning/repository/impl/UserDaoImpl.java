package uz.coder24.redislearning.repository.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import uz.coder24.redislearning.config.redis.RedisConstants;
import uz.coder24.redislearning.model.User;
import uz.coder24.redislearning.repository.UserDao;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {

    private final RedisTemplate redisTemplate;
    private HashOperations hashOperations;

    @PostConstruct
    void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public User save(User user) {
        try {

            hashOperations.put(RedisConstants.USERS, String.valueOf(user.getId()), user);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        try {
            return hashOperations.values(RedisConstants.USERS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> findAllByAnnotation() {
        try {
            return hashOperations.values(RedisConstants.USERS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Cacheable(key = "#id", value = RedisConstants.USERS)
//    {unless="#id > 10} - "make condition
    public User findById(Long id) {
        try {
            System.out.println("i am here to call db");
            return (User) hashOperations.get(RedisConstants.USERS, String.valueOf(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    @CacheEvict(key = "#id", value = RedisConstants.USERS)
    public void delete(Long id) {
        try {
            hashOperations.delete(RedisConstants.USERS, String.valueOf(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
