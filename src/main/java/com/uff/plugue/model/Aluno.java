package com.uff.plugue.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class, 
    property = "id")
public class Aluno extends Usuario {

    private static final long serialVersionUID = 1L;

    @Column
    private String curso;
    
    @ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="alunos")
    @Fetch(FetchMode.SELECT)   
    private List<Projeto> projetos;

    @OneToMany(fetch = FetchType.EAGER, mappedBy="aluno")
    private List<Ideia> ideias;

    public Aluno() {
    }

    public Aluno(int id, String nome, String contato, String senha, String curso, List<Projeto> projetos, List<Ideia> ideias, String tipoUsuario) {
        super(id, nome, contato, senha, tipoUsuario);
        this.curso = curso;
        this.projetos = projetos;
        this.ideias = ideias;
    }

    public String getCurso() {
        return this.curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public List<Projeto> getProjetos() {
        return this.projetos;
    }

    public void setProjeto(Projeto projeto) {
        this.projetos.add(projeto);
    }

    public List<Ideia> getIdeias() {
        return this.ideias;
    }

    public void setIdeias(List<Ideia> ideias) {
        this.ideias = ideias;
    }

    public Aluno curso(String curso) {
        setCurso(curso);
        return this;
    }

    public Aluno projetos(Projeto projeto) {
        setProjeto(projeto);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Aluno)) {
            return false;
        }
        Aluno aluno = (Aluno) o;
        return Objects.equals(curso, aluno.curso) && Objects.equals(projetos, aluno.projetos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(curso, projetos);
    }

    @Override
    public String toString() {
        return "{" +
            " curso='" + getCurso() + "'" +
            ", projetos='" + getProjetos() + "'" +
            "}";
    }

}
