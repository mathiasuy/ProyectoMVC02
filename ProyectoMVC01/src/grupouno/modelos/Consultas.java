/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupouno.modelos;

/**
 *
 * @author user6
 */
public class Consultas {
    
    /**
     * "INSERT INTO Proveedores(nombre,descripcion) values (?,?)"
     * @return 
     */
    public static String insertar_proveedor(){ 
            return "INSERT INTO Proveedores(nombre,descripcion) values (?,?)";
    }
    
    /**
     * "INSERT INTO Productos(nombre,descripcion,precio,fecha_ingresado,proveedor,imagen) values (?,?,?,?,?,?)"
     * @return 
     */
    public static String insertar_producto(){
            return "INSERT INTO Productos(nombre,descripcion,precio,fecha_ingresado,proveedor,imagen) values (?,?,?,?,?,?)";
    }

    /**
     * "UPADTE Proveedores SET nombre=?, descripcion=? WHERE proveedoresID=?"
     * @return 
     */
    public static String editar_proveedor(){ 
            return "UPADTE Proveedores SET nombre=?, descripcion=? WHERE proveedoresID=?";
    }
    
    /**
     * "UPADTE Proveedores SET nombre=?, descripcion=?, precio=?, fecha_ingresado=?, proveedor=?, imagen=?,  WHERE productosID=?"
     * @return 
     */
    public static String editar_producto(){
            return "UPADTE Proveedores SET nombre=?, descripcion=?, precio=?, fecha_ingresado=?, proveedor=?, imagen=?,  WHERE productosID=?";
    }

    /**
     * "DELETE FROM Proveedores WHERE proveedoresID=?"
     * @return 
     */
    public static String borrar_proveedor(){
            return "DELETE FROM Proveedores WHERE proveedoresID=?";
    }
    
    /**
     * "DELTE FROM Productos WHERE productosID=?"
     * @return 
     */
    public static String borrar_producto(){ 
            return "DELTE FROM Productos WHERE productosID=?";
    }

    /**
     * "SELECT * FROM Proveedores WHERE proveedoresid=?"
     * @return 
     */
    public static String buscar_proveedor (){
            return "SELECT * FROM Proveedores WHERE proveedoresid=?";
    }
    
    /**
     * "SELCET  * FROM Productos WHERE productosid=?"
     * @return 
     */
    public static String buscar_producto (){
            return "SELCET  * FROM Productos WHERE productosid=?";
    }

    /**
     * "SELECT * FROM Proveedores order by nombre"
     * @return 
     */
    public static String listar_proveedores (){
            return "SELECT * FROM Proveedores order by nombre";
    }
    
    /**
     * "SELECT * FROM Productos order by nombre"
     * @return 
     */
    public static String listar_productos (){
            return "SELECT * FROM Productos order by nombre";
    }
    
    /**
     * "SELECT * FROM Proveedores WHERE campo LIKE ? by nombre"
     * @return 
     */
    public static String filtro_proveedores (){
            return "SELECT * FROM Proveedores WHERE campo LIKE ? by nombre";
    }
    
    /**
     * "SELECT * FROM Productos WHERE columna LIKE ? by nombre"
     * @return 
     */
    public static String filtro_producto (){
            return "SELECT * FROM Productos WHERE columna LIKE ? by nombre";
    }
    
}
