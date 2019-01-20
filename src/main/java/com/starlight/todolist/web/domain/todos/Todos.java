package com.starlight.todolist.web.domain.todos;

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

    @Column(columnDefinition = "TEXT", nullable = false)
    private String completeYn = "N";

    @Builder
    public Todos(String todo, String completeYn) {
        this.todo = todo;
        this.completeYn = completeYn;
    }


}
