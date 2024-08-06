package Vistas;

import Controller.Conexion;
import Controller.Usuario;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author paulo
 */

public class PublicarNotas extends javax.swing.JInternalFrame {

    private DefaultTableModel modo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return column >= 4; // Permitir la edición solo en las columnas de notas (P1, P2, P3, P4)
        }
    };
    private Map<String, int[]> cambios = new HashMap<>();
    private int id_profe = -1;

    private void agregarTableModelListener() {
        modo.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {

                btnEditar.setEnabled(true);
                int row = e.getFirstRow();
                int column = e.getColumn();
                if (column >= 4) { // Solo capturar cambios en las columnas de notas
                    TableModel model = (TableModel) e.getSource();
                    String matricula = (String) model.getValueAt(row, 1);

                    // Manejar valores vacíos de las celdas
                    int p1 = parseIntOrDefault((String) model.getValueAt(row, 4), 0);
                    int p2 = parseIntOrDefault((String) model.getValueAt(row, 5), 0);
                    int p3 = parseIntOrDefault((String) model.getValueAt(row, 6), 0);
                    int p4 = parseIntOrDefault((String) model.getValueAt(row, 7), 0);

                    // Guardar los cambios en una estructura temporal (puede ser un Map, List, etc.)
                    cambios.put(matricula, new int[]{p1, p2, p3, p4});
                }
            }
        });
    }

    private int parseIntOrDefault(String value, int defaultValue) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    private void LimpiarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) Tabla.getModel();
        modelo.setRowCount(0);
    }

    private void Tabla(int id_curso, int id_materia) {

        LimpiarTabla();
        Conexion conexion = new Conexion();
        Connection conectado = conexion.Conectar();
        String ids[] = {"Nombre", "Matricula", "Curso", "Materia", "P1", "P2", "P3", "P4"};
        modo.setColumnIdentifiers(ids);
        Tabla.setModel(modo);

        try {
            Statement statement = conectado.createStatement();
            ResultSet resultado = statement.executeQuery("SELECT "
                    + "CONCAT(e.nombre, ' ', e.apellido) AS Nombres, "
                    + "e.matricula, "
                    + "c.curso, "
                    + "m.materia, "
                    + "COALESCE(n.nota_p1, '') AS P1, "
                    + "COALESCE(n.nota_p2, '') AS P2, "
                    + "COALESCE(n.nota_p3, '') AS P3, "
                    + "COALESCE(n.nota_p4, '') AS P4 "
                    + "FROM "
                    + "estudiantes e "
                    + "JOIN cursos c ON e.id_curso = c.id_curso "
                    + "JOIN curso_mate cm ON cm.id_curso = c.id_curso "
                    + "JOIN materias m ON cm.id_materia = m.id_materia "
                    + "LEFT JOIN notas n ON e.id_estu = n.id_estu AND n.id_materia = m.id_materia "
                    + "WHERE "
                    + "e.id_curso = " + id_curso + " "
                    + "AND cm.id_materia = " + id_materia);

            while (resultado.next()) {
                modo.addRow(new Object[]{resultado.getString("Nombres"), resultado.getString("matricula"), resultado.getString("curso"), resultado.getString("materia"), resultado.getString("P1"), resultado.getString("P2"), resultado.getString("P3"), resultado.getString("P4"),});

            }

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private int CursoSelecionado() {
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
        } else if (cmbCursos.getSelectedItem().equals("5to de Secundaria")) {
            curso = 5;
            return curso;
        } else if (cmbCursos.getSelectedItem().equals("6to de Secundaria")) {
            curso = 6;
            return curso;
        }
        return curso;
    }

    private void mostrarCursosCMB(int id_profe) {
        Conexion conexion = new Conexion();
        Connection conectado = conexion.Conectar();
        String curso;

        try {
            Statement statement = conectado.createStatement();
            ResultSet resultado = statement.executeQuery("SELECT*FROM profe_cursos JOIN Cursos ON  profe_cursos.id_curso= Cursos.id_curso WHERE id_profe='" + id_profe + "'");
            while (resultado.next()) {
                curso = resultado.getString("curso");
                cmbCursos.addItem(curso);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void mostrarMateriasCMB(int id_profe) {
        cmbMateria.removeAllItems();
        Conexion conexion = new Conexion();
        Connection conectado = conexion.Conectar();
        int cursoSelecionado = CursoSelecionado();
        if (cmbCursos.getSelectedItem().equals("Seleccione")) {
            jLabel2.setText("Favor Seleccionar un Curso");
        } else {
            try {
                Statement statement = conectado.createStatement();
                ResultSet resultado2 = statement.executeQuery("SELECT DISTINCT m.materia\n"
                        + "FROM profe_mate p\n"
                        + "JOIN Materias m ON p.id_materia = m.id_materia\n"
                        + "JOIN curso_mate cm ON m.id_materia = cm.id_materia\n"
                        + "JOIN profe_cursos pc ON cm.id_curso = pc.id_curso\n"
                        + "JOIN Cursos c ON pc.id_curso = c.id_curso\n"
                        + "WHERE p.id_profe = " + id_profe + " AND c.id_curso = " + cursoSelecionado + ";");

                while (resultado2.next()) {
                    cmbMateria.addItem(resultado2.getString("materia"));

                }

            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private int IdMateria() {
        int idMateria = -1; // Valor por defecto en caso de que no se encuentre el id
        String nombreMateria = (String) cmbMateria.getSelectedItem();
        Conexion conexion = new Conexion();
        Connection conectado = conexion.Conectar();

        try {
            Statement statement = conectado.createStatement();
            ResultSet resultado = statement.executeQuery("SELECT id_materia FROM Materias WHERE materia = '" + nombreMateria + "'");

            if (resultado.next()) {
                idMateria = resultado.getInt("id_materia");
            }

        } catch (SQLException ex) {
            Logger.getLogger(PublicarNotas.class.getName()).log(Level.SEVERE, null, ex);
        }

        return idMateria;
    }

    private void GuardarCambiosEnBD() {
        Conexion conexion = new Conexion();
        Connection conectado = conexion.Conectar();

        try {
            for (Map.Entry<String, int[]> entry : cambios.entrySet()) {
                String matricula = entry.getKey();
                int[] notas = entry.getValue();
                int idEstu = obtenerIdEstuPorMatricula(matricula);

                if (idEstu == -1) {
                    System.out.println("Error: No se encontró el id_estu para la matrícula " + matricula);
                    continue;
                }

                int idMateria = IdMateria();
                int idProfe = ReturnIdProfe(); // Asegúrate de que esto devuelve el id_profe correcto

                // Formatear la fecha actual
                String fechaPublicacion = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

                String checkQuery = "SELECT COUNT(*) FROM notas WHERE id_estu = " + idEstu + " AND id_materia = " + idMateria;
                Statement statement = conectado.createStatement();
                ResultSet rs = statement.executeQuery(checkQuery);
                rs.next();
                int count = rs.getInt(1);

                if (count == 0) {
                    // Insertar nuevo registro si no existe
                    String insertQuery = "INSERT INTO notas (id_estu, id_materia, id_profesor, nota_p1, nota_p2, nota_p3, nota_p4, fecha_publicacion) VALUES ("
                            + idEstu + ", " + idMateria + ", " + idProfe + ", " + notas[0] + ", " + notas[1] + ", " + notas[2] + ", " + notas[3] + ", '" + fechaPublicacion + "')";
                    statement.executeUpdate(insertQuery);
                } else {
                    // Actualizar registro existente
                    String updateQuery = "UPDATE notas SET nota_p1 = " + notas[0] + ", nota_p2 = " + notas[1] + ", nota_p3 = " + notas[2] + ", nota_p4 = " + notas[3]
                            + " WHERE id_estu = " + idEstu + " AND id_materia = " + idMateria;
                    statement.executeUpdate(updateQuery);
                }
            }

            System.out.println("Cambios guardados correctamente.");
        } catch (SQLException ex) {
            Logger.getLogger(PublicarNotas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private int obtenerIdEstuPorMatricula(String matricula) {
        Conexion conexion = new Conexion();
        Connection conectado = conexion.Conectar();

        try {
            String query = "SELECT id_estu FROM estudiantes WHERE matricula = '" + matricula + "'";
            Statement statement = conectado.createStatement();
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                return rs.getInt("id_estu");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PublicarNotas.class.getName()).log(Level.SEVERE, null, ex);
        }

        return -1; // Retorna un valor inválido si no se encuentra el id_estu
    }

    private void SetIdProfe(int id_profe) {
        this.id_profe = id_profe;
    }

    private int ReturnIdProfe() {
        return id_profe;
    }

    public PublicarNotas(Usuario data2) {
        initComponents();

        SetIdProfe(data2.getIdPerfil());
        System.out.println(ReturnIdProfe());
        mostrarCursosCMB(ReturnIdProfe());
        Tabla(CursoSelecionado(), IdMateria());
        agregarTableModelListener();
        Tabla.getTableHeader().setOpaque(false);
        Tabla.getTableHeader().setBackground(new Color(0x00ADB5));
        Tabla.getTableHeader().setForeground(new Color(0xFFFFFF));
        Tabla.getTableHeader().setFont(new Font("Poppins Medium", Font.PLAIN, 14));
        Tabla.setRowHeight(25);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSPanelForma1 = new rojeru_san.rspanel.RSPanelForma();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cmbCursos = new javax.swing.JComboBox<>();
        labelMateria = new javax.swing.JLabel();
        cmbMateria = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        btnEditar = new rojeru_san.rsbutton.RSButtonRound();

        setClosable(true);

        rSPanelForma1.setBackground(new java.awt.Color(238, 238, 238));

        jScrollPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(238, 238, 238), 3, true));
        jScrollPane1.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jScrollPane1.setOpaque(true);

        Tabla.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Lengua española", null, null, null, null},
                {"Matematicas", null, null, null, null},
                {"Naturales", null, null, null, null},
                {"Sociales", null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Materias", "Periodo 1", "Periodo 2", "Periodo 3", "Periodo 4"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabla.setFocusable(false);
        Tabla.setGridColor(new java.awt.Color(204, 204, 204));
        Tabla.setOpaque(false);
        Tabla.setRowHeight(25);
        Tabla.setSelectionBackground(new java.awt.Color(204, 204, 204));
        Tabla.setSelectionForeground(new java.awt.Color(51, 51, 51));
        Tabla.setShowGrid(false);
        Tabla.setShowHorizontalLines(true);
        Tabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(Tabla);

        jLabel2.setFont(new java.awt.Font("Poppins Medium", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Seleccione Curso");

        cmbCursos.setBackground(new java.awt.Color(238, 238, 238));
        cmbCursos.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        cmbCursos.setForeground(new java.awt.Color(51, 51, 51));
        cmbCursos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));
        cmbCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCursosActionPerformed(evt);
            }
        });

        labelMateria.setFont(new java.awt.Font("Poppins Medium", 1, 14)); // NOI18N
        labelMateria.setForeground(new java.awt.Color(51, 51, 51));
        labelMateria.setText("Seleccione Materia");

        cmbMateria.setBackground(new java.awt.Color(238, 238, 238));
        cmbMateria.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        cmbMateria.setForeground(new java.awt.Color(51, 51, 51));
        cmbMateria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));
        cmbMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMateriaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Poppins Black", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("PUBLICAR NOTA");

        btnEditar.setBackground(new java.awt.Color(0, 173, 181));
        btnEditar.setText("GUARDAR CAMBIOS");
        btnEditar.setColorHover(new java.awt.Color(2, 133, 139));
        btnEditar.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rSPanelForma1Layout = new javax.swing.GroupLayout(rSPanelForma1);
        rSPanelForma1.setLayout(rSPanelForma1Layout);
        rSPanelForma1Layout.setHorizontalGroup(
            rSPanelForma1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelForma1Layout.createSequentialGroup()
                .addGroup(rSPanelForma1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(rSPanelForma1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, rSPanelForma1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(rSPanelForma1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(rSPanelForma1Layout.createSequentialGroup()
                                .addGroup(rSPanelForma1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(rSPanelForma1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(rSPanelForma1Layout.createSequentialGroup()
                                        .addComponent(cmbMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        rSPanelForma1Layout.setVerticalGroup(
            rSPanelForma1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelForma1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel3)
                .addGap(36, 36, 36)
                .addGroup(rSPanelForma1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rSPanelForma1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rSPanelForma1, javax.swing.GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rSPanelForma1, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCursosActionPerformed

        cmbMateria.setEnabled(true);
        mostrarMateriasCMB(ReturnIdProfe());

        Tabla(CursoSelecionado(), IdMateria());

    }//GEN-LAST:event_cmbCursosActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        GuardarCambiosEnBD();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void cmbMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMateriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMateriaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla;
    private rojeru_san.rsbutton.RSButtonRound btnEditar;
    private javax.swing.JComboBox<String> cmbCursos;
    private javax.swing.JComboBox<String> cmbMateria;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelMateria;
    private rojeru_san.rspanel.RSPanelForma rSPanelForma1;
    // End of variables declaration//GEN-END:variables
}
