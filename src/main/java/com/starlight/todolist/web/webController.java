package com.starlight.todolist.web;

import com.starlight.todolist.web.domain.todos.TodosRepository;
import com.starlight.todolist.web.service.TodosService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class webController {

    private TodosService todosService;

    private final TodosRepository todosRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute ("todos", todosService.findAllDesc());
        return "index";
    }

    @GetMapping("/list")
    public String list(Model model,
                       @PageableDefault(sort = { "id" }, direction = Sort.Direction.DESC, size = 4) Pageable pageable) {
        model.addAttribute ("todosAll", todosService.findAllDesc());
        model.addAttribute ("todos", todosRepository.findAll(pageable));
        model.addAttribute("pageNumber", pageable.getPageNumber());
        model.addAttribute("pageSize", pageable.getPageSize());
        model.addAttribute("totalCount", todosRepository.getTotalCount());
        return "index";
    }



//    @GetMapping("/todos/{id}")
//    public Student retrieveStudent(@PathVariable long id) {
//        Optional<Student> student = studentRepository.findById(id);
//
//        if (!student.isPresent())
//            throw new StudentNotFoundException("id-" + id);
//
//        return student.get();
//    }
}
