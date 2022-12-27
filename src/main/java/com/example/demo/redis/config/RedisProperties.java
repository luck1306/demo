package com.example.demo.redis.config;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@ConfigurationProperties("spring.redis")
@Component
public class RedisProperties {
    private String host;
    private int port;
}
