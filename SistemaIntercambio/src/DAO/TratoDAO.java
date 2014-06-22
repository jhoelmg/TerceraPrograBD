/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Clases.Trato;
import java.util.ArrayList;

/**
 *
 * @author JuanCarlos
 */
public interface TratoDAO {
    public ArrayList<Trato> verTransacciones(String idSesion);
}
