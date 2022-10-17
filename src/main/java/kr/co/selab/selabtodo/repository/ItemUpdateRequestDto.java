package kr.co.selab.selabtodo.repository;

import lombok.Data;

@Data
public class ItemUpdateRequestDto {
    private String title;
    private Integer order;
    private Boolean completed;

    public ItemUpdateRequestDto() {
    }

    public ItemUpdateRequestDto(String title, Integer order, Boolean completed) {
        this.title = title;
        this.order = order;
        this.completed = completed;
    }
}


