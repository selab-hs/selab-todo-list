package kr.co.selab.selabtodo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import kr.co.selab.selabtodo.common.domain.DateEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ToDoList extends DateEntity{
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "todolist_id")
  private Long id;

  @NonNull
  private String content;

  @Column
  private Boolean isCompleted;

  public void update(String content, Boolean isCompleted){
    this.content = content;
    this.isCompleted = isCompleted;
  }
}