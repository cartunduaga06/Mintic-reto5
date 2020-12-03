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
public class PeliculaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @Column(name = "director_id")
    private int directorId;

    public PeliculaPK() {
    }

    public PeliculaPK(String titulo, int directorId) {
        this.titulo = titulo;
        this.directorId = directorId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDirectorId() {
        return directorId;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (titulo != null ? titulo.hashCode() : 0);
        hash += (int) directorId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeliculaPK)) {
            return false;
        }
        PeliculaPK other = (PeliculaPK) object;
        if ((this.titulo == null && other.titulo != null) || (this.titulo != null && !this.titulo.equals(other.titulo))) {
            return false;
        }
        if (this.directorId != other.directorId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.PeliculaPK[ titulo=" + titulo + ", directorId=" + directorId + " ]";
    }
    
}
