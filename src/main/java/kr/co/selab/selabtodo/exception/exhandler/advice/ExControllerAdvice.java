package kr.co.selab.selabtodo.exception.exhandler.advice;

import kr.co.selab.selabtodo.exception.exhandler.ErrorResult;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ExControllerAdvice {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ErrorResult httpMessageExHandle(HttpMessageNotReadableException e) {
        return new ErrorResult("BAD REQUEST", "잘못된 입력 값입니다.");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ErrorResult httpMessageExHandle(MethodArgumentNotValidException e) {
        return new ErrorResult("BAD REQUEST", "입력 값은 비워둘 수 없습니다.");
    }

    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected ErrorResult httpRequestExHandle(HttpRequestMethodNotSupportedException e) {
        return new ErrorResult("METHOD NOT ALLOWED", "요청이 잘못되었습니다.");
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({NoSuchElementException.class, EmptyResultDataAccessException.class})
    protected ErrorResult notFoundExHandle(Exception e) {
        return new ErrorResult("NOT FOUND", "존재하지 않는 ID입니다.");
    }
}
