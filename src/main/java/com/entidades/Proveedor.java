package com.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "PROVEEDOR")
@XmlRootElement
@NamedQueries({
              @NamedQuery( name = "proveedor.Lista" , query = "From Proveedor") 
              })
public class Proveedor implements Serializable{

    @Id
    @GeneratedValue
    @Column(name = "IDPROVEEDOR")
    private long Idproveedor;

    @Column(name = "PRONOMBRE")
    @NotNull
    private String proNombre;

    @Column(name = "PRODIRECCION")
    @NotNull
    private String proDireccion;
    
    @Column(name = "PROTELEFONO")
    @NotNull
    private String Telefono;
    
    //obtiene los datos automaticamente
    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL)
   // private Set detalleproducto = new HashSet(0);  
    private Set<DetalleProducto> detalleproducto = new HashSet<DetalleProducto>(0);
 //   private Set facturas = new HashSet(0);
//     private Set productos = new HashSet(0);
  
    public Proveedor() {

    }
       public Proveedor(long id,String protelefono, String prodireccion, String pronombre) {
       this.Telefono = protelefono;
       this.proDireccion = prodireccion;
       this.proNombre = pronombre;
       this.Idproveedor=id;
    }
    public Proveedor(long id, String pronombre) {
       
       this.proNombre = pronombre;
       this.Idproveedor=id;
    }

    public long getIdproveedor() {
        return Idproveedor;
    }

    public void setIdproveedor(long Idproveedor) {
        this.Idproveedor = Idproveedor;
    }

    public String getProNombre() {
        return proNombre;
    }

    public void setProNombre(String proNombre) {
        this.proNombre = proNombre;
    }

    public String getProDireccion() {
        return proDireccion;
    }

    public void setProDireccion(String proDireccion) {
        this.proDireccion = proDireccion;
    }

    public Set getDetalleproducto() {
        return detalleproducto;
    }

    public void setDetalleproducto(Set detalleproducto) {
        this.detalleproducto = detalleproducto;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

   

}