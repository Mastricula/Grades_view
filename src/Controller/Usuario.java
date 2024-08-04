package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Usuario {

    int id;
    String usu;
    String rol;

    public Usuario() {

    }
    
    public Usuario(int id, String usu, String rol) {
       this.id = id;
       this.usu = usu;
       this.rol = rol;
    }

    Conexion conexion = new Conexion();
    Connection conn = conexion.Conectar();
    public String nombreUsu;
    
    public void setusu(String usu){
        this.usu = usu;
    }
    
    public String getusu(){
        return usu;
    }
    
    public String DatosUsuarios(String tabla, int usu) {
  
        try {
            Statement statement;
            statement = conn.createStatement();
            String query = "SELECT nombre, apellido FROM "+tabla+" WHERE id_usu = " + usu + "";

            ResultSet resultset = statement.executeQuery(query);

            if (resultset.next()) {
                String nombre = resultset.getString("nombre");
                String apellido = resultset.getString("apellido");
                nombreUsu = nombre + " " + apellido;
                //System.out.println(nombreUsu);
                
            }
        } catch (SQLException e){
            
        }
        return nombreUsu;
    }
    
    
    public String DatosUsuarios( int usu) {
  
        try {
            Statement statement;
            statement = conn.createStatement();
            String query = "SELECT  e.nombre, e.apellido, e.matricula, 'Estudiante' AS tipo FROM estudiantes e WHERE e.id_usu = "+ usu +" "
                    + "UNION SELECT p.nombre, p.apellido, p.matricula, 'Profesor' AS tipo FROM profesores p WHERE p.id_usu = "+ usu +"";

            ResultSet resultset = statement.executeQuery(query);

            if (resultset.next()) {
                String nombre = resultset.getString("nombre");
                String apellido = resultset.getString("apellido");
                nombreUsu = nombre + " " + apellido;
                System.out.println(nombreUsu);
                
            }
        } catch (SQLException e){
            
        }
        return nombreUsu;
    }
    
    
    public static void main(String[]args)
    {
        Usuario datos = new Usuario();
        System.out.println(datos.getusu());
    } 
}
