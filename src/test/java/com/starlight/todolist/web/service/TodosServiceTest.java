package com.starlight.todolist.web.service;


import com.starlight.todolist.dto.todos.TodosSaveRequestDto;
import com.starlight.todolist.web.domain.todos.Todos;
import com.starlight.todolist.web.domain.todos.TodosRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TodosServiceTest {

    @Autowired
    private TodosService todosService;

    @Autowired
    private TodosRepository todosRepository;

    @After
    public void cleanup(){
        todosRepository .deleteAll();
    }

    @Test
    public void 서비스_클래스로_DB에_저장 () {
        //given
        TodosSaveRequestDto dto = TodosSaveRequestDto.builder()
                .todo("할일 테스트")
                .completeYn("Y")
                .build();

        //when
        todosService.save(dto);

        //then
        Todos todos = todosRepository.findAll().get(10);
        assertThat(todos.getTodo()).isEqualTo(dto.getTodo());
        assertThat(todos.getCompleteYn()).isEqualTo(dto.getCompleteYn());
    }


}
