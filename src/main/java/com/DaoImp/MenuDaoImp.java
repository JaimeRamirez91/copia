package com.DaoImp;

import com.DaoInterface.MenuDao;
import com.Util.HibernateUtil;
import com.entidades.Menu;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MenuDaoImp implements MenuDao{

    @Override
    public List<Menu> listaMenu() {
        
       List<Menu> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        try {
            lista = session.getNamedQuery("Menu.Lista").list();
            t.commit();
            session.close();
        } catch (Exception e) {
            t.rollback();
        }
        for(Menu m:lista){
            System.out.println(m.getNombre());
        }
        System.out.println("###########################################");
        return lista;
    }
    
}
