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
public class Professor extends Usuario{
    
    private static final long serialVersionUID = 1L;

    @Column
    private String paginaPessoal;

    @ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="professores")
    @Fetch(FetchMode.SELECT)  
    private List<Ideia> ideias;

    @OneToMany(fetch = FetchType.EAGER, mappedBy="professor")
    private List<Projeto> projetos;

    public Professor() {
    }

    public Professor(int id, String nome, String contato, String senha, String paginaPessoal, List<Ideia> ideias, List<Projeto> projetos, String tipoUsuario) {
        super(id, nome, contato, senha, tipoUsuario);
        this.paginaPessoal = paginaPessoal;
        this.ideias = ideias;
        this.projetos = projetos;
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

    public void setIdeia(Ideia ideia) {
        this.ideias.add(ideia);
    }

    public List<Projeto> getProjetos() {
        return this.projetos;
    }

    public void setProjeto(Projeto projeto) {
        this.projetos.add(projeto);
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
