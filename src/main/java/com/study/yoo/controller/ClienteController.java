package com.study.yoo.controller;
import com.study.yoo.configuration.ApiErrorResponses;
import com.study.yoo.dto.ClienteRequestDto;
import com.study.yoo.dto.ClienteResponseDto;
import com.study.yoo.service.ClienteService;
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
    public ResponseEntity<List<ClienteResponseDto>> findAll(){
        return ResponseEntity.ok(clienteService.findAll());
    }

    @GetMapping("/{id}")
    @ApiErrorResponses
    public ResponseEntity<ClienteResponseDto> findById(@PathVariable Long id){
        return ResponseEntity.ok(clienteService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ClienteResponseDto> create(
            @Valid @RequestBody ClienteRequestDto dto){

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(clienteService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDto> update(
            @PathVariable Long id,
            @Valid @RequestBody ClienteRequestDto dto){

        return ResponseEntity.ok(clienteService.update(id,dto));
    }

    @DeleteMapping("/{id}")
    @ApiErrorResponses
    public ResponseEntity<Void> delete(@PathVariable Long id){
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
