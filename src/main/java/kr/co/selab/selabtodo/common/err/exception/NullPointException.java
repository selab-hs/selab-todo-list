package kr.co.selab.selabtodo.common.err.exception;

import kr.co.selab.selabtodo.common.err.ErrorMessage;

public class NullPointException extends BusinessException{
  public NullPointException(ErrorMessage message) {
    super(message);
  }
}
