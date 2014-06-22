/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

/**
 *
 * @author JuanCarlos
 */
public class EstadisticaTrato {
    private String numTratos;
    private String montoColones;
    private String montoDolares;
    private String promTipoCambio;

    public EstadisticaTrato(String numTratos, String montoColones, String montoDolares, String promTipoCambio) {
        this.numTratos = numTratos;
        this.montoColones = montoColones;
        this.montoDolares = montoDolares;
        this.promTipoCambio = promTipoCambio;
    }

    public String getNumTratos() {
        return numTratos;
    }

    public void setNumTratos(String numTratos) {
        this.numTratos = numTratos;
    }

    public String getMontoColones() {
        return montoColones;
    }

    public void setMontoColones(String montoColones) {
        this.montoColones = montoColones;
    }

    public String getMontoDolares() {
        return montoDolares;
    }

    public void setMontoDolares(String montoDolares) {
        this.montoDolares = montoDolares;
    }

    public String getPromTipoCambio() {
        return promTipoCambio;
    }

    public void setPromTipoCambio(String promTipoCambio) {
        this.promTipoCambio = promTipoCambio;
    }
    
    
}
