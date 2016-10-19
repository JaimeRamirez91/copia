package com.Been;

import com.DaoImp.CategoriaDaoImp;
import com.DaoImp.DetalleProductoDaoImp;
import com.DaoImp.ProveedorDaoImp;
import com.DaoInterface.CategoriaDao;
import com.DaoInterface.DetalleProductoDao;
import com.DaoInterface.ProveedorDao;
import com.entidades.Categoria;
import com.entidades.DetalleProducto;
import com.entidades.Producto;
import com.entidades.Proveedor;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

@ManagedBean(name = "DetalleProductoBeen")
@ViewScoped
public class DetalleProductoBeen implements Serializable{
     List<DetalleProducto> listadelatte;
     List<Categoria> listaCategoria;
     List<Proveedor> listaProveedor;
     private DetalleProducto detalle; 
     private Producto producto;
     private Categoria categoria;
     private Proveedor proveedor;

    public DetalleProductoBeen() {
        nuevopructo();
    }
    public void  nuevopructo(){
        producto = new Producto();
        categoria = new Categoria();
        proveedor = new Proveedor();
        detalle = new DetalleProducto();
    }
    public List<DetalleProducto> getListadelatte() {
        DetalleProductoDao dDao= new DetalleProductoDaoImp();
        listadelatte =  dDao.listarFactura();
        return listadelatte;
    }

    public void setListadelatte(List<DetalleProducto> listadelatte) {
        this.listadelatte = listadelatte;
    }

    public DetalleProducto getDetalle() {
        return detalle;
    }

    public void setDetalle(DetalleProducto detalle) {
        this.detalle = detalle;
    }
    //operaciones CRUD
    public void nuevodetalle(){
         DetalleProductoDao dDao = new DetalleProductoDaoImp();
         dDao.newDetalle(detalle,producto,proveedor,categoria);
    }
    public void updatedetalle(){
         DetalleProductoDao dDao = new DetalleProductoDaoImp();
         dDao.updateDetalle(detalle,producto,proveedor,categoria);
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Categoria> getListaCategoria() {
        CategoriaDao cDao= new CategoriaDaoImp();
        listaCategoria =  cDao.listarCategoria();
        return listaCategoria;
    }

    public void setListaCategoria(List<Categoria> listaCategoria) {
        this.listaCategoria = listaCategoria;
    }

    public List<Proveedor> getListaProveedor() {
        ProveedorDao pDao = new ProveedorDaoImp(); 
        listaProveedor = pDao.listarProveedor();
        return listaProveedor;
    }

    public void setListaProveedor(List<Proveedor> listaProveedor) {
        this.listaProveedor = listaProveedor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

}