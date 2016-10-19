/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DaoImp;
import com.DaoInterface.LoginDao;
import com.entidades.Usuarios;
import java.util.List;
import com.Util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class LoginDaoImp implements LoginDao{

    @Override
    public Usuarios ObtenerDatosUsr(Usuarios usuario) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Query  q = session.getNamedQuery("Usr.Login");
        q.setParameter("alias",usuario.getAliass()).setParameter("passUsr", usuario.getPassUsr()); 
        return (Usuarios) q.uniqueResult();    
    }

    @Override
    public Usuarios Login(Usuarios usuario) {
        Usuarios usr = this.ObtenerDatosUsr(usuario);
        if(usr == null){
           usr = null;
        }
        return usr;
    }
    
}
