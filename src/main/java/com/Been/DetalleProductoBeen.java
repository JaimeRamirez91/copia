/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Been;

import com.DaoImp.DetalleProductoDaoImp;
import com.DaoInterface.DetalleProductoDao;
import com.entidades.DetalleProducto;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "DetalleProductoBeen")
@ViewScoped
public class DetalleProductoBeen {
     private List<DetalleProducto> listadelatte;

    public DetalleProductoBeen() {
    }

    public List<DetalleProducto> getListadelatte() {
        DetalleProductoDao dDao= new DetalleProductoDaoImp();
        listadelatte =  dDao.listarFactura();
        return listadelatte;
    }

    public void setListadelatte(List<DetalleProducto> listadelatte) {
        this.listadelatte = listadelatte;
    }

    
    
}
