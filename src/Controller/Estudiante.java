package Controller;

import Vistas.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Estudiante extends Usuario {

    public Estudiante(int id, String usu, String rol) {
        super(id, usu, rol);
    }

    public void infoEstu() {
        try {
            Statement statement;
            statement = conn.createStatement();
            String query = "SELECT * FROM estudiantes WHERE id_usu = " + usu + "";

            ResultSet resultset = statement.executeQuery(query);

            if (resultset.next()) {
                String nombre = resultset.getString("nombre");
                String apellido = resultset.getString("apellido");
                String mastricula = resultset.getString("mastricula");
                Date fecha_naci= new Date(resultset.getDate("fecha_nacimiento").getTime());
                
                System.out.println(nombre + " " + apellido + " " + mastricula + " " + fecha_naci);
            }
        } catch (SQLException e){
            
        }
        
    }
    
    public static void main(String[]args)
    {
        
    } 
}
