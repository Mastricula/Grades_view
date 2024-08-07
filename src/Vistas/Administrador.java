
package Vistas;

import Controller.*;
import Controller.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class Administrador extends Usuario {

    private int counter = -1;
    public String mastricula;

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

    private String GenerarMatricula(String tabla, String campo) {
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

    private String GenerarMatriculaP(String tabla, String campo) {
        if (counter == -1) {
            counter = obtenerUltimoContador(tabla, campo) + 1;
        }

        String identy = "P";
        String formato = String.format("%04d", counter);

        mastricula = identy + "-" + formato;

        counter++;
        return mastricula;
    }

    private void CrearUsuario(String matricula, String Rol) {
        Conexion conexion = new Conexion();
        Connection conectado = conexion.Conectar();

        String usuario = matricula;
        String password = matricula;
        String rol = Rol;
        String Query = "INSERT INTO Usuarios(usu,passw,rol) VALUES('" + usuario + "','" + password + "','" + rol + "')";
        String Query2 = "SELECT id_usu FROM Usuarios WHERE usu='" + matricula + "' ";

        try {
            Statement statement = conectado.createStatement();
            statement.executeUpdate(Query);

        } catch (SQLException ex) {

            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Agregar(String nombre, String apellido, String fechaNacimiento, int idCurso)
    {
      int id_usu=0;
      String rol = "Estudiante";
              
      Conexion conexion= new Conexion();
      Connection conectado=conexion.Conectar();
      
  
      try 
      {
               
        String matricula=GenerarMatricula("Estudiantes", "id_estu"); 
        CrearUsuario(matricula, rol);
        
        Statement statement = conectado.createStatement();
        
        ResultSet resultado=statement.executeQuery("SELECT id_usu FROM Usuarios WHERE usu='"+matricula+"' ");
        
        if(resultado.next())
        {
          id_usu=resultado.getInt("id_usu");
        }
        System.out.println(id_usu);
        statement.executeUpdate("INSERT INTO Estudiantes(matricula,nombre,apellido,fecha_nacimiento,id_curso,id_usu) VALUES('" + matricula + "','" + nombre + "','" + apellido + "','" + fechaNacimiento + "', "+ idCurso+", '"+id_usu+"' )");
        JOptionPane.showMessageDialog(null, "Estudiante añadido correctamente.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
      }
      catch(SQLException ex)
      {
        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);  
      }                      
    }
    
    public void Agregar(String nombre, String apellido, String cedula, String fechaNacimiento)
    {
      int id_usu=0;
      String rol = "Profe";
      
      Conexion conexion= new Conexion();
      Connection conectado=conexion.Conectar();
      
  
      try 
      {
               
        String matricula=GenerarMatriculaP("Profesores", "id_profe"); 
        CrearUsuario(matricula, rol);
        
        Statement statement = conectado.createStatement();
        
        ResultSet resultado=statement.executeQuery("SELECT id_usu FROM Usuarios WHERE usu='"+matricula+"' ");
        
        if(resultado.next())
        {
          id_usu=resultado.getInt("id_usu");
        }
        System.out.println(id_usu);
        statement.executeUpdate("INSERT INTO Profesores(matricula,nombre,apellido,cedula,fecha_nacimiento,id_usu) VALUES('" + matricula + "', '" + nombre + "', '" + apellido + "', '" + cedula + "', '" + fechaNacimiento + "', '"+id_usu+"' )");
        JOptionPane.showMessageDialog(null, "Docente añadido correctamente.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
      }
      catch(SQLException ex)
      {
        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);  
      }                      
    }
    
    public void Agregar(String nombre) {

        Conexion conexion = new Conexion();
        Connection conectado = conexion.Conectar();

        try {
                
            Statement statement = conectado.createStatement();         

            statement.executeUpdate("INSERT INTO Materias(materia) VALUES('" + nombre + "')");
            JOptionPane.showMessageDialog(null, "Materia añadida correctamente.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Editar(String matricula, String nombre, String apellido, String fechaNacimiento, int idCurso)
    {
        Conexion conexion= new Conexion();
        Connection conectado=conexion.Conectar();
        
        try
      {
          Statement statement= conectado.createStatement();
          statement.executeUpdate("UPDATE Estudiantes SET nombre='"+nombre+"', apellido='"+apellido+"', fecha_nacimiento='"+fechaNacimiento+"',id_curso="+idCurso+" WHERE matricula='"+matricula+"'");
               
      }
      
      
      catch(SQLException ex)
      {
        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);  
      }
    }
    
    public void Editar(String matricula, String nombre, String apellido, String fechaNacimiento, String tabla){
        Conexion conexion= new Conexion();
        Connection conectado=conexion.Conectar();
        
        try
      {
          Statement statement= conectado.createStatement();
          statement.executeUpdate("UPDATE " + tabla + " SET nombre='"+nombre+"', apellido='"+apellido+"', fecha_nacimiento='"+fechaNacimiento+"' WHERE matricula='"+matricula+"'");
               
      }
      
      
      catch(SQLException ex)
      {
        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);  
      }
    }
    
    public void Eliminar(String matricula, String tabla)
    {
        int id_profe = 0;
        
        Conexion conexion= new Conexion();
        Connection conectado= conexion.Conectar();
        try
        {
            Statement statement= conectado.createStatement();
            ResultSet resultado= statement.executeQuery("SELECT*FROM " + tabla + " WHERE matricula='"+matricula+"'");
            
            while(resultado.next())
            {
                id_profe = resultado.getInt("id_profe");  
            }
            
            statement.executeUpdate("DELETE FROM " + tabla + " WHERE id_profe="+id_profe);
     
        }
        catch(SQLException ex)
        {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Eliminar(String matricula) {
        int id_estu = 0;

        Conexion conexion = new Conexion();
        Connection conectado = conexion.Conectar();
        try {
            Statement statement = conectado.createStatement();
            ResultSet resultado = statement.executeQuery("SELECT*FROM Estudiantes WHERE matricula='" + matricula + "'");

            while (resultado.next()) {
                id_estu = resultado.getInt("id_estu");
            }

            statement.executeUpdate("DELETE FROM Estudiantes WHERE id_estu=" + id_estu);

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void EliminarMateria(String materia) {
        int id_materia = 0;

        Conexion conexion = new Conexion();
        Connection conectado = conexion.Conectar();
        try {
            Statement statement = conectado.createStatement();
            ResultSet resultado = statement.executeQuery("SELECT*FROM Materias WHERE materia='" + materia + "'");

            while (resultado.next()) {
                id_materia = resultado.getInt("id_materia");
            }

            statement.executeUpdate("DELETE FROM Materias WHERE id_materia=" + id_materia);

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarTablasProfe(String matricula){
        int id_profe = 0;
        
        Conexion conexion= new Conexion();
        Connection conectado= conexion.Conectar();
        try
        {
            Statement statement= conectado.createStatement();
            ResultSet resultado= statement.executeQuery("SELECT*FROM Profesores WHERE matricula='"+matricula+"'");
            
            while(resultado.next())
            {
                id_profe = resultado.getInt("id_profe");  
            }
            
            statement.executeUpdate("DELETE FROM profe_cursos WHERE id_profe="+id_profe);
            statement.executeUpdate("DELETE FROM profe_mate WHERE id_profe="+id_profe);
     
        }
        catch(SQLException ex)
        {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarTablasEstu(String matricula){
        int id_estu = 0;
        
        Conexion conexion= new Conexion();
        Connection conectado= conexion.Conectar();
        try
        {
            Statement statement= conectado.createStatement();
            ResultSet resultado= statement.executeQuery("SELECT*FROM Estudiantes WHERE matricula='"+matricula+"'");
            
            while(resultado.next())
            {
                id_estu = resultado.getInt("id_estu");  
            }
            
            statement.executeUpdate("DELETE FROM notas WHERE id_estu="+id_estu);
     
        }
        catch(SQLException ex)
        {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarTablasMateria(String materia){
        int id_materia = 0;
        
        Conexion conexion= new Conexion();
        Connection conectado= conexion.Conectar();
        try
        {
            Statement statement= conectado.createStatement();
            ResultSet resultado= statement.executeQuery("SELECT*FROM Materias WHERE materia='"+materia+"'");
            
            while(resultado.next())
            {
                id_materia = resultado.getInt("id_materia");  
            }
            
            statement.executeUpdate("DELETE FROM curso_mate WHERE id_materia="+id_materia);
            statement.executeUpdate("DELETE FROM profe_mate WHERE id_materia="+id_materia);
            statement.executeUpdate("DELETE FROM notas WHERE id_materia="+id_materia);
     
        }
        catch(SQLException ex)
        {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}
