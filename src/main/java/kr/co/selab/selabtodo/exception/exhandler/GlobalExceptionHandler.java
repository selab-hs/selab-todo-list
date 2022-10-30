package kr.co.selab.selabtodo.exception.exhandler;

import kr.co.selab.selabtodo.exception.CustomException;
import kr.co.selab.selabtodo.exception.dto.ErrorDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static kr.co.selab.selabtodo.exception.ErrorCode.*;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomException.class)
    protected ResponseEntity handleCustomException(CustomException e) {
        log.error("Error Code: {}, Error Message: {}", e.getErrorCode().getStatus(), e.getErrorCode().getMessage());
        return new ResponseEntity(
                new ErrorDto(e.getErrorCode().getStatus(), e.getErrorCode().getMessage()),
                HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }

    @ExceptionHandler({MethodArgumentNotValidException.class, HttpMessageNotReadableException.class})
    protected ResponseEntity handleMethodArgNotValidException(Exception e) {
        log.error("파라미터 값이 잘못되었습니다.", e);
        return new ResponseEntity(
                new ErrorDto(INVALID_PARAMETER.getStatus(), INVALID_PARAMETER.getMessage()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity handleServerException(Exception e) {
        log.error("내부 에러입니다.", e);
        return new ResponseEntity(
                new ErrorDto(INTERNAL_SERVER_ERROR.getStatus(), INTERNAL_SERVER_ERROR.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
