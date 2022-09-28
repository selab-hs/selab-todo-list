package kr.co.selab.selabtodo.controller;

import kr.co.selab.selabtodo.model.TodoEntity;
import kr.co.selab.selabtodo.model.TodoRequest;
import kr.co.selab.selabtodo.model.TodoResponse;
import kr.co.selab.selabtodo.service.TodoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
@RestController
@RequestMapping("/")
@Slf4j
public class TodoController {

    private final TodoService service;

    @PostMapping("/create")
    public ResponseEntity<TodoResponse> create(@RequestBody TodoRequest request) {
        log.info("할 일 생성");

        if (ObjectUtils.isEmpty(request.getTitle()))
            return ResponseEntity.badRequest().build();

        if (ObjectUtils.isEmpty(request.getOrder()))
            request.setOrder(0L);

        if (ObjectUtils.isEmpty(request.getChecked()))
            request.setChecked(false);

        TodoEntity result = this.service.add(request);

        return ResponseEntity.ok(new TodoResponse(result));
    }

    @GetMapping("{id}")
    public ResponseEntity<TodoResponse> item(@PathVariable Long id) {
        log.info("단건 조회");
        TodoEntity result = this.service.findById(id);

        return ResponseEntity.ok(new TodoResponse(result));
    }

    @GetMapping
    public ResponseEntity<List<TodoResponse>> items() {
        log.info("전체 조회");

        List<TodoEntity> todoList = this.service.findAll();
        List<TodoResponse> response = todoList.stream()
                .map(TodoResponse::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    @PatchMapping("{id}")
    public ResponseEntity<TodoEntity> update(@PathVariable Long id, @RequestBody TodoRequest request) {
        log.info("수정");
        TodoEntity result = this.service.update(id, request);

        return ResponseEntity.ok(result);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        log.info("삭제");
        this.service.delete(id);

        return ResponseEntity.ok().build();
    }
}
