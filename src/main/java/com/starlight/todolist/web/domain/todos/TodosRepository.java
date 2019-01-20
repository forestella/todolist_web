package com.starlight.todolist.web.domain.todos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface TodosRepository extends JpaRepository<Todos, Long> {

    @Query("SELECT p " +
            "FROM Todos p " +
            "ORDER BY p.id DESC")
    Stream<Todos> findAllDesc();
}
