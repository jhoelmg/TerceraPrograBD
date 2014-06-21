
package DAO;

import Clases.Oferta;
import Factory.SQLServerDAOFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SQLServerOfertaDAO implements OfertaDAO{
    
    @Override
    public boolean crearOferta(String pUserId, String pMonto, String pTipo, String pTipoCambio, String pSesionId){
        Connection conn = null;
        PreparedStatement stmt;
        ResultSet rs;
        boolean succesful = true;
        boolean valido = true;
        
        try{  
            conn = SQLServerDAOFactory.createConnection();
            
            stmt = conn.prepareStatement("DECLARE @exitoso bit "
                                       + "EXEC spuRealizarOferta "+pUserId+","+pMonto+",'"
                                                               +pTipo+"',"+pTipoCambio+","+pSesionId+","
                                                               + "@exitoso = @exitoso OUTPUT"
                                       +" SELECT @exitoso");   	
            rs = stmt.executeQuery();
            while(rs.next()){
                valido = rs.getBoolean(1);
            }
            
            if(!valido)
                succesful = false;            
        } 
        catch(SQLException e){
            succesful = false;
            System.out.println("Message: " + e.getMessage() + "\n" + "Code: " + e.getErrorCode());
        }
        finally{
            if(conn != null){
                try{
                    conn.close();
                }
                catch(SQLException e){
                    System.out.println("Message: " + e.getMessage() + "\n" + "Code: " + e.getErrorCode());
                }
            }
        }
        
        return succesful;
    }
    
    @Override
    public ArrayList<Oferta> buscarOferta(String pTipoOferta, String pMontoMin, String pMontoMax, 
            String pTipoCambioMin, String pTipoCambioMax){
        
        ArrayList<Oferta> ofertas = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt;
        ResultSet rs;
        
        try{  
            conn = SQLServerDAOFactory.createConnection();
            
            stmt = conn.prepareStatement("EXEC spuBuscarOferta "+pTipoOferta+","+pMontoMin+","
                                                               +pMontoMax+","+pTipoCambioMin+","+pTipoCambioMax);   	
            rs = stmt.executeQuery();
            while(rs.next()){
                ofertas.add(new Oferta(rs.getInt(1),rs.getInt(2),rs.getInt(3)));
            }         
        } 
        catch(SQLException e){
            ofertas = null;
            System.out.println("Message: " + e.getMessage() + "\n" + "Code: " + e.getErrorCode());
        }
        finally{
            if(conn != null){
                try{
                    conn.close();
                }
                catch(SQLException e){
                    System.out.println("Message: " + e.getMessage() + "\n" + "Code: " + e.getErrorCode());
                }
            }
        }
        return ofertas;
    }
}
