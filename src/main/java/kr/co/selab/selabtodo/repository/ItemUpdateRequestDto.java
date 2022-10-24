package kr.co.selab.selabtodo.repository;

import lombok.*;

import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemUpdateRequestDto {
    @NotNull
    private String title;
    @NotNull
    private Integer order;
    @NotNull
    private Boolean completed;
}


