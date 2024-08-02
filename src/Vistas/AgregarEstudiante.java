package Vistas;

import java.sql.Statement;
import java.sql.ResultSet;
import Controller.Conexion;
import java.awt.Color;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AgregarEstudiante extends javax.swing.JFrame {

    int mouseX;
    int mouseY;

    public AgregarEstudiante() {
        initComponents();
        agregarDatosAlCombobox();
        setLocationRelativeTo(null);
        setExtendedState(NORMAL);
    }

    private void agregarDatosAlCombobox() {
        Conexion conexion = new Conexion();
        Connection conectado;
        conectado = conexion.Conectar();

        try {
            Statement statement = conectado.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT curso FROM Cursos");
            //int id_Curso = resultset.getInt("id_curso");

            while (resultset.next()) {

                cmbCursos.addItem(resultset.getString("curso"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private int BuscarIdCursoSelecionado() {
        int curso = 0;

        if (cmbCursos.getSelectedItem().equals("1ro de Bachillerato")) {
            curso = 200;
            return curso;
        } else if (cmbCursos.getSelectedItem().equals("2do de Bachillerato")) {
            curso = 201;
            return curso;
        } else if (cmbCursos.getSelectedItem().equals("3ro de Bachillerato")) {
            curso = 202;
            return curso;
        } else if (cmbCursos.getSelectedItem().equals("4to de Bachillerato")) {
            curso = 203;
            return curso;
        } else if (cmbCursos.getSelectedItem().equals("5do de Bachillerato")) {
            curso = 204;
            return curso;
        } else if (cmbCursos.getSelectedItem().equals("6to de Bachillerato")) {
            curso = 205;
            return curso;
        }
        return curso;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBase = new javax.swing.JPanel();
        pnlBarra = new javax.swing.JPanel();
        btnCerrar = new rojeru_san.complementos.RSButtonHover();
        btnMini = new rojeru_san.complementos.RSButtonHover();
        btnIngresar = new rojeru_san.rsbutton.RSButtonRound();
        inputNombre = new rojeru_san.rsfield.RSTextFullRound();
        inputApellido = new rojeru_san.rsfield.RSTextFullRound();
        inputId = new rojeru_san.rsfield.RSTextFullRound();
        inputEdad = new rojeru_san.rsfield.RSTextFullRound();
        lblTitulo = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblCurso = new javax.swing.JLabel();
        cmbCursos = new javax.swing.JComboBox<>();
        btnMostrar = new rojeru_san.rsbutton.RSButtonRound();
        btnImportar = new rojeru_san.rsbutton.RSButtonRound();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        pnlBase.setBackground(new java.awt.Color(238, 238, 238));
        pnlBase.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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

        javax.swing.GroupLayout pnlBarraLayout = new javax.swing.GroupLayout(pnlBarra);
        pnlBarra.setLayout(pnlBarraLayout);
        pnlBarraLayout.setHorizontalGroup(
            pnlBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBarraLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnMini, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlBarraLayout.setVerticalGroup(
            pnlBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBarraLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnlBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMini, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        btnIngresar.setBackground(new java.awt.Color(102, 102, 102));
        btnIngresar.setText("INGRESAR");
        btnIngresar.setColorHover(new java.awt.Color(51, 51, 51));
        btnIngresar.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        inputNombre.setBackground(new java.awt.Color(255, 255, 255));
        inputNombre.setForeground(new java.awt.Color(51, 51, 51));
        inputNombre.setBorderColor(new java.awt.Color(204, 204, 204));
        inputNombre.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        inputNombre.setPhColor(new java.awt.Color(0, 0, 0));
        inputNombre.setPlaceholder("Nombres");

        inputApellido.setBackground(new java.awt.Color(255, 255, 255));
        inputApellido.setForeground(new java.awt.Color(51, 51, 51));
        inputApellido.setBorderColor(new java.awt.Color(204, 204, 204));
        inputApellido.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        inputApellido.setPhColor(new java.awt.Color(0, 0, 0));
        inputApellido.setPlaceholder("Apellidos");

        inputId.setBackground(new java.awt.Color(238, 238, 238));
        inputId.setForeground(new java.awt.Color(51, 51, 51));
        inputId.setBorderColor(new java.awt.Color(204, 204, 204));
        inputId.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        inputId.setPhColor(new java.awt.Color(0, 0, 0));

        inputEdad.setBackground(new java.awt.Color(238, 238, 238));
        inputEdad.setForeground(new java.awt.Color(51, 51, 51));
        inputEdad.setBorderColor(new java.awt.Color(204, 204, 204));
        inputEdad.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        inputEdad.setPhColor(new java.awt.Color(0, 0, 0));
        inputEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputEdadActionPerformed(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Poppins Black", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(51, 51, 51));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("AGREGAR ESTUDIANTE");

        lblNombre.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(102, 102, 102));
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre.setText("Nombre del estudiante");

        lblApellido.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        lblApellido.setForeground(new java.awt.Color(102, 102, 102));
        lblApellido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblApellido.setText("Apellido del estudiante");

        lblCurso.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        lblCurso.setForeground(new java.awt.Color(102, 102, 102));
        lblCurso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCurso.setText("Curso del estudiante");

        cmbCursos.setBackground(new java.awt.Color(238, 238, 238));
        cmbCursos.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cmbCursos.setForeground(new java.awt.Color(51, 51, 51));
        cmbCursos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cursos" }));
        cmbCursos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnMostrar.setBackground(new java.awt.Color(102, 102, 102));
        btnMostrar.setText("MOSTRAR");
        btnMostrar.setColorHover(new java.awt.Color(51, 51, 51));
        btnMostrar.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        btnImportar.setBackground(new java.awt.Color(102, 102, 102));
        btnImportar.setText("IMPORTAR");
        btnImportar.setColorHover(new java.awt.Color(51, 51, 51));
        btnImportar.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N

        javax.swing.GroupLayout pnlBaseLayout = new javax.swing.GroupLayout(pnlBase);
        pnlBase.setLayout(pnlBaseLayout);
        pnlBaseLayout.setHorizontalGroup(
            pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBarra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlBaseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBaseLayout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblCurso, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(inputNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblApellido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(inputApellido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(pnlBaseLayout.createSequentialGroup()
                            .addComponent(inputEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inputId, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlBaseLayout.createSequentialGroup()
                            .addComponent(btnMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnImportar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnIngresar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(82, 82, 82))
        );
        pnlBaseLayout.setVerticalGroup(
            pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBaseLayout.createSequentialGroup()
                .addComponent(pnlBarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(lblNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(lblApellido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblCurso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImportar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBase, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnlBarraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBarraMousePressed
        mouseX = evt.getX();
        mouseY = evt.getY();
    }//GEN-LAST:event_pnlBarraMousePressed

    private void pnlBarraMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBarraMouseDragged
        int pX = evt.getXOnScreen();
        int pY = evt.getYOnScreen();

        this.setLocation(pX - mouseX, pY - mouseY);
    }//GEN-LAST:event_pnlBarraMouseDragged

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed

        //Se instacia la clase conexion de la caperta BD para luego llamar el metodo Conexion() que permite hacer la conexion la BD.
        Conexion conectado = new Conexion();
        //Se instacia el objeto conect simplemente para organizar el codigo mejor y no realizar un codigo tan poco agradable...
        Connection conect = conectado.Conectar();

        // Se  obtiene los valores de los jtexfield y del comBox
        String matricula = inputId.getText();
        String nombres = inputNombre.getText();
        String apellidos = inputApellido.getText();
        String edadstr = inputEdad.getText();
        int idCurso = BuscarIdCursoSelecionado();

        // Se verifica si estan vacios los JtextField sino se cumple no se ejucuta el demas codigo...
        if (matricula.isEmpty() || nombres.isEmpty() || apellidos.isEmpty() || edadstr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "IDIOTA TODOS LOS CAMPOS DEBEN SER LLENADOS");

        } else {

            try {
                //Se convierte a enteros los valores y luego se hace el insert en caso de que error la conversion de datos o el insert se maneja los errores en los catch
                int edad = Integer.parseInt(edadstr);

                Statement statement = conect.createStatement();

                statement.executeUpdate("INSERT INTO Estudiantes(matricula_estu,nombre,apellido,edad,id_curso) values('" + matricula + "','" + nombres + "','" + apellidos + "','" + edad + "','" + idCurso + "')");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Edad e Id del Curso deben ser números válidos", "Error", JOptionPane.ERROR_MESSAGE);

            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);

            }

        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void inputEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputEdadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputEdadActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        //this.dispose();
        System.exit(0);
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnMiniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMiniActionPerformed
        setExtendedState(ICONIFIED);
    }//GEN-LAST:event_btnMiniActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AgregarEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarEstudiante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.complementos.RSButtonHover btnCerrar;
    private rojeru_san.rsbutton.RSButtonRound btnImportar;
    private rojeru_san.rsbutton.RSButtonRound btnIngresar;
    private rojeru_san.complementos.RSButtonHover btnMini;
    private rojeru_san.rsbutton.RSButtonRound btnMostrar;
    public javax.swing.JComboBox<String> cmbCursos;
    private rojeru_san.rsfield.RSTextFullRound inputApellido;
    private rojeru_san.rsfield.RSTextFullRound inputEdad;
    private rojeru_san.rsfield.RSTextFullRound inputId;
    private rojeru_san.rsfield.RSTextFullRound inputNombre;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCurso;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlBarra;
    private javax.swing.JPanel pnlBase;
    // End of variables declaration//GEN-END:variables

    private void sysoutPrintln(String no_se_conecto_chiva) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
