package com.example.demo.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String accountId;

    @Column(nullable = false)
    private String password;

    @Column(columnDefinition = "default \"Hello!\"")
    private String introduce;

    @Builder
    public User(String accountId, String password, String introduce) {
        this.accountId = accountId;
        this.password = password;
        this.introduce = introduce;
    }

    public User updateIntroduce(String introduce) {
        this.introduce = introduce;
        return this;
    }
}
