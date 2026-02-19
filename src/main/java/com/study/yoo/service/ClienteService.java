package com.study.yoo.service;

import com.study.yoo.dto.ClienteDto;
import com.study.yoo.model.Cliente;

import java.util.List;

public interface ClienteService {
    List<Cliente> findAll();
    Cliente findById(Long id);
    Cliente create(ClienteDto dto);
    Cliente update(Long id,ClienteDto dto);
    void delete(Long id);
}
