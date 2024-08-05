package Controller;

import Vistas.Login;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Usuario {

    private int id_usu;
    private String usu;
    private String passw;
    private String rol;
    private int id_perfil;
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
                id_usu = resultset.getInt("id_usu");
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
            String query = "SELECT e.id_estu AS ID, e.id_estu, e.nombre, e.apellido, e.matricula, 'Estudiante' AS tipo FROM estudiantes e WHERE e.id_usu = " + id_usu + " "
                    + "UNION SELECT p.id_profe AS ID, p.id_profe, p.nombre, p.apellido, p.matricula, 'Profesor' AS tipo FROM profesores p WHERE p.id_usu = " + id_usu;

            ResultSet resultset = statement.executeQuery(query);

            if (resultset.next()) {
                id_perfil = resultset.getInt("ID");
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

    public ResultSet obtenerNotas() {
        ResultSet resultset = null;
        try {
            Statement statement = conn.createStatement();
             String query = "SELECT CONCAT(e.nombre, ' ', e.apellido) AS Nombres, e.matricula, c.curso, m.materia AS materias, " +
                           "n.nota_p1 AS P1, n.nota_p2 AS P2, n.nota_p3 AS P3, n.nota_p4 AS P4, " +
                           "ROUND((n.nota_p1 + n.nota_p2 + n.nota_p3 + n.nota_p4) / 4.0) AS Total " +
                           "FROM notas n " +
                           "JOIN estudiantes e ON n.id_estu = e.id_estu " +
                           "JOIN cursos c ON e.id_curso = c.id_curso " +
                           "JOIN materias m ON n.id_materia = m.id_materia " +
                           "WHERE n.id_estu = " + getIdPerfil() + ";";

            resultset = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultset;
    }
    
    public int getIdUsu() {
        return id_usu;
    }

    public void setIdUsu(int id_usu) {
        this.id_usu = id_usu;
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
    
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getIdPerfil() {
        if (id_perfil == 0) {
            DatosUsuarios();
        }
        return id_perfil;
    }

    public void setIdPerfil(int id_perfil) {
        this.id_perfil = id_perfil;
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
