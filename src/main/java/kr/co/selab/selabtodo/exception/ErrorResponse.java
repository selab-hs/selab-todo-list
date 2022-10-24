package kr.co.selab.selabtodo.exception;

import lombok.Builder;

@Builder
public record ErrorResponse(
    int code,
    String message
){}
