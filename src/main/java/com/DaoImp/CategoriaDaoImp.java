
package com.DaoImp;
import com.DaoInterface.CategoriaDao;
import com.Util.HibernateUtil;
import com.entidades.Categoria;
import com.entidades.Categoria;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author pc
 */
public class CategoriaDaoImp implements CategoriaDao{

    @Override
    public List<Categoria> listarCategoria() {
        List<Categoria> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Categoria";
        try {
            lista = session.createQuery(hql).list();
            t.commit();

            session.close();
        } catch (Exception e) {
            t.rollback();
        }
        for(Categoria c:lista){
            System.out.println("----------------------------------------------");
            System.out.println(c.getIdCategoria());
            System.out.println(c.getCategoria());
            System.out.println("----------------------------------------------");
        }
        return lista;
    }
    
}
