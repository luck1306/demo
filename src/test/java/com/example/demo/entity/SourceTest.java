package com.example.demo.entity;

import com.example.demo.entity.repository.SourceRepository;
import com.example.demo.service.DemoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SourceTest {

    private final SourceRepository repository;

    private final DemoService service;

    public SourceTest(SourceRepository repository, DemoService service) {
        this.repository = repository;
        this.service = service;
    }



//    @Test
//    @DisplayName("test Source Entity")
//    void testSource() {
//        Source source = Source.builder()
//                .content("source's content")
//                .name("source's name")
//                .build();
//        Assertions.assertThat(source.getContent()).isEqualTo("source's content");
//        Assertions.assertThat(source.getName()).isEqualTo("source's name");
//    }
    @Test
    @DisplayName("test service")
    void testService() {
        //
    }
}