package com.koesob.webservice.web;

import com.koesob.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// Spring Boot 제공
@Controller
@AllArgsConstructor
public class WebController {
    private PostsService postsService;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        // handlebars 가 알아서 main.hbs 로 연결
        return "main";
    }
}
