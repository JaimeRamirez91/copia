
package com.entidades;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@Table(name = "TIPO")
public class Tipo  implements Serializable{
    @Id
    @GeneratedValue
    @Column(name = "IDTIPO")
    private long idTipo;
    @Column(name = "TIPOUSR")
    private String tipoUsr;
    
     //relacion con Usuario
    @OneToMany(mappedBy = "tipo", cascade = CascadeType.ALL)
    private Set<Usuarios> Usuarios = new HashSet<Usuarios>(0);

    public Set<Usuarios> getUsuarios() {
        return Usuarios;
    }

    public void setUsuarios(Set<Usuarios> Usuarios) {
        this.Usuarios = Usuarios;
    }
    

    
    public long getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(long idTipo) {
        this.idTipo = idTipo;
    }

    public String getTipoUsr() {
        return tipoUsr;
    }

    public void setTipoUsr(String tipoUsr) {
        this.tipoUsr = tipoUsr;
    }
    
    
}
