package kr.co.selab.selabtodo.error.exception;

import kr.co.selab.selabtodo.error.dto.ErrorResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponseDto> handleBusinessException(final BusinessException e) {
        log.error("BusinessException : {}", e.getMessage());
        ErrorResponseDto errorResponseDto = ErrorResponseDto.builder()
                .status(e.getErrorMessage().getStatus())
                .description(e.getErrorMessage().getDescription())
                .build();
        return ResponseEntity.status(e.getErrorMessage().getStatus())
                .body(errorResponseDto);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorResponseDto> handleNullPointerException(final NullPointerException e) {
        log.error("NullPointerException : {}", e.getMessage());
        ErrorResponseDto errorResponseDto = ErrorResponseDto.builder()
                .status(HttpStatus.BAD_REQUEST)
                .description(e.getMessage())
                .build();

        return ResponseEntity.status(errorResponseDto.getStatus())
                .body(errorResponseDto);
    }
}
