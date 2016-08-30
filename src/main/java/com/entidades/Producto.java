
package com.entidades;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
@Entity
@Table(name = "PRODUCTO")
public class Producto {
    @Id
    @GeneratedValue
    @Column(name = "IDPRODUCTO")
    private long idProducto; 
    @Column(name = "PRONOMBRE")
    @NotNull
    private String proNombre;
    @Column(name = "PROPRECIO")
    @NotNull
    private double proPrecio;
    @Column(name = "STOCK")
    @NotNull
    private int stock;
    //Bidireccional
    @OneToOne(cascade=CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private DetalleProducto detalleproducto;
   
    public Producto(){
    
    }

    public long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(long idProducto) {
        this.idProducto = idProducto;
    }

    public String getProNombre() {
        return proNombre;
    }

    public void setProNombre(String proNombre) {
        this.proNombre = proNombre;
    }

    public double getProPrecio() {
        return proPrecio;
    }

    public void setProPrecio(double proPrecio) {
        this.proPrecio = proPrecio;
    }

    public DetalleProducto getDetalleproducto() {
        return detalleproducto;
    }

    public void setDetalleproducto(DetalleProducto detalleproducto) {
        this.detalleproducto = detalleproducto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
 
    
    
}
