package com.koesob.webservice.web;

import com.koesob.webservice.domain.posts.PostsRepository;
import com.koesob.webservice.dto.posts.PostsSaveRequestDto;
import com.koesob.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// @ResponseBody 를 모든 메소드에 적용 = Java 객체를 Http 객체로 = JSON 형태로
@RestController
// Lombok 제공, 모든 필드 인자값으로 생성자
@AllArgsConstructor
public class WebRestController {

    private PostsService postsService;

    // Mapping 설명은 생략 쌉가능
    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }

    @PostMapping("/posts")
    // RequestBody HTTP 요청을 Java 객체로, 반대가 @ResponseBody
    public Long savePosts(@RequestBody PostsSaveRequestDto dto) {
        return postsService.save(dto);
    }
}
