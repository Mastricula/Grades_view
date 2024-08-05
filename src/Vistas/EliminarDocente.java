package Vistas;

import Controller.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel Garcia
 */
public class EliminarDocente extends javax.swing.JInternalFrame {

    /**
     * Creates new form EliminarDocente
     */
    String tabla = "Profesores";
    
    public EliminarDocente() {
        initComponents();
        MostrarDocentesComboBox();
    }
    
    private void Editar()
    {
     Administrador admin= new Administrador(); 
        
      String matricula = inputMatricula.getText();
      String nombre = inputNombre.getText();
      String apellido = inputApellido.getText();
      String cedula = inputCedula.getText();
      String fechaDeNacimiento = inputFecha.getText();
      
      
      int respuesta =JOptionPane.showConfirmDialog(this, "¿Estás seguro de que quieres editar los datos de este docente? '"+matricula + nombre + apellido+"' ", "Seleccione su respuesta", JOptionPane.YES_NO_OPTION);
      if(respuesta==JOptionPane.YES_NO_OPTION)
      {
        admin.Editar(matricula, nombre, apellido, cedula, fechaDeNacimiento, tabla);
        MostrarDocentesComboBox();
      }
    }

    private void HabilitarEdicion() {
        if (checkBoxEditar.getState()) {
            btnEditar.setEnabled(false);
            inputMatricula.setEnabled(false);
            inputNombre.setEnabled(false);
            inputApellido.setEnabled(false);
            inputCedula.setEnabled(false);
            inputFecha.setEnabled(false);
            btnEliminar.setEnabled(true);

        } else {
            btnEditar.setEnabled(true);
            inputNombre.setEnabled(true);
            inputApellido.setEnabled(true);
            inputFecha.setEnabled(true);
            btnEliminar.setEnabled(false);

        }
    }

