package com.koesob.webservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// @ResponseBody 를 모든 메소드에 적용 = Java 객체를 Http 객체로 = JSON 형태로
@RestController
public class WebRestController {
    
    // Mapping 설명은 생략 쌉가능
    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }
}
