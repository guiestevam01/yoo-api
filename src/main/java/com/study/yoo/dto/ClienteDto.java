package com.study.yoo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteDto {

    private Long id;

    @NotBlank(message = "Campo name não pode ser nulo ou vazio.")
    private String name;

    @NotBlank(message = "Campo email não pode ser nulo ou vazio.")
    private String email;
}
