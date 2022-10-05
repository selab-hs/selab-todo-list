package kr.co.selab.selabtodo.infrastructure;

import org.springframework.data.domain.Pageable;
import java.util.List;
import kr.co.selab.selabtodo.domain.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {
  List<ToDoList> findAllTodo(Pageable pageable);
}