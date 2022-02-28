package com.example.barrosapi.controller;

import com.example.barrosapi.domain.Cliente;
import com.example.barrosapi.exception.NotPageException;
import com.example.barrosapi.service.ClienteService;
import com.sipios.springsearch.anotation.SearchSpec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController()
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    private final Logger logger = LoggerFactory.getLogger(ClienteController.class);

    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> listaClientes() {
        List<Cliente> clientes = null;
        clientes = clienteService.findAll();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping(path = "/clientes/{id}")
    public ResponseEntity<Cliente> findCliente(@PathVariable("id") Integer id) {
        Cliente ciudad = clienteService.findCliente(id);
        return new ResponseEntity<>(ciudad, HttpStatus.OK);
    }

    @PostMapping(path = "/addCliente")
    public ResponseEntity<Cliente> addCliente(@RequestBody Cliente cliente) {
        Cliente addCliente = clienteService.addCliente(cliente);
        return new ResponseEntity<>(addCliente, HttpStatus.OK);
    }

    @PutMapping("/modifyCliente/{id}")
    public ResponseEntity<Cliente> modifyCliente(@PathVariable Integer id, @RequestBody Cliente
            newCliente) {
        Cliente addedCliente = clienteService.modifyCliente(id, newCliente);
        return new ResponseEntity<>(addedCliente, HttpStatus.OK);
    }

    @DeleteMapping("/deleteCliente/{id}")
    public ResponseEntity<Cliente> dellClienteByID(@PathVariable("id") Integer id) {
        Cliente dellCliente = clienteService.findCliente(id);
        clienteService.deleteCliente(id);
        return new ResponseEntity<>(dellCliente, HttpStatus.OK);
    }

    @GetMapping(path = "/paginadoCliente")
    public Page<Cliente> listaClientesPaginado(Pageable pageable) {
        Page<Cliente> response;
        response = clienteService.findAll(pageable);
        if ((pageable).getPageNumber() > response.getTotalPages()) {
            throw new NotPageException();
        }
        return response;
    }

    @GetMapping(path = "/paginadoFiltradoCliente")
    public Page<Cliente> listaClientesFiltradoPaginado(@PageableDefault(size = 10, page = 0)
                                                               Pageable pageable, @SearchSpec Specification<Cliente> specs) {
        Page<Cliente> response;
        response = clienteService.getClientes(pageable, specs);
        if (pageable.getPageNumber() > response.getTotalPages()) {
            throw new NotPageException();
        }
        return response;
    }
}
