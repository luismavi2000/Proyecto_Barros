package com.example.barrosapi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;


@AllArgsConstructor
@Entity
@Table(name = "file")
public class File {
    private Integer idFile;
    private String name;
    private String type;
    private String data;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Evento evento;

    public File() {
    }
    public File(String name, String type, String data) {
        this.name = name;
        this.type = type;
        this.data = data;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_file")
    public Integer getIdFile() {
        return idFile;
    }

    public void setIdFile(Integer idFile) {
        this.idFile = idFile;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "data")
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof File)) return false;
        File file = (File) o;
        return Objects.equals(idFile, file.idFile) && Objects.equals(name, file.name) && Objects.equals(type, file.type) && Objects.equals(data, file.data) && Objects.equals(evento, file.evento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFile, name, type, data, evento);
    }

    @OneToOne(mappedBy="file")
    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}
