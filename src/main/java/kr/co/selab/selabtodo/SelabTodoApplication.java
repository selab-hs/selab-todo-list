package kr.co.selab.selabtodo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SelabTodoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SelabTodoApplication.class, args);
    }
}