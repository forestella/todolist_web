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

    //단건 조회
    @Transactional(readOnly = true)
    public Todos getTodo(Long id){
        Todos todos = todosRepository.findOne(id);
        if (todos == null) {

        }
        return todos;
    }

    //리스트 조회
    @Transactional(readOnly = true)
    public List<TodosMainResponseDto> findAllDesc() {
        return todosRepository.findAllDesc()
                .map(TodosMainResponseDto::new)
                .collect(Collectors.toList());
    }

    //할일 수정
    @Transactional
    public Todos updateTodo(Long id, TodosSaveRequestDto dto) {
        Todos todos = getTodo(id);
        todos.setTodo(dto.getTodo());
        return todos;
    }

    //완료 처리
    @Transactional
    public Todos updateCompleteYn(Long id, TodosSaveRequestDto dto) {
        Todos todos = getTodo(id);
        todos.setCompleteYn(dto.getCompleteYn());
        return todos;
    }

    //삭제
    @Transactional
    public Todos delete(Long id, TodosSaveRequestDto dto) {
        Todos todos = getTodo(id);
        if(todos != null){
            todosRepository.delete(id);
        }
        return todos;
    }




}
