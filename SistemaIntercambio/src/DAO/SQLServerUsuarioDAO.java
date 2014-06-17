
package DAO;

import Factory.SQLServerDAOFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLServerUsuarioDAO implements UsuarioDAO {
    
    public SQLServerUsuarioDAO(){ }
      
    @Override
    public String checkUser(String pUserId, String pUserPassword){
        
        Connection conn = null;
        PreparedStatement stmt;
        ResultSet rs;
        String userType = "";
        
        try{  
            conn = SQLServerDAOFactory.createConnection();
            
            //Obtener competidorId de este Equipo
            stmt = conn.prepareStatement("DECLARE @userType varchar(50) "
                                        + "EXEC spuCheckLogin "+pUserId+", '"+pUserPassword+"', @userType OUTPUT "
                                        + "SELECT @userType ");                  
            rs = stmt.executeQuery();
            
            while(rs.next()){
                userType = rs.getString(1);
            }            
        } 
        catch(SQLException e){
            userType = "";
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
        
        return userType;
    }
    
    @Override
    public void changePassword(String pUserId, String pNewPassword){
        
        Connection conn = null;
        PreparedStatement stmt;
        try{  
            conn = SQLServerDAOFactory.createConnection();
            
            //Obtener competidorId de este Equipo
            stmt = conn.prepareStatement("EXEC spuChangePassword @userId = "+pUserId+", "
                                                              + "@newPassword = '"+pNewPassword+"' ");   
						
            stmt.execute();
                       
        } 
        catch(SQLException e){
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
    }

}

