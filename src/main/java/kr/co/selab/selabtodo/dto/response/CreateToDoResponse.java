package kr.co.selab.selabtodo.dto.response;

import lombok.Data;

@Data
public class CreateToDoResponse {
  private String content;
  private Boolean isCompleted;
}
