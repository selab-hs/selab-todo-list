package kr.co.selab.selabtodo.dto.response;

import lombok.Data;

@Data
public class UpdateToDoResponse {
  private String content;
  private Boolean isCompleted;
}