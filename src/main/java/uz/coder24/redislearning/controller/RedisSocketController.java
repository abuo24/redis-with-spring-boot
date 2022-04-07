package uz.coder24.redislearning.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.coder24.redislearning.service.redis.RedisMessagePublisher;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/redis")
public class RedisSocketController {

    private final RedisMessagePublisher redisMessagePublisher;

    @PostMapping("/")
    public void publish(@RequestParam String say) {
        redisMessagePublisher.publish(say);
    }

}
