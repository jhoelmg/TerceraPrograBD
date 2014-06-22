
package Clases;

public class Oferta {
    String tipoCambio;
    String monto;
    int  idOferta;
    String tipoOferta;

    public Oferta(int idOferta, String monto, String tipoCambio, boolean pTipoOferta) {
        this.tipoCambio = tipoCambio;
        this.monto = monto;
        this.idOferta = idOferta;
        
        if(pTipoOferta)
            tipoOferta = "Compra";
        else
            tipoOferta = "Venta";
    }

    public String getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(String tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public int getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(int idOferta) {
        this.idOferta = idOferta;
    }

    public String getTipoOferta() {
        return tipoOferta;
    }

    public void setTipoOferta(String tipoOferta) {
        this.tipoOferta = tipoOferta;
    }
}
