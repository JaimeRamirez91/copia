package com.DaoInterface;
import com.entidades.Clientes;
import java.util.List;
import org.hibernate.Session;
public interface ClienteDao {
   public List<Clientes> listaClientes();
   
   //Metodo a utilizar en factura
   public Clientes obtenerClientPorCodigo(Session session, Integer codCliente )throws Exception;
}
