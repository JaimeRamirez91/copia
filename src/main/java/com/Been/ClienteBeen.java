package com.Been;

import com.DaoImp.ClienteDaoImp;
import com.DaoInterface.ClienteDao;
import com.Util.HibernateUtil;
import com.entidades.Clientes;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import org.hibernate.Transaction;

@ManagedBean(name = "clientebeen")
@ViewScoped
public class ClienteBeen implements Serializable {

    private List<Clientes> listaClientes;
    private Clientes cliente;
    private Integer codigoCliente = null;

    Session session = null;
    Transaction transaction = null;

    public ClienteBeen() {
    }

    public List<Clientes> getListaClientes() {
        ClienteDao cDao = new ClienteDaoImp();
        listaClientes = cDao.listaClientes();
        return listaClientes;
    }

    public void setListaClientes(List<Clientes> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Integer getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Integer codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    //Metodo para agregar los datos del cliente agregado por dialogo
    public void agregarDatosCliente(Integer codCliente) {

        this.session = null;
        this.transaction = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            ClienteDao cDao = new ClienteDaoImp();
            this.transaction = this.session.beginTransaction();
            //obtener los datos del cliente en el objeto cliente segus sea su codigo
            this.cliente = cDao.obtenerClientPorCodigo(session, codCliente);

            this.transaction.commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "correcto", "ok"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (this.transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (this.session != null) {

                this.session.close();

            }
        }
    }

    //Metodo para agregar los datos del cliente por codigo
    public void agregarDatosCliente2() {

        this.session = null;
        this.transaction = null;

        try {
            if (this.codigoCliente == null) {
                
            } else {
                this.session = HibernateUtil.getSessionFactory().openSession();
                ClienteDao cDao = new ClienteDaoImp();
                this.transaction = this.session.beginTransaction();
                //obtener los datos del cliente en el objeto cliente segus sea su codigo
                this.cliente = cDao.obtenerClientPorCodigo(session, codigoCliente);
                
                if(this.cliente != null){
                    this.codigoCliente=null;
                     FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se encontro el cliente", "ok"));
                }else{
                  this.codigoCliente=null;
                   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "No se encontro el registro", ";/"));
                }
                this.transaction.commit();
               
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (this.transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (this.session != null) {
                this.session.close();

            }
        }
    }
}
