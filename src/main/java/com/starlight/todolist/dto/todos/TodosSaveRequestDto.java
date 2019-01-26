package com.starlight.todolist.dto.todos;

import com.starlight.todolist.web.domain.todos.Todos;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TodosSaveRequestDto {

    private Long id;
    private String todo;
    private String completeYn;
    private String modifiedTime;

    @Builder
    public TodosSaveRequestDto (Long id, String todo, String completeYn) {
        this.id = id;
        this.todo = todo;
        this.completeYn = completeYn;
    }


    public Todos toEntity(){
        return Todos.builder()
                .todo(todo)
                .completeYn(completeYn)
                .build();
    }

}
