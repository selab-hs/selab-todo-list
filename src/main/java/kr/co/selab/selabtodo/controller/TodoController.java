package kr.co.selab.selabtodo.controller;

import io.swagger.v3.oas.annotations.Operation;
import kr.co.selab.selabtodo.dto.*;
import kr.co.selab.selabtodo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@RestController
@RequestMapping("api/todo/v1")
@RequiredArgsConstructor
public class TodoController{
    private final TodoService service;

    @Operation(summary = "Create Todo-List", description = "title과 content 요청 값으로 Todo List 생성")
    @PostMapping
    public ResponseEntity<TodoResponseDto> createTodo(@RequestBody CreateTodoRequestDto todo){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.createTodo(todo));
    }

    @Operation(summary = "Update Todo-List", description = "id를 통한 조회 및 Todo-List 업데이트")
    @PatchMapping("/{id}")
    public ResponseEntity<TodoResponseDto> updateTodo(@PathVariable @Positive long id,
                                                      @RequestBody UpdateTodoRequestDto todo) {
        return ResponseEntity.ok(service.updateTodo(id,todo));
    }

    @Operation(summary = "Delete Todo-List", description = "id를 통한 Todo-List 삭제")
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteTodoById(@PathVariable @Positive long id){
        service.deleteTodoById(id);
        return ResponseEntity.ok(id);
    }

    @Operation(summary = "Search Todo-List Page", description = "특정 페이지의 Todo-List를 5개씩 역순으로 조회")
    @GetMapping("/page")
    public ResponseEntity<InquiryTodoPageResponseDto> searchPageTodos(
            @PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC) @PositiveOrZero Pageable page){
        return ResponseEntity.ok(service.searchPageTodos(page));
    }

    @Operation(summary = "Search All Todo-List", description = "모든 Todo-List 조회")
    @GetMapping
    public ResponseEntity<InquiryTodoResponseDto> searchTodos(){
        return ResponseEntity.ok(service.searchAllTodos());
    }
}
