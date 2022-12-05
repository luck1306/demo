package com.example.demo.controller.dto.request;

import com.example.demo.entity.Source;
import com.example.demo.entity.repository.SourceRepository;
import lombok.Getter;

@Getter
public class PostRequest {

    private String name;
    private String content;

    public Source toSource(SourceRepository repository) {
        return Source.builder()
                        .content(this.content)
                        .name(this.name)
                .build();
    }
}
