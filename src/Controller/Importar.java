/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.io.File;
import necesario.RSFileChooser;

/**
 *
 * @author palc0
 */
public class Importar {
    
    private String ruta;
    
    public void documento(){
        RSFileChooser fileChooser = new necesario.RSFileChooser();
        int eleccion = fileChooser.showOpenDialog(null);
        if (eleccion == RSFileChooser.APPROVE_OPTION){
            File file = fileChooser.getSelectedFile();
            ruta = file.getAbsolutePath();
        }
    }
}