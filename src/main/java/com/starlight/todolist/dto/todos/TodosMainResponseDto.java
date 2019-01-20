package com.starlight.todolist.dto.todos;

import com.starlight.todolist.web.domain.todos.Todos;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Getter
public class TodosMainResponseDto {
    private Long id;
    private String todo;
    private String completeYn;
    private String createdTime;
    private String modifiedTime;

    public TodosMainResponseDto(Todos entity){
        id = entity.getId();
        todo = entity.getTodo ();
        completeYn = entity.getCompleteYn();
        createdTime = toStringDateTime(entity.getCreatedTime());
        modifiedTime = toStringDateTime(entity.getModifiedTime());
    }

    private String toStringDateTime(LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime)
                .map(formatter::format)
                .orElse("");
    }
}
