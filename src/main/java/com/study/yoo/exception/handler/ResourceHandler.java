package com.study.yoo.exception.handler;

import com.study.yoo.dto.error.ErrorRespondeDto;
import com.study.yoo.exception.BadRequestException;
import com.study.yoo.exception.NotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;


@RestControllerAdvice
public class ResourceHandler {

    @ExceptionHandler(NotFoundException.class)

    public ResponseEntity<ErrorRespondeDto> handleNotFound(
            NotFoundException ex,
            HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;

        return ResponseEntity.status(status).body(
                ErrorRespondeDto.builder()
                        .timestamp(LocalDateTime.now())
                        .status(status.value())
                        .error(status.getReasonPhrase())
                        .message(ex.getMessage())
                        .path(request.getRequestURI())
                        .build()
        );
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorRespondeDto> handleBadRequest(
            BadRequestException ex,
            HttpServletRequest request) {

        HttpStatus status = HttpStatus.BAD_REQUEST;

        return ResponseEntity.status(status).body(
                ErrorRespondeDto.builder()
                        .timestamp(LocalDateTime.now())
                        .status(status.value())
                        .error(status.getReasonPhrase())
                        .message(ex.getMessage())
                        .path(request.getRequestURI())
                        .build()
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorRespondeDto> handleValidation(
            MethodArgumentNotValidException ex,
            HttpServletRequest request) {

        HttpStatus status = HttpStatus.BAD_REQUEST;

        String message = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .findFirst()
                .orElse("Erro de validação");

        return ResponseEntity.status(status).body(
                ErrorRespondeDto.builder()
                        .timestamp(LocalDateTime.now())
                        .status(status.value())
                        .error(status.getReasonPhrase())
                        .message(message)
                        .path(request.getRequestURI())
                        .build()
        );
    }


}
