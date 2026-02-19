package com.study.yoo.dto.error;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class ErrorRespondeDto {

    private LocalDateTime timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}
