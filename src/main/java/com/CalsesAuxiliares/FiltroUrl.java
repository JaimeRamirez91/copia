
package com.CalsesAuxiliares;

import com.entidades.Usuarios;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.NavigationHandler;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;
/*
Esta clase se invoca en la carpeta web-inf, en el archivo faces config para filtarar las url
*/
public class FiltroUrl implements PhaseListener{

  @Override
  public void afterPhase(PhaseEvent event) {
        FacesContext fc = event.getFacesContext();
        ExternalContext ec = fc.getExternalContext();
        //VERIFICA SI ESTA EN EL LOGIN
        if (!fc.getViewRoot().getViewId().contains("Login.xhtml")) {
            HttpSession session = (HttpSession) ec.getSession(true);
            Object usuario =  session.getAttribute("usuario");
            //SI INTENTAS ACCEDER Y EL USR ES NULL TE REDIRECCIONA
            if (usuario == null) {
                try {
                    ec.redirect(ec.getRequestContextPath() + "/faces/Vistas/Inicio/Login.xhtml");
                } catch (IOException ex) {
                   
                }
            }
        }
}
    @Override
    public void beforePhase(PhaseEvent pe) {
       
    }
    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;

    }
    
}
    
