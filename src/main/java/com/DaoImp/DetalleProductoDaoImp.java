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
    public void newDetalle(DetalleProducto detalle,Producto prod, Proveedor proveedor, Categoria categoria) {
        Session session = null;
        try {
            /*
            ---------------------------------------------------------------------------
            Es para realizar pruebas de insercion sin necesidad de utilisar la cista
            ---------------------------------------------------------------------------
            Categoria categoria =new Categoria(1L,"categoria");
            Proveedor  proveedor = new Proveedor(1L,"1234","direccion","proveedor");
            Producto producto = new Producto("prueba2",2.2,1);
            --------------------------------------------------------------------------
            */
            
            detalle.setProducto(prod);
            detalle.setCategoria(categoria);
            detalle.setProveedor(proveedor);
            /*
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("categoria");
            System.out.println(detalle.getCategoria().getIdCategoria());
            System.out.println("proveedor");
            System.out.println(detalle.getProveedor().getIdproveedor());
            System.out.println("nombre producto");
            System.out.println(detalle.getProducto().getProNombre());
           System.out.println("-----------------------------------------------------------------------------------");
            */
            session = HibernateUtil.getSessionFactory().openSession();
             
           session.beginTransaction();
           /*Al ser una relacion OneToOne entre DetalleProducto y Producto, al crear el detalle o el producto
             automaticamente se crea la otra tabla 
           */
            session.save(detalle);
            session.getTransaction().commit();

        } catch (Exception e) {
            System.out.println(e);
            session.getTransaction().rollback();
        }finally{
        if(session!=null){
        session.close();
        }
        }
    }

    @Override
    public void uodateDetalle(DetalleProducto detalle, Producto prod, Proveedor proveedor, Categoria categoria) {
        Session session = null;
        try {
            /*
            ---------------------------------------------------------------------------
            Es para realizar pruebas de insercion sin necesidad de utilisar la cista
            ---------------------------------------------------------------------------
            Categoria categoria =new Categoria(1L,"categoria");
            Proveedor  proveedor = new Proveedor(1L,"1234","direccion","proveedor");
            Producto producto = new Producto("prueba2",2.2,1);
            --------------------------------------------------------------------------
            */
            
            detalle.setProducto(prod);
            detalle.setCategoria(categoria);
            detalle.setProveedor(proveedor);
            /*
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("categoria");
            System.out.println(detalle.getCategoria().getIdCategoria());
            System.out.println("proveedor");
            System.out.println(detalle.getProveedor().getIdproveedor());
            System.out.println("nombre producto");
            System.out.println(detalle.getProducto().getProNombre());
           System.out.println("-----------------------------------------------------------------------------------");
            */
            session = HibernateUtil.getSessionFactory().openSession();
             
           session.beginTransaction();
           /*Al ser una relacion OneToOne entre DetalleProducto y Producto, al crear el detalle o el producto
             automaticamente se crea la otra tabla 
           */
            session.update(detalle);
            session.getTransaction().commit();

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
