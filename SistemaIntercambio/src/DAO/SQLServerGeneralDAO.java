/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Factory.SQLServerDAOFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author JuanCarlos
 */
public class SQLServerGeneralDAO implements GeneralDAO{

    @Override
    public String verTipoCambioPromedio() {
        Connection conn = null;
        PreparedStatement stmt;
        ResultSet rs;
        String tipoCambio = null;
        try{  
            conn = SQLServerDAOFactory.createConnection();
            
            stmt = conn.prepareStatement("EXEC spuGeneralEstadisticas ");   	
            rs = stmt.executeQuery();
            while(rs.next()){
                tipoCambio = rs.getString("PromTipoCambio");
            }
                      
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
        
        return tipoCambio;
    }

    @Override
    public String verMontoTransado() {
        Connection conn = null;
        PreparedStatement stmt;
        ResultSet rs;
        String montoTransado = null;
        try{  
            conn = SQLServerDAOFactory.createConnection();
            
            stmt = conn.prepareStatement("EXEC spuGeneralEstadisticas ");   	
            rs = stmt.executeQuery();
            while(rs.next()){
                montoTransado = rs.getString("MontoTransado");
            }
                      
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
        
        return montoTransado;
    }
    
    
}
