package kr.co.selab.selabtodo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class InquiryTodoPageResponseDto {
    private int page;
    private List<TodoResponseDto> inquiryAllTodo;
}
