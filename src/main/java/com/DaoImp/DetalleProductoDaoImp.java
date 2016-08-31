package com.DaoImp;

import com.DaoInterface.DetalleProductoDao;
import com.Util.HibernateUtil;
import com.entidades.Categoria;
import com.entidades.DetalleProducto;
import com.entidades.Producto;
import com.entidades.Proveedor;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DetalleProductoDaoImp implements DetalleProductoDao {

    @Override
    public List<DetalleProducto> listarFactura() {
        List<DetalleProducto> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM DetalleProducto";
        /*
       inner join fetch hace que se llene el objeto estadoProducto con todos los datos en una 
       sola consulta para evitar el error de que el proxy no esta inicializado
       buscar aquimas info:
       
       http://www.javatutoriales.com/2009/09/hibernate-parte-7-hql-primera-parte.html
       
       
         */
        //String hql = "from Producto p inner join fetch p.estadoProducto";

        try {
            lista = session.createQuery(hql).list();
            t.commit();

            session.close();
        } catch (Exception e) {
            t.rollback();
        }

        return lista;

    }

    @Override
    public void newDetalle(DetalleProducto detalle,Producto prod) {
        Session session = null;
        try {
            Categoria categoria =new Categoria(1L,"categoria");
            Proveedor  proveedor = new Proveedor(1L,"1234","direccion","proveedor");
            Producto producto = new Producto("prueba",2.2,1);
          //  producto.setDetalleproducto(detalle); 
            detalle.setProducto(producto);
            detalle.setCategoria(categoria);
            detalle.setProveedor(proveedor);
            System.out.println(".........................................");
            System.out.println(detalle.getCategoria().getIdCategoria());
            System.out.println(detalle.getProveedor().getIdproveedor());
            System.out.println(detalle.getProducto().getProNombre());
           System.out.println(".........................................");
         //   session.getTransaction().begin(); 
            session = HibernateUtil.getSessionFactory().openSession();
             
           session.beginTransaction();
            session.save(detalle);
            session.getTransaction().commit();
         //   session.getTransaction().begin();
        } catch (Exception e) {
            System.out.println(e);
            session.getTransaction().rollback();
        }finally{
        if(session!=null){
        session.close();
        }
        }
    }

}
