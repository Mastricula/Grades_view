
package Controller;

import java.io.File;
import necesario.RSFileChooser;


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