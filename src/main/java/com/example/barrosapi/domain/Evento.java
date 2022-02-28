package com.example.barrosapi.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "evento")
public class Evento {

    private Integer id_evento;
    private String tipo_evento;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date fecha;
    @JsonFormat(pattern = "hh:mm:ss")
    private Date hora_inicio;
    @JsonFormat(pattern = "hh:mm:ss")
    private Date hora_fin;
    private String tipo_comida;
    private String salon;
    private Integer comensales;
    private Integer contrato_asociado;
    private String dj;
    private String musica_salon;
    private String musica_aperitivo;
    private String musica_baile;
    private String barra_libre;
    private String flores;
    private String ceremonia_barros;
    private String autobus;
    private String vino;
    private String cava;
    private String rincones;
    private String decoracion;
    private String notas;
    private Boolean bono_autobus;
    private Boolean bono_hotel;
    private List<Cliente> cliente = new ArrayList<>();
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private File file;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evento")
    public Integer getId_evento() {
        return id_evento;
    }


    public void setId_evento(Integer id_evento) {
        this.id_evento = id_evento;
    }

    @Basic
    @Column(name = "Tipo_evento")
    public String getTipo_evento() {
        return tipo_evento;
    }

    public void setTipo_evento(String tipo_evento) {
        this.tipo_evento = tipo_evento;
    }

    @Basic
    @Column(name = "Fecha")
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Basic
    @Column(name = "Hora_inicio")
    public Date getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(Date hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    @Basic
    @Column(name = "Hora_fin")
    public Date getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(Date hora_fin) {
        this.hora_fin = hora_fin;
    }


    @Basic
    @Column(name = "Tipo_comida")
    public String getTipo_comida() {
        return tipo_comida;
    }

    public void setTipo_comida(String tipo_comida) {
        this.tipo_comida = tipo_comida;
    }

    @Basic
    @Column(name = "Salon")
    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }

    @Basic
    @Column(name = "Comensales")
    public Integer getComensales() {
        return comensales;
    }

    public void setComensales(Integer comensales) {
        this.comensales = comensales;
    }

    @Basic
    @Column(name = "Contrato_asociado")
    public Integer getContrato_asociado() {
        return contrato_asociado;
    }

    public void setContrato_asociado(Integer contrato_asociado) {
        this.contrato_asociado = contrato_asociado;
    }

    @Basic
    @Column(name = "Dj")
    public String getDj() {
        return dj;
    }

    public void setDj(String dj) {
        this.dj = dj;
    }

    @Basic
    @Column(name = "Musica_salon")
    public String getMusica_salon() {
        return musica_salon;
    }

    public void setMusica_salon(String musica_salon) {
        this.musica_salon = musica_salon;
    }

    @Basic
    @Column(name = "Musica_aperitivo")
    public String getMusica_aperitivo() {
        return musica_aperitivo;
    }

    public void setMusica_aperitivo(String musica_aperitivo) {
        this.musica_aperitivo = musica_aperitivo;
    }

    @Basic
    @Column(name = "Musica_baile")
    public String getMusica_baile() {
        return musica_baile;
    }

    public void setMusica_baile(String musica_baile) {
        this.musica_baile = musica_baile;
    }

    @Basic
    @Column(name = "Barra_libre")
    public String getBarra_libre() {
        return barra_libre;
    }

    public void setBarra_libre(String barra_libre) {
        this.barra_libre = barra_libre;
    }

    @Basic
    @Column(name = "Flores")
    public String getFlores() {
        return flores;
    }

    public void setFlores(String flores) {
        this.flores = flores;
    }

    @Basic
    @Column(name = "Ceremonia_barros")
    public String getCeremonia_barros() {
        return ceremonia_barros;
    }

    public void setCeremonia_barros(String ceremonia_barros) {
        this.ceremonia_barros = ceremonia_barros;
    }

    @Basic
    @Column(name = "Autobus")
    public String getAutobus() {
        return autobus;
    }

    public void setAutobus(String autobus) {
        this.autobus = autobus;
    }

    @Basic
    @Column(name = "Vino")
    public String getVino() {
        return vino;
    }

    public void setVino(String vino) {
        this.vino = vino;
    }

    @Basic
    @Column(name = "Cava")
    public String getCava() {
        return cava;
    }

    public void setCava(String cava) {
        this.cava = cava;
    }

    @Basic
    @Column(name = "Rincones")
    public String getRincones() {
        return rincones;
    }

    public void setRincones(String rincones) {
        this.rincones = rincones;
    }

    @Basic
    @Column(name = "Decoracion")
    public String getDecoracion() {
        return decoracion;
    }

    public void setDecoracion(String decoracion) {
        this.decoracion = decoracion;
    }

    @Basic
    @Column(name = "Notas")
    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    @Basic
    @Column(name = "Bono_autobus")
    public Boolean getBono_autobus() {
        return bono_autobus;
    }

    public void setBono_autobus(Boolean bono_autobus) {
        this.bono_autobus = bono_autobus;
    }


    @Basic
    @Column(name = "Bono_hotel")
    public Boolean getBono_hotel() {
        return bono_hotel;
    }

    public void setBono_hotel(Boolean bono_hotel) {
        this.bono_hotel = bono_hotel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Evento)) return false;
        Evento evento = (Evento) o;
        return Objects.equals(id_evento, evento.id_evento) && Objects.equals(tipo_evento, evento.tipo_evento) && Objects.equals(fecha, evento.fecha) && Objects.equals(hora_inicio, evento.hora_inicio) && Objects.equals(hora_fin, evento.hora_fin) && Objects.equals(tipo_comida, evento.tipo_comida) && Objects.equals(salon, evento.salon) && Objects.equals(comensales, evento.comensales) && Objects.equals(contrato_asociado, evento.contrato_asociado) && Objects.equals(dj, evento.dj) && Objects.equals(musica_salon, evento.musica_salon) && Objects.equals(musica_aperitivo, evento.musica_aperitivo) && Objects.equals(musica_baile, evento.musica_baile) && Objects.equals(barra_libre, evento.barra_libre) && Objects.equals(flores, evento.flores) && Objects.equals(ceremonia_barros, evento.ceremonia_barros) && Objects.equals(autobus, evento.autobus) && Objects.equals(vino, evento.vino) && Objects.equals(cava, evento.cava) && Objects.equals(rincones, evento.rincones) && Objects.equals(decoracion, evento.decoracion) && Objects.equals(notas, evento.notas) && Objects.equals(bono_autobus, evento.bono_autobus) && Objects.equals(bono_hotel, evento.bono_hotel) && Objects.equals(cliente, evento.cliente) && Objects.equals(file, evento.file);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_evento, tipo_evento, fecha, hora_inicio, hora_fin, tipo_comida, salon, comensales, contrato_asociado, dj, musica_salon, musica_aperitivo, musica_baile, barra_libre, flores, ceremonia_barros, autobus, vino, cava, rincones, decoracion, notas, bono_autobus, bono_hotel, cliente, file);
    }

    @JoinTable(name = "cliente_evento", schema = "public",
            joinColumns = @JoinColumn(name = "id_evento", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "id_cliente ", nullable = false)
    )
    @ManyToMany()
    public List<Cliente> getCliente() {
        return cliente;
    }

    public void setCliente(List<Cliente> cliente) {
        this.cliente = cliente;
    }

    public void addCliente(Cliente clienterel){
        cliente.add(clienterel);
    }

    @OneToOne
    @JoinColumn(name = "file", nullable = true, updatable = false, insertable = false)
    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

}

