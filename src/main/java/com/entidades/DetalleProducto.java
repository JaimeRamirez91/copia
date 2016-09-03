
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
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "DETALLEPRODUCTO")
@XmlRootElement
@NamedQueries({
              @NamedQuery( name = "detalleProducto.Lista" , query = "From DetalleProducto") 
              })
public class DetalleProducto implements Serializable{
    @Id
    @GeneratedValue
    @Column(name = "IDDETALLE")
    private long IdDetalle; 
    @Column(name = "PRECIOCOMPRA")
    private double precioCompra;
    //obtiene los datos automaticamente
    @ManyToOne
    @JoinColumn(name="IDPROVEEDOR")
    @org.hibernate.annotations.ForeignKey(name = "FK_PROVEEDOR_ID")
    //private Proveedor proveedor;
    private Proveedor proveedor;
    //Categoria
    @ManyToOne
    @JoinColumn(name="IDCATEGORIA")
    @org.hibernate.annotations.ForeignKey(name = "FK_PROVEEDOR_ID")
     private Categoria categoria;
    
    //bidireccional 
    @OneToOne(cascade=CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Producto producto;
    //Leer http://www.tacs-utn.com.ar/Home/apuntes/hibernate---mapping-y-relaciones
    //http://cursohibernate.es/doku.php?id=unidades:03_relaciones:03_uno_a_muchos_desordenada
    
    
    public DetalleProducto(){
        
    }
    
    public DetalleProducto(Categoria categoria, Double preciocompra, Proveedor proveedor){
        this.categoria = categoria;
        this.precioCompra=preciocompra;
        this.proveedor = proveedor;
        }

    public long getIdDetalle() {
        return IdDetalle;
    }

    public void setIdDetalle(long IdDetalle) {
        this.IdDetalle = IdDetalle;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
 
}