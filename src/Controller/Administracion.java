package Controller;

import java.time.LocalDate;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Administracion {

    private int counter = -1;
    public String mastricula;
    public String nombreUsu;

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

    public String GenerarMatricula(String tabla, String campo) {

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
        
        Conexion conectado = new Conexion();
        Connection con = conectado.Conectar();

        try {
            Statement statement;
            statement = con.createStatement();
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
    

}
