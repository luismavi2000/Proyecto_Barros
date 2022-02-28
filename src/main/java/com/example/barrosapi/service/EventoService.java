package com.example.barrosapi.service;

import com.example.barrosapi.domain.Cliente;
import com.example.barrosapi.domain.Evento;
import com.example.barrosapi.exception.EventoNotFoundException;
import com.example.barrosapi.repository.EventoRepository;
import com.sipios.springsearch.anotation.SearchSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


@Service
public class EventoService extends BaseService<Evento, Integer, EventoRepository>{

    @Autowired
    private EventoRepository eventoRepository;

    public Evento findEvento(Integer id) {
        return eventoRepository.findById(id)//.get();
                .orElseThrow(() -> new EventoNotFoundException("Evento con id: " + id + " no encontrado"));
    }
    public Evento addEvento(Evento evento){
        evento.setCliente(evento.getCliente());
        return eventoRepository.save(evento);
    }

    public Evento modifyEvento(Integer id, Evento newEvento) {
        Evento evento= eventoRepository.findById(id).orElseThrow(()-> new
                EventoNotFoundException(id));
        newEvento.setId_evento(evento.getId_evento());
        return eventoRepository.save(newEvento);
    }

    public void deleteEvento(Integer id){
        eventoRepository.deleteById(id);
    }


    public Page<Evento> findPage(Pageable pageable) {
        return repositorio.findAll(pageable);
    }

    public Page<Evento> getEventos(Pageable pageable, @SearchSpec Specification<Evento> specs){
        return eventoRepository.findAll(specs, pageable);
    }
}
