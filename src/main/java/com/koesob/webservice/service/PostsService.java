package com.koesob.webservice.service;

import com.koesob.webservice.domain.posts.PostsMainResponseDto;
import com.koesob.webservice.domain.posts.PostsRepository;
import com.koesob.webservice.dto.posts.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
// Spring Boot 제공
// 비즈니스 로직 & 트랜잭션 관리는 Service 관리, View 연동은 Controller 담당 구성
@Service
public class PostsService {
    private PostsRepository postsRepository;

    // Exception 발생시 이 메소드에서 이뤄진 모든 DB 작업 초기화
    @Transactional
    public Long save(PostsSaveRequestDto dto) {
        return postsRepository.save(dto.toEntity()).getId();
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<PostsMainResponseDto> findAllDesc() {
        return postsRepository.findAllDesc()
                .map(PostsMainResponseDto::new)
                .collect(Collectors.toList());
    }
}
