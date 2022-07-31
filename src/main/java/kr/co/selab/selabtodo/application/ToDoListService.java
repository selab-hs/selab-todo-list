package kr.co.selab.selabtodo.application;

import java.time.LocalDateTime;
import java.util.List;
import kr.co.selab.selabtodo.domain.ToDoList;
import kr.co.selab.selabtodo.dto.request.CreateToDoRequest;
import kr.co.selab.selabtodo.dto.request.UpdateToDoRequest;
import kr.co.selab.selabtodo.infrastructure.ToDoListRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ToDoListService {

  private final ToDoListRepository todoRepository;

  public ToDoListService(ToDoListRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  public String findTodoByContent(Long id) {
    return findTodoById(id).getContent();
  }

  public Boolean findTodoByIsCompleted(Long id) {
    return findTodoById(id).getIsCompleted();
  }

  public LocalDateTime findTodoByCreateDateTime(Long id) {
    return findTodoById(id).getCreatedDateTime();
  }


  public List<ToDoList> getTodos(Sort sort) {
    return todoRepository.findAll(sort);
  }

  public void postTodo(ToDoList toDoList) {
    todoRepository.save(toDoList);
  }


  public void deleteTodo(Long id) {
    todoRepository.deleteById(id);
  }


  public ToDoList findTodoById(Long Id) {
    return todoRepository.findById(Id).orElse(new ToDoList());
  }

  public ToDoList createToDos(CreateToDoRequest createToDoRequest) {
    return createToDo(createToDoRequest);
  }

  public ToDoList createToDo(CreateToDoRequest createToDoRequest) {
    return ToDoList.builder()
        .content(createToDoRequest.getContent())
        .createdDateTime(LocalDateTime.now())
        .isCompleted(false)
        .build();
  }

  public ToDoList updateToDo(Long id, UpdateToDoRequest updateToDoRequest) {
    return ToDoList.builder()
        .id(id)
        .content(updateToDoRequest.getContent())
        .isCompleted(false)
        .createdDateTime(LocalDateTime.now())
        .build();
  }
}