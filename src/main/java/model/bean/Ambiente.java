package model.bean;

public class Ambiente {
    private Integer id;
    private String nome;
    private String descricao;

    public Ambiente() {
    }

    public Ambiente(Integer id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Ambiente{" + "id=" + id + ", nome=" + nome + ", descricao=" + descricao + '}';
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
}
