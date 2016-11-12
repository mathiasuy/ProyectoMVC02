/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupouno.modelos;

import grupouno.conexion.Conectar;
import grupouno.entidades.Proveedor;
import grupouno.interfaces.IAcceso;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author user6
 */
public class DAOProveedor implements IAcceso<Proveedor>{

    private static final Conectar CONEXION = Conectar.estado();
    private PreparedStatement ps;
    private Proveedor p = null;
    private ResultSet rs;
    private ArrayList<Proveedor> l = null;
    private boolean retorno = false;
    
    @Override
    public boolean alta(Proveedor o) {
        try {
            ps = CONEXION.getConnection().prepareStatement(Consultas.insertar_proveedor());
            ps.setString(1, o.getNombre());
            ps.setString(2, o.getDescripcion());
            if (ps.executeUpdate() > 0){
                retorno = true;
                rs = ps.executeQuery("SELECT @@identity AS id");
                if (rs.next()){
                    o.setProveedoresID(rs.getInt("id"));
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
            ps = CONEXION.getConnection().prepareStatement(Consultas.borrar_proveedor());
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
    public boolean modificar(Proveedor o) {
        try {
            ps = CONEXION.getConnection().prepareStatement(Consultas.editar_proveedor());
            ps.setString(1, o.getNombre());
            ps.setString(2, o.getDescripcion());
            ps.setInt(3, o.getProveedoresID());
            retorno = ps.executeUpdate() > 0;
        } catch (Exception e) {
            throw new Error("ERROR " + e.getMessage() + " en " + this.getClass().getName());
        }finally{
           CONEXION.cerrarConexion();
        }
        return retorno;
    }

    @Override
    public Proveedor obtener(int id) {
        try {
            ps = CONEXION.getConnection().prepareStatement(Consultas.buscar_proveedor());
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()){
                p = new Proveedor(
                    rs.getInt("productoesID"),
                    rs.getString("nombre"),
                    rs.getString("descripcion")
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
    public ArrayList<Proveedor> listar() {
        try {
            ps = CONEXION.getConnection().prepareStatement(Consultas.listar_proveedores());
            rs = ps.executeQuery();
            l = new ArrayList<>();
            while (rs.next()){
                p = new Proveedor(
                    rs.getInt("productoesID"),
                    rs.getString("nombre"),
                    rs.getString("descripcion")
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
    public ArrayList<Proveedor> filtro(String campo, String filtro) {
        try {
            ps = CONEXION.getConnection().prepareStatement(Consultas.filtro_proveedores().replaceAll("campo", campo));
            ps.setString(1, campo);
            rs = ps.executeQuery();
            l = new ArrayList<>();
            while (rs.next()){
                p = new Proveedor(
                    rs.getInt("productoesID"),
                    rs.getString("nombre"),
                    rs.getString("descripcion")
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
