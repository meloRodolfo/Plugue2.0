package com.uff.plugue.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String nome;

    @Column
    private String contato;

    @Column 
    private String senha;

    @Column
    private String tipoUsuario;

    public Usuario() {
    }

    public Usuario(int id, String nome, String contato, String senha, String tipoUsuario) {
        this.id = id;
        this.nome = nome;
        this.contato = contato;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContato() {
        return this.contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipoUsuario() {
        return this.tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Usuario id(int id) {
        setId(id);
        return this;
    }

    public Usuario nome(String nome) {
        setNome(nome);
        return this;
    }

    public Usuario contato(String contato) {
        setContato(contato);
        return this;
    }

    public Usuario senha(String senha) {
        setSenha(senha);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Usuario)) {
            return false;
        }
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id) 
        && Objects.equals(nome, usuario.nome) 
        && Objects.equals(contato, usuario.contato) 
        && Objects.equals(senha, usuario.senha)
        && Objects.equals(tipoUsuario, usuario.tipoUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, contato, senha, tipoUsuario);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nome='" + getNome() + "'" +
            ", contato='" + getContato() + "'" +
            ", senha='" + getSenha() + "'" +
            ", tipoUsuario='" + getTipoUsuario() + "'" +
            "}";
    }

}