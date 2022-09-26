package kr.co.selab.selabtodo.model.dto;

public record UpdateRequest(
        String title, 
        Long order, 
        boolean completed
) {
}