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
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class Agregar extends javax.swing.JInternalFrame {

    public Agregar() {
        initComponents();
        AgregarDatosAlCombobox();
        //setBackground(new Color(0, 0, 0, 0));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        //bui.setNorthPane(null);
    }
    
    private void AgregarDatosAlCombobox() 
    {
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
    
    private int BuscarIdCursoSelecionado() 
    {
       int curso = 0;

        if (cmbCursos.getSelectedItem().equals("1ro de Secundaria")) {
            curso = 1;
            return curso;
        } else if (cmbCursos.getSelectedItem().equals("2do de Secundaria")) {
            curso = 2;
            return curso;
        } else if (cmbCursos.getSelectedItem().equals("3ro de Secundaria")) {
            curso = 3;
            return curso;
        } else if (cmbCursos.getSelectedItem().equals("4to de Secundaria")) {
            curso = 4;
            return curso;
        } else if (cmbCursos.getSelectedItem().equals("5do de Secundaria")) {
            curso = 5;
            return curso;
        } else if (cmbCursos.getSelectedItem().equals("6to de Secundaria")) {
            curso = 6;
            return curso;
        }
        return curso;
    }

    private String obtenerFecha() 
    {
        Date fechaSeleccionada = inputFecha.getDatoFecha();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        return formato.format(fechaSeleccionada);
    }
    
    private void agregarEstudiante()
    {
        Administrador admin1= new Administrador();
        String nombres = inputNombre.getText();
        String apellidos = inputApellido.getText();
        String fechaNacimiento = obtenerFecha();
        
        int idCurso = BuscarIdCursoSelecionado();
        if(idCurso==0)
        {
            JOptionPane.showMessageDialog(this, "SE DEBEN LLENAR TODOS LO CAMPOS REQUERIDOS");
        }
        else
        {
                              
            if (nombres.isEmpty() || apellidos.isEmpty() || fechaNacimiento.isEmpty()) 
            {
                JOptionPane.showMessageDialog(this, "SE DEBEN LLENAR TODOS LO CAMPOS REQUERIDOS");

            }
            else 
            {
                admin1.Agregar(nombres, apellidos, fechaNacimiento, idCurso);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBase = new javax.swing.JPanel();
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
        lblCurso1 = new javax.swing.JLabel();
        inputFecha = new rojeru_san.rsdate.RSDateChooser();

        setClosable(true);
        setOpaque(true);

        pnlBase.setBackground(new java.awt.Color(238, 238, 238));
        pnlBase.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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
        inputApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputApellidoActionPerformed(evt);
            }
        });

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

        btnImportar.setBackground(new java.awt.Color(102, 102, 102));
        btnImportar.setText("IMPORTAR");
        btnImportar.setColorHover(new java.awt.Color(51, 51, 51));
        btnImportar.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        btnImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportarActionPerformed(evt);
            }
        });

        lblCurso1.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        lblCurso1.setForeground(new java.awt.Color(102, 102, 102));
        lblCurso1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCurso1.setText("Fecha de nacimiento");

        javax.swing.GroupLayout pnlBaseLayout = new javax.swing.GroupLayout(pnlBase);
        pnlBase.setLayout(pnlBaseLayout);
        pnlBaseLayout.setHorizontalGroup(
            pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBaseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBaseLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(inputFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlBaseLayout.createSequentialGroup()
                        .addComponent(btnMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnImportar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnIngresar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCurso1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputApellido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblApellido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbCursos, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCurso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(46, 46, 46)
                .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputId, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pnlBaseLayout.setVerticalGroup(
            pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBaseLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBaseLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(inputEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(inputId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(pnlBaseLayout.createSequentialGroup()
                        .addComponent(lblNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblApellido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblCurso1)
                        .addGap(18, 18, 18)
                        .addComponent(inputFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(lblCurso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnImportar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35))))
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

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        agregarEstudiante();
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void inputEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputEdadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputEdadActionPerformed

    private void inputApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputApellidoActionPerformed

    private void btnImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnImportarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.rsbutton.RSButtonRound btnImportar;
    private rojeru_san.rsbutton.RSButtonRound btnIngresar;
    private rojeru_san.rsbutton.RSButtonRound btnMostrar;
    private javax.swing.JComboBox<String> cmbCursos;
    private rojeru_san.rsfield.RSTextFullRound inputApellido;
    private rojeru_san.rsfield.RSTextFullRound inputEdad;
    private rojeru_san.rsdate.RSDateChooser inputFecha;
    private rojeru_san.rsfield.RSTextFullRound inputId;
    private rojeru_san.rsfield.RSTextFullRound inputNombre;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCurso;
    private javax.swing.JLabel lblCurso1;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlBase;
    // End of variables declaration//GEN-END:variables

}
