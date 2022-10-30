package kr.co.selab.selabtodo.repository;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class ItemUpdateRequestDto {
    @NotNull
    private String title;
    @NotNull
    private Integer order;
    @NotNull
    private Boolean completed;
}


