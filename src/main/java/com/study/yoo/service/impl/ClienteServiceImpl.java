package com.study.yoo.service.impl;


import com.study.yoo.dto.ClienteRequestDto;
import com.study.yoo.dto.ClienteResponseDto;
import com.study.yoo.exception.NotFoundException;
import com.study.yoo.mapper.ClienteMapper;
import com.study.yoo.model.Cliente;
import com.study.yoo.repository.ClienteRepository;
import com.study.yoo.service.ClienteService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<ClienteResponseDto> findAll() {
        return clienteRepository.findAll()
                .stream()
                .map(ClienteMapper::toResponse)
                .toList();
    }

    @Override
    public ClienteResponseDto findById(Long id){
        Cliente cliente = getCliente(id);
        return ClienteMapper.toResponse(cliente);
    }

    @Override
    public ClienteResponseDto create(ClienteRequestDto dto) {

        Cliente cliente = ClienteMapper.fromRequestToEntity(dto);
        Cliente saved = clienteRepository.save(cliente);

        return ClienteMapper.toResponse(saved);
    }

    @Override
    public ClienteResponseDto update(Long id, ClienteRequestDto dto) {

        Cliente cliente = getCliente(id);

        cliente.setName(dto.getName());
        cliente.setEmail(dto.getEmail());

        Cliente updated = clienteRepository.save(cliente);

        return ClienteMapper.toResponse(updated);
    }

    @Override
    public void delete(Long id) {
        getCliente(id);
        clienteRepository.deleteById(id);
    }

    private Cliente getCliente(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Cliente nao encontrado."));
    }
}

