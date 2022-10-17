package kr.co.selab.selabtodo.repository;

import lombok.Data;

@Data
public class ItemSaveResponseDto {
    private Long id;
    private String title;
    private Integer order;
    private Boolean completed;

    public ItemSaveResponseDto() {
    }

    public ItemSaveResponseDto(Long id, String title, Integer order, Boolean completed) {
        this.id = id;
        this.title = title;
        this.order = order;
        this.completed = completed;
    }
}
