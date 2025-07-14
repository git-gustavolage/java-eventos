package model.bean;

import java.time.LocalDate;

import model.vo.EventoFormato;

public class Evento {

    private Long id;
    private Long id_organizador;
    private String titulo;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataTermino;
    private EventoFormato formato;
    private Boolean publicado = false;
    private Boolean cancelado = false;
    private User organizador = null;

    public Evento() {
    }

    public Evento(
            Long id,
            Long id_organizador,
            String titulo,
            String descricao,
            LocalDate dataInicio,
            LocalDate dataTermino,
            EventoFormato formato,
            Boolean publicado,
            Boolean cancelado
    ) {
        this.id = id;
        this.id_organizador = id_organizador;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.formato = formato;
        this.publicado = publicado;
        this.cancelado = cancelado;
    }

    @Override
    public String toString() {
        return "Evento{" + "id=" + id + ", id_organizador=" + id_organizador + ", titulo=" + titulo + ", descricao=" + descricao + ", dataInicio=" + dataInicio + ", dataTermino=" + dataTermino + ", formato=" + formato + ", publicado=" + publicado + ", cancelado=" + cancelado + '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_organizador() {
        return id_organizador;
    }

    public void setId_organizador(Long id_organizador) {
        this.id_organizador = id_organizador;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }

    public EventoFormato getFormato() {
        return formato;
    }

    public String getFormatoNome() {
        return formato.name();
    }

    public void setFormato(EventoFormato formato) {
        this.formato = formato;
    }

    public Boolean isPublicado() {
        return publicado;
    }

    public void setPublicado(Boolean publicado) {
        this.publicado = publicado;
    }

    public Boolean isCancelado() {
        return cancelado;
    }

    public void setCancelado(Boolean cancelado) {
        this.cancelado = cancelado;
    }

    public void setOrganizador(User organizador) {
        this.organizador = organizador;
    }

    public User getOrganizador() {
        return organizador;
    }
    
}
