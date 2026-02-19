package com.study.yoo.mapper;

import com.study.yoo.dto.ClienteDto;
import com.study.yoo.model.Cliente;

public class ClienteMapper {
    public static Cliente fromDtoToEntity(ClienteDto dto) {
        return Cliente.builder()
                .id(dto.getId())
                .name(dto.getName())
                .email(dto.getEmail())
                .build();
    }
}
