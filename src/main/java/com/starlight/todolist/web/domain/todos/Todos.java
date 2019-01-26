package com.starlight.todolist.web.domain.todos;

import com.starlight.todolist.dto.todos.TodosSaveRequestDto;
import com.starlight.todolist.web.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Todos extends BaseTimeEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 500, nullable = false)
    private String todo;

    @Column
    private String completeYn;

    @Builder
    public Todos(String todo, String completeYn) {
        this.todo = todo;
        this.completeYn = completeYn;
    }

    public void update (TodosSaveRequestDto dto) {
        this.todo = dto.getTodo();
        this.completeYn = dto.getCompleteYn();
    }


}
