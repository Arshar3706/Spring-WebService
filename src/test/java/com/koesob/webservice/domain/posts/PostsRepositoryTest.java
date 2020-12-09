package com.koesob.webservice.domain.posts;

import org.hibernate.event.spi.PostDeleteEventListener;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup() {
        /*
        이후 테스트 코드에 영향을 끼치지 않기 위해
        테슽 메소드가 끝날 때마다 repository 전체 비우는 코드드
        */
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        // BDD(Behaviour-Driven Development)에서 사용하는 용어
        // given : 테스트 기반 환경을 구축, 여기선 Builder 사용법 확인
        postsRepository.save(Posts.builder()
                .title("테스트 게시글")
                .content("테스트 본문")
                .author("koesob@gmail.com")
                .build());

        // 참고로 하단 코드는 깃허브에서 삭제 돼 있음, 그래서 상기에 java.util 도 import 돼 있지 않음, 심지어 assertThat 도 깃허브에는 없음
        // when : 테스트하고자 하는 행위 선언, Posts DB에 insert 되는가?
        List<Posts> postsList = postsRepository.findAll();

        // then : 테스트 결과 검증, 조회 후, 입력 된 값 확인
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle(), is("테스트 게시글"));
        assertThat(posts.getContent(), is("테스트 본문"));
    }

    @Test
    public void BaseTimeEntity_등록() {
        // given : 테스트 기반 환경을 구축, 여기선 시간이 들어가는지 확인
        LocalDateTime now = LocalDateTime.now();
        postsRepository.save(Posts.builder()
                .title("테스트 게시글")
                .content("테스트 본문")
                .author("koesob@gmail.com")
                .build());

        // when : 테스트 하고자 하는 행위 선언
        List<Posts> postsList = postsRepository.findAll();

        //then : 테스트 결과 검증, 테이블에 들어간 첫 번쨰 posts 검증
        Posts posts = postsList.get(0);
        assertTrue(posts.getCreatedDate().isAfter(now));
        assertTrue(posts.getModifiedDate().isAfter(now));
    }
}
