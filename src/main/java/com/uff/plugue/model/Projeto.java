package com.uff.plugue.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Projeto implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String titulo;

    @Column
    private String areaInteresse;

    @Column
    private String desccricao;

    @ManyToMany
    @JoinTable(name = "aluno_projeto",
            joinColumns = @JoinColumn(name = "fk_projeto"),
            inverseJoinColumns = @JoinColumn(name = "fk_aluno"))
    private List<Aluno> alunos;

    public Projeto() {
    }

    public Projeto(int id, String titulo, String areaInteresse, String desccricao, List<Aluno> alunos) {
        this.id = id;
        this.titulo = titulo;
        this.areaInteresse = areaInteresse;
        this.desccricao = desccricao;
        this.alunos = alunos;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAreaInteresse() {
        return this.areaInteresse;
    }

    public void setAreaInteresse(String areaInteresse) {
        this.areaInteresse = areaInteresse;
    }

    public String getDesccricao() {
        return this.desccricao;
    }

    public void setDesccricao(String desccricao) {
        this.desccricao = desccricao;
    }

    public List<Aluno> getAlunos() {
        return this.alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Projeto id(int id) {
        setId(id);
        return this;
    }

    public Projeto titulo(String titulo) {
        setTitulo(titulo);
        return this;
    }

    public Projeto areaInteresse(String areaInteresse) {
        setAreaInteresse(areaInteresse);
        return this;
    }

    public Projeto desccricao(String desccricao) {
        setDesccricao(desccricao);
        return this;
    }

    public Projeto alunos(List<Aluno> alunos) {
        setAlunos(alunos);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Projeto)) {
            return false;
        }
        Projeto projeto = (Projeto) o;
        return id == projeto.id && Objects.equals(titulo, projeto.titulo) && Objects.equals(areaInteresse, projeto.areaInteresse) && Objects.equals(desccricao, projeto.desccricao) && Objects.equals(alunos, projeto.alunos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, areaInteresse, desccricao, alunos);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", titulo='" + getTitulo() + "'" +
            ", areaInteresse='" + getAreaInteresse() + "'" +
            ", desccricao='" + getDesccricao() + "'" +
            ", alunos='" + getAlunos() + "'" +
            "}";
    }
    
}
