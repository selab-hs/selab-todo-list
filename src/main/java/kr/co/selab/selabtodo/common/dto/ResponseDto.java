package kr.co.selab.selabtodo.common.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.Getter;

@Getter
public class ResponseDto<T> {

  @Getter
  public static class ResponseDtoV1 {

    private final String message;
    private final String serverDateTime;

    public ResponseDtoV1(ResponseMessage message) {
      this.message = message.name();
      this.serverDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }
  }

  @Getter
  public static class ResponseDtoV2<T> {

    private final String message;
    private final String serverDateTime;
    private final T data;

    public ResponseDtoV2(ResponseMessage message, T data) {
      this.message = message.name();
      this.serverDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
      this.data = data;
    }
  }
}