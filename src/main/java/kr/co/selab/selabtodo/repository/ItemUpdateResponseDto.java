package kr.co.selab.selabtodo.repository;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class ItemUpdateResponseDto {
    private Long id;
    private String title;
    private Integer order;
    private Boolean completed;
}


