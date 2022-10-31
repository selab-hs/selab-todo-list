package kr.co.selab.selabtodo.service;

import kr.co.selab.selabtodo.dto.*;
import kr.co.selab.selabtodo.entity.TodoEntity;
import kr.co.selab.selabtodo.exception.NotExistTodoException;
import kr.co.selab.selabtodo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository repository;

    @Transactional(readOnly = true)
    public TodoEntity searchTodo(long id){
        return repository.findById(id)
                .orElseThrow(NotExistTodoException::new);
    }

    @Transactional
    public TodoResponseDto createTodo(CreateTodoRequestDto todo){
        return repository.save(todo.toEntity())
                .toTodoResponseDto();
    }

    @Transactional
    public TodoResponseDto updateTodo(long id, UpdateTodoRequestDto todo) {
        var response = searchTodo(id);
        response.updateTodoEntity(todo);

        return response.toTodoResponseDto();
    }

    @Transactional
    public void deleteTodoById(long id) {

        repository.deleteById(searchTodo(id).getId());
    }

    @Transactional(readOnly = true)
    public InquiryTodoResponseDto searchAllTodos() {
        var response = repository.findAll().stream()
                .map(TodoEntity::toTodoResponseDto)
                .collect(Collectors.toList());

        return new InquiryTodoResponseDto(response);
    }

    @Transactional(readOnly = true)
    public InquiryTodoPageResponseDto searchPageTodos(Pageable page) {
        int pageNumber = page.getPageNumber();
        var response = repository.findAll(page).stream()
                .map(TodoEntity::toTodoResponseDto)
                .collect(Collectors.toList());

        return new InquiryTodoPageResponseDto(pageNumber, response);
    }
}
