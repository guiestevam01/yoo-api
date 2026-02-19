package com.study.yoo.configuration;

import com.study.yoo.dto.error.ErrorRespondeDto;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ApiResponses(value = {
        @ApiResponse(
                responseCode = "400",
                description = "Requisição inválida",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = ErrorRespondeDto.class)
                )
        ),
        @ApiResponse(
                responseCode = "404",
                description = "Recurso não encontrado",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = ErrorRespondeDto.class)
                )
        ),
        @ApiResponse(
                responseCode = "500",
                description = "Erro interno",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = ErrorRespondeDto.class)
                )
        )
})
public @interface ApiErrorResponses {
}
