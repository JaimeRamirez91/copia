package com.entidades;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@Table(name = "MENU")
@XmlRootElement
@NamedQueries({
     @NamedQuery(name = "Menu.Lista", query = "FROM Menu")
              })
public class Menu implements Serializable{
    @Id
    @GeneratedValue
    @Column(name = "codigo")
    private long codigo;
    //
    @Column(name = "nombre")
    private String nombre;
    // S ó I Submenu ó Item
    @Column(name = "tipo")
    private String tipo;
    
    //Roles admin ó vendedor
    @Column(name = "tipoUsruario")
    private String tipoUsruario;
    
    
    @ManyToOne
    @JoinColumn(name="codigo_submenu")
    private Menu submenu;
    
     @Column(name = "estado")
    private int estado;
     
     //Roles admin ó vendedor
    @Column(name = "url")
    private String url;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipoUsruario() {
        return tipoUsruario;
    }

    public void setTipoUsruario(String tipoUsruario) {
        this.tipoUsruario = tipoUsruario;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Menu getSubmenu() {
        return submenu;
    }

    public void setSubmenu(Menu submenu) {
        this.submenu = submenu;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

   
    
    
}
