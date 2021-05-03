package com.uff.plugue.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
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
public class Ideia implements Serializable {
    
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
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "professor_ideia",
            joinColumns = @JoinColumn(name = "fk_ideia"),
            inverseJoinColumns = @JoinColumn(name = "fk_professor"))
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class, 
            property = "id")
    private List<Professor> professores;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="aluno_id", nullable = false)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id")
    private Aluno aluno;

    public Ideia() {
    }

    public Ideia(int id, String titulo, String areaInteresse, String descricao, List<Professor> professores, Aluno aluno) {
        this.id = id;
        this.titulo = titulo;
        this.areaInteresse = areaInteresse;
        this.descricao = descricao;
        this.professores = professores;
        this.aluno = aluno;
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

    public List<Professor> getProfessores() {
        return this.professores;
    }

    public void setProfessor(Professor professor) {
        this.professores.add(professor);
    }

    public Aluno getaluno() {
        return this.aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Ideia id(int id) {
        setId(id);
        return this;
    }

    public Ideia titulo(String titulo) {
        setTitulo(titulo);
        return this;
    }

    public Ideia areaInteresse(String areaInteresse) {
        setAreaInteresse(areaInteresse);
        return this;
    }

    public Ideia descricao(String descricao) {
        setDescricao(descricao);
        return this;
    }

    public Ideia professores(Professor professores) {
        setProfessor(professores);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Ideia)) {
            return false;
        }
        Ideia ideia = (Ideia) o;
        return Objects.equals(id, ideia.id) && Objects.equals(titulo, ideia.titulo) && Objects.equals(areaInteresse, ideia.areaInteresse) && Objects.equals(descricao, ideia.descricao) && Objects.equals(professores, ideia.professores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, areaInteresse, descricao, professores);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", titulo='" + getTitulo() + "'" +
            ", areaInteresse='" + getAreaInteresse() + "'" +
            ", descricao='" + getDescricao() + "'" +
            ", professores='" + getProfessores() + "'" +
            "}";
    }

}
