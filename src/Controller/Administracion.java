package Controller;

import java.time.LocalDate;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Administracion {
    
    Conexion conexion = new Conexion();
    Connection conn = conexion.Conectar();
    
    private int counter = -1;
    public String mastricula;
    public String nombreUsu;

    
    public void CrearUsuario(String matricula)
    {
        String usuario = matricula;
        String password = matricula;
        String rol = "Estudiante";
        String Query = "INSERT INTO Usuarios(usu,passw,rol) VALUES('"+ usuario +"','"+ password +"','"+ rol +"')";
        String Query2 = "SELECT id_usu FROM Usuarios WHERE usu='"+ matricula +"' ";
        
        try{
            Statement statement=conn.createStatement();
            statement.executeUpdate(Query);
            
        }
        catch(SQLException ex)
        {
            System.out.println("Soy de la ventana Admin\n" + ex);
        }

    }
    
    private static int ObtenerUltimoContador(String tabla, String campo) {
        int ultimoContador = -1;
        String query = "SELECT matricula FROM " + tabla + " ORDER BY " + campo + " DESC LIMIT 1";

        Conexion conexion = new Conexion();
        Connection conn = conexion.Conectar();

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                String ultimaMatricula = rs.getString("matricula");
                String[] partes = ultimaMatricula.split("-");
                ultimoContador = Integer.parseInt(partes[1]);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return ultimoContador;
    }

    public String GenerarMatricula(String tabla, String campo) 

    {

        if (counter == -1) {
            counter = ObtenerUltimoContador(tabla, campo) + 1;
        }

        LocalDate fecha = LocalDate.now();
        String year = Integer.toString(fecha.getYear());
        String formato = String.format("%04d", counter);

        mastricula = year + "-" + formato;

        counter++;
        return mastricula;
    }


    public String DatosUsuarios(int usu) {
  
        try {
            Statement statement;
            statement = conn.createStatement();
            String query = "SELECT nombre, apellido FROM estudiantes WHERE id_usu = " + usu + "";

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
    
    public static void main(String[]args)
    {
       /*Administracion admin= new Administracion();
       admin.DatosUsuarios(10);
       admin.CrearUsuario("2020-1756");*/
    } 
}
