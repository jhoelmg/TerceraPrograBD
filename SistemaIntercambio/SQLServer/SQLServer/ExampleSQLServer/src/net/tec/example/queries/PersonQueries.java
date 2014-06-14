/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tec.example.queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import net.tec.example.connector.SQLServerConnector;

/**
 *
 * @author AAC
 */
public class PersonQueries {
    
    public PersonQueries(){ }

    // Implement insert person here.
    // Return newly created person number (row count) or a -1 on error
    public int insertPerson(Person p) {
        
        Connection conn = null;
        PreparedStatement stmt;
        int rowCount = 0;
        
        try{  
            conn = SQLServerConnector.createConnection();
            stmt = conn.prepareStatement("INSERT INTO Person VALUES(?, ?, ?, ?, ?)");
            stmt.setInt(1, p.getPersonID());
            stmt.setString(2, p.getName());
            stmt.setString(3, p.getLastname());
            stmt.setString(4, p.getCountry());
            stmt.setString(5, p.getAddress());
            
            rowCount = stmt.executeUpdate();
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
    
    // Implement search persons here using the supplied criteria.
    // Alternatively, implement to return a Collection of Transfer Objects.
    public Collection selectPerson() {
        
        Connection conn = null;
        PreparedStatement stmt;
        ResultSet rs;
        Collection personList = null;
        Person p;
        
        try{  
            conn = SQLServerConnector.createConnection();
            stmt = conn.prepareStatement("SELECT * FROM Person");
            rs = stmt.executeQuery();
            
            personList = new ArrayList();
            
            while(rs.next()){
                p = new Person(rs.getInt("personID"), rs.getString("name"), rs.getString("lastName"), rs.getString("country"), rs.getString("address"));
                personList.add(p);
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
        
        return personList;
    }
    
    // Change name and last name upper case.
    // Return 0 for success or a -1 on error.
    public int toUpperCaseNameAndLastName() {
        
        Connection conn = null;
        PreparedStatement stmt;
        int error = 0;
        
        try{  
            conn = SQLServerConnector.createConnection();
            stmt = conn.prepareStatement("EXEC toUpperCaseNameAndLastName");
            stmt.execute();
        } 
        catch(SQLException e){
            error = -1;
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
        
        return error;
    }
}