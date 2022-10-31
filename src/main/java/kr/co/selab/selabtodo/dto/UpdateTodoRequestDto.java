package kr.co.selab.selabtodo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTodoRequestDto {
    private String title;

    private String content;

    private boolean checked;
}
