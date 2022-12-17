package com.example.demo.controller;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
public class TestController {

    @Cacheable(value = "data")
    @GetMapping
    public String get(@RequestParam(value = "id") String id) {
        return id;
    }

    @CacheEvict(value = "data")
    @DeleteMapping
    public void delete(@RequestParam String id) {
        System.out.println(id);
    }
}
