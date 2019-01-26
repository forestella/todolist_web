package com.starlight.todolist.web;

import com.starlight.todolist.dto.todos.TodosSaveRequestDto;
import com.starlight.todolist.web.service.TodosService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class WebRestController {

    private TodosService todosService;


    @PostMapping("/todosInsert")
    public Long saveTodos(@RequestBody TodosSaveRequestDto dto){
        return todosService.save(dto);
    }

//    @PostMapping("/todosUpdate")
//    public Long updateTodos(@RequestBody TodosSaveRequestDto dto){
//        return todosService.update(dto);
//    }

    //수정, 삭제 추가 해야함

}
