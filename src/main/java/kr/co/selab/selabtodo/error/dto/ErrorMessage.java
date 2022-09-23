package kr.co.selab.selabtodo.error.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorMessage {
    NOT_EXIST_TODO(HttpStatus.NOT_FOUND, "존재하지 않는 아이템입니다."),
    ;

    private final HttpStatus status;
    private final String description;
}
