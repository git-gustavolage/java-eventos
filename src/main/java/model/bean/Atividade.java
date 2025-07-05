package model.bean;

import java.time.LocalDate;
import java.time.LocalTime;

public class Atividade {

    private Long id;
    private Long id_evento;
    private Long id_responsavel;
    private Long id_ambiente;
    private String titulo;
    private String descricao;
    private LocalDate data;
    private LocalTime hora_inicio;
    private LocalTime hora_termino;
    private Boolean cancelada;

    public Atividade() {
    }

    public Atividade(
            Long id,
            Long id_evento,
            Long id_responsavel,
            Long id_ambiente,
            String titulo,
            String descricao,
            LocalDate data,
            LocalTime hora_inicio,
            LocalTime hora_termino,
            Boolean cancelada
    ) {
        this.id = id;
        this.id_evento = id_evento;
        this.id_responsavel = id_responsavel;
        this.id_ambiente = id_ambiente;
        this.titulo = titulo;
        this.descricao = descricao;
        this.data = data;
        this.hora_inicio = hora_inicio;
        this.hora_termino = hora_termino;
        this.cancelada = cancelada;
    }

    @Override
    public String toString() {
        return "Atividade{" + "id=" + id + ", id_evento=" + id_evento + ", id_responsavel=" + id_responsavel + ", id_ambiente=" + id_ambiente + ", titulo=" + titulo + ", descricao=" + descricao + ", data=" + data + ", hora_inicio=" + hora_inicio + ", hora_termino=" + hora_termino + ", cancelada=" + cancelada + '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_evento() {
        return id_evento;
    }

    public void setId_evento(Long id_evento) {
        this.id_evento = id_evento;
    }

    public Long getId_responsavel() {
        return id_responsavel;
    }

    public void setId_responsavel(Long id_responsavel) {
        this.id_responsavel = id_responsavel;
    }

    public Long getId_ambiente() {
        return id_ambiente;
    }

    public void setId_ambiente(Long id_ambiente) {
        this.id_ambiente = id_ambiente;
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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(LocalTime hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public LocalTime getHora_termino() {
        return hora_termino;
    }

    public void setHora_termino(LocalTime hora_termino) {
        this.hora_termino = hora_termino;
    }

    public Boolean isCancelada() {
        return cancelada;
    }

    public void setCancelada(Boolean cancelada) {
        this.cancelada = cancelada;
    }

}
