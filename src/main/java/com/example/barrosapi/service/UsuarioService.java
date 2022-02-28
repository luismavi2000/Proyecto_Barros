package com.example.barrosapi.service;

import com.example.barrosapi.domain.Usuario;
import com.example.barrosapi.exception.UsuarioNotFoundException;
import com.example.barrosapi.repository.UsuarioRepository;
import com.sipios.springsearch.anotation.SearchSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService extends BaseService<Usuario, Integer, UsuarioRepository>{

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario findUsuario(Integer id) {
        return usuarioRepository.findById(id)//.get();
                .orElseThrow(() -> new UsuarioNotFoundException("Usuario con id: " + id + " no encontrado"));
    }
    public Usuario addUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario modifyUsuario(Integer id, Usuario newUsuario) {
        Usuario usuario= usuarioRepository.findById(id).orElseThrow(()-> new
                UsuarioNotFoundException(id));
        newUsuario.setId_usuario(usuario.getId_usuario());
        return usuarioRepository.save(newUsuario);
    }

    public void deleteUsuario(Integer id){
        usuarioRepository.deleteById(id);
    }

    public Page<Usuario> findPage(Pageable pageable) {
        return repositorio.findAll(pageable);
    }

    public Page<Usuario> getUsuarios(Pageable pageable, @SearchSpec Specification<Usuario> specs){
        return usuarioRepository.findAll(specs, pageable);
    }

}
