package com.starlight.todolist.web;

import com.starlight.todolist.dto.posts.PostsSaveRequestDto;
import com.starlight.todolist.dto.todos.TodosSaveRequestDto;
import com.starlight.todolist.web.service.PostsService;
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
    private PostsService postsService;

    @GetMapping("/hello")
    public String Hello() {
        return "Hello World";
    }

    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto){
        return postsService.save(dto);
    }

    @PostMapping("/todos")
    public Long saveTodos(@RequestBody TodosSaveRequestDto dto){
        return todosService.save(dto);
    }

}
