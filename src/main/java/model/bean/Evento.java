package model.bean;

import java.util.Date;

public class Evento {
    private Long id;
    private String uuid;
    private String titulo;
    private String descricao;
    private Date dataInicio;
    private Date dataTermino;
    private Long idFormato;
    private Date createdAt;
    private Date updatedAt;

    public Evento() {
    }

    public Evento(Long id, String uuid, String titulo, String descricao, 
                 Date dataInicio, Date dataTermino, Long idFormato, 
                 Date createdAt, Date updatedAt) {
        this.id = id;
        this.uuid = uuid;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.idFormato = idFormato;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Evento{" + "id=" + id + ", uuid=" + uuid + ", titulo=" + titulo + 
               ", descricao=" + descricao + ", dataInicio=" + dataInicio + 
               ", dataTermino=" + dataTermino + ", idFormato=" + idFormato + 
               ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + '}';
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    public Long getIdFormato() {
        return idFormato;
    }

    public void setIdFormato(Long idFormato) {
        this.idFormato = idFormato;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}