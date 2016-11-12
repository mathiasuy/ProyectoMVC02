/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupouno.modelos;

import grupouno.conexion.Conectar;
import grupouno.entidades.Producto;
import grupouno.entidades.Producto;
import grupouno.interfaces.IAcceso;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author user6
 */
public class DAOProducto implements IAcceso<Producto>{

    private static final Conectar CONEXION = Conectar.estado();
    private PreparedStatement ps;
    private Producto p = null;
    private ResultSet rs;
    private ArrayList<Producto> l = null;
    private boolean retorno = false;
    
    private java.util.Date toDateUtil(java.sql.Date f){
        java.util.Date d = new java.util.Date(f.getTime());
        return d;
    }    
    
    private java.sql.Date toDateSQL(java.util.Date f){
        java.sql.Date d = new java.sql.Date(f.getTime());
        return d;
    }    
    
    @Override
    public boolean alta(Producto o) {
        try {
            ps = CONEXION.getConnection().prepareStatement(Consultas.insertar_producto());
            ps.setString(1, o.getNombre());
            ps.setString(2, o.getDescripcion());
            ps.setDouble(3, o.getPrecio());
            ps.setDate(4, toDateSQL(o.getFecha_ingresado()));
            ps.setInt(5, o.getProveedor().getProveedoresID());
            ps.setString(6, o.getImagen());
            if (ps.executeUpdate() > 0){
                retorno = true;
                rs = ps.executeQuery("SELECT @@identity AS id");
                if (rs.next()){
                    o.setProductoID(rs.getInt("id"));
                }
            };
        } catch (Exception e) {
            throw new Error("ERROR " + e.getMessage() + " en " + this.getClass().getName());
        }finally{
           CONEXION.cerrarConexion();
        }
        return retorno;
    }

    @Override
    public boolean baja(int id) {
        try {
            ps = CONEXION.getConnection().prepareStatement(Consultas.borrar_producto());
            ps.setInt(1, id);
            retorno = ps.executeUpdate() > 0;
        } catch (Exception e) {
            throw new Error("ERROR " + e.getMessage() + " en " + this.getClass().getName());
        }finally{
           CONEXION.cerrarConexion();
        }
        return retorno;
    }

    @Override
    public boolean modificar(Producto o) {
        try {
            ps = CONEXION.getConnection().prepareStatement(Consultas.editar_producto());
            ps.setString(1, o.getNombre());
            ps.setString(2, o.getDescripcion());
            ps.setDouble(3, o.getPrecio());
            ps.setDate(4, toDateSQL(o.getFecha_ingresado()));
            ps.setInt(5, o.getProveedor().getProveedoresID());
            ps.setString(6, o.getImagen());
            ps.setInt(7, o.getProductoID());
            retorno = ps.executeUpdate() > 0;
        } catch (Exception e) {
            throw new Error("ERROR " + e.getMessage() + " en " + this.getClass().getName());
        }finally{
           CONEXION.cerrarConexion();
        }
        return retorno;
    }

   
    @Override
    public Producto obtener(int id) {
        try {
            ps = CONEXION.getConnection().prepareStatement(Consultas.buscar_producto());
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()){
                DAOProveedor pro = new DAOProveedor();
                p = new Producto(
                        rs.getInt("productoesID"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getDouble("precio"),
                        toDateUtil(rs.getDate("fecha_ingresado")),
                        pro.obtener(rs.getInt("proveedor")),
                        rs.getString("imagen")
                );
            }
        } catch (Exception e) {
            throw new Error("ERROR " + e.getMessage() + " en " + this.getClass().getName());
        }finally{
           CONEXION.cerrarConexion();
        }
        return p;
    }

    @Override
    public ArrayList<Producto> listar() {
        try {
            ps = CONEXION.getConnection().prepareStatement(Consultas.listar_productos());
            rs = ps.executeQuery();
            l = new ArrayList<>();
            while (rs.next()){
                DAOProveedor pro = new DAOProveedor();
                p = new Producto(
                        rs.getInt("productoesID"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getDouble("precio"),
                        toDateUtil(rs.getDate("fecha_ingresado")),
                        pro.obtener(rs.getInt("proveedor")),
                        rs.getString("imagen")
                );
                l.add(p);
            }
        } catch (Exception e) {
            throw new Error("ERROR " + e.getMessage() + " en " + this.getClass().getName());
        }finally{
           CONEXION.cerrarConexion();
        }
        return l;
    }

    @Override
    public ArrayList<Producto> filtro(String campo, String filtro) {
        try {
            ps = CONEXION.getConnection().prepareStatement(Consultas.filtro_producto().replaceAll("campo", campo));
            ps.setString(1, campo);
            rs = ps.executeQuery();
            l = new ArrayList<>();
            while (rs.next()){
                DAOProveedor pro = new DAOProveedor();
                p = new Producto(
                        rs.getInt("productoesID"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getDouble("precio"),
                        toDateUtil(rs.getDate("fecha_ingresado")),
                        pro.obtener(rs.getInt("proveedor")),
                        rs.getString("imagen")
                );
                l.add(p);
            }
        } catch (Exception e) {
            throw new Error("ERROR " + e.getMessage() + " en " + this.getClass().getName());
        }finally{
           CONEXION.cerrarConexion();
        }
        return l;
    }
}
