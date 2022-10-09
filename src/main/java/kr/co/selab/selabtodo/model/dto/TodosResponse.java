package kr.co.selab.selabtodo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class TodosResponse {
    private List<TodoResponse> todos;
}
