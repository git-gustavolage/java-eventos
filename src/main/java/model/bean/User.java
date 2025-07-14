package model.bean;

import java.util.Date;

public class User {
    private Long id;
    private String nome;
    private String email;
    private String password;
    private Date data_nascimento;
    private Boolean admin = false;

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", nome=" + nome + ", email=" + email + ", password=" + password + ", data_nascimento=" + data_nascimento + '}';
    }

    public User() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public Boolean isAdmin() {
        return admin;
    }

    public void setAdmin(Boolean is_admin) {
        this.admin = is_admin;
    }
    
}
