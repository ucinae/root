package com.ucinae.root.error.exception;

import com.ucinae.root.dto.response.ApiResponse;
import com.ucinae.root.error.ErrorCode;
import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {

    private final ErrorCode errorCode;
    private final ApiResponse<?> apiResponse;

    public CustomException(String originalMessage, ErrorCode errorCode, ApiResponse<?> apiResponse) {
        super(originalMessage);
        this.errorCode = errorCode;
        this.apiResponse = apiResponse;
    }
}
