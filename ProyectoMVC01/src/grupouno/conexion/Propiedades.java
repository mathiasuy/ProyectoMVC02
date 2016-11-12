/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupouno.conexion;

import java.io.FileInputStream;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author user6
 */
public class Propiedades {
    public static void Cargar() {
        try {
            FileInputStream archivo = new FileInputStream("src//grupouno//dataAcces//datos.txt");
            Properties p = new Properties(System.getProperties());
            p.load(archivo);
            System.setProperties(p);
            if (System.getProperty("mostrarpropierties").compareTo("si")==0){
                System.out.print("Propiedades cargadas con éxito!");
                System.getProperties().list(System.out);
            }
            
        } catch (java.io.FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "No se encuentra el archivo de configuracion" + e);
            System.exit(-1);
        } catch (java.io.IOException w) {
            JOptionPane.showMessageDialog(null, "Ocurrio algun error de I/O");
            System.exit(-1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo abrir la ventana ","Problema",JOptionPane.ERROR_MESSAGE);
        }     
    }
}
