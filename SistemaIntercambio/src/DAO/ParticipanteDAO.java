package DAO;

import Clases.*;
import java.util.ArrayList;

public interface ParticipanteDAO {
    
    public ArrayList<Participante> listarParticipantes();
    public boolean suspenderParticipante(String pCedula);
    public boolean insertarParticipante(String pUserId, String pNombre, String pApellP, String pApellM, String pPassword,
            String pEmail, String pTelefono, String pDireccion, String pFechaNac);
    public ArrayList<Usuario>  listarUsuarios();
}
