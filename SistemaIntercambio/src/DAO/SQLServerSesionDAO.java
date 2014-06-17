
package DAO;

import Factory.SQLServerDAOFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLServerSesionDAO implements SesionDAO{
    
    @Override
    public int createSesion(String pAdminID){
        
        Connection conn = null;
        PreparedStatement stmt;
        ResultSet rs;
        int sesionID = -1;
        
        try{  
            conn = SQLServerDAOFactory.createConnection();
            
            //Obtener competidorId de este Equipo
            stmt = conn.prepareStatement("DECLARE @sesionID int "
                                        + "EXEC spuIniciarSesionNegociaciones @administrador = "+pAdminID+", "
                                        + "@numPK = @sesionID OUTPUT "
                                        + "SELECT @sesionID ");                  
            rs = stmt.executeQuery();
            
            while(rs.next()){
                sesionID = rs.getInt(1);
            }            
        } 
        catch(SQLException e){
            sesionID = -1;
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
        
        return sesionID;
    }
}
