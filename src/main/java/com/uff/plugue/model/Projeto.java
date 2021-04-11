package com.uff.plugue.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class, 
        property = "id")
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
    private String descricao;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "aluno_projeto",
            joinColumns = @JoinColumn(name = "fk_projeto"),
            inverseJoinColumns = @JoinColumn(name = "fk_aluno"))
    private List<Aluno> alunos;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="professor_id", nullable = false)
    private Professor professor;

    public Projeto() {
    }

    public Projeto(int id, String titulo, String areaInteresse, String descricao, List<Aluno> alunos, Professor professor) {
        this.id = id;
        this.titulo = titulo;
        this.areaInteresse = areaInteresse;
        this.descricao = descricao;
        this.alunos = alunos;
        this.professor = professor;
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

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Aluno> getAlunos() {
        return this.alunos;
    }

    public void setAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public Professor getProfessor() {
        return this.professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Projeto)) {
            return false;
        }
        Projeto projeto = (Projeto) o;
        return id == projeto.id && Objects.equals(titulo, projeto.titulo) && Objects.equals(areaInteresse, projeto.areaInteresse) && Objects.equals(descricao, projeto.descricao) && Objects.equals(alunos, projeto.alunos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, areaInteresse, descricao, alunos);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", titulo='" + getTitulo() + "'" +
            ", areaInteresse='" + getAreaInteresse() + "'" +
            ", descricao='" + getDescricao() + "'" +
            ", alunos='" + getAlunos() + "'" +
            "}";
    }
    
}
