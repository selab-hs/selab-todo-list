package kr.co.selab.selabtodo.controller;

import io.swagger.v3.oas.annotations.Operation;
import kr.co.selab.selabtodo.dto.*;
import kr.co.selab.selabtodo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.RelationNotFoundException;

@RestController
@RequestMapping("api/todo/v1")
@RequiredArgsConstructor
public class TodoController{
    private final TodoService service;

    @Operation(summary = "Create Todo-List", description = "title과 content 요청 값으로 Todo List 생성")
    @PostMapping
    public ResponseEntity<TodoResponseDto> createTodo(@RequestBody CreateTodoRequestDto todo){
        return ResponseEntity.ok(service.createTodo(todo));
    }

    @Operation(summary = "Update Todo-List", description = "id를 통한 조회 및 Todo-List 업데이트")
    @PatchMapping("/{id}")
    public ResponseEntity<TodoResponseDto> updateTodo(@PathVariable long id, @RequestBody UpdateTodoRequestDto todo) throws RelationNotFoundException {
        return ResponseEntity.ok(service.updateTodo(id,todo));
    }

    @Operation(summary = "Delete Todo-List", description = "id를 통한 Todo-List 삭제")
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteTodoById(@PathVariable long id){
        service.deleteTodoById(id);
        return ResponseEntity.ok(id);
    }

    @Operation(summary = "Search Todo-List Page", description = "특정 페이지의 Todo-List를 5개씩 역순으로 조회")
    @GetMapping
    public ResponseEntity<InquiryTodoPageResponseDto> searchPageTodos(@PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable page){
        return ResponseEntity.ok(service.searchPageTodos(page));
    }

    @Operation(summary = "Search All Todo-List", description = "모든 Todo-List 조회")
    @GetMapping("/all")
    public ResponseEntity<InquiryTodoResponseDto> searchTodos(){
        return ResponseEntity.ok(service.searchAllTodos());
    }
}
