package com.ucinae.root.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    INVALID_INPUT_VALUE(400, "ERROR-001", "Invalid Input Value"),
    ;

    private final int status;
    private final String code;
    private final String message;

}
