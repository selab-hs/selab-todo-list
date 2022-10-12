package kr.co.selab.selabtodo.common.Handler;

import kr.co.selab.selabtodo.common.dto.ResponseDto;
import kr.co.selab.selabtodo.common.dto.ResponseMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class BoardResponseHandler {
  public <T> ResponseEntity<ResponseDto> toResponseEntity(ResponseMessage message, T data) {
    return ResponseEntity
        .status(message.getStatus())
        .body(
            new ResponseDto<>(message, data)
        );
  }
}