
package DAO;

import Clases.Sesion;
import Factory.SQLServerDAOFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
            
            rs.close();
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

    @Override
    public ArrayList<Sesion> listarSesiones (){
        ArrayList<Sesion> listaSesiones = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt;
        ResultSet rs;
        
        try{  
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("EXEC spuListarSesiones");
            rs = stmt.executeQuery();
                        
            while(rs.next()){
                listaSesiones.add(new Sesion(rs.getInt("idSesion"),rs.getDate("fecha")));
            }
            
            rs.close();
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
        return listaSesiones;
    }

    @Override
    public boolean finalizarSesion(String sesionID){
        
        Connection conn = null;
        PreparedStatement stmt;
        boolean succesful = true;
        
        try{  
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("EXEC spuTerminarSesion "+sesionID);
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
