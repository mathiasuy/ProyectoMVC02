/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupouno.conexion;

/**
 *
 * @author user6
 */
public class Conexion_mySQL extends Conexion{

    public Conexion_mySQL() {
        iniciardb();
    }

    @Override
    public void iniciardb() {
        super.datosConexion = jdbc + host + "/" + database + "?";
        super.iniciardb(); //To change body of generated methods, choose Tools | Templates.
    }

    
}
