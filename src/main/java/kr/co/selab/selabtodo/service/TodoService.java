package kr.co.selab.selabtodo.service;

import kr.co.selab.selabtodo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TodoService {
    private final TodoRepository todoRepository;

}
