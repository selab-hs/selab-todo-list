package kr.co.selab.selabtodo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.management.relation.RelationNotFoundException;

@RestControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(RelationNotFoundException.class)
    public ResponseEntity handleRelationNotFoundException(RelationNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                ErrorResponse.builder()
                        .code(404)
                        .content("해당 정보가 존재하지 않습니다")
                        .build()
        );
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity handleIllegalArgumentException(IllegalArgumentException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                ErrorResponse.builder()
                        .code(400)
                        .content("잘못된 요청 정보 입니다")
                        .build()
        );
    }
}
