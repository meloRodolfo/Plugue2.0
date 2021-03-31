package com.uff.plugue.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Aluno extends Usuario {

    private static final long serialVersionUID = 1L;

    @Column
    private String curso;
    
    @ManyToMany(mappedBy = "alunos")
    private List<Projeto> projetos;

    public Aluno() {
    }

    public Aluno(int id, String nome, String contato, String senha, String curso, List<Projeto> projetos) {
        super(id, nome, contato, senha);
        this.curso = curso;
        this.projetos = projetos;
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

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }

    public Aluno curso(String curso) {
        setCurso(curso);
        return this;
    }

    public Aluno projetos(List<Projeto> projetos) {
        setProjetos(projetos);
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
