package com.DaoImp;
import com.DaoInterface.ProveedorDao;
import com.Util.HibernateUtil;
import com.entidades.Proveedor;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProveedorDaoImp implements ProveedorDao{

    @Override
    public List<Proveedor> listarProveedor() {
       List<Proveedor> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            lista = session.getNamedQuery("proveedor.Lista").list();
            t.commit();
            session.close();
        } catch (Exception e) {
            t.rollback();
        }
        return lista;
    }
}