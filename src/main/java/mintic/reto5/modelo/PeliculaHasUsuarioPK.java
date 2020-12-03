/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mintic.reto5.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author CARLOS
 */
@Embeddable
public class PeliculaHasUsuarioPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @Column(name = "pelicula_titulo")
    private String peliculaTitulo;
    @Basic(optional = false)
    @Column(name = "pelicula_director_id")
    private int peliculaDirectorId;

    public PeliculaHasUsuarioPK() {
    }

    public PeliculaHasUsuarioPK(String usuario, String peliculaTitulo, int peliculaDirectorId) {
        this.usuario = usuario;
        this.peliculaTitulo = peliculaTitulo;
        this.peliculaDirectorId = peliculaDirectorId;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPeliculaTitulo() {
        return peliculaTitulo;
    }

    public void setPeliculaTitulo(String peliculaTitulo) {
        this.peliculaTitulo = peliculaTitulo;
    }

    public int getPeliculaDirectorId() {
        return peliculaDirectorId;
    }

    public void setPeliculaDirectorId(int peliculaDirectorId) {
        this.peliculaDirectorId = peliculaDirectorId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuario != null ? usuario.hashCode() : 0);
        hash += (peliculaTitulo != null ? peliculaTitulo.hashCode() : 0);
        hash += (int) peliculaDirectorId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeliculaHasUsuarioPK)) {
            return false;
        }
        PeliculaHasUsuarioPK other = (PeliculaHasUsuarioPK) object;
        if ((this.usuario == null && other.usuario != null) || (this.usuario != null && !this.usuario.equals(other.usuario))) {
            return false;
        }
        if ((this.peliculaTitulo == null && other.peliculaTitulo != null) || (this.peliculaTitulo != null && !this.peliculaTitulo.equals(other.peliculaTitulo))) {
            return false;
        }
        if (this.peliculaDirectorId != other.peliculaDirectorId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.PeliculaHasUsuarioPK[ usuario=" + usuario + ", peliculaTitulo=" + peliculaTitulo + ", peliculaDirectorId=" + peliculaDirectorId + " ]";
    }
    
}
