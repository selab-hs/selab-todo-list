package kr.co.selab.selabtodo.repository;

import kr.co.selab.selabtodo.domain.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemRepositoryDto {
    private Long id;
    private String title;
    private Integer order;
    private Boolean completed;

    public ItemRepositoryDto(Item item) {
        this.id = item.getId();
        this.title = item.getTitle();
        this.order = item.getOrder();
        this.completed = item.getCompleted();
    }
}