package uz.coder24.redislearning.service.redis;


public interface MessagePublisher {
    void publish(String message);
}
