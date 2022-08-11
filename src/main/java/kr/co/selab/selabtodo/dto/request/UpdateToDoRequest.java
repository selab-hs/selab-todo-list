package kr.co.selab.selabtodo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateToDoRequest {
  private  Long id;
  private String content;
  private Boolean isCompleted;
}