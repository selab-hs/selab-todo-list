package kr.co.selab.selabtodo.service;

import kr.co.selab.selabtodo.model.Todo;
import kr.co.selab.selabtodo.model.dto.CreateRequest;
import kr.co.selab.selabtodo.repository.TodoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@Transactional
@ExtendWith(MockitoExtension.class)
class TodoServiceTest {

    @Mock
    private TodoRepository todoRepository;

    @InjectMocks
    private TodoService todoService;

    @Test
    void createTodo() {
        when(this.todoRepository.save(any(Todo.class)))
                .then(AdditionalAnswers.returnsFirstArg());

        CreateRequest expected = new CreateRequest("test", 1L);
        Todo actual = this.todoService.createTodo(expected);

        assertEquals(expected.title(), actual.getTitle());
    }

    @Test
    void getTodo() {
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