package com.koesob.webservice.domain.posts;

import com.koesob.webservice.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// Lombok 제공, 기본 생성자 자동 추가, 접근자 설정 = 프로젝트 상에서 생성은 막고, JPA 만 허용
@NoArgsConstructor(access = AccessLevel.PROTECTED)
// Lombok 제공, Getter 메소드 자동 생성
@Getter
// JPA 제공, 테이블 링크 클래스, _네이밍으로 매칭
@Entity
public class Posts extends BaseTimeEntity {

    // JPA 제공, Primary Key(PK) 필드, 각 행 고유 식별 키
    @Id
    // JPA 제공, PK 생성 규칙, 기본값은 자동 증가 정수, Boot 2.0부터는 옵션 줘야함
    @GeneratedValue
    private Long id;

    // JPA 제공, 원래는 자동 제공, 기본값 변경을 위해 설정함
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    // Lombok 제공, 빌더패턴 클래스 생성
    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
