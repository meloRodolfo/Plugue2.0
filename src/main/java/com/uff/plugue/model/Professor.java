package com.uff.plugue.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Professor extends Usuario{
    
    private static final long serialVersionUID = 1L;

    @Column
    private String paginaPessoal;

    @ManyToMany(mappedBy="professores")
    private List<Ideia> ideias;

    public Professor() {
    }

    public Professor(int id, String nome, String contato, String senha, String paginaPessoal, List<Ideia> ideias) {
        super(id, nome, contato, senha);
        this.paginaPessoal = paginaPessoal;
        this.ideias = ideias;
    }

    public String getPaginaPessoal() {
        return this.paginaPessoal;
    }

    public void setPaginaPessoal(String paginaPessoal) {
        this.paginaPessoal = paginaPessoal;
    }

    public List<Ideia> getIdeias() {
        return this.ideias;
    }

    public void setIdeias(Ideia ideia) {
        this.ideias.add(ideia);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Professor)) {
            return false;
        }
        Professor professor = (Professor) o;
        return Objects.equals(paginaPessoal, professor.paginaPessoal) && Objects.equals(ideias, professor.ideias);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paginaPessoal, ideias);
    }

    @Override
    public String toString() {
        return "{" +
            ", paginaPessoal='" + getPaginaPessoal() + "'" +
            ", ideias='" + getIdeias() + "'" +
            "}";
    }

}
