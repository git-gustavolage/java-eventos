package model.bean;

public class AmbienteTipo {

    private Integer id;
    private String tipo;

    public AmbienteTipo() {
    }

    public AmbienteTipo(Integer id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "AmbienteTipo{" + "id=" + id + ", tipo=" + tipo + '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
