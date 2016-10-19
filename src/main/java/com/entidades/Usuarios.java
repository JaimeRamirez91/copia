/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@Table(name = "USUARIOS")
@XmlRootElement
@NamedQueries({
     @NamedQuery(name = "Usr.Login", query = "SELECT l FROM Usuarios l WHERE l.alias = :alias AND l.passUsr = :passUsr")
              })
public class Usuarios implements Serializable{
    @Id
    @GeneratedValue
    @Column(name = "IDUSUARIO")
    private long idUsuario;
    @Column(name = "ALIAS")
    private String alias;
    @Column(name = "PASSUSR")
    private String passUsr;
    @Column(name = "NOMBRE")
    private String nombres;
    @Column(name = "APELLIDO")
    private String apellidos;
    @Column(name = "DIRECCION")
    private String direccion;
    @Column(name = "TEL")
    private String tel;

    //relacion con la entidad Tipo
    @ManyToOne
    @JoinColumn(name="idTipo")
    @org.hibernate.annotations.ForeignKey(name = "FK_Tipo_ID")
    private Tipo tipo;

    public String getAliass() {
        return alias;
    }

    public void setAliass(String aliass) {
        this.alias = aliass;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    

    public String getPassUsr() {
        return passUsr;
    }

    public void setPassUsr(String passUsr) {
        this.passUsr = passUsr;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
    
    
}
