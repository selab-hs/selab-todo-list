package kr.co.selab.selabtodo.controller;

import kr.co.selab.selabtodo.model.Todo;
import kr.co.selab.selabtodo.model.dto.TodoReq;
import kr.co.selab.selabtodo.model.dto.TodosRes;
import kr.co.selab.selabtodo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/todo/")
public class TodoController {

    private final TodoService todoService;

    @GetMapping("")
    public TodosRes getAllTodo() {
        return todoService.getTodos();
    }

    @GetMapping("{id}")
    public Todo getTodoById(@PathVariable("id") Long id) {
        return todoService.getTodo(id);
    }

    @PostMapping("")
    public Todo createTodo(TodoReq todoReq) {
        return todoService.createTodo(todoReq);
    }

    @PatchMapping("{id}")
    public Todo updateTodo(@PathVariable("id") Long id, TodoReq todoReq) {
        return todoService.updateTodo(id, todoReq);
    }

    @DeleteMapping("{id}")
    public String deleteTodo(@PathVariable("id") Long id) {
        todoService.deleteTodo(id);
        String result = "해당 할 일이 삭제되었습니다";
        return result;
    }

    @DeleteMapping("")
    public String deleteAllTodo() {
        todoService.deleteAll();
        String result = "모든 할 일이 삭제되었습니다";
        return result;
    }
}
