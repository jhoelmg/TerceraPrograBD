
package DAO;

public interface UsuarioDAO {

    public String checkUser(String pUserId, String pUserPassword);

    public void changePassword(String pUserId, String pNewPassword);
    
}