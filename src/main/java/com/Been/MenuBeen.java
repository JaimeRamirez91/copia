package com.Been;
import com.DaoImp.MenuDaoImp;
import com.DaoInterface.MenuDao;
import com.entidades.Menu;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

@ManagedBean
@SessionScoped

public class MenuBeen implements Serializable{
    private List<Menu> lista;
    private MenuModel model;
    MenuDao mDao = new MenuDaoImp();
    
    @PostConstruct
    public void init() {
        model = new DefaultMenuModel();
        this.listarmenu();
        this.EstablecerPermisos();
    }
    
    public void listarmenu(){
        try {
             lista = mDao.listaMenu();
        } catch (Exception e) {
        }
    }

    public List<Menu> getLista() {
        return lista;
    }

    public void setLista(List<Menu> lista) {
        this.lista = lista;
    }

    public MenuDao getmDao() {
        return mDao;
    }

    public void setmDao(MenuDao mDao) {
        this.mDao = mDao;
    }

    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }
    
    public void EstablecerPermisos(){  
           for(Menu m: lista){
               System.out.println(m.getTipo());
                System.out.println("--------------------------------------------");
              if(m.getTipo().equals("S")){
              DefaultSubMenu  firstsubmenu = new DefaultSubMenu(m.getNombre());
              for(Menu i: lista){
                 Menu submenu= i.getSubmenu();
                 if(submenu != null){
                    if(submenu.getCodigo() == m.getCodigo()){
                       DefaultMenuItem item = new DefaultMenuItem(i.getNombre());
                       item.setOutcome(i.getUrl());
                       
                       firstsubmenu.addElement(item);
                    }
                     
                 
                 }
              }
              model.addElement(firstsubmenu);
              }else{
                  if(m.getSubmenu() == null){
                  DefaultMenuItem item = new DefaultMenuItem(m.getNombre());
                  model.addElement(item);}
              
              }
           }
    }

}