package kr.co.selab.selabtodo.dto;

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
}
