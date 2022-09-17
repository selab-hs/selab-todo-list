package kr.co.selab.selabtodo.service;

import kr.co.selab.selabtodo.model.Todo;
import kr.co.selab.selabtodo.model.dto.TodoReq;
import kr.co.selab.selabtodo.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class TodoServiceTest {

    @Autowired
    TodoService todoService;

    @Autowired
    TodoRepository todoRepository;

    @Test
    void createTodo() {
        TodoReq todo1 = new TodoReq("title", 1L, false);
        Todo serviceTodo = todoService.createTodo(todo1);
        Todo repTodo = todoRepository.getById(serviceTodo.getId());
        assertEquals(todo1.getTitle(), repTodo.getTitle());
    }

    @Test
    void getTodo() {
        TodoReq todo1 = new TodoReq("title", 1L, false);
        Todo serviceTodo = todoService.createTodo(todo1);
        Todo getTodo = todoService.getTodo(serviceTodo.getId());
        assertEquals(todo1.getTitle(), getTodo.getTitle());
    }

    @Test
    void getTodos() {
    }

    @Test
    void updateTodo() {
    }

    @Test
    void deleteTodo() {
    }

    @Test
    void deleteAll() {
    }
}