package kr.co.selab.selabtodo.common.err;

import java.util.Arrays;
import org.springframework.http.HttpStatus;

public enum ErrorMessage {
  NOT_FIND_ID_TODO(HttpStatus.BAD_REQUEST, "ToDo가 존재하지 않습니다.");

  private final HttpStatus status;
  private final String message;

  ErrorMessage(HttpStatus status, String message){
    this.status = status;
    this.message = message;
  }

  public HttpStatus status(){
    return status;
  }

  public String message(){
    return message;
  }

  public static ErrorMessage of(String errorMessage){
    return Arrays.stream(values())
        .filter(e -> e.message.equals(errorMessage))
        .findFirst()
        .orElseThrow(() -> new RuntimeException("Non Existent Exception"));
  }
}