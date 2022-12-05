package com.example.demo.controller.dto.response;

import com.example.demo.entity.Source;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class SourceListResponse {

    private final long totalLength;

    private final List<Source> sourceList;

    @Builder
    public SourceListResponse(long totalLength, List<Source> sourceList) {
        this.totalLength = totalLength;
        this.sourceList =sourceList;
    }
}
