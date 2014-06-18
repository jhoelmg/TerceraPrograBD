package DAO;

import Clases.Sesion;
import java.util.ArrayList;

public interface SesionDAO {
    
    public int createSesion(String pAdminID);
    
    public ArrayList<Sesion> listarSesiones ();
    
    public boolean finalizarSesion(String sesionID);
}
