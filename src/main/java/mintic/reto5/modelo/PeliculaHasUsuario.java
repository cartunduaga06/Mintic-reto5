/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mintic.reto5.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CARLOS
 */
@Entity
@Table(name = "pelicula_has_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PeliculaHasUsuario.findAll", query = "SELECT p FROM PeliculaHasUsuario p")
    , @NamedQuery(name = "PeliculaHasUsuario.findByUsuario", query = "SELECT p FROM PeliculaHasUsuario p WHERE p.peliculaHasUsuarioPK.usuario = :usuario")
    , @NamedQuery(name = "PeliculaHasUsuario.findByPeliculaTitulo", query = "SELECT p FROM PeliculaHasUsuario p WHERE p.peliculaHasUsuarioPK.peliculaTitulo = :peliculaTitulo")
    , @NamedQuery(name = "PeliculaHasUsuario.findByPeliculaDirectorId", query = "SELECT p FROM PeliculaHasUsuario p WHERE p.peliculaHasUsuarioPK.peliculaDirectorId = :peliculaDirectorId")
    , @NamedQuery(name = "PeliculaHasUsuario.findByFechayhora", query = "SELECT p FROM PeliculaHasUsuario p WHERE p.fechayhora = :fechayhora")})
public class PeliculaHasUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PeliculaHasUsuarioPK peliculaHasUsuarioPK;
    @Basic(optional = false)
    @Column(name = "fechayhora")
    private String fechayhora;
    @JoinColumns({
        @JoinColumn(name = "pelicula_director_id", referencedColumnName = "director_id", insertable = false, updatable = false)
        , @JoinColumn(name = "pelicula_titulo", referencedColumnName = "titulo", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Pelicula pelicula;
    @JoinColumn(name = "usuario", referencedColumnName = "usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario1;

    public PeliculaHasUsuario() {
    }

    public PeliculaHasUsuario(PeliculaHasUsuarioPK peliculaHasUsuarioPK) {
        this.peliculaHasUsuarioPK = peliculaHasUsuarioPK;
    }

    public PeliculaHasUsuario(PeliculaHasUsuarioPK peliculaHasUsuarioPK, String fechayhora) {
        this.peliculaHasUsuarioPK = peliculaHasUsuarioPK;
        this.fechayhora = fechayhora;
    }

    public PeliculaHasUsuario(String usuario, String peliculaTitulo, int peliculaDirectorId) {
        this.peliculaHasUsuarioPK = new PeliculaHasUsuarioPK(usuario, peliculaTitulo, peliculaDirectorId);
    }

    public PeliculaHasUsuarioPK getPeliculaHasUsuarioPK() {
        return peliculaHasUsuarioPK;
    }

    public void setPeliculaHasUsuarioPK(PeliculaHasUsuarioPK peliculaHasUsuarioPK) {
        this.peliculaHasUsuarioPK = peliculaHasUsuarioPK;
    }

    public String getFechayhora() {
        return fechayhora;
    }

    public void setFechayhora(String fechayhora) {
        this.fechayhora = fechayhora;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Usuario getUsuario1() {
        return usuario1;
    }

    public void setUsuario1(Usuario usuario1) {
        this.usuario1 = usuario1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (peliculaHasUsuarioPK != null ? peliculaHasUsuarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeliculaHasUsuario)) {
            return false;
        }
        PeliculaHasUsuario other = (PeliculaHasUsuario) object;
        if ((this.peliculaHasUsuarioPK == null && other.peliculaHasUsuarioPK != null) || (this.peliculaHasUsuarioPK != null && !this.peliculaHasUsuarioPK.equals(other.peliculaHasUsuarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.PeliculaHasUsuario[ peliculaHasUsuarioPK=" + peliculaHasUsuarioPK + " ]";
    }
    
}
