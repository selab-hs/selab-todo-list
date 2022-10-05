package kr.co.selab.selabtodo.common.err.exception;

import kr.co.selab.selabtodo.common.err.ErrorMessage;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException{

  private ErrorMessage errorMessage;

  public BusinessException(ErrorMessage message){
    super(message.message());
    this.errorMessage = message;
  }
}