
package DAO;

import Clases.Trato;
import java.util.ArrayList;

public interface TratoDAO {
    public ArrayList<Trato> verTransacciones(String idSesion);
    public ArrayList<Trato> verUltimosTratos();
}
