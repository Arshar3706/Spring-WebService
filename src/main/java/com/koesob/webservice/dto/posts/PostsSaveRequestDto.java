package com.koesob.webservice.dto.posts;

import com.koesob.webservice.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
// Lombok 제공, @RequestBody 로 외부 데이터 받는 경우, 기본생성자 + set 메소드로만 가능
@Setter
@NoArgsConstructor
// Dto Storage 단 제외한 곳에서 주고 받을 객체
public class PostsSaveRequestDto {

    private String title;
    private String content;
    private String author;

    // 설명 생략 ㅇㅈㅇㅈ
    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    // Dto → Entity 변환, builder 사용
    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
