package uz.coder24.redislearning.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("Student")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {

    private Long id;
    private String name;
    private Long age;

}
