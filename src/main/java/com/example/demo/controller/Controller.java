package com.example.demo.controller;

import com.example.demo.controller.dto.request.PostRequest;
import com.example.demo.controller.dto.response.SourceListResponse;
import com.example.demo.entity.Source;
import com.example.demo.service.DemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
public class Controller {

    private final DemoService service;

    @GetMapping
    public SourceListResponse getMethod(Pageable page) {
        return service.get(page);
    }

    @GetMapping("/{id}")
    public Source getDetailsMethod(@PathVariable Long id) {
        return service.getDetail(id);
    }

    @PostMapping
    public void postMethod(@RequestBody PostRequest postRequest) {
        service.post(postRequest);
    }
}
