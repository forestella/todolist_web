package com.starlight.todolist.web.domain.refTodos;

import com.starlight.todolist.web.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class RefTodos extends BaseTimeEntity {

    @Id
    @Column(nullable = false)
    private Long todoId;

    @Column(nullable = false)
    private Long refId;

    @Builder
    public RefTodos(Long todoId, Long refId) {
        this.todoId = todoId;
        this.refId = refId;
    }


}
