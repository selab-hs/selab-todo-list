package kr.co.selab.selabtodo.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemSaveResponseDto {
    private Long id;
    private String title;
    private Integer order;
    private Boolean completed;
}
