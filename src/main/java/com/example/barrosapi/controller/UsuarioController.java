package com.example.barrosapi.controller;

import com.example.barrosapi.domain.Cliente;
import com.example.barrosapi.domain.Usuario;
import com.example.barrosapi.exception.NotPageException;
import com.example.barrosapi.service.UsuarioService;
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
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    private final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> listaUsuarios() {
        List<Usuario> usuarios = null;
        usuarios = usuarioService.findAll();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping(path="/usuarios/{id}")
    public ResponseEntity<Usuario> findUsuario(@PathVariable("id") Integer id){
        Usuario ciudad = usuarioService.findUsuario(id);
        return  new ResponseEntity<>(ciudad, HttpStatus.OK);
    }

    @PostMapping(path = "/addUsuario")
    public ResponseEntity<Usuario> addUsuario(@RequestBody Usuario usuario){
        Usuario addUsuario = usuarioService.addUsuario(usuario);
        return new ResponseEntity<>(addUsuario, HttpStatus.OK);
    }

    @PutMapping("/modifyUsuario/{id}")
    public ResponseEntity<Usuario> modifyUsuario(@PathVariable Integer id, @RequestBody Usuario
            newUsuario) {
        Usuario addedUsuario = usuarioService.modifyUsuario(id, newUsuario);
        return new ResponseEntity<>(addedUsuario, HttpStatus.OK);
    }

    @DeleteMapping("/deleteUsuario/{id}")
    public ResponseEntity<Usuario> dellUsuarioByID(@PathVariable("id") Integer id){
        Usuario dellUsuario = usuarioService.findUsuario(id);
        usuarioService.deleteUsuario(id);
        return new ResponseEntity<>(dellUsuario,HttpStatus.OK);
    }

    @GetMapping(path = "/paginadoUsuario")
    public Page<Usuario> listaUsuarioPaginado(Pageable pageable){
        Page<Usuario> response;
        response=usuarioService.findAll(pageable);
        if ((pageable).getPageNumber() > response.getTotalPages()) {
            throw new NotPageException();
        }
        return response;
    }

    @GetMapping(path="/paginadoFiltradoUsuario")
    public Page<Usuario> listaUsuarioPaginadoFiltrado(@PageableDefault(size=10, page = 0)
                                             Pageable pageable, @SearchSpec Specification<Usuario> specs) {
        Page<Usuario> response;
        response=usuarioService.getUsuarios(pageable, specs);
        if ( pageable.getPageNumber() > response.getTotalPages()) {
            throw new NotPageException();
        }
        return response;
    }
}
