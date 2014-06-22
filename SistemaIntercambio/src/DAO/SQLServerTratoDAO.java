/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Clases.Oferta;
import Clases.Trato;
import Factory.SQLServerDAOFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author JuanCarlos
 */
public class SQLServerTratoDAO implements TratoDAO{

    @Override
    public ArrayList<Trato> verTransacciones(String idSesion) {
        ArrayList<Trato> tratos = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt;
        ResultSet rs;
        
        try{  
            conn = SQLServerDAOFactory.createConnection();
            
            stmt = conn.prepareStatement("EXEC spuVisualizarTratos "+idSesion);   	
            rs = stmt.executeQuery();
            while(rs.next()){
                tratos.add(new Trato(rs.getString(1),rs.getString(2),rs.getString(3),""));
            }         
        } 
        catch(SQLException e){
            tratos = null;
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
        return tratos;
    }
    
    @Override
    public ArrayList<Trato> verUltimosTratos(){
        ArrayList<Trato> ultimasTratos = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt;
        ResultSet rs;
        
        try{  
            conn = SQLServerDAOFactory.createConnection();
            
            stmt = conn.prepareStatement("EXEC spuVisualizarUltimosTratos");   	
            rs = stmt.executeQuery();
            while(rs.next()){
                ultimasTratos.add(new Trato(String.valueOf(rs.getInt(2)),String.valueOf(rs.getInt(3)),
                        String.valueOf(rs.getInt(4)),String.valueOf(rs.getInt(1))));
            }         
        } 
        catch(SQLException e){
            ultimasTratos = null;
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
        return ultimasTratos;
    }
}
