package Vistas;

import java.awt.*;
import Controller.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;

public class MainScreen extends javax.swing.JFrame {

    int mouseX;
    int mouseY;

    public MainScreen() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/IMG/IconoSplash.png")).getImage());
        setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPerfil5 = new javax.swing.JLabel();
        pnlBase = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        rSPanelGradiente1 = new rojeru_san.rspanel.RSPanelGradiente();
        lblPerfil = new javax.swing.JLabel();
        lblPerfil1 = new javax.swing.JLabel();
        lblPerfil2 = new javax.swing.JLabel();
        lblPerfil3 = new javax.swing.JLabel();
        lblPerfil4 = new javax.swing.JLabel();
        lblPerfil6 = new javax.swing.JLabel();
        lblPerfil7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        pnlBarra = new javax.swing.JPanel();
        lblMini = new javax.swing.JLabel();
        lblCerrar = new javax.swing.JLabel();
        lblMax = new javax.swing.JLabel();

        lblPerfil5.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        lblPerfil5.setForeground(new java.awt.Color(238, 238, 238));
        lblPerfil5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Iconos/user.png"))); // NOI18N
        lblPerfil5.setText("AGREGAR");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        pnlBase.setBackground(new java.awt.Color(238, 238, 238));

        jDesktopPane1.setBackground(new java.awt.Color(204, 204, 204));
        jDesktopPane1.setDragMode(javax.swing.JDesktopPane.OUTLINE_DRAG_MODE);

        rSPanelGradiente1.setColorPrimario(new java.awt.Color(0, 173, 181));
        rSPanelGradiente1.setColorSecundario(new java.awt.Color(0, 173, 181));

        lblPerfil.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        lblPerfil.setForeground(new java.awt.Color(238, 238, 238));
        lblPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Iconos/user.png"))); // NOI18N
        lblPerfil.setText("PERFIL");

        lblPerfil1.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        lblPerfil1.setForeground(new java.awt.Color(238, 238, 238));
        lblPerfil1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Iconos/user.png"))); // NOI18N
        lblPerfil1.setText("VER NOTAS");

        lblPerfil2.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        lblPerfil2.setForeground(new java.awt.Color(238, 238, 238));
        lblPerfil2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Iconos/user.png"))); // NOI18N
        lblPerfil2.setText("VER MATERIAS");

        lblPerfil3.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        lblPerfil3.setForeground(new java.awt.Color(238, 238, 238));
        lblPerfil3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Iconos/user.png"))); // NOI18N
        lblPerfil3.setText("PUBLICAR NOTAS");

        lblPerfil4.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        lblPerfil4.setForeground(new java.awt.Color(238, 238, 238));
        lblPerfil4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Iconos/user.png"))); // NOI18N
        lblPerfil4.setText("AGREGAR");

        lblPerfil6.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        lblPerfil6.setForeground(new java.awt.Color(238, 238, 238));
        lblPerfil6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Iconos/user.png"))); // NOI18N
        lblPerfil6.setText("ACTUALIZAR");

        lblPerfil7.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        lblPerfil7.setForeground(new java.awt.Color(238, 238, 238));
        lblPerfil7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Iconos/user.png"))); // NOI18N
        lblPerfil7.setText("ELIMINAR");

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rSPanelGradiente1Layout = new javax.swing.GroupLayout(rSPanelGradiente1);
        rSPanelGradiente1.setLayout(rSPanelGradiente1Layout);
        rSPanelGradiente1Layout.setHorizontalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                        .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPerfil7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPerfil6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addComponent(lblPerfil4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPerfil3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                    .addComponent(lblPerfil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPerfil1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPerfil2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        rSPanelGradiente1Layout.setVerticalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(lblPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblPerfil1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblPerfil2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblPerfil3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblPerfil4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblPerfil6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblPerfil7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jButton1)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        jDesktopPane1.setLayer(rSPanelGradiente1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(rSPanelGradiente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 970, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelGradiente1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlBaseLayout = new javax.swing.GroupLayout(pnlBase);
        pnlBase.setLayout(pnlBaseLayout);
        pnlBaseLayout.setHorizontalGroup(
            pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        pnlBaseLayout.setVerticalGroup(
            pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pnlBarra.setBackground(new java.awt.Color(238, 238, 238));
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

        lblMini.setBackground(new java.awt.Color(238, 238, 238));
        lblMini.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMini.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Iconos/minus.png"))); // NOI18N
        lblMini.setOpaque(true);
        lblMini.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblMiniMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblMiniMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblMiniMousePressed(evt);
            }
        });

        lblCerrar.setBackground(new java.awt.Color(238, 238, 238));
        lblCerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Iconos/cerrar2.png"))); // NOI18N
        lblCerrar.setOpaque(true);
        lblCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCerrarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblCerrarMousePressed(evt);
            }
        });

