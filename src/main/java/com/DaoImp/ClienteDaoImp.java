package com.DaoImp;
import com.entidades.Clientes;
import com.DaoInterface.ClienteDao;
import com.Util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClienteDaoImp implements ClienteDao{

    @Override
    public List<Clientes> listaClientes() {
        List<Clientes> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            lista = session.getNamedQuery("Usr.Login").setParameter("alias", "jaime").setParameter("passUsr", "123").list();
            t.commit();

            session.close();
        } catch (Exception e) {
            t.rollback();
        }

        return lista;
       
    }

    @Override
    public Clientes obtenerClientPorCodigo(Session session, Integer codCliente) throws Exception {
        Long id = codCliente.longValue();
        Query query =session.getNamedQuery("clientes.codigo").setParameter("idCliente", id);
        Clientes cliente = (Clientes)query.uniqueResult();
        return  cliente;
    }
    
}
