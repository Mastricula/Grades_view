
package Controller;

import Vistas.*;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Responsive {
    
    
    
    private int[] ajustarVentana() {
        // Obtiene la resolución de la pantalla
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        // Calcula el tamaño deseado de la ventana como un porcentaje de la pantalla
        int windowWidth = (int) (screenWidth * 0.8); // 80% del ancho de la pantalla
        int windowHeight = (int) (screenHeight * 0.8); // 80% de la altura de la pantalla

        // Establece el tamaño de la ventana
        return new int[]{ windowWidth, windowHeight};

    }

    
    
}
