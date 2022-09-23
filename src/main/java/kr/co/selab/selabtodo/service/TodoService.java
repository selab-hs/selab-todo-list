package kr.co.selab.selabtodo.service;

import kr.co.selab.selabtodo.error.exception.NotExistsTodoException;
import kr.co.selab.selabtodo.model.Todo;
import kr.co.selab.selabtodo.model.dto.CreateRequest;
import kr.co.selab.selabtodo.model.dto.TodoRequest;
import kr.co.selab.selabtodo.model.dto.TodosResponse;
import kr.co.selab.selabtodo.model.dto.UpdateRequest;
import kr.co.selab.selabtodo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@RequiredArgsConstructor
@Service
public class TodoService {
    private final TodoRepository todoRepository;

    @Transactional(readOnly = true)
    public Todo getTodo(Long id) {
        return todoRepository.findById(id).orElseThrow(NotExistsTodoException::new);
    }

    @Transactional(readOnly = true)
    public TodosResponse getTodos() {
        return TodosResponse.builder()
                .todos(todoRepository.findAll())
                .build();
    }

    // 투두리스트에 아이템 추가
    public Todo createTodo(CreateRequest request) {
        return todoRepository.save(Todo.builder()
                        .title(request.title())
                        .order(request.order())
                        .completed(false)
                .build());
    }

    @Transactional
    public Todo updateTodo(Long id, UpdateRequest request) {
        Todo todo = getTodo(id);
        todo.update(request);
        return getTodo(id);
    }

    // 특정 아이템 삭제
    public Boolean deleteTodo(Long id) {
        todoRepository.deleteById(id);
        if(todoRepository.findById(id).isPresent()) {
            return false;
        }
        return true;
    }

    // 전체 아이템 삭제
    public void deleteAll() {
        todoRepository.deleteAll();
    }

}
