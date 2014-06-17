
package DAO;

import Factory.SQLServerDAOFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLServerAgenteDAO implements AgenteDAO{
    
    @Override
    public int insertAgent(String pUserId, String pNombre, String pApellP, String pApellM, String pPassword){
        Connection conn = null;
        PreparedStatement stmt;
        int rowCount = 0;
        
        try{  
            conn = SQLServerDAOFactory.createConnection();
            
            //Obtener competidorId de este Equipo
            stmt = conn.prepareStatement("EXEC spuInsertarAgente "+pUserId+","+pPassword+","
                                                               +pNombre+","+pApellM+","+pApellP);   
						
            stmt.execute();
                      
        } 
        catch(SQLException e){
            rowCount = -1;
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
        
        return rowCount;
    }
}
