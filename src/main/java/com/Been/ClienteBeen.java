/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Been;
import com.DaoImp.ClienteDaoImp;
import com.DaoInterface.ClienteDao;
import com.entidades.Clientes;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
@ManagedBean(name = "clientebeen")
@ViewScoped
public class ClienteBeen  implements Serializable{
    private List<Clientes> listaClientes;
    public ClienteBeen() {
    }

    public List<Clientes> getListaClientes() {
         ClienteDao cDao= new ClienteDaoImp();
        listaClientes =  cDao.listaClientes();
        return listaClientes;
    }

    public void setListaClientes(List<Clientes> listaClientes) {
        this.listaClientes = listaClientes;
    }

  
    
}
