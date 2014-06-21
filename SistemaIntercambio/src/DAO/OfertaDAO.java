package DAO;

import Clases.Oferta;
import java.util.ArrayList;

public interface OfertaDAO {
    
    public boolean crearOferta(String pUserId, String pMonto, String pTipo, String pTipoCambio, String pSesionId);
    public ArrayList<Oferta> buscarOferta(String pTipoOferta, String pMontoMin, String pMontoMax, 
            String pTipoCambioMin, String pTipoCambioMax);
}
