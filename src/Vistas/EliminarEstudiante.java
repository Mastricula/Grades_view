/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import java.sql.Statement;
import java.sql.ResultSet;
import Controller.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class EliminarEstudiante extends javax.swing.JFrame {
    
    
    private int BuscarCurso()
    {
        int Curso=0;
       
        
        if(inputCurso.getText().equals("1ro de Bachillerato"))
        {
          Curso=200;
          return Curso;
        }
        else if(inputCurso.getText().equals("2do de Bachillerato"))
        {
            Curso=201;
            return Curso;
        }
        else if(inputCurso.getText().equals("3ro de Bachillerato"))
        {
            Curso=202;
            return Curso;
        }
        else if(inputCurso.getText().equals("4to de Bachillerato"))
        {
            Curso=203;
            return Curso;
        }
        else if(inputCurso.getText().equals("5to de Bachillerato"))
        {
            Curso=204;
            return Curso;
        }
        else if(inputCurso.getText().equals("6to de Bachillerato"))
        {
            Curso=205;
            return Curso;
        }
     
        return Curso;
    }
    private void Editar()
    {
      Conexion conexion= new Conexion();
      
      Connection conectado=conexion.Conectar();
      String matricula=inputMatricula.getText();
      String nombre= inputNombre.getText();
      String apellido=inputApellido.getText();
      int edad=Integer.parseInt(inputEdad.getText());
      int idCurso=BuscarCurso();
      int idEstudiante=-1;
      System.out.println(matricula);
      System.out.println(nombre);
      System.out.println(apellido);
      System.out.println(edad);
      System.out.println(idCurso);
      
          
      try
      {
          Statement statement= conectado.createStatement();
          statement.executeUpdate("UPDATE Estudiantes SET nombre='"+nombre+"', apellido='"+apellido+"', edad='"+edad+"',id_curso='"+idCurso+"' WHERE matricula_estu='"+matricula+"'");
          //ResultSet resultado= statement.executeQuery("SELECT*FROM Estudiantes WHERE matricula_estu='"+matricula+"'and nombre='"+nombre+"'");
          
          /*if(resultado.next())
          {
            idEstudiante=resultado.getInt("id_estu");
            System.out.println(idEstudiante);
          }
          
          if(idEstudiante!=-1)
          {
            statement.executeUpdate("UPDATE Estudiantes SET matricula_estu='"+matricula+"', nombre='"+nombre+"', apellido='"+apellido+"', edad='"+edad+"',id_curso='"+idCurso+"' WHERE id_estu="+idEstudiante);
          }
          System.out.println(idEstudiante);
          
          conectado.close();
        */
          
            
      }
      
      
      catch(SQLException ex)
      {
        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);  
      }
       
      
    }
    
    private void HabilitarEdicion()
    {
        if(checkBoxEditar.getState())
        {
          btnEditar.setEnabled(false);
          inputMatricula.setEnabled(false);
          inputNombre.setEnabled(false);
          inputApellido.setEnabled(false);
          inputEdad.setEnabled(false);
          inputCurso.setEnabled(false);
          
        }
        else
        {
            btnEditar.setEnabled(true);
            
            inputMatricula.setEnabled(true);
            inputNombre.setEnabled(true);
            inputApellido.setEnabled(true);
            inputEdad.setEnabled(true);
            inputCurso.setEnabled(true);
         
            
        }
    }
    private void MostrarEstudiantesComboBox()
    {
        Connection conectado;
        Conexion conexion= new Conexion();
        conectado=conexion.Conectar();
        
        try
        {
            Statement statement=conectado.createStatement();
            ResultSet resultset=statement.executeQuery("SELECT matricula_estu, nombre, apellido FROM Estudiantes");
            comboBoxEstudiantes.removeAllItems();
            while(resultset.next())
            {
                String matricula=resultset.getString("matricula_estu");
                String nombre=resultset.getString("nombre");
                String apellido= resultset.getString("apellido");
                String MatriculaNombre= matricula+"  "+nombre+"  "+apellido; 
                comboBoxEstudiantes.addItem(MatriculaNombre);
            
            }
            
        }
        catch(SQLException ex)
        {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);  
        }
    
    }

    /**
     * Creates new form EliminarEstudiante
     */
    public EliminarEstudiante() {
        initComponents();
        MostrarEstudiantesComboBox();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboBoxEstudiantes = new javax.swing.JComboBox<>();
        btnEliminar = new rojeru_san.rsbutton.RSButtonRound();
        btnEditar = new rojeru_san.rsbutton.RSButtonRound();
        inputCurso = new rojeru_san.rsfield.RSTextFullRound();
        inputMatricula = new rojeru_san.rsfield.RSTextFullRound();
        inputNombre = new rojeru_san.rsfield.RSTextFullRound();
        inputApellido = new rojeru_san.rsfield.RSTextFullRound();
        inputEdad = new rojeru_san.rsfield.RSTextFullRound();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        checkBoxEditar = new java.awt.Checkbox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        comboBoxEstudiantes.setToolTipText("Selecionar Estudiante");
        comboBoxEstudiantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxEstudiantesActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.setEnabled(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        inputCurso.setEnabled(false);
        inputCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputCursoActionPerformed(evt);
            }
        });

        inputMatricula.setEnabled(false);
        inputMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputMatriculaActionPerformed(evt);
            }
        });

        inputNombre.setEnabled(false);
        inputNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNombreActionPerformed(evt);
            }
        });

        inputApellido.setEnabled(false);
        inputApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputApellidoActionPerformed(evt);
            }
        });

        inputEdad.setEnabled(false);
        inputEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputEdadActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Estudiantes");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nombre");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Apellido");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Edad");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Curso");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Matrícula");

        checkBoxEditar.setLabel("  Habilitar Edición");
        checkBoxEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkBoxEditarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(inputApellido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(inputNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(inputMatricula, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(comboBoxEstudiantes, javax.swing.GroupLayout.Alignment.LEADING, 0, 234, Short.MAX_VALUE)
                            .addComponent(inputCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(inputEdad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(checkBoxEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(151, 151, 151))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxEstudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inputNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inputApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(inputCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(checkBoxEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxEstudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxEstudiantesActionPerformed
       
        
        String matriculaNombreApellido2=(String)comboBoxEstudiantes.getSelectedItem();
        if (matriculaNombreApellido2 == null) {
        return; 
        }
        String matriculaEstudianteSeleccionado=matriculaNombreApellido2.substring(0, 9);
        Conexion conexion= new Conexion();
        Connection conectado= conexion.Conectar();
        
        String nombres;
        String apellidos;
        String edad;
        String curso;
        String matricula=matriculaEstudianteSeleccionado;
       
        
        try
        {
            Statement statement= conectado.createStatement();
            ResultSet resultado= statement.executeQuery("SELECT*FROM Estudiantes JOIN Cursos on Estudiantes.id_curso= Cursos.id_curso WHERE matricula_estu='"+matriculaEstudianteSeleccionado+"'");
            while(resultado.next())
            {
                nombres=resultado.getString("nombre");
                apellidos=resultado.getString("apellido");
                edad=resultado.getString("edad");
                curso=resultado.getString("curso");
                
                
                
                
                inputMatricula.setText(matricula);
                inputNombre.setText(nombres);
                inputApellido.setText(apellidos);
                inputEdad.setText(edad);
                inputCurso.setText(curso);
                
                
                
            }
        }
        catch(SQLException ex)
        {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }//GEN-LAST:event_comboBoxEstudiantesActionPerformed
    
    
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        
        String matriculaNombreApellido= (String)comboBoxEstudiantes.getSelectedItem();
        String matricula= matriculaNombreApellido.substring(0, 9);
        int id_estu = 0;
        
        Conexion conexion= new Conexion();
        Connection conectado= conexion.Conectar();
        System.out.println(matricula);
        
        int respuesta =JOptionPane.showConfirmDialog(this, "¿Estás seguro de que quieres eliminar este estudiante '"+matriculaNombreApellido+"' ", "Seleccione su respuesta", JOptionPane.YES_NO_OPTION);
        if(respuesta==JOptionPane.YES_NO_OPTION)
        {       
            try
            {
                Statement statement= conectado.createStatement();
                ResultSet resultado= statement.executeQuery("SELECT*FROM Estudiantes WHERE matricula_estu='"+matricula+"'");
            
                while(resultado.next())
                {
                    id_estu= resultado.getInt("id_estu");  
                }
                statement.executeUpdate("DELETE FROM Estudiantes WHERE id_estu="+id_estu);
                
            }
            catch(SQLException ex)
            {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            
           
            
        }
        else
        {
            System.out.println("Le dio a no elminar no bulto");
        }
        MostrarEstudiantesComboBox();
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void inputMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputMatriculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputMatriculaActionPerformed

    private void inputCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputCursoActionPerformed

    private void inputNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNombreActionPerformed

    private void inputApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputApellidoActionPerformed

    private void inputEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputEdadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputEdadActionPerformed

    private void checkBoxEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkBoxEditarMouseClicked
        
        HabilitarEdicion();
        
    }//GEN-LAST:event_checkBoxEditarMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        Editar();
        
    }//GEN-LAST:event_btnEditarActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(EliminarEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EliminarEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EliminarEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EliminarEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EliminarEstudiante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.rsbutton.RSButtonRound btnEditar;
    private rojeru_san.rsbutton.RSButtonRound btnEliminar;
    private java.awt.Checkbox checkBoxEditar;
    private javax.swing.JComboBox<String> comboBoxEstudiantes;
    private rojeru_san.rsfield.RSTextFullRound inputApellido;
    private rojeru_san.rsfield.RSTextFullRound inputCurso;
    private rojeru_san.rsfield.RSTextFullRound inputEdad;
    private rojeru_san.rsfield.RSTextFullRound inputMatricula;
    private rojeru_san.rsfield.RSTextFullRound inputNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
