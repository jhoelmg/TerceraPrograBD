package DAO;

public interface CuentaDAO {
    public boolean depositar(String pUserId, String pAgentId, String pMonto, String pMoneda);
    public boolean retirar(String pUserId, String pAgentId, String pMonto, String pMoneda);
}
