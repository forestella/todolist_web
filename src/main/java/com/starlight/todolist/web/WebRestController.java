package com.starlight.todolist.web;

import com.starlight.todolist.dto.todos.TodosSaveRequestDto;
import com.starlight.todolist.web.domain.todos.Todos;
import com.starlight.todolist.web.service.TodosService;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class WebRestController {

    private TodosService todosService;


    @PostMapping("/todosInsert")
    public Long saveTodos(@RequestBody TodosSaveRequestDto dto){
        return todosService.save(dto);
    }

    @PostMapping("/todosUpdate/{id}")
    public Todos updateTodos(@PathVariable Long id, @RequestBody TodosSaveRequestDto dto){
        return todosService.updateTodo(id, dto);
    }

    @PostMapping("/todosComplete/{id}")
    public Todos updateComplete(@PathVariable Long id, @RequestBody TodosSaveRequestDto dto){
        return todosService.updateCompleteYn(id, dto);
    }

    @PostMapping("/todosDelete/{id}")
    public Todos deleteTodos(@PathVariable Long id, @RequestBody TodosSaveRequestDto dto){
        return todosService.delete(id, dto);
    }


}
