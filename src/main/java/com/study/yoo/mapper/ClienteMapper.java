package com.study.yoo.mapper;

import com.study.yoo.dto.ClienteRequestDto;
import com.study.yoo.dto.ClienteResponseDto;
import com.study.yoo.model.Cliente;

public class ClienteMapper {

    public static Cliente fromRequestToEntity(ClienteRequestDto dto) {
        return Cliente.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .build();
    }

    public static ClienteResponseDto toResponse(Cliente cliente) {
        return ClienteResponseDto.builder()
                .id(cliente.getId())
                .name(cliente.getName())
                .email(cliente.getEmail())
                .build();
    }
}

