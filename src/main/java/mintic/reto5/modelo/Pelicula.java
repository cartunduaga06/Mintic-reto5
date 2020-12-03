/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mintic.reto5.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author CARLOS
 */
@Entity
@Table(name = "pelicula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pelicula.findAll", query = "SELECT p FROM Pelicula p")
    , @NamedQuery(name = "Pelicula.findByTitulo", query = "SELECT p FROM Pelicula p WHERE p.peliculaPK.titulo = :titulo")
    , @NamedQuery(name = "Pelicula.findByResumen", query = "SELECT p FROM Pelicula p WHERE p.resumen = :resumen")
    , @NamedQuery(name = "Pelicula.findByAno", query = "SELECT p FROM Pelicula p WHERE p.ano = :ano")
    , @NamedQuery(name = "Pelicula.findByTemporadas", query = "SELECT p FROM Pelicula p WHERE p.temporadas = :temporadas")
    , @NamedQuery(name = "Pelicula.findByNumeroEpisodios", query = "SELECT p FROM Pelicula p WHERE p.numeroEpisodios = :numeroEpisodios")
    , @NamedQuery(name = "Pelicula.findByDirectorId", query = "SELECT p FROM Pelicula p WHERE p.peliculaPK.directorId = :directorId")})
public class Pelicula implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PeliculaPK peliculaPK;
    @Column(name = "resumen")
    private String resumen;
    @Column(name = "ano")
    private Integer ano;
    @Column(name = "temporadas")
    private Integer temporadas;
    @Column(name = "numero_episodios")
    private Integer numeroEpisodios;
    @JoinColumn(name = "director_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Director director;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pelicula")
    private List<PeliculaHasUsuario> peliculaHasUsuarioList;

    public Pelicula() {
    }

    public Pelicula(PeliculaPK peliculaPK) {
        this.peliculaPK = peliculaPK;
    }

    public Pelicula(String titulo, int directorId) {
        this.peliculaPK = new PeliculaPK(titulo, directorId);
    }

    public PeliculaPK getPeliculaPK() {
        return peliculaPK;
    }

    public void setPeliculaPK(PeliculaPK peliculaPK) {
        this.peliculaPK = peliculaPK;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(Integer temporadas) {
        this.temporadas = temporadas;
    }

    public Integer getNumeroEpisodios() {
        return numeroEpisodios;
    }

    public void setNumeroEpisodios(Integer numeroEpisodios) {
        this.numeroEpisodios = numeroEpisodios;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    @XmlTransient
    public List<PeliculaHasUsuario> getPeliculaHasUsuarioList() {
        return peliculaHasUsuarioList;
    }

    public void setPeliculaHasUsuarioList(List<PeliculaHasUsuario> peliculaHasUsuarioList) {
        this.peliculaHasUsuarioList = peliculaHasUsuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (peliculaPK != null ? peliculaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pelicula)) {
            return false;
        }
        Pelicula other = (Pelicula) object;
        if ((this.peliculaPK == null && other.peliculaPK != null) || (this.peliculaPK != null && !this.peliculaPK.equals(other.peliculaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Pelicula[ peliculaPK=" + peliculaPK + " ]";
    }
    
}
