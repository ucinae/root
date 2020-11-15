package com.ucinae.root.error.advice;

import com.ucinae.root.dto.response.ApiResponse;
import com.ucinae.root.dto.response.ErrorResponse;
import com.ucinae.root.error.exception.CustomException;
import com.ucinae.root.model.Error;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class RestControllerExceptionHandler {

    @ExceptionHandler(value = { HttpMessageNotReadableException.class})
    protected ResponseEntity<ErrorResponse> handleConflict(Exception ex, HttpServletRequest request) {

        ErrorResponse error = ErrorResponse.builder()
                .code(HttpStatus.BAD_REQUEST.toString())
                .message(ex.getMessage())
                .build();

        log.warn("this is controller advice");
        log.warn("http request queryString = {}", request.getQueryString());
        log.warn("http requestURI = {}", request.getRequestURI());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(value = { HttpClientErrorException.class })
    protected ResponseEntity<ErrorResponse> handleHttpClientErrorException(HttpClientErrorException ex) {

        ErrorResponse errorResponse = ErrorResponse.builder()
                .code(ex.getStatusCode().toString())
                .message(ex.getMessage())
                .errors(List.of(Error.builder()
                        .reason(ex.getStatusText())
                        .message(ex.getResponseBodyAsString())
                        .build()))
                .build();

        return new ResponseEntity<>(errorResponse ,ex.getStatusCode());
    }

    @ExceptionHandler(value = { MethodArgumentNotValidException.class })
    protected ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();

        List<Error> errors = new ArrayList<>();
        
        List<ObjectError> errorList = bindingResult.getAllErrors();
        for (ObjectError error : errorList) {
            errors.add(Error.builder()
                    .domain(error.getCode())
                    .reason(error.getObjectName())
                    .message(error.getDefaultMessage())
                    .build());
        }

        ErrorResponse errorResponse = ErrorResponse.builder()
                .code(HttpStatus.BAD_REQUEST.toString())
                .message(ex.getMessage())
                .errors(errors)
                .build();

        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(value = { CustomException.class })
    protected ResponseEntity<ApiResponse<?>> handleCustomException(CustomException ex) {

        ErrorResponse errorResponse = ErrorResponse.builder()
                .code(ex.getErrorCode().getCode())
                .message(ex.getMessage())
                .errors(List.of(Error.builder()
                        .message(ex.getErrorCode().getMessage())
                        .reason(ex.getMessage())
                        .build()))
                .build();

        ex.getApiResponse().setError(errorResponse);

        return ResponseEntity.badRequest().body(ex.getApiResponse());
    }
}
