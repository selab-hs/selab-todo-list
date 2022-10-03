package kr.co.selab.selabtodo.error.exception;

import kr.co.selab.selabtodo.error.dto.ErrorMessage;
import lombok.Getter;

@Getter
public abstract class BusinessException extends RuntimeException {
    private final ErrorMessage errorMessage;

    public BusinessException(ErrorMessage message) {
        super(message.getDescription());
        this.errorMessage = message;
    }

}
