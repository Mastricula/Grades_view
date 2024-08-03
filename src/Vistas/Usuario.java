/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vistas;

import Controller.Administracion;

/**
 *
 * @author paulo
 */
public abstract class Usuario 
{
    protected String usuario;
    protected String password;
    protected String rol;
    
    public Usuario()
    {
    
    }
    
    public String getUsuario()
    {
        return usuario;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    
    
    
}
