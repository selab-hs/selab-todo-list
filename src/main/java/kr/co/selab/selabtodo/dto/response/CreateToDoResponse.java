package kr.co.selab.selabtodo.dto.response;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateToDoResponse {
  private Long id;
  private String content;
  private Boolean isCompleted;
  private LocalDateTime createdDate;
  private LocalDateTime modifiedDate;
}