package kr.co.selab.selabtodo.exception.dto;

import kr.co.selab.selabtodo.exception.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorDto {
    private int status;
    private String message;

    public static ErrorDto of(ErrorCode errorCode) {
        return new ErrorDto(errorCode.getStatus(), errorCode.getMessage());
    }
}
