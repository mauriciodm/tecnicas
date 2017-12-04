/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CASKLE
 */
@Entity
@Table(name = "laboral", catalog = "perfil_tecnicas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Laboral.findAll", query = "SELECT e FROM Laboral e")
    , @NamedQuery(name = "Laboral.findByTiempoDisponible", query = "SELECT e FROM Laboral e WHERE e.tiempoDisponible = :tiempoDisponible")
    , @NamedQuery(name = "Laboral.findByExperiencia", query = "SELECT e FROM Laboral e WHERE e.experiencia = :experiencia")
    , @NamedQuery(name = "Laboral.findByEstudiosSuperiores", query = "SELECT e FROM Laboral e WHERE e.estudiosSuperiores = :estudiosSuperiores")})
public class Laboral implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column
    private String tiempoDisponible;
    @Size(max = 50)
    @Column
    private String experiencia;
    @Size(max = 50)
    @Column
    private String estudiosSuperiores;

    public Laboral() {
    }

    public Laboral(String tiempoDisponible) {
        this.tiempoDisponible = tiempoDisponible;
    }

    public String getTiempoDisponible() {
        return tiempoDisponible;
    }

    public void setTiempoDisponible(String tiempoDisponible) {
        this.tiempoDisponible = tiempoDisponible;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getEstudiosSuperiores() {
        return estudiosSuperiores;
    }

    public void setEstudiosSuperiores(String estudiosSuperiores) {
        this.estudiosSuperiores = estudiosSuperiores;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tiempoDisponible != null ? tiempoDisponible.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Laboral)) {
            return false;
        }
        Laboral other = (Laboral) object;
        if ((this.tiempoDisponible == null && other.tiempoDisponible != null) || (this.tiempoDisponible != null && !this.tiempoDisponible.equals(other.tiempoDisponible))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "POJO.Laboral[ tiempoDisponible=" + tiempoDisponible + " ]";
    }
    
}
