
package com.DaoImp;

import com.DaoInterface.ventasDAO;
import com.Util.HibernateUtil;
import com.entidades.Producto;
import com.entidades.Proveedor;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class VentasDaoImp  implements ventasDAO{

    @Override
    public List<Producto> listaProducto() {
        List<Producto> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            lista = session.getNamedQuery("producto.codigo").setParameter("proCodigoBarra", "11111").list();
            t.commit();
            session.close();
        } catch (Exception e) {
            t.rollback();
        }
        return lista;
    }
    
}
