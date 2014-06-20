
package DAO;

import Clases.Participante;
import Factory.SQLServerDAOFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SQLServerCuentaDAO implements CuentaDAO{
    
    @Override 
    public boolean depositar(String pUserId, String pAgentId, String pMonto, String pMoneda){
        Connection conn = null;
        PreparedStatement stmt;
        boolean succesful = true;
        
        try{  
            conn = SQLServerDAOFactory.createConnection();
        
            //Obtener competidorId de este Equipo
            stmt = conn.prepareStatement("EXEC spuDepositarDinero @cedulaParticipante = "+pUserId+", @idAgente = "+pAgentId+","
										+" @monto = "+pMonto+", @moneda = '"+pMoneda+"'");
                                                                               
            stmt.execute();
                      
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
}
