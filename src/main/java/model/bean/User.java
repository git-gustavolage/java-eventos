package model.bean;

import java.util.Date;

public class User {
    private Integer id;
    private String username;
    private String nome;
    private String email;
    private String password;
    private Date data_nascimento;

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", nome=" + nome + ", email=" + email + ", password=" + password + ", data_nascimento=" + data_nascimento + '}';
    }

    public User() {}

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String user) {
        this.username = user;
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
    
}
