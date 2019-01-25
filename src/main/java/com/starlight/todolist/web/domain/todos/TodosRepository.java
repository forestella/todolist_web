package com.starlight.todolist.web.domain.todos;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface TodosRepository extends JpaRepository<Todos, Long> {

    @Query("SELECT p " +
            "FROM Todos p " +
            "ORDER BY p.id DESC")
    Stream<Todos> findAllDesc();

    @Query("SELECT COUNT(p) FROM Todos p")
    long getTotalCount();


//    @Query("UPDATE TODOS p SET p.complete_yn = :complete_yn WHERE p.id = :id");
//    Stream<Todos>  update();
}
