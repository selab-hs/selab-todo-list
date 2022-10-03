package kr.co.selab.selabtodo.error.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
public class ErrorResponseDto {
    private HttpStatus status;
    private String description;

    @Builder
    public ErrorResponseDto(HttpStatus status, String description) {
        this.status = status;
        this.description = description;
    }
}
