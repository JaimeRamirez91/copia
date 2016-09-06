package com.DaoImp;
import com.entidades.Clientes;
import com.DaoInterface.ClienteDao;
import com.Util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClienteDaoImp implements ClienteDao{

    @Override
    public List<Clientes> listaClientes() {
        List<Clientes> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            lista = session.getNamedQuery("clientes.Lista").list();
            t.commit();

            session.close();
        } catch (Exception e) {
            t.rollback();
        }

        return lista;
       
    }
    
}
