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
public class Ideia implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String titulo;

    @Column
    private String areaInteresse;

    @Column
    private String descricao;

    @ManyToMany
    @JoinTable(name = "professor_ideia",
            joinColumns = @JoinColumn(name = "fk_ideia"),
            inverseJoinColumns = @JoinColumn(name = "fk_professor"))
    private List<Professor> professores;

    public Ideia() {
    }

    public Ideia(Long id, String titulo, String areaInteresse, String descricao, List<Professor> professores) {
        this.id = id;
        this.titulo = titulo;
        this.areaInteresse = areaInteresse;
        this.descricao = descricao;
        this.professores = professores;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
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

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

    public Ideia id(Long id) {
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

    public Ideia professores(List<Professor> professores) {
        setProfessores(professores);
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
