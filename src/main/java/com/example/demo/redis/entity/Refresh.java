package com.example.demo.redis.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RedisHash
public class Refresh {

    @Id
    private Long id;

    @Indexed
    private String token;

    @TimeToLive
    private Long exp;

    @Builder
    public Refresh(Long id, String token, Long exp) {
        this.id = id;
        this.token = token;
        this.exp = exp;
    }
}
