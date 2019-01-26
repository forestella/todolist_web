package com.starlight.todolist.web.service;

import com.starlight.todolist.dto.todos.TodosMainResponseDto;
import com.starlight.todolist.dto.todos.TodosSaveRequestDto;
import com.starlight.todolist.web.domain.todos.Todos;
import com.starlight.todolist.web.domain.todos.TodosRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class TodosService {

    private TodosRepository todosRepository;

    //추가
    @Transactional
    public Long save(TodosSaveRequestDto dto) {
        return todosRepository.save(dto.toEntity()).getId();
    }

    //조회
    @Transactional(readOnly = true)
    public List<TodosMainResponseDto> findAllDesc() {
        return todosRepository.findAllDesc()
                .map(TodosMainResponseDto::new)
                .collect(Collectors.toList());
    }

    //수정
    @Transactional
    public Todos update(Long id, TodosSaveRequestDto dto) {
        Todos todos = todosRepository.findOne(id);
        todos.update(dto);
        return todos;
    }

    //삭제
    @Transactional
    public Todos delete(Long id, TodosSaveRequestDto dto) {
        Todos todos = todosRepository.findOne(id);
        if(todos != null){
            todosRepository.delete(id);
        }
        return todos;
    }




}
