package com.starlight.todolist.web;

import com.starlight.todolist.web.service.PostsService;
import com.starlight.todolist.web.service.TodosService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class webController {

    private PostsService postsService;
    private TodosService todosService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute ("todos", todosService.findAllDesc());
        return "index";
    }

    @GetMapping("/main")
    public String main(Model model) {
        model.addAttribute ("posts", postsService.findAllDesc());
        return "main";
    }
}
