package com.Been;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import com.entidades.Usuarios;
import java.io.Serializable;
import javax.faces.bean.SessionScoped;
@ManagedBean(name ="secion")
@SessionScoped
public class PlantillaContolerBeen implements Serializable {
     Usuarios objeto =  new Usuarios();
     public String nombre; 
     public String contraseña;

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String cadena) {
        try {
            FacesContext context =  FacesContext.getCurrentInstance();
            objeto = (Usuarios) context.getExternalContext().getSessionMap().get("usuario");
            if(objeto != null) {
              this.contraseña = objeto.getPassUsr(); 
            }else {
            this.nombre =  cadena;
            }
            
        } catch (Exception e) {
        this.nombre = cadena;
        }
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String cadena) {
         try {
            FacesContext context =  FacesContext.getCurrentInstance();
            objeto = (Usuarios) context.getExternalContext().getSessionMap().get("usuario");
            if(objeto != null) {
              this.nombre = objeto.getAliass(); 
            }else {
            this.nombre =  cadena;
            }
            
        } catch (Exception e) {
        this.nombre = cadena;
        }
        
    }
     
    public PlantillaContolerBeen() {
        setNombre("fff");
        setContraseña("ffff");
    }
    
    public void verificarsecion(){
        try {
            FacesContext context =  FacesContext.getCurrentInstance();
            objeto = (Usuarios) context.getExternalContext().getSessionMap().get("usuario");
            if(objeto == null) {
            System.out.println("si entre");
            context.getExternalContext().redirect("/mavenproject1/");
          
            } 
            System.out.println("no entre");
        } catch (Exception e) {
           System.out.println("error");
        }
    }
    
    public void cerrarsesion(){
    FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }
    
    public String redirecthome(){
    return "/mavenproject1/"; 
    } 
}
