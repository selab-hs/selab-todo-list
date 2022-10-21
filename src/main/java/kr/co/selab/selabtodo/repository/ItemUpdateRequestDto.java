package kr.co.selab.selabtodo.repository;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemUpdateRequestDto {
    private String title;
    private Integer order;
    private Boolean completed;
}


