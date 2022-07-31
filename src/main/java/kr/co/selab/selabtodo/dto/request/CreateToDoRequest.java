package kr.co.selab.selabtodo.dto.request;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateToDoRequest {

  private String content;
  private LocalDateTime createDataTime = LocalDateTime.now();

  public String getContent() {
    return content;
  }
}