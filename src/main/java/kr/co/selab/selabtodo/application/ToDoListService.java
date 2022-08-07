package kr.co.selab.selabtodo.application;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Id;
import kr.co.selab.selabtodo.domain.ToDoList;
import kr.co.selab.selabtodo.dto.request.CreateToDoRequest;
import kr.co.selab.selabtodo.dto.request.UpdateToDoRequest;
import kr.co.selab.selabtodo.infrastructure.ToDoListRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ToDoListService {

  private final ToDoListRepository todoRepository;

  public List<ToDoList> getTodos(Sort sort) {
    return todoRepository.findAll(sort);
  }

  public void deleteTodo(Long id) {
    todoRepository.deleteById(id);
  }


  public ToDoList findTodoById(Long Id) {
    return todoRepository.findById(Id).orElse(new ToDoList());
  }

  @Transactional
  public void createToDo(CreateToDoRequest createToDoRequest) {
    todoRepository.save(ToDoList.builder()
        .content(createToDoRequest.getContent())
        .isCompleted(false)
        .build()
    );
  }

  @Transactional
  public void updateToDo(Long id, UpdateToDoRequest updateToDoRequest) {
    ToDoList todo = todoRepository.findById(id)
        .orElseThrow(()-> {
          throw new NullPointerException();
        });
    todo.update(updateToDoRequest.getContent(),updateToDoRequest.getIsCompleted());
  }
}