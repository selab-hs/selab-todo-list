package kr.co.selab.selabtodo.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemSaveRequestDto {
    @NotNull(message = "title은 비워둘 수 없습니다.")
    private String title;

    @NotNull(message = "order는 비워둘 수 없습니다.")
    private Integer order;
}
