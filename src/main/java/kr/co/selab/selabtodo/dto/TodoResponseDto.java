package kr.co.selab.selabtodo.dto;

import kr.co.selab.selabtodo.entity.TodoEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TodoResponseDto {
    Long id;
    String title;
    String content;
    boolean checked;

    @Builder
    public TodoResponseDto(long id, String title, String content, boolean checked){
        this.id = id;
        this.title = title;
        this.content = content;
        this.checked = checked;
    }

    public TodoEntity toEntity(){
        return TodoEntity.builder()
                .id(this.id)
                .title(this.title)
                .content(this.content)
                .checked(this.checked)
                .build();
    }

    public TodoEntity updateTodo(long id, UpdateTodoRequestDto todo){
        this.id = id;
        this.title = todo.getTitle();
        this.content = todo.getContent();
        this.checked = todo.isChecked();

        return toEntity();
    }
}
