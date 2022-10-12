package kr.co.selab.selabtodo.dto.request;

import lombok.Data;

@Data
public class UpdateToDoRequest {
  private  Long id;
  private String content;
  private Boolean isCompleted;
}