package com.study.yoo.service;

import com.study.yoo.dto.ClienteRequestDto;
import com.study.yoo.dto.ClienteResponseDto;

import java.util.List;

public interface ClienteService {
    ClienteResponseDto create(ClienteRequestDto dto);
    ClienteResponseDto findById(Long id);
    List<ClienteResponseDto> findAll();
    ClienteResponseDto update(Long id, ClienteRequestDto dto);
    void delete(Long id);
}
