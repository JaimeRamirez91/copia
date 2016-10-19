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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "FACTURA")
public class Factura implements Serializable{
    
    @Id
    @GeneratedValue
    @Column(name = "codFactura")
    private long codFactura; 
    
    @Column(name = "numeroFactura")
    private long numeroFactura; 
    
    @Column(name = "codVendedor")
    private long codVendedor; 
    
    @Column(name = "codCliente")
    private long codCliente;
    
     //relacion con detalle factura
    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL)
    private Set<DetalleFactura> detallefactura = new HashSet<DetalleFactura>(0);
    
    public Factura(){
    
    }
    
    public long getCodFactura() {
        return codFactura;
    }

    public void setCodFactura(long codFactura) {
        this.codFactura = codFactura;
    }

    public long getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(long numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public long getCodVendedor() {
        return codVendedor;
    }

    public void setCodVendedor(long codVendedor) {
        this.codVendedor = codVendedor;
    }

    public long getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(long codCliente) {
        this.codCliente = codCliente;
    }
    
    
}
