package com.starlight.todolist.web.domain.posts;

import com.starlight.todolist.web.domain.BaseTimeEntity;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest{

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        postsRepository.save(Posts.builder()
                .title("안녕하세요.")
                .author("zeldatt@gmail.com")
                .content("테스트 글 작성")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);

        assertThat(posts.getTitle(), is("안녕하세요."));
        assertThat(posts.getContent(), is("테스트 글 작성"));
        assertThat(posts.getAuthor(), is("zeldatt@gmail.com"));


    }

    @Test
    public void BaseTimeEntity_등록() {
        //given
        LocalDateTime now = LocalDateTime.now();
        postsRepository.save(Posts.builder()
                .title("테스트 게시글.")
                .author("zeldatt@gmail.com")
                .content("테스트 글 작성")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertTrue(posts.getCreatedTime().isAfter(now));
        assertTrue(posts.getModifiedTime().isAfter(now));
    }

}
