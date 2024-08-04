package Vistas;

import Controller.*;
import java.awt.*;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class MainScreen extends javax.swing.JFrame {

    int mouseX;
    int mouseY;
    boolean estadoA = false;
    boolean estadoM = false;
    boolean estado = false;
    int num = 90;
    int num2 = 100;
    int pro = (num + num2) / 2;
    Conexion cx = new Conexion();
    
    private void Resolucion(){
        // Obtiene el entorno gráfico
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        // Obtiene el dispositivo gráfico principal (la pantalla principal)
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        // Obtiene la configuración de la pantalla
        DisplayMode dm = gd.getDisplayMode();
        // Obtiene el ancho y el alto de la pantalla
        int width = dm.getWidth();
        int height = dm.getHeight();
        String rs = width + "-" + height;
        System.out.println(rs);
    }

    public void AjustarVentana() {
        // Obtiene la resolución de la pantalla
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        // Calcula el tamaño deseado de la ventana como un porcentaje de la pantalla
        int windowWidth = (int) (screenWidth * 0.8); // 80% del ancho de la pantalla
        int windowHeight = (int) (screenHeight * 0.8); // 80% de la altura de la pantalla

        // Establece el tamaño de la ventana
        this.setSize(windowWidth, windowHeight);

        // Centra la ventana en la pantalla
        this.setLocationRelativeTo(null);
    }
    
    private void AnimacionPromedio() {
        prgPromedio.setMaximum(100);

        for (int i = 0; i >= pro; i++) {
            prgPromedio.setValue(i);
        }
        prgPromedio.setString(Integer.toString(pro));
        prgPromedio.setAnimated(false);
    }

    private void EstadoMenuAgregar(boolean visible) {
        btnAgEst.setVisible(visible);
        btnAgProf.setVisible(visible);
        btnAgMat.setVisible(visible);
    }

    private void EstadoMenuModificar(boolean visible) {
        btnMoEst.setVisible(visible);
        btnMoProf.setVisible(visible);
        btnMoMat.setVisible(visible);
    }

    private void MostrarSubMenu(int menu) {
        switch (menu) {
            case 1 -> {
                estadoA = !estadoA;
                EstadoMenuAgregar(estadoA);
                if (!estadoA) {
                    btnAgregar.setIcon(new ImageIcon("src\\IMG\\Iconos\\plusb.png"));
                } else {
                    btnAgregar.setIcon(new ImageIcon("src\\IMG\\Iconos\\minusb.png"));
                }
            }

            case 2 -> {
                estadoM = !estadoM;
                EstadoMenuModificar(estadoM);
                if (!estadoM) {
                    btnModificar.setIcon(new ImageIcon("src\\IMG\\Iconos\\plusb.png"));
                } else {
                    btnModificar.setIcon(new ImageIcon("src\\IMG\\Iconos\\minusb.png"));
                }
            }
        }
    }
    
    public MainScreen() {
        initComponents();
        setLocationRelativeTo(null);
        EstadoMenuAgregar(false);
        EstadoMenuModificar(false);
        //AnimacionPromedio();
        //AjustarVentana();
        jTable1.getTableHeader().setOpaque(false);
        jTable1.getTableHeader().setBackground(new Color(0x00ADB5));
        jTable1.getTableHeader().setForeground(new Color(0xFFFFFF));
        jTable1.getTableHeader().setFont(new Font("Poppins Medium", Font.PLAIN, 14));
        jTable1.setRowHeight(25);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBase = new rojeru_san.rspanel.RSPanelGradiente();
        pantalla = new javax.swing.JDesktopPane();
        pnlNota = new LIB.JPanelRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        pnlPromedioP = new LIB.JPanelRound();
        prgPromedio = new rojeru_san.rsprogress.RSProgressCircleAnimated();
        lblProgresoP = new javax.swing.JLabel();
        lblSubP = new javax.swing.JLabel();
        pnlPromedioC = new LIB.JPanelRound();
        lblProgresoC = new javax.swing.JLabel();
        lblSubC = new javax.swing.JLabel();
        prgPromedio1 = new rojeru_san.rsprogress.RSProgressCircleAnimated();
        jPanelRound2 = new LIB.JPanelRound();
        pnlMenu = new rojeru_san.rspanel.RSPanelGradiente();
        lblLogo = new javax.swing.JLabel();
        btnPerfil = new rojeru_san.rsbutton.RSButtonRoundEffect();
        btnNotas = new rojeru_san.rsbutton.RSButtonRoundEffect();
        btnMaterias = new rojeru_san.rsbutton.RSButtonRoundEffect();
        btnPublicar = new rojeru_san.rsbutton.RSButtonRoundEffect();
        btnAgregar = new rojeru_san.rsbutton.RSButtonRoundEffect();
        btnModificar = new rojeru_san.rsbutton.RSButtonRoundEffect();
        btnMoMat = new rojeru_san.rsbutton.RSButtonRoundEffect();
        btnMoProf = new rojeru_san.rsbutton.RSButtonRoundEffect();
        btnMoEst = new rojeru_san.rsbutton.RSButtonRoundEffect();
        btnAgEst = new rojeru_san.rsbutton.RSButtonRoundEffect();
        btnAgProf = new rojeru_san.rsbutton.RSButtonRoundEffect();
        btnAgMat = new rojeru_san.rsbutton.RSButtonRoundEffect();
        lblGif = new javax.swing.JLabel();
        btnSalir = new rojeru_san.rsbutton.RSButtonRoundEffect();
        pnlBarra = new rojeru_san.rspanel.RSPanelGradiente();
        btnCerrar = new rojeru_san.complementos.RSButtonHover();
        btnMax = new rojeru_san.complementos.RSButtonHover();
        btnMin = new rojeru_san.complementos.RSButtonHover();
        btnEstado = new rojeru_san.rsbutton.RSButtonRound();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        pnlBase.setColorPrimario(new java.awt.Color(182, 223, 225));
        pnlBase.setColorSecundario(new java.awt.Color(216, 216, 216));

        pantalla.setOpaque(false);

        pnlNota.setBackground(new java.awt.Color(238, 238, 238));
        pnlNota.setOpaque(true);

        jScrollPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(238, 238, 238), 3, true));
        jScrollPane1.setFont(new java.awt.Font("Poppins Medium", 1, 12)); // NOI18N
        jScrollPane1.setOpaque(true);

        jTable1.setFont(new java.awt.Font("Poppins Medium", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.setFocusable(false);
        jTable1.setGridColor(new java.awt.Color(204, 204, 204));
        jTable1.setOpaque(false);
        jTable1.setRowHeight(25);
        jTable1.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jTable1.setSelectionForeground(new java.awt.Color(51, 51, 51));
        jTable1.setShowGrid(false);
        jTable1.setShowHorizontalLines(true);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout pnlNotaLayout = new javax.swing.GroupLayout(pnlNota);
        pnlNota.setLayout(pnlNotaLayout);
        pnlNotaLayout.setHorizontalGroup(
            pnlNotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNotaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        pnlNotaLayout.setVerticalGroup(
            pnlNotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNotaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlPromedioP.setBackground(new java.awt.Color(238, 238, 238));
        pnlPromedioP.setOpaque(true);
        pnlPromedioP.setPreferredSize(new java.awt.Dimension(555, 168));

        prgPromedio.setForeground(new java.awt.Color(0, 173, 181));
        prgPromedio.setAnimated(false);
        prgPromedio.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        prgPromedio.setName(""); // NOI18N
        prgPromedio.setString("90");

        lblProgresoP.setFont(new java.awt.Font("Poppins Medium", 0, 24)); // NOI18N
        lblProgresoP.setForeground(new java.awt.Color(51, 51, 51));
        lblProgresoP.setText("PROGRESO DEL PERIODO");

        lblSubP.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        lblSubP.setForeground(new java.awt.Color(51, 51, 51));
        lblSubP.setText("periodo actual");
        lblSubP.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout pnlPromedioPLayout = new javax.swing.GroupLayout(pnlPromedioP);
        pnlPromedioP.setLayout(pnlPromedioPLayout);
        pnlPromedioPLayout.setHorizontalGroup(
            pnlPromedioPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPromedioPLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(pnlPromedioPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblProgresoP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSubP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(54, 54, 54)
                .addComponent(prgPromedio, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addGap(41, 41, 41))
        );
        pnlPromedioPLayout.setVerticalGroup(
            pnlPromedioPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPromedioPLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblProgresoP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(lblSubP, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addGap(91, 91, 91))
            .addGroup(pnlPromedioPLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(prgPromedio, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        pnlPromedioC.setBackground(new java.awt.Color(238, 238, 238));
        pnlPromedioC.setOpaque(true);

        lblProgresoC.setFont(new java.awt.Font("Poppins Medium", 0, 24)); // NOI18N
        lblProgresoC.setForeground(new java.awt.Color(51, 51, 51));
        lblProgresoC.setText("PROGRESO DEL CURSO");

        lblSubC.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        lblSubC.setForeground(new java.awt.Color(51, 51, 51));
        lblSubC.setText("Periodo anterior");
        lblSubC.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        prgPromedio1.setForeground(new java.awt.Color(0, 173, 181));
        prgPromedio1.setAnimated(false);
        prgPromedio1.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        prgPromedio1.setName(""); // NOI18N
        prgPromedio1.setString("90");

        javax.swing.GroupLayout pnlPromedioCLayout = new javax.swing.GroupLayout(pnlPromedioC);
        pnlPromedioC.setLayout(pnlPromedioCLayout);
        pnlPromedioCLayout.setHorizontalGroup(
            pnlPromedioCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPromedioCLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnlPromedioCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblProgresoC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlPromedioCLayout.createSequentialGroup()
                        .addComponent(lblSubC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10)))
                .addGap(50, 50, 50)
                .addComponent(prgPromedio1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(41, 41, 41))
        );
        pnlPromedioCLayout.setVerticalGroup(
            pnlPromedioCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPromedioCLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblProgresoC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(lblSubC, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addGap(91, 91, 91))
            .addGroup(pnlPromedioCLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(prgPromedio1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        jPanelRound2.setBackground(new java.awt.Color(238, 238, 238));
        jPanelRound2.setOpaque(true);
        jPanelRound2.setPreferredSize(new java.awt.Dimension(534, 166));

        javax.swing.GroupLayout jPanelRound2Layout = new javax.swing.GroupLayout(jPanelRound2);
        jPanelRound2.setLayout(jPanelRound2Layout);
        jPanelRound2Layout.setHorizontalGroup(
            jPanelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelRound2Layout.setVerticalGroup(
            jPanelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 168, Short.MAX_VALUE)
        );

        pantalla.setLayer(pnlNota, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pantalla.setLayer(pnlPromedioP, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pantalla.setLayer(pnlPromedioC, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pantalla.setLayer(jPanelRound2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout pantallaLayout = new javax.swing.GroupLayout(pantalla);
        pantalla.setLayout(pantallaLayout);
        pantallaLayout.setHorizontalGroup(
            pantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pantallaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, 1109, Short.MAX_VALUE)
                    .addComponent(pnlNota, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pantallaLayout.createSequentialGroup()
                        .addComponent(pnlPromedioP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(20, 20, 20)
                        .addComponent(pnlPromedioC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        pantallaLayout.setVerticalGroup(
            pantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pantallaLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlPromedioP, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                    .addComponent(pnlPromedioC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addComponent(pnlNota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addComponent(jPanelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );

        pnlMenu.setColorPrimario(new java.awt.Color(0, 173, 181));
        pnlMenu.setColorSecundario(new java.awt.Color(0, 173, 181));

        lblLogo.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        lblLogo.setForeground(new java.awt.Color(238, 238, 238));
        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Logoblanco.png"))); // NOI18N

        btnPerfil.setBackground(new java.awt.Color(0, 173, 181));
        btnPerfil.setBorder(null);
        btnPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Iconos/userb.png"))); // NOI18N
        btnPerfil.setText("Nombre Apellido");
        btnPerfil.setColorHover(new java.awt.Color(2, 133, 139));
        btnPerfil.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        btnPerfil.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);

        btnNotas.setBackground(new java.awt.Color(0, 173, 181));
        btnNotas.setBorder(null);
        btnNotas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Iconos/testb.png"))); // NOI18N
        btnNotas.setText("Exportar Notas");
        btnNotas.setColorHover(new java.awt.Color(2, 133, 139));
        btnNotas.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        btnNotas.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);

        btnMaterias.setBackground(new java.awt.Color(0, 173, 181));
        btnMaterias.setBorder(null);
        btnMaterias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Iconos/book.bpng.png"))); // NOI18N
        btnMaterias.setText("Ver Materias");
        btnMaterias.setColorHover(new java.awt.Color(2, 133, 139));
        btnMaterias.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        btnMaterias.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);

        btnPublicar.setBackground(new java.awt.Color(0, 173, 181));
        btnPublicar.setBorder(null);
        btnPublicar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Iconos/editingb.png"))); // NOI18N
        btnPublicar.setText("Publicar Notas");
        btnPublicar.setColorHover(new java.awt.Color(2, 133, 139));
        btnPublicar.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        btnPublicar.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnPublicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPublicarActionPerformed(evt);
            }
        });

        btnAgregar.setBackground(new java.awt.Color(0, 173, 181));
        btnAgregar.setBorder(null);
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Iconos/plusb.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setColorHover(new java.awt.Color(2, 133, 139));
        btnAgregar.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        btnAgregar.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnModificar.setBackground(new java.awt.Color(0, 173, 181));
        btnModificar.setBorder(null);
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Iconos/plusb.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setColorHover(new java.awt.Color(2, 133, 139));
        btnModificar.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        btnModificar.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnMoMat.setBackground(new java.awt.Color(0, 173, 181));
        btnMoMat.setBorder(null);
        btnMoMat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Iconos/circle.png"))); // NOI18N
        btnMoMat.setText("Materias");
        btnMoMat.setColorHover(new java.awt.Color(2, 133, 139));
        btnMoMat.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        btnMoMat.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);

        btnMoProf.setBackground(new java.awt.Color(0, 173, 181));
        btnMoProf.setBorder(null);
        btnMoProf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Iconos/circle.png"))); // NOI18N
        btnMoProf.setText("Profesores");
        btnMoProf.setColorHover(new java.awt.Color(2, 133, 139));
        btnMoProf.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        btnMoProf.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);

        btnMoEst.setBackground(new java.awt.Color(0, 173, 181));
        btnMoEst.setBorder(null);
        btnMoEst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Iconos/circle.png"))); // NOI18N
        btnMoEst.setText("Estudiantes");
        btnMoEst.setColorHover(new java.awt.Color(2, 133, 139));
        btnMoEst.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        btnMoEst.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnMoEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoEstActionPerformed(evt);
            }
        });

        btnAgEst.setBackground(new java.awt.Color(0, 173, 181));
        btnAgEst.setBorder(null);
        btnAgEst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Iconos/circle.png"))); // NOI18N
        btnAgEst.setText("Estudiantes");
        btnAgEst.setColorHover(new java.awt.Color(2, 133, 139));
        btnAgEst.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        btnAgEst.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnAgEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgEstActionPerformed(evt);
            }
        });

        btnAgProf.setBackground(new java.awt.Color(0, 173, 181));
        btnAgProf.setBorder(null);
        btnAgProf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Iconos/circle.png"))); // NOI18N
        btnAgProf.setText("Profesores");
        btnAgProf.setColorHover(new java.awt.Color(2, 133, 139));
        btnAgProf.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        btnAgProf.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnAgProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgProfActionPerformed(evt);
            }
        });

        btnAgMat.setBackground(new java.awt.Color(0, 173, 181));
        btnAgMat.setBorder(null);
        btnAgMat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Iconos/circle.png"))); // NOI18N
        btnAgMat.setText("Materias");
        btnAgMat.setColorHover(new java.awt.Color(2, 133, 139));
        btnAgMat.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        btnAgMat.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);

        lblGif.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        lblGif.setForeground(new java.awt.Color(238, 238, 238));
        lblGif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Iconos/user.png"))); // NOI18N

        btnSalir.setBackground(new java.awt.Color(0, 173, 181));
        btnSalir.setBorder(null);
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Iconos/logout.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setColorHover(new java.awt.Color(2, 133, 139));
        btnSalir.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        btnSalir.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblGif, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlMenuLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnMaterias, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(btnAgregar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(btnPublicar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(btnNotas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(btnPerfil, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(btnModificar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(lblLogo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                    .addComponent(btnSalir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlMenuLayout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnAgProf, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                        .addComponent(btnAgMat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                                    .addComponent(btnAgEst, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(22, 22, 22)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlMenuLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnMoEst, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnMoProf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnMoMat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblLogo)
                .addGap(30, 30, 30)
                .addComponent(btnPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNotas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPublicar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgEst, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgProf, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(btnAgMat, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMoEst, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMoProf, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(btnMoMat, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 193, Short.MAX_VALUE)
                .addComponent(lblGif, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlBarra.setColorPrimario(new java.awt.Color(182, 223, 225));
        pnlBarra.setColorSecundario(new java.awt.Color(216, 216, 216));
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

        btnCerrar.setBackground(new java.awt.Color(216, 216, 216));
        btnCerrar.setBorder(null);
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Iconos/cerrar2.png"))); // NOI18N
        btnCerrar.setColorHover(new java.awt.Color(251, 77, 77));
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        btnMax.setBackground(new java.awt.Color(216, 216, 216));
        btnMax.setBorder(null);
        btnMax.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Iconos/maximize.png"))); // NOI18N
        btnMax.setColorHover(new java.awt.Color(195, 192, 192));
        btnMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaxActionPerformed(evt);
            }
        });

        btnMin.setBackground(new java.awt.Color(216, 216, 216));
        btnMin.setBorder(null);
        btnMin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Iconos/minus.png"))); // NOI18N
        btnMin.setColorHover(new java.awt.Color(195, 192, 192));
        btnMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinActionPerformed(evt);
            }
        });

        btnEstado.setBackground(new java.awt.Color(216, 216, 216));
        btnEstado.setBorder(null);
        btnEstado.setForeground(new java.awt.Color(51, 51, 51));
        btnEstado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Iconos/circleOn.png"))); // NOI18N
        btnEstado.setText("Estado");
        btnEstado.setColorHover(new java.awt.Color(195, 192, 192));
        btnEstado.setColorText(new java.awt.Color(51, 51, 51));
        btnEstado.setColorTextHover(new java.awt.Color(51, 51, 51));
        btnEstado.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        btnEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBarraLayout = new javax.swing.GroupLayout(pnlBarra);
        pnlBarra.setLayout(pnlBarraLayout);
        pnlBarraLayout.setHorizontalGroup(
            pnlBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBarraLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnMax, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlBarraLayout.setVerticalGroup(
            pnlBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
            .addComponent(btnMax, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(btnMin, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(btnEstado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlBaseLayout = new javax.swing.GroupLayout(pnlBase);
        pnlBase.setLayout(pnlBaseLayout);
        pnlBaseLayout.setHorizontalGroup(
            pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBaseLayout.createSequentialGroup()
                .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pantalla))
            .addComponent(pnlBarra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlBaseLayout.setVerticalGroup(
            pnlBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlBaseLayout.createSequentialGroup()
                .addComponent(pnlBarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pantalla))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBase, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBase, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnlBarraMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBarraMouseDragged
        int pX = evt.getXOnScreen();
        int pY = evt.getYOnScreen();

        this.setLocation(pX - mouseX, pY - mouseY);
    }//GEN-LAST:event_pnlBarraMouseDragged

    private void pnlBarraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBarraMousePressed
        mouseX = evt.getX();
        mouseY = evt.getY();
        setExtendedState(NORMAL);
    }//GEN-LAST:event_pnlBarraMousePressed

    private void btnMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinActionPerformed
        setExtendedState(ICONIFIED);
    }//GEN-LAST:event_btnMinActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        //this.dispose();
        System.exit(0);
        cx.desconectar();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaxActionPerformed
        //Dectetando que accion debe de realizar
        if (getExtendedState() == MAXIMIZED_BOTH) {
            setExtendedState(NORMAL);
        } else {
            setExtendedState(MAXIMIZED_BOTH);
        }
    }//GEN-LAST:event_btnMaxActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        MostrarSubMenu(1);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        MostrarSubMenu(2);
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnAgEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgEstActionPerformed
        Agregar age = new Agregar();
        if (!estado) {
            btnAgEst.setIcon(new ImageIcon("src\\IMG\\Iconos\\circle2.png"));
            estado = !estado;
            //age.show();
            pantalla.add(age);
            age.show();
            
        } else {
            btnAgEst.setIcon(new ImageIcon("src\\IMG\\Iconos\\circle.png"));
            estado = !estado;
            pantalla.remove(age);
            age.dispose();
        }
    }//GEN-LAST:event_btnAgEstActionPerformed

    private void btnAgProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgProfActionPerformed

    }//GEN-LAST:event_btnAgProfActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Seguro que desea salir?", "Confirmar accion", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION){
            this.dispose();
            Login log = new Login();
            log.setVisible(true); 
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnMoEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoEstActionPerformed
        
    }//GEN-LAST:event_btnMoEstActionPerformed

    private void btnEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadoActionPerformed
        if (!estado) {
            btnEstado.setIcon(new ImageIcon("src\\IMG\\Iconos\\circleOFF.png"));
            estado = !estado;
            btnPerfil.setEnabled(false);
            
        } else {
            btnEstado.setIcon(new ImageIcon("src\\IMG\\Iconos\\circleON.png"));
            estado = !estado;
            btnPerfil.setEnabled(true);
        }
    }//GEN-LAST:event_btnEstadoActionPerformed

    private void btnPublicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPublicarActionPerformed
       PublicarNotas pnotas = new PublicarNotas();
       pantalla.add(pnotas);
       pnotas.show();
    }//GEN-LAST:event_btnPublicarActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.rsbutton.RSButtonRoundEffect btnAgEst;
    private rojeru_san.rsbutton.RSButtonRoundEffect btnAgMat;
    private rojeru_san.rsbutton.RSButtonRoundEffect btnAgProf;
    private rojeru_san.rsbutton.RSButtonRoundEffect btnAgregar;
    private rojeru_san.complementos.RSButtonHover btnCerrar;
    private rojeru_san.rsbutton.RSButtonRound btnEstado;
    private rojeru_san.rsbutton.RSButtonRoundEffect btnMaterias;
    private rojeru_san.complementos.RSButtonHover btnMax;
    private rojeru_san.complementos.RSButtonHover btnMin;
    private rojeru_san.rsbutton.RSButtonRoundEffect btnMoEst;
    private rojeru_san.rsbutton.RSButtonRoundEffect btnMoMat;
    private rojeru_san.rsbutton.RSButtonRoundEffect btnMoProf;
    private rojeru_san.rsbutton.RSButtonRoundEffect btnModificar;
    private rojeru_san.rsbutton.RSButtonRoundEffect btnNotas;
    public rojeru_san.rsbutton.RSButtonRoundEffect btnPerfil;
    private rojeru_san.rsbutton.RSButtonRoundEffect btnPublicar;
    private rojeru_san.rsbutton.RSButtonRoundEffect btnSalir;
    private LIB.JPanelRound jPanelRound2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblGif;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblProgresoC;
    private javax.swing.JLabel lblProgresoP;
    private javax.swing.JLabel lblSubC;
    private javax.swing.JLabel lblSubP;
    private javax.swing.JDesktopPane pantalla;
    private rojeru_san.rspanel.RSPanelGradiente pnlBarra;
    private rojeru_san.rspanel.RSPanelGradiente pnlBase;
    private rojeru_san.rspanel.RSPanelGradiente pnlMenu;
    private LIB.JPanelRound pnlNota;
    private LIB.JPanelRound pnlPromedioC;
    private LIB.JPanelRound pnlPromedioP;
    private rojeru_san.rsprogress.RSProgressCircleAnimated prgPromedio;
    private rojeru_san.rsprogress.RSProgressCircleAnimated prgPromedio1;
    // End of variables declaration//GEN-END:variables
}