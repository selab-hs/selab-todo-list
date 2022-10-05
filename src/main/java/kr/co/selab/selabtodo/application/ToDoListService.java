package kr.co.selab.selabtodo.application;

import java.util.List;
import java.util.Optional;
import kr.co.selab.selabtodo.common.err.ErrorMessage;
import kr.co.selab.selabtodo.common.err.exception.NullPointException;
import kr.co.selab.selabtodo.domain.ToDoList;
import kr.co.selab.selabtodo.dto.request.CreateToDoRequest;
import kr.co.selab.selabtodo.dto.request.UpdateToDoRequest;
import kr.co.selab.selabtodo.infrastructure.ToDoListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ToDoListService {

  private final ToDoListRepository todoRepository;

  public List<ToDoList> getTodos(Pageable pageable) {
    return todoRepository.findAllTodo(pageable);
  }

  @Transactional(readOnly = true)
  public Page<ToDoList> pageable(Pageable pageable){
    return todoRepository.findAll(pageable);
  }

  public void deleteTodo(Long id) {
    todoRepository.deleteById(id);
  }


  public Optional<ToDoList> findTodoById(Long Id) {
    return todoRepository.findById(Id);
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
          throw new NullPointException(ErrorMessage.NOT_FIND_ID_TODO);
        });
    todo.update(updateToDoRequest.getContent(),updateToDoRequest.getIsCompleted());
  }
}