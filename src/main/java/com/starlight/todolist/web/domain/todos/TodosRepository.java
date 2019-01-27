package com.starlight.todolist.web.domain.todos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface TodosRepository extends JpaRepository<Todos, Long> {

    @Query("SELECT p " +
            "FROM Todos p " +
            "ORDER BY p.id DESC")
    Stream<Todos> findAllDesc();

    Page<Todos> findAll(Pageable pageable);

    @Query("SELECT COUNT(p) FROM Todos p")
    long getTotalCount();


}
