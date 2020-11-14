package com.ucinae.root.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T, S> {
    private String apiVersion;
    private String id;
    private String method;
    private T params;
    private S data;
    private ErrorResponse error;
}
