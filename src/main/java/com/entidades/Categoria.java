package com.entidades;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORIA")
public class Categoria {
    @Id
    @GeneratedValue
    @Column(name = "IDCATEGORIA")
    private long idCategoria;
    @Column (name = "CATEGORIA")
    private String Categoria;

     @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    // private Set detalleproducto = new HashSet(0);  
    private Set<DetalleProducto> detalleproducto = new HashSet<DetalleProducto>(0);
     //   private Set facturas = new HashSet(0);
     //     private Set productos = new HashSet(0);
 
    public long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public Set<DetalleProducto> getDetalleproducto() {
        return detalleproducto;
    }

    public void setDetalleproducto(Set<DetalleProducto> detalleproducto) {
        this.detalleproducto = detalleproducto;
    }
   
   
    
}
