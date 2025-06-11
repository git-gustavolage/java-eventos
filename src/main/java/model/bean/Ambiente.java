package model.bean;

public class Ambiente {
    private Integer id;
    private String nome;
    private String descricao;
    private Integer id_tipo_ambiente;

    public Ambiente() {
    }

    public Ambiente(Integer id, String nome, String descricao, Integer id_tipo_ambiente) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.id_tipo_ambiente = id_tipo_ambiente;
    }

    @Override
    public String toString() {
        return "Ambiente{" + "id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", id_tipo_ambiente=" + id_tipo_ambiente + '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getId_tipo_ambiente() {
        return id_tipo_ambiente;
    }

    public void setId_tipo_ambiente(Integer id_tipo_ambiente) {
        this.id_tipo_ambiente = id_tipo_ambiente;
    }
    
    
}
