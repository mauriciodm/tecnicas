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
@Table(name = "perfil", catalog = "perfil_tecnicas", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perfil.findAll", query = "SELECT p FROM Perfil p")
    , @NamedQuery(name = "Perfil.findByNombre", query = "SELECT p FROM Perfil p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Perfil.findByApellido", query = "SELECT p FROM Perfil p WHERE p.apellido = :apellido")
    , @NamedQuery(name = "Perfil.findByEdad", query = "SELECT p FROM Perfil p WHERE p.edad = :edad")
    , @NamedQuery(name = "Perfil.findByPregrado", query = "SELECT p FROM Perfil p WHERE p.pregrado = :pregrado")})
public class Perfil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 255)
    @Column(name = "APELLIDO")
    private String apellido;
    @Size(max = 255)
    @Column(name = "EDAD")
    private String edad;
    @Size(max = 255)
    @Column(name = "PREGRADO")
    private String pregrado;

    public Perfil() {
    }

    public Perfil(String nombre, String apellido, String edad, String pregrado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.pregrado = pregrado;
    }

    public Perfil(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getPregrado() {
        return pregrado;
    }

    public void setPregrado(String pregrado) {
        this.pregrado = pregrado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombre != null ? nombre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfil)) {
            return false;
        }
        Perfil other = (Perfil) object;
        if ((this.nombre == null && other.nombre != null) || (this.nombre != null && !this.nombre.equals(other.nombre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "POJO.Perfil[ nombre=" + nombre + " ]";
    }
    
}
