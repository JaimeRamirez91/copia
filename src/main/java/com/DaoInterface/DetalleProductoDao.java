package com.DaoInterface;

import com.entidades.Categoria;
import com.entidades.DetalleProducto;
import com.entidades.Producto;
import com.entidades.Proveedor;
import java.util.List;
import org.hibernate.Session;

public interface DetalleProductoDao {
    public List<DetalleProducto> listarFactura();
    public void newDetalle(DetalleProducto detalle, Producto prod, Proveedor proveedor, Categoria categoria);
    public void updateDetalle(DetalleProducto detalle, Producto prod, Proveedor proveedor, Categoria categoria);
    
    //Metodo para llenar la tabla de la factura por codigo de barra
    public Producto obtenerProducto(Session session, String codBarra) throws Exception; 
}
