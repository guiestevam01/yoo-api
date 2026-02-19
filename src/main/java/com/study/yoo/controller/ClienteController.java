package com.study.yoo.controller;
import com.study.yoo.configuration.ApiErrorResponses;
import com.study.yoo.dto.ClienteDto;
import com.study.yoo.model.Cliente;
import com.study.yoo.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }
    @GetMapping
    public ResponseEntity<List<Cliente>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findAll());
    }

    @GetMapping("/{id}")
    @ApiErrorResponses
    public ResponseEntity<Cliente> findById(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findById(id));
    }
    @PostMapping
    public ResponseEntity<Cliente> create(@Valid @RequestBody ClienteDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.create(dto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable("id") Long id, @RequestBody ClienteDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.update(id,dto));
    }
    @DeleteMapping("/{id}")
    @ApiErrorResponses
    public ResponseEntity<Void> delete(@PathVariable ("id") Long id){
        clienteService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
