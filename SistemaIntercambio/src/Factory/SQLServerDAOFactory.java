
package Factory;

import DAO.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import DAO.*;

public class SQLServerDAOFactory extends DAOFactory {
    
    public static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // Ref http://technet.microsoft.com/en-us/library/ms378526.aspx
    public static final String DBURL = "jdbc:sqlserver://localhost;databaseName=SistemaNegociaciones;integratedSecurity=true"; // Ref http://technet.microsoft.com/en-us/library/ms378428.aspx

    // Method to create SQLServer connections
    public static Connection createConnection() {
        
        Connection conn = null;
        
        try{
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(DBURL);
            // If there is an error about PORT IP/TCP is not litening in port 1433 (SQL Server 2012), look this link http://msdn.microsoft.com/en-us/library/ms177440.aspx
        } 
        catch(ClassNotFoundException ex){
            System.out.println("Message: " + ex.getMessage());
        } 
        catch(SQLException ex) {
            System.out.println("Message: " + ex.getMessage() + "\n" + "Code: " + ex.getErrorCode());
        }
        
        return conn;
    }
    
    @Override
    public UsuarioDAO getUsuarioDAO()
    {
        // SQLServerPersonDAO implements UsuarioDAO
        return new SQLServerUsuarioDAO();
    }
    
    @Override
    public AgenteDAO getAgenteDAO()
    {
        // SQLServerPersonDAO implements UsuarioDAO
        return new SQLServerAgenteDAO();
    }
    
    @Override
    public ParticipanteDAO getParticipanteDAO()
    {
        // SQLServerPersonDAO implements UsuarioDAO
        return new SQLServerParticipanteDAO();
    }
    
    @Override
    public SesionDAO getSesionDAO()
    {
        // SQLServerPersonDAO implements UsuarioDAO
        return new SQLServerSesionDAO();
    }
    
    @Override
    public CuentaDAO getCuentaDAO()
    {
        // SQLServerPersonDAO implements UsuarioDAO
        return new SQLServerCuentaDAO();
    }
    
    @Override
    public OfertaDAO getOfertaDAO()
    {
        // SQLServerPersonDAO implements UsuarioDAO
        return new SQLServerOfertaDAO();
    }
    
    @Override
    public GeneralDAO getGeneralDAO()
    {
        // SQLServerPersonDAO implements UsuarioDAO
        return new SQLServerGeneralDAO();
    }
    
}


