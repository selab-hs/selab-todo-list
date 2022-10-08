package kr.co.selab.selabtodo.common.err.exception;

import kr.co.selab.selabtodo.common.err.ErrorMessage;

public class NullPointerException extends BusinessException{
  public NullPointerException(ErrorMessage message) {
    super(message);
  }
}
