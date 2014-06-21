
package Factory;

import DAO.*;


public abstract class DAOFactory {

    // List of DAO types supported by the factory
    public static final int SQLSERVER = 1;
    //public static final int CLOUDSCAPE = 2;
    //public static final int ORACLE = 3;
    //public static final int SYBASE = 4;
    //public static final int MYSQL = 5;

    // There will be a method for each DAO that can be created. The concrete factories will have to implement these methods.  
    public abstract UsuarioDAO getUsuarioDAO();
    public abstract AgenteDAO getAgenteDAO();
    public abstract ParticipanteDAO getParticipanteDAO();
    public abstract SesionDAO getSesionDAO();
    public abstract CuentaDAO getCuentaDAO();
    public abstract OfertaDAO getOfertaDAO();
    
    public static DAOFactory getDAOFactory(int whichFactory){

        switch(whichFactory){
          case SQLSERVER: 
              return new SQLServerDAOFactory();
          default: 
              return null;
        }
    }
}
