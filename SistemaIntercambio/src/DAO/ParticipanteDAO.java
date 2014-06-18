package DAO;

import Clases.Participante;
import java.util.Date;
import java.util.ArrayList;

public interface ParticipanteDAO {
    
    public ArrayList<Participante> listarParticipantes();
    public boolean suspenderParticipante(String pCedula);
    public boolean insertarParticipante(String pUserId, String pNombre, String pApellP, String pApellM, String pPassword,
            String pEmail, String pTelefono, String pDireccion, Date pFechaNac);
}
