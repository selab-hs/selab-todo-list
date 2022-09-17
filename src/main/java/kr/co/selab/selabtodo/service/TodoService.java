package kr.co.selab.selabtodo.service;

import kr.co.selab.selabtodo.model.Todo;
import kr.co.selab.selabtodo.model.dto.TodoReq;
import kr.co.selab.selabtodo.model.dto.TodosRes;
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
    public TodosRes getTodos() {
        return TodosRes.builder()
                .todos(todoRepository.findAll())
                .build();
    }

    // 투두리스트에 아이템 추가
    public Todo createTodo(TodoReq request) {
        return todoRepository.save(Todo.buildTodo(request));
    }

    // 특정 아이템 수정
    public Todo updateTodo(Long id, TodoReq todoReq) {
        Todo todo = todoRepository.getById(id);
        if(todoReq.getTitle() != null) {
            todo.updateTitle(todoReq.getTitle());
        }
        if(todoReq.getOrder() != null) {
            todo.updateOrder(todoReq.getOrder());
        }
        if(todoReq.getCompleted() != null) {
            todo.updateCompleted(todoReq.getCompleted());
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
