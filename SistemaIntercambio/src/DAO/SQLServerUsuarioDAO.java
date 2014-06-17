
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

