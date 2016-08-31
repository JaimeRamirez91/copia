package com.DaoInterface;

import com.entidades.DetalleProducto;
import com.entidades.Producto;
import java.util.List;

public interface DetalleProductoDao {
    
    public List<DetalleProducto> listarFactura();
    public void newDetalle(DetalleProducto detalle, Producto prod);
    
}
