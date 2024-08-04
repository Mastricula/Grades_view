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
    
    public static void main(String[]args)
    {
        Usuario datos = new Usuario();
        System.out.println(datos.getusu());
    } 
}
