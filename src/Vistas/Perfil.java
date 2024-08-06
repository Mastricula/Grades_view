package Vistas;

import Controller.Conexion;
import Controller.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Perfil extends javax.swing.JInternalFrame {

    private String password;

    private void Nombre(String nombre) {
        jlbNombre.setText(nombre);
    }

    private void Apellido(String apellido) {
        jblApellido.setText(apellido);
    }

    private void Matricula(String matricula) {
        jblMatricula.setText(matricula);
    }

    Usuario data2;

    public Perfil(Usuario data) {
        initComponents();
        Nombre(data.getNombre());
        Apellido(data.getApellido());
        Matricula(data.getMatricula());
        data2 = data;
        btnConfirmar.disable();
        ModPAss.disable();
        inputAcontrasena.disable();
        inputNcontrasena.disable();
        btnConfirmar.disable();
        password = data.getPassw();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlbNombre = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jlbNombre1 = new javax.swing.JLabel();
        jlbNombre2 = new javax.swing.JLabel();
        jblApellido = new javax.swing.JLabel();
        jblMatricula = new javax.swing.JLabel();
        CambiarContrasena = new rojeru_san.rsbutton.RSButtonRound();
        ModPAss = new javax.swing.JLabel();
        inputAcontrasena = new rojeru_san.rsfield.RSTextFullRound();
        btnConfirmar = new rojeru_san.rsbutton.RSButtonRound();
        jLabel3 = new javax.swing.JLabel();
        inputNcontrasena = new rojeru_san.rsfield.RSTextFullRound();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(238, 238, 238));

        jlbNombre.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        jlbNombre.setForeground(new java.awt.Color(51, 51, 51));
        jlbNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbNombre.setText("Nombre");

        jLabel2.setFont(new java.awt.Font("Poppins Medium", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nombre");

        jlbNombre1.setFont(new java.awt.Font("Poppins Medium", 1, 18)); // NOI18N
        jlbNombre1.setForeground(new java.awt.Color(0, 0, 0));
        jlbNombre1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbNombre1.setText("Apellido");

        jlbNombre2.setFont(new java.awt.Font("Poppins Medium", 1, 18)); // NOI18N
        jlbNombre2.setForeground(new java.awt.Color(0, 0, 0));
        jlbNombre2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbNombre2.setText("Matricula");

        jblApellido.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        jblApellido.setForeground(new java.awt.Color(51, 51, 51));
        jblApellido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblApellido.setText("Apelido");

        jblMatricula.setFont(new java.awt.Font("Poppins Medium", 0, 18)); // NOI18N
        jblMatricula.setForeground(new java.awt.Color(51, 51, 51));
        jblMatricula.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblMatricula.setText("Matricula");

        CambiarContrasena.setBackground(new java.awt.Color(0, 173, 181));
        CambiarContrasena.setText("Cambiar Contraseña");
        CambiarContrasena.setColorHover(new java.awt.Color(2, 133, 139));
        CambiarContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CambiarContrasenaActionPerformed(evt);
            }
        });

        ModPAss.setFont(new java.awt.Font("Poppins Medium", 1, 16)); // NOI18N
        ModPAss.setForeground(new java.awt.Color(0, 0, 0));
        ModPAss.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ModPAss.setText("Antigua Contraseña");

        inputAcontrasena.setBackground(new java.awt.Color(255, 255, 255));
        inputAcontrasena.setForeground(new java.awt.Color(51, 51, 51));
        inputAcontrasena.setBorderColor(new java.awt.Color(204, 204, 204));
        inputAcontrasena.setCaretColor(new java.awt.Color(51, 51, 51));
        inputAcontrasena.setPhColor(new java.awt.Color(0, 0, 0));
        inputAcontrasena.setPlaceholder("Antigua Contraseña");
        inputAcontrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputAcontrasenaActionPerformed(evt);
            }
        });

        btnConfirmar.setBackground(new java.awt.Color(0, 173, 181));
        btnConfirmar.setText("Confirmar");
        btnConfirmar.setColorHover(new java.awt.Color(2, 133, 139));
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Poppins Black", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("PERFIL");

        inputNcontrasena.setBackground(new java.awt.Color(255, 255, 255));
        inputNcontrasena.setForeground(new java.awt.Color(51, 51, 51));
        inputNcontrasena.setBorderColor(new java.awt.Color(204, 204, 204));
        inputNcontrasena.setCaretColor(new java.awt.Color(51, 51, 51));
        inputNcontrasena.setPhColor(new java.awt.Color(0, 0, 0));
        inputNcontrasena.setPlaceholder("Nueva Contraseña");
        inputNcontrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNcontrasenaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(inputNcontrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(inputAcontrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(CambiarContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(2, 2, 2))
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlbNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlbNombre1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jblApellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlbNombre2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jblMatricula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ModPAss, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(0, 0, 0)
                .addComponent(jlbNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jlbNombre1)
                .addGap(0, 0, 0)
                .addComponent(jblApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jlbNombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jblMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(ModPAss)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputNcontrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputAcontrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CambiarContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CambiarContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CambiarContrasenaActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Desea modificar su contraseña actual?");
        if (respuesta == JOptionPane.YES_NO_OPTION) {
            ModPAss.setEnabled(true);
            ModPAss.setEnabled(true);
            inputAcontrasena.setEnabled(true);
            inputNcontrasena.setEnabled(true);
            btnConfirmar.setEnabled(true);
        }
    }//GEN-LAST:event_CambiarContrasenaActionPerformed

    private void inputNcontrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNcontrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNcontrasenaActionPerformed

    private void inputAcontrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputAcontrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputAcontrasenaActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        
        String actualContrasena = inputAcontrasena.getText();
        String nuevaContrasena = inputNcontrasena.getText();

        if (actualContrasena == null || nuevaContrasena == null || actualContrasena.isEmpty() || nuevaContrasena.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Se deben llenar todos los campos");
            return;
        }

        // Verificar la contraseña actual
        data2.Login(data2.getUsu(), actualContrasena); // Asegúrate de que el usuario está autenticado

        if (data2.getPassw().equals(actualContrasena)) {
            // Establecer la conexión a la base de datos
            Conexion conexion = new Conexion();
            Connection conectado = null;
            try {
                conectado = conexion.Conectar();
                if (conectado == null) {
                    throw new SQLException("No se pudo establecer la conexión con la base de datos.");
                }

                // Crear una sentencia SQL para actualizar la contraseña
                String sqlUpdate = "UPDATE Usuarios SET passw = ? WHERE id_usu = ?";
                PreparedStatement preparedStatement = conectado.prepareStatement(sqlUpdate);

                // Asignar los parámetros
                preparedStatement.setString(1, nuevaContrasena);
                preparedStatement.setInt(2, data2.getIdUsu());

                // Ejecutar la actualización
                int filasAfectadas = preparedStatement.executeUpdate();

                // Verificar si se actualizó la contraseña
                if (filasAfectadas > 0) {
                    JOptionPane.showMessageDialog(this, "Contraseña actualizada correctamente");
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo actualizar la contraseña");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error en la operación: " + ex.getMessage());
                ex.printStackTrace();
            }
            } else {
                JOptionPane.showMessageDialog(this, "La contraseña actual es incorrecta");
            }
        
    }//GEN-LAST:event_btnConfirmarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.rsbutton.RSButtonRound CambiarContrasena;
    private javax.swing.JLabel ModPAss;
    private rojeru_san.rsbutton.RSButtonRound btnConfirmar;
    private rojeru_san.rsfield.RSTextFullRound inputAcontrasena;
    private rojeru_san.rsfield.RSTextFullRound inputNcontrasena;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jblApellido;
    private javax.swing.JLabel jblMatricula;
    private javax.swing.JLabel jlbNombre;
    private javax.swing.JLabel jlbNombre1;
    private javax.swing.JLabel jlbNombre2;
    // End of variables declaration//GEN-END:variables
}
