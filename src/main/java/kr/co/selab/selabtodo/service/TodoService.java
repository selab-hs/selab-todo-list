package kr.co.selab.selabtodo.service;

import kr.co.selab.selabtodo.error.exception.NotExistsTodoException;
import kr.co.selab.selabtodo.model.Todo;
import kr.co.selab.selabtodo.model.dto.CreateRequest;
import kr.co.selab.selabtodo.model.dto.TodoResponse;
import kr.co.selab.selabtodo.model.dto.TodosResponse;
import kr.co.selab.selabtodo.model.dto.UpdateRequest;
import kr.co.selab.selabtodo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class TodoService {
    private final TodoRepository todoRepository;

    @Transactional(readOnly = true)
    public TodoResponse getTodo(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(NotExistsTodoException::new);
        return TodoResponse.of(todo);
    }

    @Transactional(readOnly = true)
    public TodosResponse getTodos() {
        return TodosResponse.builder()
                .todos(todoRepository.findAll())
                .build();
    }

    @Transactional
    public TodoResponse createTodo(CreateRequest request) {
        Todo todo = todoRepository.save(Todo.builder()
                .title(request.title())
                .order(request.order())
                .completed(Boolean.FALSE)
                .build());

        return TodoResponse.of(todo);
    }

    @Transactional
    public TodoResponse updateTodo(Long id, UpdateRequest request) {
        Todo todo = todoRepository.getById(id);
        todo.update(request);
        return TodoResponse.of(todo);
    }

    @Transactional
    public void deleteTodo(Long id) {
        if(!todoRepository.existsById(id)) {
            throw new NotExistsTodoException();
        }
        todoRepository.deleteById(id);
    }

    @Transactional
    public void deleteAll() {
        todoRepository.deleteAll();
    }

}
