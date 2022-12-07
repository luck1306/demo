package com.example.demo.controller.dto.response;

import com.example.demo.entity.Source;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
public class SourceListResponse {

    private final long totalElements;

    private final List<Source> sourceList;

    @Builder
    public SourceListResponse(long totalLength, Page<Source> sourceList) {
        this.totalElements = sourceList.getTotalElements();
        this.sourceList = sourceList.getContent();
    }
}
