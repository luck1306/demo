package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
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

    @GetMapping("/hello")
    public void hello(@ModelAttribute TestDto testDto) {
        log.info(testDto.getName());
        log.info(testDto.getAge().toString());
        log.info(testDto.getNow().toString());
    }

    @GetMapping("/aaa")
    public void gram() {
        log.info("success");
    }
}
