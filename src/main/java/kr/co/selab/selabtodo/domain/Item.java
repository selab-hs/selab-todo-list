package kr.co.selab.selabtodo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(name = "todo_order")
    private Integer order;

    private Boolean completed;

    public Item(String title, Integer order) {
        this.title = title;
        this.order = order;
        this.completed = false;
    }
}
