package kr.co.selab.selabtodo.application;

import java.util.Optional;
import kr.co.selab.selabtodo.common.err.ErrorMessage;
import kr.co.selab.selabtodo.common.err.exception.NullPointerException;
import kr.co.selab.selabtodo.domain.ToDoList;
import kr.co.selab.selabtodo.dto.request.CreateToDoRequest;
import kr.co.selab.selabtodo.dto.request.UpdateToDoRequest;
import kr.co.selab.selabtodo.dto.response.CreateToDoResponse;
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

  @Transactional(readOnly = true)
  public Page<CreateToDoResponse> getTodos(Pageable pageable) {
    Page<ToDoList> toDoPage = todoRepository.findAll(pageable);
    return toDoPage.map(
        ToDoList ->
            CreateToDoResponse.builder()
                .id(ToDoList.getId())
                .content(ToDoList.getContent())
                .isCompleted(ToDoList.getIsCompleted())
                .createdDate(ToDoList.getCreatedDate())
                .modifiedDate(ToDoList.getModifiedDate())
                .build()
    );
  }

  public void deleteTodo(Long id) {
    todoRepository.deleteById(id);
  }

  public CreateToDoResponse findTodoById(Long Id) {
    Optional<ToDoList> toDoList = todoRepository.findById(Id);
    return CreateToDoResponse.builder()
        .id(toDoList.get().getId())
        .content(toDoList.get().getContent())
        .isCompleted(toDoList.get().getIsCompleted())
        .createdDate(toDoList.get().getCreatedDate())
        .modifiedDate(toDoList.get().getModifiedDate())
        .build();
  }

  @Transactional
  public void createToDo(CreateToDoRequest createToDoRequest) {
    todoRepository.save(
        ToDoList.builder()
            .content(createToDoRequest.getContent())
            .isCompleted(false)
            .build()
    );
  }

  @Transactional
  public void updateToDo(Long id, UpdateToDoRequest updateToDoRequest) {
    ToDoList todo = todoRepository.findById(id)
        .orElseThrow(() -> {
          throw new NullPointerException(ErrorMessage.NOT_FIND_ID_TODO);
        });
    todo.update(updateToDoRequest.getContent(), updateToDoRequest.getIsCompleted());
    todoRepository.save(todo);
  }
}