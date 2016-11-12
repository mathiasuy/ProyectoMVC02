/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupouno.entidades;

import java.util.Date;

/**
 *
 * @author user6
 */
public class Producto {
    private int  productoID;
    private String nombre; //max 30
    private String descripcion;// max 50
    private double precio;
    private Date fecha_ingresado;
    private Proveedor proveedor;
    private String imagen;

    public Producto() {
        this.productoID = -1;
        this.nombre = "";
        this.descripcion = "N/D";
        this.precio = 0;
        this.fecha_ingresado = null;
        this.proveedor = new Proveedor();
        this.imagen = "img//default.jpg";
    }
    
    public Producto(int productoID, String nombre, String descripcion, double precio, Date fecha_ingresado, Proveedor proveedor, String imagen) {
        this.productoID = productoID;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fecha_ingresado = fecha_ingresado;
        this.proveedor = proveedor;
        this.imagen = imagen;
    }    
    
    public Producto(String nombre, String descripcion, 
            double precio, Date fecha_ingresado, Proveedor proveedor, String imagen) {
        this.productoID = -1;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fecha_ingresado = fecha_ingresado;
        this.proveedor = proveedor;
        this.imagen = imagen;
    }

    public int getProductoID() {
        return productoID;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public Date getFecha_ingresado() {
        return fecha_ingresado;
    }

    public Proveedor getProveedor() {
        return this.proveedor;
    }

    public String getImagen() {
        return imagen;
    }

    public void setProductoID(int productoID) {
        this.productoID = productoID;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setFecha_ingresado(Date fecha_ingresado) {
        this.fecha_ingresado = fecha_ingresado;
    }

    public void setProveedorD(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Producto{" + "productoID=" + productoID + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + ", fecha_ingresado=" + fecha_ingresado + ", proveedorID=" + proveedor + ", imagen=" + imagen + '}';
    }
    
    
}
