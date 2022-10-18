package kr.co.selab.selabtodo.controller;

import kr.co.selab.selabtodo.dto.*;
import kr.co.selab.selabtodo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/todo")
@RequiredArgsConstructor
public class TodoController{
    private final TodoService service;

    @PostMapping
    public ResponseEntity<TodoResponseDto> createTodo(@RequestBody CreateTodoRequestDto todo){
        return ResponseEntity.ok(service.createTodo(todo));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TodoResponseDto> updateTodo(@PathVariable long id, @RequestBody UpdateTodoRequestDto todo){
        return ResponseEntity.ok(service.updateTodo(id,todo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteTodoById(@PathVariable long id){
        service.deleteTodoById(id);
        return ResponseEntity.ok(id);
    }

    @GetMapping
    public ResponseEntity<InquiryTodoPageResponseDto> searchPageTodos(@PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable page){
        return ResponseEntity.ok(service.searchPageTodos(page));
    }

    @GetMapping("/all")
    public ResponseEntity<InquiryTodoResponseDto> searchTodos(){
        return ResponseEntity.ok(service.searchAllTodos());
    }
}
