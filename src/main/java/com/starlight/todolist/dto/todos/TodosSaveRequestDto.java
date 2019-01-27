package com.starlight.todolist.dto.todos;

import com.starlight.todolist.web.domain.todos.Todos;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TodosSaveRequestDto {

    private Long id;
    private String todo;
    private String completeYn;
    private List<Todos> refTodos;
    private List<Todos> originTodos;
    private Long ref_id;
    private String modifiedTime;

    @Builder
    public TodosSaveRequestDto (Long id, String todo, String completeYn, List<Todos> refTodos, List<Todos> originTodos, Long ref_id) {
        this.id = id;
        this.todo = todo;
        this.completeYn = completeYn;
        this.refTodos = refTodos;
        this.originTodos = originTodos;
        this.ref_id = ref_id;
    }


    public Todos toEntity(){
        return Todos.builder()
                .todo(todo)
                .completeYn(completeYn)
                .build();
    }

}
