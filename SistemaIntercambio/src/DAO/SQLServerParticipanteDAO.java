
package DAO;

import Clases.Participante;
import Factory.SQLServerDAOFactory;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SQLServerParticipanteDAO implements ParticipanteDAO{
    
    @Override 
    public ArrayList<Participante> listarParticipantes(){
        ArrayList<Participante> listaParticipantes = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt;
        ResultSet rs;
        
        try{  
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("EXEC spuListarParticipantes");
            rs = stmt.executeQuery();
                        
            while(rs.next()){
                listaParticipantes.add(new Participante(rs.getInt("cedula"), rs.getString("nombre"), 
                        rs.getString("apellidoP"), rs.getString("apellidoM")));
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
        return listaParticipantes;
    }

    @Override 
    public boolean suspenderParticipante(String pCedula){
        
        Connection conn = null;
        PreparedStatement stmt;
        boolean succesful = true;
        
        try{  
            conn = SQLServerDAOFactory.createConnection();
            stmt = conn.prepareStatement("EXEC spuSuspenderParticipante "+pCedula);
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
    
    @Override
    public boolean insertarParticipante(String pUserId, String pNombre, String pApellP, String pApellM, String pPassword,
            String pEmail, String pTelefono, String pDireccion, String pFechaNac){
        
        Connection conn = null;
        PreparedStatement stmt;
        boolean succesful = true;
        
        try{  
            conn = SQLServerDAOFactory.createConnection();
        
            //Obtener competidorId de este Equipo
            stmt = conn.prepareStatement("EXEC spuInsertarParticipante @cedulaParticipante = "+pUserId+", @password = '"+pPassword+"',"
										+" @nombre = '"+pNombre+"', @apellidoM = '"+pApellM+"',"
                                                                                +" @apellidoP = '"+pApellP+"',@telefono = '"+pTelefono+"',"
                                                                                +" @email = '"+pEmail+"',@direccion = '"+pDireccion+"',@fechaNacimiento = '"+pFechaNac+"'");   
						
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
