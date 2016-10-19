package com.Been;
import com.DaoImp.LoginDaoImp;
import com.DaoInterface.LoginDao;
import com.entidades.Usuarios;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;
@ManagedBean(name ="login")
@SessionScoped
public class loginControllerBeen implements Serializable{
    
    private String username;     
    private String password;
    private Usuarios usr;
 
    public loginControllerBeen(){
        usr = new Usuarios(); 
        
    }
    
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
   
    public void login(ActionEvent event) throws IOException{
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn = false;
        String ruta = "";
        LoginDao uDao = new LoginDaoImp();
        this.usr = uDao.Login(this.usr);
        System.out.println("----------------------------------");
        System.out.println(usr.getAliass());
        System.out.println("----------------------------------");
        if(usr != null) {
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", username);
            //Es de JSF 
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            ec.redirect(ec.getRequestContextPath()+"/faces/Vistas/Inicio/Inicio.xhtml");
            //se usaria si utilizo escrip JQuery  
            // ruta = "/mavenproject1/faces/Vistas/Inicio/Inicio.xhtml";
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
            this.usr = new Usuarios();
        }
         
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedIn", loggedIn);
      //se usaria si utilizo escrip JQuery  
      //  context.addCallbackParam("ruta", ruta);
    }  
    /*    Este es de internet
    public void logout() throws IOException {
    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
    ec.invalidateSession();
    ec.redirect(ec.getRequestContextPath());
   }
    */
    public void clssession() throws IOException{
        this.username = null;
        this.password = null;
        //se inporta de java servlet
        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        httpSession.invalidate();
        //Es de JSF 
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(ec.getRequestContextPath());
    }

    public Usuarios getUsr() {
        return usr;
    }

    public void setUsr(Usuarios usr) {
        this.usr = usr;
    }
    
    
}
