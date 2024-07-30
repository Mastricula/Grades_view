package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

//Importando clases de otro paquete
import Vistas.Splash;

public class Conexion {

    //guardando los datos en variables
    String bd ="Sistema_Notas";
    String url = "jdbc:mysql://localhost:3306/";
    String user = "root";
    String passw = "root";
    String driver = "com.mysql.cj.jdbc.Driver";
    Splash spla = new Splash();
    public Connection cx;       
    
    
    public Connection Conectar() {
       try {
            Class.forName(driver);
            cx = DriverManager.getConnection(url + bd, user, passw);
            System.out.println("Se a Conecta a la BD");
            spla.lblTexto.setText("BASE DE DATOS CONECTADA...");
                    
       
       } catch (ClassNotFoundException |SQLException ex){
            //System.out.print("No se Conecta A BD" + bd);
            JOptionPane.showMessageDialog(null, "No se ha podido conectar con la base de datos", "Erro de conexion", JOptionPane.ERROR_MESSAGE);
            System.exit(0);   
       }
        return cx; // Devolvemos el valor   
       }
    
    public void desconectar() {
        try {
            cx.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}

