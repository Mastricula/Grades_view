package Vistas;

import javax.swing.JOptionPane;

import Controller.Conexion;
import java.awt.Color;
import javax.swing.ImageIcon;

public final class Splash extends javax.swing.JFrame {

   public Splash() {
        initComponents();
        setLocationRelativeTo(null); //La ventana saldra en el centro
        setBackground(new Color(0, 0, 0, 0));
        setIconImage(new ImageIcon(getClass().getResource("/IMG/IconoProye.png")).getImage());
        

    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBase = new javax.swing.JPanel();
        lblTexto = new javax.swing.JLabel();
        lblIcon = new javax.swing.JLabel();
        lblIMG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        pnlBase.setBackground(new java.awt.Color(238, 238, 238));
        pnlBase.setForeground(new java.awt.Color(57, 61, 70));
        pnlBase.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTexto.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        lblTexto.setForeground(new java.awt.Color(0, 0, 0));
        lblTexto.setText("INICIANDO..");
        pnlBase.add(lblTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 309, 250, -1));

        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/LogoSplash2.png"))); // NOI18N
        lblIcon.setText("s");
        pnlBase.add(lblIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 190, -1));

        lblIMG.setForeground(new java.awt.Color(238, 238, 238));
        lblIMG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/ImgSplash.png"))); // NOI18N
        pnlBase.add(lblIMG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 350));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        
        Splash spla = new Splash();
        spla.setVisible(true);
        
        Conexion conexion = new Conexion(); //Instanciamos la clase
        
        try { //Intentara lo siguiente
            Thread.sleep(1000); //Tendra un tiempo de espera de 1s
            spla.lblTexto.setText("CONECTANDO CON LA BASE DE DATOS..."); //Agregara ese mensaje al label
            Thread.sleep(1000);
            conexion.Conectar(); //Llamamos un metodo de la clase conexion
            Thread.sleep(1000);
            spla.lblTexto.setText("CARGANDO DATOS...");
            Thread.sleep(1000);
            spla.lblIMG.setIcon(new ImageIcon("src/IMG/ImgSplash2.png"));
            Thread.sleep(1000);
            spla.lblTexto.setText("ABRIENDO...");
            Thread.sleep(1000);
            spla.dispose(); //Solo cerra esta venatan
            Login login = new Login();
            
            login.setVisible(true);
            
        } catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblIMG;
    private javax.swing.JLabel lblIcon;
    public javax.swing.JLabel lblTexto;
    private javax.swing.JPanel pnlBase;
    // End of variables declaration//GEN-END:variables
}
