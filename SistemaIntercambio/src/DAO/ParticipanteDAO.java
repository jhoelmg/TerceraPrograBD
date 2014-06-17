package DAO;

import Clases.Participante;
import java.util.ArrayList;

public interface ParticipanteDAO {
    
    public ArrayList<Participante> listarParticipantes();
    public boolean suspenderParticipante(String pCedula);
}
