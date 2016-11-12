/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupouno.conexion;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author user6
 */
public class Conexion {
    public Connection conn=null;
    public DatabaseMetaData dbmt;
    public String datosConexion;
    
    protected String jdbc;
    protected String driver;
    protected String host;
    protected String database;
    protected String username;
    protected String password;
    protected String ssl;

    public Conexion() {
        Propiedades.Cargar();
        this.database = System.getProperty("database");
        this.driver = System.getProperty("driver");
        this.host = System.getProperty("host");
        this.jdbc = System.getProperty("jdbc");
        this.username = System.getProperty("username");
        this.password = System.getProperty("password");
        this.ssl = System.getProperty("ssl");
        
        try {
           // iniciardb();
        } catch (Exception e) {
            throw new Error("Ha ocurrido un error al conectar a la base de datos");
        }        
    }

    public void iniciardb() {
        try{
            this.datosConexion = jdbc + host + "/" + database;
            Class.forName(driver).newInstance();
            conn= DriverManager.getConnection(datosConexion, username, password);
        }
        catch(ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e){
           throw new Error("Ha ocurrido un error al conectar a la base de datos");
        }
    }
    
    
}