    private void MostrarDocentesComboBox() {
        Connection conectado;
        Conexion conexion= new Conexion();
        conectado=conexion.Conectar();
        
        try{
            Statement statement=conectado.createStatement();
            ResultSet resultset=statement.executeQuery("SELECT matricula, nombre, apellido, cedula, fecha_nacimiento FROM Profesores");
            comboBoxDocentes.removeAllItems();
            while(resultset.next()){
                String matricula=resultset.getString("matricula");
                String nombre=resultset.getString("nombre");
                String apellido= resultset.getString("apellido");
                String MatriculaNombre= matricula+"  "+nombre+"  "+apellido; 
                comboBoxDocentes.addItem(MatriculaNombre);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }

    private void Eliminar() {
        Administrador admin= new Administrador();
        String matriculaNombreApellido= (String)comboBoxDocentes.getSelectedItem();
        String matricula= matriculaNombreApellido.substring(0, 6);
        
        int respuesta =JOptionPane.showConfirmDialog(this, "¿Estás seguro de que quieres eliminar este Docente? '"+matriculaNombreApellido+"' ", "Seleccione su respuesta", JOptionPane.YES_NO_OPTION);
        if(respuesta==JOptionPane.YES_NO_OPTION)
        {       
            admin.eliminarTablasIntermedias(matricula);
            admin.Eliminar(matricula, tabla);
            MostrarDocentesComboBox();     
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        btnEliminar = new rojeru_san.rsbutton.RSButtonRound();
        lblFecha = new javax.swing.JLabel();
        btnEditar = new rojeru_san.rsbutton.RSButtonRound();
        lblMatricula = new javax.swing.JLabel();
        inputFecha = new rojeru_san.rsfield.RSTextFullRound();
        checkBoxEditar = new java.awt.Checkbox();
        inputMatricula = new rojeru_san.rsfield.RSTextFullRound();
        inputNombre = new rojeru_san.rsfield.RSTextFullRound();
        inputApellido = new rojeru_san.rsfield.RSTextFullRound();
        inputCedula = new rojeru_san.rsfield.RSTextFullRound();
        lblDocentes = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        comboBoxDocentes = new javax.swing.JComboBox<>();
        lblCedula = new javax.swing.JLabel();

        setClosable(true);

        jPanel.setBackground(new java.awt.Color(238, 238, 238));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        lblFecha.setForeground(new java.awt.Color(51, 51, 51));
        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFecha.setText("Fecha de nacimiento");

        btnEditar.setText("Editar");
        btnEditar.setEnabled(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarbtnEditarActionPerformed(evt);
            }
        });

        lblMatricula.setForeground(new java.awt.Color(51, 51, 51));
        lblMatricula.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMatricula.setText("Matrícula");

        inputFecha.setBackground(new java.awt.Color(255, 255, 255));
        inputFecha.setBorderColor(new java.awt.Color(204, 204, 204));
        inputFecha.setEnabled(false);
        inputFecha.setPhColor(new java.awt.Color(204, 204, 204));
        inputFecha.setPlaceholder("Fecha de nacimiento");
        inputFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputFechainputFechaActionPerformed(evt);
            }
        });

        checkBoxEditar.setLabel("  Habilitar Edición");
        checkBoxEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkBoxEditarcheckBoxEditarMouseClicked(evt);
            }
        });

        inputMatricula.setBackground(new java.awt.Color(255, 255, 255));
        inputMatricula.setForeground(new java.awt.Color(51, 51, 51));
        inputMatricula.setBorderColor(new java.awt.Color(204, 204, 204));
        inputMatricula.setEnabled(false);
        inputMatricula.setPhColor(new java.awt.Color(153, 153, 153));
        inputMatricula.setPlaceholder("Matricula");
        inputMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputMatriculainputMatriculaActionPerformed(evt);
            }
        });

        inputNombre.setBackground(new java.awt.Color(255, 255, 255));
        inputNombre.setBorderColor(new java.awt.Color(204, 204, 204));
        inputNombre.setEnabled(false);
        inputNombre.setPhColor(new java.awt.Color(153, 153, 153));
        inputNombre.setPlaceholder("Nombre");
        inputNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNombreinputNombreActionPerformed(evt);
            }
        });

        inputApellido.setBackground(new java.awt.Color(255, 255, 255));
        inputApellido.setBorderColor(new java.awt.Color(204, 204, 204));
        inputApellido.setEnabled(false);
        inputApellido.setPhColor(new java.awt.Color(153, 153, 153));
        inputApellido.setPlaceholder("Apellido");
        inputApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputApellidoinputApellidoActionPerformed(evt);
            }
        });

        inputCedula.setBackground(new java.awt.Color(255, 255, 255));
        inputCedula.setForeground(new java.awt.Color(51, 51, 51));
        inputCedula.setBorderColor(new java.awt.Color(204, 204, 204));
        inputCedula.setEnabled(false);
        inputCedula.setPhColor(new java.awt.Color(204, 204, 204));
        inputCedula.setPlaceholder("Cedula");
        inputCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputCedulainputCedulaActionPerformed(evt);
            }
        });

        lblDocentes.setForeground(new java.awt.Color(51, 51, 51));
        lblDocentes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDocentes.setText("Docente");

        lblNombre.setBackground(new java.awt.Color(51, 51, 51));
        lblNombre.setForeground(new java.awt.Color(51, 51, 51));
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre.setText("Nombre");

        lblApellido.setForeground(new java.awt.Color(51, 51, 51));
        lblApellido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblApellido.setText("Apellido");

        comboBoxDocentes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elegir" }));
        comboBoxDocentes.setToolTipText("Selecionar Estudiante");
        comboBoxDocentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxDocentescomboBoxDocentesActionPerformed(evt);
            }
        });

        lblCedula.setForeground(new java.awt.Color(51, 51, 51));
        lblCedula.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCedula.setText("Cedula");

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(inputApellido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(inputNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(inputMatricula, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(comboBoxDocentes, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inputCedula, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(inputFecha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addComponent(checkBoxEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelLayout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55))))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(lblApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(lblCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(lblDocentes, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(lblMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblDocentes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxDocentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lblMatricula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inputNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(lblApellido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inputApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(lblCedula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblFecha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(checkBoxEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Eliminar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarbtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarbtnEditarActionPerformed
        Editar();
    }//GEN-LAST:event_btnEditarbtnEditarActionPerformed

    private void inputFechainputFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputFechainputFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputFechainputFechaActionPerformed

    private void checkBoxEditarcheckBoxEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkBoxEditarcheckBoxEditarMouseClicked
        HabilitarEdicion();
    }//GEN-LAST:event_checkBoxEditarcheckBoxEditarMouseClicked

    private void inputMatriculainputMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputMatriculainputMatriculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputMatriculainputMatriculaActionPerformed

    private void inputNombreinputNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNombreinputNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNombreinputNombreActionPerformed

    private void inputApellidoinputApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputApellidoinputApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputApellidoinputApellidoActionPerformed

    private void inputCedulainputCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputCedulainputCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputCedulainputCedulaActionPerformed

    private void comboBoxDocentescomboBoxDocentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxDocentescomboBoxDocentesActionPerformed
        String matriculaNombreApellido=(String)comboBoxDocentes.getSelectedItem();
        
        if (matriculaNombreApellido == null) {
        return; 
        }
        String matriculaDocenteSeleccionado = matriculaNombreApellido.substring(0, 6);
        
        Conexion conexion= new Conexion();
        Connection cx = conexion.Conectar();
        
        String nombres;
        String apellidos;
        String fechaDeNacimiento;
        String cedula;
        String matricula = matriculaDocenteSeleccionado;
        
        try{
            Statement statement= cx.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Profesores WHERE matricula='"+matriculaDocenteSeleccionado+"'");
            while(rs.next()){
                nombres =rs.getString("nombre");
                apellidos =rs.getString("apellido");
                fechaDeNacimiento =rs.getString("fecha_nacimiento");
                cedula =rs.getString("cedula");
                
                inputMatricula.setText(matricula);
                inputNombre.setText(nombres);
                inputApellido.setText(apellidos);
                inputCedula.setText(cedula);
                inputFecha.setText(fechaDeNacimiento); 
            }
        }
        catch(SQLException ex){
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_comboBoxDocentescomboBoxDocentesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.rsbutton.RSButtonRound btnEditar;
    private rojeru_san.rsbutton.RSButtonRound btnEliminar;
    private java.awt.Checkbox checkBoxEditar;
    private javax.swing.JComboBox<String> comboBoxDocentes;
    private rojeru_san.rsfield.RSTextFullRound inputApellido;
    private rojeru_san.rsfield.RSTextFullRound inputCedula;
    private rojeru_san.rsfield.RSTextFullRound inputFecha;
    private rojeru_san.rsfield.RSTextFullRound inputMatricula;
    private rojeru_san.rsfield.RSTextFullRound inputNombre;
    private javax.swing.JPanel jPanel;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblDocentes;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblMatricula;
    private javax.swing.JLabel lblNombre;
    // End of variables declaration//GEN-END:variables
}
