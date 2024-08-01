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

    private int counter = -1;
    public String mastricula;
    AgregarEstudiante agregar = new AgregarEstudiante();

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

    public String GenerarMatricula() {

        if (counter == -1) {
            counter = obtenerUltimoContador("estudiantes", "id_estu") + 1;
        }

        LocalDate fecha = LocalDate.now();
        String year = Integer.toString(fecha.getYear());
        String formato = String.format("%04d", counter);

        mastricula = year + "-" + formato;

        counter++;
        return mastricula;
    }
}

        
