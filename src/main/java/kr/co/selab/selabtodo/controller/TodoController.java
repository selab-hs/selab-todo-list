package kr.co.selab.selabtodo.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.models.Swagger;
import kr.co.selab.selabtodo.common.dto.ResponseDto;
import kr.co.selab.selabtodo.common.dto.SwaggerNote;
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

    @ApiOperation(value = "모든 Todo list 조회", notes = SwaggerNote.TODO_READ_ALL_NOTE)
    @GetMapping
    public ResponseEntity<TodosResponse> getAllTodo() {
        TodosResponse todos = todoService.getTodos();
        return ResponseDto.ok(todos);
    }

    @ApiOperation(value = "Todo list 단건 조회", notes = SwaggerNote.TODO_READ_ONE_NOTE)
    @GetMapping("{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable("id") Long id) {
        Todo todo = todoService.getTodo(id);
        return ResponseDto.ok(todo);
    }

    @ApiOperation(value = "Todo 생성하기", notes = SwaggerNote.TODO_CREATE_NOTE)
    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody CreateRequest request) {
        Todo todo = todoService.createTodo(request);
        return ResponseDto.ok(todo);
    }

    @ApiOperation(value = "Todo 수정하기", notes = SwaggerNote.TODO_UPDATE_NOTE)
    @PatchMapping("{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable("id") Long id, @RequestBody UpdateRequest request) {
        Todo todo = todoService.updateTodo(id, request);
        return ResponseDto.ok(todo);
    }

    @ApiOperation(value = "Todo 단건 삭제하기", notes = SwaggerNote.TODO_DELTE_NOTE)
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable("id") Long id) {
        todoService.deleteTodo(id);
        return ResponseDto.noContent();
    }

    @ApiOperation(value = "Todo 전체 삭제하기", notes = SwaggerNote.TODO_DELTE_ALL_NOTE)
    @DeleteMapping
    public ResponseEntity<Void> deleteAllTodo() {
        todoService.deleteAll();
        return ResponseDto.noContent();
    }
}
