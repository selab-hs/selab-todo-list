package kr.co.selab.selabtodo.error.exception;

import kr.co.selab.selabtodo.error.dto.ErrorMessage;
import lombok.Getter;

import java.util.function.Supplier;

@Getter
public class NotExistsTodoException extends BusinessException {
    public NotExistsTodoException() {
        super(ErrorMessage.NOT_EXIST_TODO);
    }
}
