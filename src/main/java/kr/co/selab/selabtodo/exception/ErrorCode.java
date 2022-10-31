package kr.co.selab.selabtodo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    INVALID_PARAMETER(400, "파라미터 값을 확인해주세요."),
    ID_NOT_FOUND(404, "존재하지 않는 ID 입니다."),
    INTERNAL_SERVER_ERROR(500, "서버 에러입니다.");

    private final int status;
    private final String message;
}