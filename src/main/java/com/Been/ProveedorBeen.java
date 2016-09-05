package com.Been;

import com.DaoImp.ProveedorDaoImp;
import com.DaoInterface.ProveedorDao;
import com.entidades.Categoria;
import com.entidades.Proveedor;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
@ManagedBean(name = "proveedorbeen")
@ViewScoped
public class ProveedorBeen implements Serializable{
    List<Proveedor> listaProveedor;
    public ProveedorBeen()  {
    }

    public List<Proveedor> getListaProveedor() {
        ProveedorDao pDao = new ProveedorDaoImp();
        listaProveedor = pDao.listarProveedor();
        return listaProveedor;
    }

    public void setListaProveedor(List<Proveedor> listaProveedor) {
        this.listaProveedor = listaProveedor;
    }
    
}
