/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupouno.interfaces;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author user6
 * @param <Object>
 */
public interface IAcceso <Object>{
    
    public boolean alta(Object o);
    public boolean baja(int id);
    public  boolean modificar(Object o);
    public Object obtener(int id);
    public ArrayList<Object> listar();
    public ArrayList<Object> filtro(String campo, String filtro);
    
}
