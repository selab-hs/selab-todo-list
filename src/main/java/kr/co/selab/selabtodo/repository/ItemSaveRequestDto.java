package kr.co.selab.selabtodo.repository;

import lombok.Data;

@Data
public class ItemSaveRequestDto {
    private String title;
    private Integer order;

    public ItemSaveRequestDto() {
    }

    public ItemSaveRequestDto(String title, Integer order) {
        this.title = title;
        this.order = order;
    }
}
