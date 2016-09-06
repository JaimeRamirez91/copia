
package com.entidades;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@Table(name="CLIENTES")
@XmlRootElement
@NamedQueries({
              @NamedQuery( name = "clientes.Lista" , query = "FROM Clientes") 
              })
public class Clientes implements Serializable{
    @Id
    @GeneratedValue
    @Column(name = "IDCLIENTE")
    private long idCliente; 
    
    @Column(name = "CLIENTENOMBRE")
    @NotNull
    private String cliNombre;
    
    @Column(name = "CLIENTEAPELLIDOS")
    @NotNull
    private String cliApellidos;
    
    @Column(name = "CLIENTEDIRECCION")
    @NotNull
    private String cliDireccion;

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public String getCliNombre() {
        return cliNombre;
    }

    public void setCliNombre(String cliNombre) {
        this.cliNombre = cliNombre;
    }

    public String getCliApellidos() {
        return cliApellidos;
    }

    public void setCliApellidos(String cliApellidos) {
        this.cliApellidos = cliApellidos;
    }

    public String getCliDireccion() {
        return cliDireccion;
    }

    public void setCliDireccion(String cliDireccion) {
        this.cliDireccion = cliDireccion;
    }
    
    
    
}
