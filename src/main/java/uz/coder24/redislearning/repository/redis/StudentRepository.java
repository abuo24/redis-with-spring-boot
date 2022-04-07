package uz.coder24.redislearning.repository.redis;

import org.springframework.data.repository.CrudRepository;
import uz.coder24.redislearning.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {}
