/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupouno.entidades;



/**
 *
 * @author user6
 */
public class Proveedor {
    private int proveedoresID;
    private String nombre;//max 30
    private String descripcion;// max 50

    public Proveedor() {
    }


    public Proveedor(String nombre) {
        this.proveedoresID = -1;
        this.nombre = nombre;
        this.descripcion = "N/D";
    }
    
    public Proveedor(String nombre, String descripcion) {
        this.proveedoresID = -1;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }    
    
    public Proveedor(int proveedoresID, String nombre, String descripcion) {
        this.proveedoresID = proveedoresID;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getProveedoresID() {
        return proveedoresID;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setProveedoresID(int proveedoresID) {
        this.proveedoresID = proveedoresID;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "proveedoresID=" + proveedoresID + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }
    

    
}
