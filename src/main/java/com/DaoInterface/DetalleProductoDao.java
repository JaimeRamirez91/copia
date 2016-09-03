package com.DaoInterface;

import com.entidades.Categoria;
import com.entidades.DetalleProducto;
import com.entidades.Producto;
import com.entidades.Proveedor;
import java.util.List;

public interface DetalleProductoDao {
    public List<DetalleProducto> listarFactura();
    public void newDetalle(DetalleProducto detalle, Producto prod, Proveedor proveedor, Categoria categoria);
    public void updateDetalle(DetalleProducto detalle, Producto prod, Proveedor proveedor, Categoria categoria);
    
}
