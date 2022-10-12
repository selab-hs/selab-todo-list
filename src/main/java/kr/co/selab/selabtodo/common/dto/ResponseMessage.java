package kr.co.selab.selabtodo.common.dto;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ResponseMessage {
  CREATE_TODO_SUCCESS(HttpStatus.CREATED, "ToDo 추가 성공"),
  UPDATE_TODO_SUCCESS(HttpStatus.OK,"ToDo 수정 성공"),
  READ_ALL_TODO_SUCCESS(HttpStatus.OK,"ToDo 전체 조회 성공"),
  READ_TODO_SUCCESS(HttpStatus.OK,"ToDo 아이디 조회 성공"),
  DELETE_TODO_SUCCESS(HttpStatus.OK, "ToDo 삭제 성공");


  private final HttpStatus status;
  private final String message;

  ResponseMessage(HttpStatus status, String message) {
    this.status = status;
    this.message = message;
  }
}