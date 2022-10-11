package kr.co.selab.selabtodo.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateToDoResponse {
  private Long id;
  private String content;
  private Boolean isCompleted;
}