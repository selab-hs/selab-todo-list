package kr.co.selab.selabtodo.repository;

import lombok.Data;

@Data
public class ItemUpdateResponseDto {
    private Long id;
    private String title;
    private Integer order;
    private Boolean completed;

    public ItemUpdateResponseDto() {
    }

    public ItemUpdateResponseDto(Long id, String title, Integer order, Boolean completed) {
        this.id = id;
        this.title = title;
        this.order = order;
        this.completed = completed;
    }
}


