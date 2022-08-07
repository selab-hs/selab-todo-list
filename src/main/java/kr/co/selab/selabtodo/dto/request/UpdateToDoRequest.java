package kr.co.selab.selabtodo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UpdateToDoRequest {
  private  Long id;
  private String content;
  private Boolean isCompleted;
}