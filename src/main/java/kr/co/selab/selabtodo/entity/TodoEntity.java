package kr.co.selab.selabtodo.entity;

import kr.co.selab.selabtodo.common.BaseEntity;
import kr.co.selab.selabtodo.dto.TodoResponseDto;
import kr.co.selab.selabtodo.dto.UpdateTodoRequestDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="todo_list")
public class TodoEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String title;

    @Column(length = 2000, nullable = false)
    private String content;

    @Column(nullable = false)
    private boolean checked;

    @Builder
    public TodoEntity(long id, String title, String content, boolean checked){
        this.id = id;
        this.title = title;
        this.content = content;
        this.checked = checked;
    }

    @Builder
    public TodoEntity(String title, String content){
        this.title = title;
        this.content = content;
        this.checked = false;
    }

    public TodoResponseDto toTodoResponseDto(){
        return TodoResponseDto.builder()
                .id(this.id)
                .title(this.title)
                .content(this.content)
                .checked(this.checked)
                .build();
    }

    public void updateTodoEntity(UpdateTodoRequestDto todo){
        this.title = todo.getTitle();
        this.content = todo.getContent();
        this.checked = todo.isChecked();
    }
}
