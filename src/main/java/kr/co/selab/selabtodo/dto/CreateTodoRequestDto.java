package kr.co.selab.selabtodo.dto;

import kr.co.selab.selabtodo.entity.TodoEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class CreateTodoRequestDto {
    String title;

    String content;

    boolean checked;

    public CreateTodoRequestDto(String title, String content){
        this.title = title;
        this.content = content;
        this.checked = false;
    }

    public TodoEntity toEntity(){
        return TodoEntity.builder()
                .title(this.title)
                .content(this.content)
                .checked(this.checked)
                .build();
    }
}
