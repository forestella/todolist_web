package com.starlight.todolist.web.domain.todos;

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
public class TodosRepositoryTest{

    @Autowired
    TodosRepository todosRepository;

    @After
    public void cleanup() {
        todosRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        todosRepository.save(Todos.builder()
                .todo("안녕하세요..")
                .completeYn("Y")
                .build());

        //when
        List<Todos> todosList = todosRepository.findAll();

        //then
        Todos todos = todosList.get(10);

        assertThat(todos.getTodo(), is("안녕하세요.."));
        assertThat(todos.getCompleteYn(), is("Y"));

    }

    @Test
    public void BaseTimeEntity_등록() {
        //given
        LocalDateTime now = LocalDateTime.now();
        todosRepository.save(Todos.builder()
                .todo("테스트 게시글.")
                .completeYn("Y")
                .build());

        //when
        List<Todos> todosList = todosRepository.findAll();

        //then
        Todos todos = todosList.get(10);
        assertTrue(todos.getCreatedTime().isAfter(now));
        assertTrue(todos.getModifiedTime().isAfter(now));
    }

}
