package model.bean;

import java.time.LocalTime;

public class Atividade {

    private Long id;
    private Long id_evento;
    private Long id_responsavel;
    private Long id_ambiente;
    private String titulo;
    private String descricao;
    private LocalTime hora_inicio;
    private LocalTime hora_termino;

    public Atividade() {
    }

    public Atividade(
            Long id,
            Long id_evento,
            Long id_responsavel,
            Long id_ambiente,
            String titulo,
            String descricao,
            LocalTime hora_inicio,
            LocalTime hora_termino
    ) {
        this.id = id;
        this.id_evento = id_evento;
        this.id_responsavel = id_responsavel;
        this.id_ambiente = id_ambiente;
        this.titulo = titulo;
        this.descricao = descricao;
        this.hora_inicio = hora_inicio;
        this.hora_termino = hora_termino;
    }

    @Override
    public String toString() {
        return "Atividade{" + "id=" + id + ", id_evento=" + id_evento + ", id_responsavel=" + id_responsavel + ", id_ambiente=" + id_ambiente + ", titulo=" + titulo + ", descricao=" + descricao + ", hora_inicio=" + hora_inicio + ", hora_termino=" + hora_termino + '}';
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

}
