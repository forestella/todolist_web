package com.starlight.todolist.web.domain.refTodos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface RefTodosRepository extends JpaRepository<RefTodos, Long> {

    @Query("SELECT p " +
            "FROM RefTodos p " +
            "ORDER BY p.id DESC")
    Stream<RefTodos> findAllDesc();
}
