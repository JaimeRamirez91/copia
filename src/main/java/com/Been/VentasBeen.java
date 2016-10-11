
package com.Been;
import com.DaoImp.VentasDaoImp;
import com.DaoInterface.ventasDAO;
import com.entidades.Producto;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "ventasbeen")
@ViewScoped
public class VentasBeen implements Serializable {
    List<Producto> listaproducto;
    public VentasBeen() {
        
    }

    public List<Producto> getListaproducto() {
        ventasDAO pDao = new VentasDaoImp();
        listaproducto =  pDao.listaProducto();
        return listaproducto;
    }

    public void setListaproducto(List<Producto> listaproducto) {
        this.listaproducto = listaproducto;
    }
    
}
