package com.example.barrosapi.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "usuario")
public class Usuario {
    private Integer id_usuario;
    private String username;
    private String contrasena;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_usuario")
    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    @Basic
    @Column(name = "Username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "Contrasena")
    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario usuario = (Usuario) o;
        return id_usuario.equals(usuario.id_usuario)
                && username.equals(usuario.username)
                && contrasena.equals(usuario.contrasena);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_usuario, username, contrasena);
    }
}
