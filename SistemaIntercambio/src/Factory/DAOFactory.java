
package Factory;

//import DAO.*;

import DAO.UsuarioDAO;


public abstract class DAOFactory {

    // List of DAO types supported by the factory
    public static final int SQLSERVER = 1;
    //public static final int CLOUDSCAPE = 2;
    //public static final int ORACLE = 3;
    //public static final int SYBASE = 4;
    //public static final int MYSQL = 5;

    // There will be a method for each DAO that can be created. The concrete factories will have to implement these methods.
    /*public abstract EventoDAO getEventoDAO();
    public abstract IndividuoDAO getIndividuoDAO();
    public abstract AlojamientoDAO getAlojamientoDAO();
    public abstract EntrenadorDAO getEntrenadorDAO();
    public abstract PaisDAO getPaisDAO();
    public abstract CompetidorDAO getCompetidorDAO();
    public abstract EquipoDAO getEquipoDAO();
    public abstract IntegrantesEquipoDAO getIntegrantesEquipoDAO();
    public abstract ConsultasDAO getConsultasDAO();*/
    
    public abstract UsuarioDAO getUsuarioDAO();

    public static DAOFactory getDAOFactory(int whichFactory){

        switch(whichFactory){
          case SQLSERVER: 
              return new SQLServerDAOFactory();
          default: 
              return null;
        }
    }
}
