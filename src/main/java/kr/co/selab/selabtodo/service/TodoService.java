package kr.co.selab.selabtodo.service;

import kr.co.selab.selabtodo.model.TodoEntity;
import kr.co.selab.selabtodo.model.TodoRequest;
import kr.co.selab.selabtodo.repository.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoService {
    private final TodoRepository repository;

    public TodoEntity add(TodoRequest request) {
        TodoEntity entity = new TodoEntity();

        entity.setTitle(request.getTitle());
        entity.setOrder(request.getOrder());
        entity.setChecked(request.getChecked());

        return this.repository.save(entity);
    }

    public TodoEntity update(Long id, TodoRequest request) {
        TodoEntity entity = this.findById(id);

        if (request.getTitle() != null) {
            entity.setTitle(request.getTitle());
        }

        if (request.getOrder() != null) {
            entity.setOrder(request.getOrder());
        }

        if(request.getChecked() != null) {
            entity.setChecked(request.getChecked());
        }

        return this.repository.save(entity);
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    public TodoEntity findById(Long id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<TodoEntity> findAll() {
        return this.repository.findAll();
    }

}
