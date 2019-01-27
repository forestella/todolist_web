package com.starlight.todolist.web.domain.todos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.starlight.todolist.dto.todos.TodosSaveRequestDto;
import com.starlight.todolist.web.domain.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
public class Todos extends BaseTimeEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 500, nullable = false)
    private String todo;

    @Column
    private String completeYn;

    @ManyToMany(mappedBy = "refTodos")
    @JsonIgnore
    private List<Todos> originTodos = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "ref_todos",
            joinColumns = @JoinColumn(name = "todo_id"),
            inverseJoinColumns = @JoinColumn(name = "ref_id"))
    private List<Todos> refTodos = new ArrayList<>();



    @Builder
    public Todos(String todo, String completeYn) {
        this.todo = todo;
        this.completeYn = completeYn;
    }

    public void update (TodosSaveRequestDto dto) {
        this.todo = dto.getTodo();
        this.completeYn = dto.getCompleteYn();
    }

    public void updateRefTodo (Todos todos){
        refTodos.add(todos);
    }


}
