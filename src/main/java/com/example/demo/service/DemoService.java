package com.example.demo.service;

import com.example.demo.controller.dto.request.PostRequest;
import com.example.demo.controller.dto.response.SourceListResponse;
import com.example.demo.entity.Source;
import com.example.demo.entity.repository.SourceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DemoService {

    private final SourceRepository repository;

    public SourceListResponse get(Pageable page) {
        Page<Source> sourceList = repository.findAll(page);
        long totalLength = repository.count();
        return SourceListResponse.builder()
                .sourceList(sourceList)
                .totalLength(totalLength)
                .build();
    }

    public Source getDetail(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> {
                    throw new RuntimeException("존재하지 않는 아이디 입니다.");
                });
    }

    public void post(PostRequest postRequest) {
        repository.save(postRequest.toSource(repository));
    }
}
