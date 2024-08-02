package Controller;

import Vistas.*;
import java.time.LocalDate;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Administracion {

    Connection conectado;
    
    private int counter = -1;
    public String mastricula;
    AgregarEstudiante agregar = new AgregarEstudiante();
    
   
    public void CrearUsuario(String matricula)
    {
        Conexion conexion= new Conexion();
        Connection conectado=conexion.Conectar();
        
        String usuario=matricula;
        String password=matricula;
        String rol="Estudiante";
        String Query="INSERT INTO Usuarios(usu,passw,rol) VALUES('"+usuario+"','"+password+"','"+rol+"')";
        String Query2="SELECT id_usu FROM Usuarios WHERE usu='"+matricula+"' ";
        
        try{
            Statement statement=conectado.createStatement();
            statement.executeUpdate(Query);
            
        }
        catch(SQLException ex)
        {
            
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
    private static int obtenerUltimoContador(String tabla, String campo) {

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
            e.printStackTrace();
        }

        return ultimoContador;
    }

    public String GenerarMatricula(String tabla, String campo) 

    {

        if (counter == -1) {
            counter = obtenerUltimoContador(tabla, campo) + 1;
        }

        LocalDate fecha = LocalDate.now();
        String year = Integer.toString(fecha.getYear());
        String formato = String.format("%04d", counter);

        mastricula = year + "-" + formato;

        counter++;
        return mastricula;
    }
    public static void main(String[]args)
    {
       Administracion admin= new Administracion();
       admin.CrearUsuario("2020-1756");
    } 
}
