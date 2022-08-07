package kr.co.selab.selabtodo.common.converter;

import kr.co.selab.selabtodo.common.dto.ResponseDto.ResponseDtoV1;
import kr.co.selab.selabtodo.common.dto.ResponseDto.ResponseDtoV2;
import kr.co.selab.selabtodo.common.dto.ResponseMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseConverter {
  public ResponseEntity<ResponseDtoV1> toResponseEntity(ResponseMessage message) {
    return ResponseEntity
        .status(message.getStatus())
        .body(
            new ResponseDtoV1(message)
        );
  }

  public <T> ResponseEntity<ResponseDtoV2<T>> toResponseEntity(ResponseMessage message, T data) {
    return ResponseEntity
        .status(message.getStatus())
        .body(
            new ResponseDtoV2<>(message, data)
        );
  }
}
