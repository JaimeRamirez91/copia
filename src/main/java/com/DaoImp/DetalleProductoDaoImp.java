package com.DaoImp;

import com.DaoInterface.DetalleProductoDao;
import com.Util.HibernateUtil;
import com.entidades.DetalleProducto;
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

}
