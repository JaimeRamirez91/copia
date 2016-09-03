package com.DaoImp;
import com.DaoInterface.CategoriaDao;
import com.Util.HibernateUtil;
import com.entidades.Categoria;
import com.entidades.Categoria;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CategoriaDaoImp implements CategoriaDao{

    @Override
    public List<Categoria> listarCategoria() {
        List<Categoria> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            lista = session.getNamedQuery("categoria.Lista").list();
            t.commit();

            session.close();
        } catch (Exception e) {
            t.rollback();
        }
        return lista;
    }
    
}