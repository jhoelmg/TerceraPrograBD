
package Clases;

public class Usuario {
 
    String usuarioId;
    String colones;
    String congeladoColones;
    String dolares;
    String congeladoDolares;

    public Usuario(String usuarioId, String colones, String congeladoColones, String dolares, String congeladoDolares) {
        this.usuarioId = usuarioId;
        this.colones = colones;
        this.congeladoColones = congeladoColones;
        this.dolares = dolares;
        this.congeladoDolares = congeladoDolares;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getColones() {
        return colones;
    }

    public void setColones(String colones) {
        this.colones = colones;
    }

    public String getCongeladoColones() {
        return congeladoColones;
    }

    public void setCongeladoColones(String congeladoColones) {
        this.congeladoColones = congeladoColones;
    }

    public String getDolares() {
        return dolares;
    }

    public void setDolares(String dolares) {
        this.dolares = dolares;
    }

    public String getCongeladoDolares() {
        return congeladoDolares;
    }

    public void setCongeladoDolares(String congeladoDolares) {
        this.congeladoDolares = congeladoDolares;
    }
}
