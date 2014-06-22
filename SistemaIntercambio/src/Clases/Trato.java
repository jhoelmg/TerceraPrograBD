
package Clases;

public class Trato {
    
    int idTrato;
    double montoDolare;
    double montoColones;
    double tipoCambio;

    public Trato(int idTrato, double montoDolare, double montoColones, double tipoCambio) {
        this.idTrato = idTrato;
        this.montoDolare = montoDolare;
        this.montoColones = montoColones;
        this.tipoCambio = tipoCambio;
    }

    public int getIdTrato() {
        return idTrato;
    }

    public void setIdTrato(int idTrato) {
        this.idTrato = idTrato;
    }

    public double getMontoDolare() {
        return montoDolare;
    }

    public void setMontoDolare(double montoDolare) {
        this.montoDolare = montoDolare;
    }

    public double getMontoColones() {
        return montoColones;
    }

    public void setMontoColones(double montoColones) {
        this.montoColones = montoColones;
    }

    public double getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(double tipoCambio) {
        this.tipoCambio = tipoCambio;
    }
    
}
