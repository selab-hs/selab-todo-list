package kr.co.selab.selabtodo.service;

import kr.co.selab.selabtodo.model.Todo;
import kr.co.selab.selabtodo.model.dto.TodoRequest;
import kr.co.selab.selabtodo.model.dto.TodosResponse;
import kr.co.selab.selabtodo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class TodoService {
    private final TodoRepository todoRepository;

    // 특정 아이템 조회
    public Todo getTodo(Long id) {
        return todoRepository.getById(id);
    }

    // 모든 아이템 조회
    public TodosResponse getTodos() {
        return TodosResponse.builder()
                .todos(todoRepository.findAll())
                .build();
    }

    // 투두리스트에 아이템 추가
    public Todo createTodo(TodoRequest request) {
        return todoRepository.save(Todo.buildTodo(request));
    }

    // 특정 아이템 수정
    public Todo updateTodo(Long id, TodoRequest todoRequest) {
        Todo todo = todoRepository.getById(id);
        if(todoRequest.getTitle() != null) {
            todo.updateTitle(todoRequest.getTitle());
        }
        if(todoRequest.getOrder() != null) {
            todo.updateOrder(todoRequest.getOrder());
        }
        if(todoRequest.getCompleted() != null) {
            todo.updateCompleted(todoRequest.getCompleted());
        }
        return todoRepository.save(todo);
    }

    // 특정 아이템 삭제
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }

    // 전체 아이템 삭제
    public void deleteAll() {
        todoRepository.deleteAll();
    }

}
