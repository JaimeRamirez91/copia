package com.DaoInterface;

import com.entidades.Usuarios;
import java.util.List;

public interface LoginDao {
    //Lista de usuario para loguin
    public Usuarios ObtenerDatosUsr(Usuarios usuario);
    public Usuarios Login(Usuarios usuario);
    
}
