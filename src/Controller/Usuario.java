package Controller;

import Vistas.Login;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Usuario {

    private int id;
    private String usu;
    private String passw;
    private String rol;
    private String nombre;
    private String apellido;
    private String matricula;
    private String nombreUsu;

    Conexion conexion = new Conexion();
    Connection conn = conexion.Conectar();

    public Usuario() {
    }

    public void Login(String usua, String pass) {
        Conexion conectado = new Conexion();
        Connection con = conectado.Conectar();

        try {
            Statement statement = con.createStatement();
            String query = "SELECT * FROM usuarios WHERE usu = '" + usua + "' and BINARY passw = '" + pass + "'";
            ResultSet resultset = statement.executeQuery(query);

            if (resultset.next()) {
                id = resultset.getInt("id_usu");
                usu = resultset.getString("usu");
                passw = resultset.getString("passw");
                rol = resultset.getString("rol");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String DatosUsuarios() {
        try {
            Statement statement = conn.createStatement();
            String query = "SELECT e.nombre, e.apellido, e.matricula, 'Estudiante' AS tipo FROM estudiantes e WHERE e.id_usu = " + id + " "
                    + "UNION SELECT p.nombre, p.apellido, p.matricula, 'Profesor' AS tipo FROM profesores p WHERE p.id_usu = " + id;

            ResultSet resultset = statement.executeQuery(query);

            if (resultset.next()) {
                nombre = resultset.getString("nombre");
                apellido = resultset.getString("apellido");
                matricula = resultset.getString("matricula");
                nombreUsu = nombre + " " + apellido;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nombreUsu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsu() {
        return usu;
    }

    public void setUsu(String usu) {
        this.usu = usu;
    }

    public String getPassw() {
        return this.passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    public String getMatricula() {
        if (matricula == null) {
            DatosUsuarios();
        }
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombreApe() {
        if (nombreUsu == null) {
            DatosUsuarios();
        }
        return nombreUsu;
    }

    public void setNombreApe(String nombreUsu) {
        this.nombreUsu = nombreUsu;
    }

    public String getNombre() {
        if (nombre == null) {
            DatosUsuarios();
        }
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        if (apellido == null) {
            DatosUsuarios();
        }
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public static void main(String[] args) {
        Usuario datos = new Usuario();
        datos.Login("P-0001", "P-0001");
        System.out.println(datos.getUsu());
        System.out.println(datos.getPassw());
        System.out.println(datos.getNombre());
        System.out.println(datos.getMatricula());
        //datos.DatosUsuarios();
        //System.out.println(datos.getId());
    }
}
