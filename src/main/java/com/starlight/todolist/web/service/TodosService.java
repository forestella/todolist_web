package com.starlight.todolist.web.service;

import com.starlight.todolist.dto.todos.TodosMainResponseDto;
import com.starlight.todolist.dto.todos.TodosSaveRequestDto;
import com.starlight.todolist.web.domain.todos.Todos;
import com.starlight.todolist.web.domain.todos.TodosRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
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

    //리스트 조회2
    @Transactional(readOnly = true)
    public Page<Todos> findAll(Pageable pageable) {
        return todosRepository.findAll(pageable);
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
        if(todos != null) {
            if(todos.getOriginTodos().stream().anyMatch(t -> t.getCompleteYn().equals("N"))){
                throw new RuntimeException("완료하지 않은 업무가 존재 합니다.");
            }else if(todos.getCompleteYn().equals("Y")){
                throw new RuntimeException("이미 완료된 업무 입니다.");
            }
        }
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

    //참조 추가
    @Transactional
    public Todos saveRef(Long id, TodosSaveRequestDto dto) {
        Todos todos = getTodo(id);
        Todos refTodos = getTodo(dto.getRef_id());
        todos.updateRefTodo(refTodos);
        return todos;
    }


}
