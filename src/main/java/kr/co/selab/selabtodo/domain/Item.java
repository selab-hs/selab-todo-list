package kr.co.selab.selabtodo.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(name = "todo_order")
    private Integer order;
    private Boolean completed;

    public Item() {
    }

    public Item(String title, Integer order, Boolean completed) {
        this.title = title;
        this.order = order;
        this.completed = completed;
    }

    public Item(String title, Integer order) {
        this.title = title;
        this.order = order;
        this.completed = false;
    }
}
