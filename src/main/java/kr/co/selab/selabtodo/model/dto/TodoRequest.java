package kr.co.selab.selabtodo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TodoRequest {
    private String title;
    private Long order;
    private Boolean completed;
}
