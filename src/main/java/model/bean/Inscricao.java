package model.bean;

import java.time.LocalDate;

public class Inscricao {

    private Long id;
    private Long id_usuario;
    private Long id_evento;
    private String categoria;
    private LocalDate data;

    public Inscricao() {
    }

    public Inscricao(Long id, Long id_usuario, Long id_evento, String categoria, LocalDate data) {
        this.id = id;
        this.id_usuario = id_usuario;
        this.id_evento = id_evento;
        this.categoria = categoria;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Long getId_evento() {
        return id_evento;
    }

    public void setId_evento(Long id_evento) {
        this.id_evento = id_evento;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Inscricao{" + "id=" + id + ", id_usuario=" + id_usuario + ", id_evento=" + id_evento + ", categoria=" + categoria + ", data=" + data + '}';
    }

}
