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
public class Trato {
    private String montoDolares;
    private String montoColones;
    private String tipoCambio;
    private String tratoId;

    public Trato(String montoDolares, String montoColones, String tipoCambio, String tratoId) {
        this.montoDolares = montoDolares;
        this.montoColones = montoColones;
        this.tipoCambio = tipoCambio;
        this.tratoId = tratoId;
    }

    public String getMontoDolares() {
        return montoDolares;
    }

    public void setMontoDolares(String montoDolares) {
        this.montoDolares = montoDolares;
    }

    public String getMontoColones() {
        return montoColones;
    }

    public void setMontoColones(String montoColones) {
        this.montoColones = montoColones;
    }

    public String getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(String tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    public String getTratoId() {
        return tratoId;
    }

    public void setTratoId(String tratoId) {
        this.tratoId = tratoId;
    }
  
}
