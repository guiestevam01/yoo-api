package com.study.yoo.service.impl;


import ch.qos.logback.core.net.server.Client;
import com.study.yoo.dto.ClienteDto;
import com.study.yoo.exception.BadRequestException;
import com.study.yoo.exception.NotFoundException;
import com.study.yoo.mapper.ClienteMapper;
import com.study.yoo.model.Cliente;
import com.study.yoo.repository.ClienteRepository;
import com.study.yoo.service.ClienteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{

    private final ClienteRepository clienteRepository;
    public ClienteServiceImpl(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }
    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente findById(Long id) {
        return getCliente(id);
    }

    /* sem dao
    @Override
    public Cliente create(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    */

    @Override
    public Cliente create(ClienteDto dto){
        if(Objects.nonNull(dto.getId())){
           throw new BadRequestException("Cliente deve ser nulo");
        }
        return clienteRepository.save(ClienteMapper.fromDtoToEntity(dto));
    }
    @Override
    public Cliente update(Long id, ClienteDto dto) {
        getCliente(id);
        dto.setId(id);
        return clienteRepository.save(ClienteMapper.fromDtoToEntity(dto));

    }
    @Override
    public void delete(Long id) {
        getCliente(id);
        clienteRepository.deleteById(id);
    }

    private Cliente getCliente(Long id) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);
        if(optionalCliente.isEmpty()){
            throw new NotFoundException("Cliente nao encontrado.");
        }
        return optionalCliente.get();
    }
}