        lblMax.setBackground(new java.awt.Color(238, 238, 238));
        lblMax.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMax.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Iconos/maximize.png"))); // NOI18N
        lblMax.setOpaque(true);
        lblMax.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblMaxMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblMaxMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblMaxMousePressed(evt);
            }
        });

        javax.swing.GroupLayout pnlBarraLayout = new javax.swing.GroupLayout(pnlBarra);
        pnlBarra.setLayout(pnlBarraLayout);
        pnlBarraLayout.setHorizontalGroup(
            pnlBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBarraLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMini, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblMax, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlBarraLayout.setVerticalGroup(
            pnlBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBarraLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnlBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMini, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCerrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMax, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlBarra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnlBarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblMiniMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMiniMouseEntered
        lblMini.setBackground(new Color(0xB6B6B6));
    }//GEN-LAST:event_lblMiniMouseEntered

    private void lblMiniMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMiniMouseExited
        //Restableciendo el color
        lblMini.setBackground(new Color(0xEEEEEE));
    }//GEN-LAST:event_lblMiniMouseExited

    private void lblMiniMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMiniMousePressed
        //Estableciendo nuevo color
        lblMini.setBackground(new Color(0xD3D3D3));
        setExtendedState(ICONIFIED);
    }//GEN-LAST:event_lblMiniMousePressed

    private void pnlBarraMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBarraMouseDragged
        int pX = evt.getXOnScreen();
        int pY = evt.getYOnScreen();

        this.setLocation(pX - mouseX, pY - mouseY);
    }//GEN-LAST:event_pnlBarraMouseDragged

    private void pnlBarraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBarraMousePressed
        mouseX = evt.getX();
        mouseY = evt.getY();
    }//GEN-LAST:event_pnlBarraMousePressed

    private void lblCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseEntered
        lblCerrar.setBackground(new Color(0xFA3030));
    }//GEN-LAST:event_lblCerrarMouseEntered

    private void lblCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseExited
        lblCerrar.setBackground(new Color(0xEEEEEE));
    }//GEN-LAST:event_lblCerrarMouseExited

    private void lblCerrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMousePressed
        lblCerrar.setBackground(new Color(0xFA6565));
        //this.dispose();
        System.exit(0);
    }//GEN-LAST:event_lblCerrarMousePressed

    private void lblMaxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMaxMouseEntered
        lblMax.setBackground(new Color(0xB6B6B6));
    }//GEN-LAST:event_lblMaxMouseEntered

    private void lblMaxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMaxMouseExited
        //Restableciendo el color
        lblMax.setBackground(new Color(0xEEEEEE));
    }//GEN-LAST:event_lblMaxMouseExited

    private void lblMaxMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMaxMousePressed
        //Estableciendo nuevo color
        lblMax.setBackground(new Color(0xD3D3D3));

        if (getExtendedState() == MAXIMIZED_BOTH) {
            setExtendedState(NORMAL);
            
        } else {
            setExtendedState(MAXIMIZED_BOTH);
            
        }
    }//GEN-LAST:event_lblMaxMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        AgregarEstudiante age = new AgregarEstudiante();
        age.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblMax;
    private javax.swing.JLabel lblMini;
    private javax.swing.JLabel lblPerfil;
    private javax.swing.JLabel lblPerfil1;
    private javax.swing.JLabel lblPerfil2;
    private javax.swing.JLabel lblPerfil3;
    private javax.swing.JLabel lblPerfil4;
    private javax.swing.JLabel lblPerfil5;
    private javax.swing.JLabel lblPerfil6;
    private javax.swing.JLabel lblPerfil7;
    private javax.swing.JPanel pnlBarra;
    private javax.swing.JPanel pnlBase;
    private rojeru_san.rspanel.RSPanelGradiente rSPanelGradiente1;
    // End of variables declaration//GEN-END:variables
}
