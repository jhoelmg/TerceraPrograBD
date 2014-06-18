
package Clases;

import java.sql.Date;

public class Sesion {
    int idSesion;
    Date fecha;

    public Sesion(int idSesion, Date fecha) {
        this.idSesion = idSesion;
        this.fecha = fecha;
    }

    public int getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(int idSesion) {
        this.idSesion = idSesion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
