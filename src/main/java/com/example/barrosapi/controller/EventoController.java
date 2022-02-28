package com.example.barrosapi.controller;

import com.example.barrosapi.domain.Cliente;
import com.example.barrosapi.domain.Evento;
import com.example.barrosapi.exception.NotPageException;
import com.example.barrosapi.service.EventoService;
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
public class EventoController {

    @Autowired
    private EventoService eventoService;
    private final Logger logger = LoggerFactory.getLogger(EventoController.class);

    @GetMapping("/eventos")
    public ResponseEntity<List<Evento>> listaEventos() {
        List<Evento> eventos = null;
        eventos = eventoService.findAll();
        return new ResponseEntity<>(eventos, HttpStatus.OK);
    }

    @GetMapping(path="/eventos/{id}")
    public ResponseEntity<Evento> findEvento(@PathVariable("id") Integer id){
        Evento evento = eventoService.findEvento(id);
        return  new ResponseEntity<>(evento, HttpStatus.OK);
    }

    @PostMapping(path = "/addEvento")
    public ResponseEntity<Evento> addEvento(@RequestBody Evento evento){
        Evento addEvento = eventoService.addEvento(evento);
        return new ResponseEntity<>(addEvento, HttpStatus.OK);
    }

    @PutMapping("/modifyEvento/{id}")
    public ResponseEntity<Evento> modifyEvento(@PathVariable Integer id, @RequestBody Evento
            newEvento) {
        Evento addedEvento = eventoService.modifyEvento(id, newEvento);
        return new ResponseEntity<>(addedEvento, HttpStatus.OK);
    }

    @DeleteMapping("/deleteEvento/{id}")
    public ResponseEntity<Evento> dellEventoByID(@PathVariable("id") Integer id){
        Evento dellEvento = eventoService.findEvento(id);
        eventoService.deleteEvento(id);
        return new ResponseEntity<>(dellEvento,HttpStatus.OK);
    }

    @GetMapping(path = "/paginadoEvento")
    public Page<Evento> listaEventosPaginado(Pageable pageable){
        Page<Evento> response;
        response=eventoService.findAll(pageable);
        if ((pageable).getPageNumber() > response.getTotalPages()) {
            throw new NotPageException();
        }
        return response;
    }

    @GetMapping(path="/paginadoFiltradoEvento")
    public Page<Evento> listaEventosPaginadoFiltrado(@PageableDefault(size=10, page = 0)
                                             Pageable pageable, @SearchSpec Specification<Evento> specs) {
        Page<Evento> response;
        response=eventoService.getEventos(pageable, specs);
        if ( pageable.getPageNumber() > response.getTotalPages()) {
            throw new NotPageException();
        }
        return response;
    }
}
