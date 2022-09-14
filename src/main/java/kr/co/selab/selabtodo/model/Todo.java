package kr.co.selab.selabtodo.model;

import kr.co.selab.selabtodo.common.BaseEntity;
import kr.co.selab.selabtodo.model.dto.TodoReq;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Todo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(name = "todo_order", nullable = false)
    private Long order;

    @Column(nullable = false)
    private Boolean completed;

    @Builder
    public Todo(String title, Long order, Boolean completed) {
        this.title =title;
        this.order = order;
        this.completed = completed;
    }

    public static Todo buildTodo(TodoReq request) {
        return Todo.builder()
                .title(request.getTitle())
                .order(request.getOrder())
                .completed(request.getCompleted())
                .build();
    }

    public void updateTitle(String title) {
        this.title = title;
    }

    public void updateOrder(Long order) {
        this.order = order;
    }

    public void updateCompleted(Boolean completed) {
        this.completed = completed;
    }
}
