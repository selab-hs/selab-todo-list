package kr.co.selab.selabtodo.service;

import kr.co.selab.selabtodo.error.exception.NotExistsTodoException;
import kr.co.selab.selabtodo.model.Todo;
import kr.co.selab.selabtodo.model.dto.CreateRequest;
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
    public Todo getTodo(Long id) {
        return todoRepository.findById(id).orElseThrow(NotExistsTodoException::new);
    }

    @Transactional(readOnly = true)
    public TodosResponse getTodos() {
        return TodosResponse.builder()
                .todos(todoRepository.findAll())
                .build();
    }

    @Transactional
    public Todo createTodo(CreateRequest request) {
        return todoRepository.save(Todo.builder()
                        .title(request.title())
                        .order(request.order())
                        .completed(Boolean.FALSE)
                .build());
    }

    @Transactional
    public Todo updateTodo(Long id, UpdateRequest request) {
        Todo todo = getTodo(id);
        todo.update(request);
        return getTodo(id);
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
