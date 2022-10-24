package kr.co.selab.selabtodo.service;

import kr.co.selab.selabtodo.dto.*;
import kr.co.selab.selabtodo.entity.TodoEntity;
import kr.co.selab.selabtodo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.relation.RelationNotFoundException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository repository;

    @Transactional(readOnly = true)
    public TodoResponseDto searchTodo(long id) throws RelationNotFoundException {
        return repository.findById(id).orElseThrow(RelationNotFoundException::new).toTodoResponseDto();
    }

    @Transactional
    public TodoResponseDto createTodo(CreateTodoRequestDto todo){
        return repository.save(todo.toEntity()).toTodoResponseDto();
    }

    @Transactional
    public TodoResponseDto updateTodo(long id, UpdateTodoRequestDto todo) throws RelationNotFoundException {
        return repository.save(searchTodo(id).updateTodo(id, todo)).toTodoResponseDto();
    }

    @Transactional
    public void deleteTodoById(long id) {
        repository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public InquiryTodoResponseDto searchAllTodos() {
        return new InquiryTodoResponseDto(repository.findAll().stream()
                .map(TodoEntity::toTodoResponseDto)
                .collect(Collectors.toList()));
    }

    @Transactional(readOnly = true)
    public InquiryTodoPageResponseDto searchPageTodos(Pageable page) {
        return new InquiryTodoPageResponseDto(page.getPageNumber(), repository.findAll(page).stream()
                .map(TodoEntity::toTodoResponseDto)
                .collect(Collectors.toList()));
    }
}
