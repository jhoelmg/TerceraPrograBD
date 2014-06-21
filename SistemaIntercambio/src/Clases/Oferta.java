
package Clases;

public class Oferta {
    double tipoCambio;
    double monto;
    int  idOferta;
    String tipoOferta;

    public Oferta(int idOferta, double monto, double tipoCambio, boolean pTipoOferta) {
        this.tipoCambio = tipoCambio;
        this.monto = monto;
        this.idOferta = idOferta;
        
        if(pTipoOferta)
            tipoOferta = "Compra";
        else
            tipoOferta = "Venta";
    }

    public double getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(double tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
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
