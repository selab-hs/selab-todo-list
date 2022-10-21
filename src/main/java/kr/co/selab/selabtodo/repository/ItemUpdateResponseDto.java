package kr.co.selab.selabtodo.repository;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemUpdateResponseDto {
    private Long id;
    private String title;
    private Integer order;
    private Boolean completed;
}


