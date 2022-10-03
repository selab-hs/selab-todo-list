package kr.co.selab.selabtodo.controller;

import kr.co.selab.selabtodo.common.ResponseDto;
import kr.co.selab.selabtodo.model.Todo;
import kr.co.selab.selabtodo.model.dto.CreateRequest;
import kr.co.selab.selabtodo.model.dto.TodosResponse;
import kr.co.selab.selabtodo.model.dto.UpdateRequest;
import kr.co.selab.selabtodo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/todos/")
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public ResponseEntity<TodosResponse> getAllTodo() {
        TodosResponse todos = todoService.getTodos();
        return ResponseDto.ok(todos);
    }

    @GetMapping("{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable("id") Long id) {
        Todo todo = todoService.getTodo(id);
        return ResponseDto.ok(todo);
    }

    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody CreateRequest request) {
        Todo todo = todoService.createTodo(request);
        return ResponseDto.ok(todo);
    }

    @PatchMapping("{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable("id") Long id, @RequestBody UpdateRequest request) {
        Todo todo = todoService.updateTodo(id, request);
        return ResponseDto.ok(todo);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable("id") Long id) {
        todoService.deleteTodo(id);
        return ResponseDto.noContent();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllTodo() {
        todoService.deleteAll();
        return ResponseDto.noContent();
    }
}
