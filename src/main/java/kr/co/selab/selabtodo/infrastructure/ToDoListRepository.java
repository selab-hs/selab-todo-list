package kr.co.selab.selabtodo.infrastructure;

import kr.co.selab.selabtodo.domain.ToDoList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {
  Page<ToDoList> findAll(Pageable pageable);
}