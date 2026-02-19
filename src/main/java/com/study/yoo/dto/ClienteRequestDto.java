package com.study.yoo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteRequestDto {

    @NotBlank(message = "Campo name não pode ser nulo ou vazio.")
    private String name;

    @NotBlank(message = "Campo email não pode ser nulo ou vazio.")
    private String email;
}
