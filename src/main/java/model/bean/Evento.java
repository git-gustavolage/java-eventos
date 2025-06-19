package model.bean;

import java.util.Date;

import model.vo.EventoFormato;

public class Evento {

    private Long id;
    private String titulo;
    private String descricao;
    private Date dataInicio;
    private Date dataTermino;
    private EventoFormato formato;

    public Evento() {
    }

    public Evento(
            Long id,
            String titulo,
            String descricao,
            Date dataInicio,
            Date dataTermino,
            EventoFormato formato
    ) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.formato = formato;
    }

    @Override
    public String toString() {
        return "Evento{" + "id=" + id + ", titulo=" + titulo
                + ", descricao=" + descricao + ", dataInicio=" + dataInicio
                + ", dataTermino=" + dataTermino + ", formato=" + formato.name() + '}';
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public EventoFormato getFormato() {
        return formato;
    }

    public void setFormato(EventoFormato formato) {
        this.formato = formato;
    }
}
