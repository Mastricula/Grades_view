package Vistas;

import Controller.*;
import java.awt.*;
import Controller.Usuario;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class Login extends javax.swing.JFrame {

    int mouseX;
    int mouseY;

    public Login() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/IMG/IconoProye.png")).getImage()); //Poniendo icono
        setBackground(new Color(0, 0, 0, 0));//La ventana sera trasparente
        setLocationRelativeTo(null); // La ventana saldrá en el centro
        inputPass.setEchoChar('•'); //Estableciendo el caracter de la contraseña
        setExtendedState(NORMAL);
//Estado de la ventana
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBase = new javax.swing.JPanel();
        pnlFondo = new javax.swing.JPanel();
        lblLogin = new javax.swing.JLabel();
        inputUsu = new rojeru_san.rsfield.RSTextFullRound();
        inputPass = new rojeru_san.rsfield.RSPassRound();
        lblUser = new javax.swing.JLabel();
        lblPass = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblVer = new javax.swing.JLabel();
        btnCerrar = new rojeru_san.complementos.RSButtonHover();
        btnMini = new rojeru_san.complementos.RSButtonHover();
        btnIniciar = new rojeru_san.rsbutton.RSButtonRound();
        pnlBarra = new javax.swing.JPanel();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        pnlBase.setBackground(new java.awt.Color(0, 173, 181));
        pnlBase.setOpaque(false);
        pnlBase.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlFondo.setBackground(new java.awt.Color(238, 238, 238));

        lblLogin.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        lblLogin.setForeground(new java.awt.Color(51, 51, 51));
        lblLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogin.setText("LOGIN");

        inputUsu.setBackground(new java.awt.Color(238, 238, 238));
        inputUsu.setForeground(new java.awt.Color(51, 51, 51));
        inputUsu.setBorderColor(new java.awt.Color(204, 204, 204));
        inputUsu.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        inputUsu.setPhColor(new java.awt.Color(0, 0, 0));
        inputUsu.setPlaceholder("Usuario");

        inputPass.setBackground(new java.awt.Color(238, 238, 238));
        inputPass.setForeground(new java.awt.Color(51, 51, 51));
        inputPass.setBorderColor(new java.awt.Color(204, 204, 204));
        inputPass.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        inputPass.setPhColor(new java.awt.Color(0, 0, 0));
        inputPass.setPlaceholder("Contraseña");

        lblUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Iconos/user.png"))); // NOI18N

        lblPass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Iconos/candado.png"))); // NOI18N

        lblTitulo.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(102, 102, 102));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("¿Qué esperas para iniciar sesion?");

        lblVer.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        lblVer.setForeground(new java.awt.Color(102, 102, 102));
        lblVer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVer.setText("Ver Contraseña");
        lblVer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblVerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblVerMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblVerMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblVerMouseReleased(evt);
            }
        });

        btnCerrar.setBackground(new java.awt.Color(238, 238, 238));
        btnCerrar.setBorder(null);
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Iconos/cerrar2.png"))); // NOI18N
        btnCerrar.setColorHover(new java.awt.Color(251, 77, 77));
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        btnMini.setBackground(new java.awt.Color(238, 238, 238));
        btnMini.setBorder(null);
        btnMini.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Iconos/minus.png"))); // NOI18N
        btnMini.setColorHover(new java.awt.Color(195, 192, 192));
        btnMini.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMiniActionPerformed(evt);
            }
        });

        btnIniciar.setBackground(new java.awt.Color(0, 173, 181));
        btnIniciar.setText("INICIAR");
        btnIniciar.setColorHover(new java.awt.Color(2, 133, 139));
        btnIniciar.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFondoLayout = new javax.swing.GroupLayout(pnlFondo);
        pnlFondo.setLayout(pnlFondoLayout);
        pnlFondoLayout.setHorizontalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFondoLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblVer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(pnlFondoLayout.createSequentialGroup()
                                    .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblPass, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(inputUsu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(inputPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                                .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(103, 103, 103))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                                .addComponent(btnMini, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0))))))
        );
        pnlFondoLayout.setVerticalGroup(
            pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFondoLayout.createSequentialGroup()
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMini, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(124, 124, 124)
                .addComponent(lblLogin)
                .addGap(0, 0, 0)
                .addComponent(lblTitulo)
                .addGap(47, 47, 47)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputUsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblVer, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(145, 145, 145))
        );

        pnlBase.add(pnlFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 380, 580));

        pnlBarra.setOpaque(false);
        pnlBarra.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlBarraMouseDragged(evt);
            }
        });
        pnlBarra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlBarraMousePressed(evt);
            }
        });

        javax.swing.GroupLayout pnlBarraLayout = new javax.swing.GroupLayout(pnlBarra);
        pnlBarra.setLayout(pnlBarraLayout);
        pnlBarraLayout.setHorizontalGroup(
            pnlBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 970, Short.MAX_VALUE)
        );
        pnlBarraLayout.setVerticalGroup(
            pnlBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 24, Short.MAX_VALUE)
        );

        pnlBase.add(pnlBarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, -1));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/FondoLoginE.png"))); // NOI18N
        pnlBase.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 580));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBase, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        //Obtenemos  los datos de nuestros inputs
        String textoUsu = inputUsu.getText();
        String textoPass = inputPass.getText();

        if (!textoUsu.equals("") && !textoPass.equals("")) {
            Usuario data = new Usuario();
            data.Login(textoUsu, textoPass);

            if (textoUsu.equals(data.getUsu()) && textoPass.equals(data.getPassw())) {
                MainScreen screen = new MainScreen(data);
                data.DatosUsuarios();
                this.dispose();
                screen.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(this, "El usuario o la contraseña no son correctos");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese usuario y contraseña");
        }
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void pnlBarraMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBarraMouseDragged
        int pX = evt.getXOnScreen();
        int pY = evt.getYOnScreen();

        this.setLocation(pX - mouseX, pY - mouseY);
    }//GEN-LAST:event_pnlBarraMouseDragged

    private void pnlBarraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBarraMousePressed
        mouseX = evt.getX();
        mouseY = evt.getY();
    }//GEN-LAST:event_pnlBarraMousePressed

    private void lblVerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVerMousePressed
        lblVer.setForeground(new Color(0x02858B));
        inputPass.setEchoChar((char) 0);
    }//GEN-LAST:event_lblVerMousePressed

    private void lblVerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVerMouseEntered
        lblVer.setForeground(new Color(0x00ADB5));
    }//GEN-LAST:event_lblVerMouseEntered

    private void lblVerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVerMouseExited
        lblVer.setForeground(new Color(0x666666));
    }//GEN-LAST:event_lblVerMouseExited

    private void lblVerMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVerMouseReleased
        inputPass.setEchoChar('•');
    }//GEN-LAST:event_lblVerMouseReleased

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        //this.dispose();
        System.exit(0);
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnMiniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMiniActionPerformed
        setExtendedState(ICONIFIED);
    }//GEN-LAST:event_btnMiniActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.complementos.RSButtonHover btnCerrar;
    private rojeru_san.rsbutton.RSButtonRound btnIniciar;
    private rojeru_san.complementos.RSButtonHover btnMini;
    private rojeru_san.rsfield.RSPassRound inputPass;
    private rojeru_san.rsfield.RSTextFullRound inputUsu;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblVer;
    private javax.swing.JPanel pnlBarra;
    private javax.swing.JPanel pnlBase;
    private javax.swing.JPanel pnlFondo;
    // End of variables declaration//GEN-END:variables
}
