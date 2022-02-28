package com.example.barrosapi.service;

import com.example.barrosapi.domain.Cliente;
import com.example.barrosapi.exception.ClienteNotFoundException;
import com.example.barrosapi.repository.ClienteRepository;
import com.sipios.springsearch.anotation.SearchSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class ClienteService extends BaseService<Cliente, Integer, ClienteRepository> {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente findCliente(Integer id) {
        return clienteRepository.findById(id)//.get();
                .orElseThrow(() -> new ClienteNotFoundException("Cliente con id: " + id + " no encontrado"));
    }
    public Cliente addCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente modifyCliente(Integer id, Cliente newCliente) {
        Cliente cliente= clienteRepository.findById(id).orElseThrow(()-> new
                ClienteNotFoundException(id));
        newCliente.setId_cliente(cliente.getId_cliente());
        return clienteRepository.save(newCliente);
    }

    public void deleteCliente(Integer id){
        clienteRepository.deleteById(id);
    }

    public Page<Cliente> findPage(Pageable pageable) {
        return repositorio.findAll(pageable);
    }

    public Page<Cliente> getClientes(Pageable pageable, @SearchSpec Specification<Cliente> specs){
        return clienteRepository.findAll(specs, pageable);
    }

}

