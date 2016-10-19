/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "DETALLEFACTURA")
public class DetalleFactura implements Serializable{
    @Id
    @GeneratedValue
    @Column(name = "codDetalle")
    private long codDetalle;
    
    //relacion con la entidad factura
    @ManyToOne
    @JoinColumn(name="codFactura")
    @org.hibernate.annotations.ForeignKey(name = "FK_FACTURA_ID")
    private Factura factura;
    //relacion con la entidad producto
    @ManyToOne
    @JoinColumn(name="idProducto")
    @org.hibernate.annotations.ForeignKey(name = "FK_PRODUCTO_ID")
    private Producto producto;
    
    @Column(name = "cantidad")
    private int cantidad;
    
    @Column(name = "Total")
    private double Total;
    
    @Column(name = "codBarra")
    private int codbarra;
    
    
   //constructor
    public DetalleFactura(){
    
    }
    //constructor
    public DetalleFactura(Producto producto){
        this.producto = producto;
    }
    
    public long getCodDetalle() {
        return codDetalle;
    }

    public void setCodDetalle(long codDetalle) {
        this.codDetalle = codDetalle;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

    public int getCodbarra() {
        return codbarra;
    }

    public void setCodbarra(int codbarra) {
        this.codbarra = codbarra;
    }
    
    
}
