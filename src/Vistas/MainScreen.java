package Vistas;

import Controller.*;
import java.awt.*;
import javax.swing.ImageIcon;

public class MainScreen extends javax.swing.JFrame {

    int mouseX;
    int mouseY;
    boolean estadoA = false;
    boolean estadoM = false;
    int num = 90;
    int num2 = 100;
    int pro = (num + num2) / 2;
    Conexion cx = new Conexion();

    public MainScreen() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/IMG/IconoSplash.png")).getImage());
        setLocationRelativeTo(null);
        EstadoMenuAgregar(false);
        EstadoMenuModificar(false);
        AnimacionPromedio();
    }

    private void AnimacionPromedio() {
        prgPromedio.setMaximum(100);
        
        for(int i = 0; i >= pro; i++){
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
                //System.out.println("Menu Agregar toggled. Estado: " + estadoA);
            }
            
            case 2 -> {
                estadoM = !estadoM;
                EstadoMenuModificar(estadoM);
                //System.out.println("Menu Modificar toggled. Estado: " + estadoM);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBase = new rojeru_san.rspanel.RSPanelGradiente();
        pantalla = new javax.swing.JDesktopPane();
        pnl = new LIB.JPanelRound();
        pnlPromedio2 = new LIB.JPanelRound();
        prgPromedio = new rojeru_san.rsprogress.RSProgressCircleAnimated();
        pnlPromedio3 = new LIB.JPanelRound();
        prgPromedio2 = new rojeru_san.rsprogress.RSProgressCircle();
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
        pnlBarra = new rojeru_san.rspanel.RSPanelGradiente();
        btnCerrar = new rojeru_san.complementos.RSButtonHover();
        btnMax = new rojeru_san.complementos.RSButtonHover();
        btnMin = new rojeru_san.complementos.RSButtonHover();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        pnlBase.setColorPrimario(new java.awt.Color(182, 223, 225));
        pnlBase.setColorSecundario(new java.awt.Color(216, 216, 216));

        pantalla.setOpaque(false);

        pnl.setBackground(new java.awt.Color(238, 238, 238));
        pnl.setOpaque(true);

        javax.swing.GroupLayout pnlLayout = new javax.swing.GroupLayout(pnl);
        pnl.setLayout(pnlLayout);
        pnlLayout.setHorizontalGroup(
            pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1092, Short.MAX_VALUE)
        );
        pnlLayout.setVerticalGroup(
            pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );

        pnlPromedio2.setBackground(new java.awt.Color(238, 238, 238));
        pnlPromedio2.setOpaque(true);

        prgPromedio.setForeground(new java.awt.Color(0, 173, 181));
        prgPromedio.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        prgPromedio.setName(""); // NOI18N
        prgPromedio.setString("90");

        javax.swing.GroupLayout pnlPromedio2Layout = new javax.swing.GroupLayout(pnlPromedio2);
        pnlPromedio2.setLayout(pnlPromedio2Layout);
        pnlPromedio2Layout.setHorizontalGroup(
            pnlPromedio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPromedio2Layout.createSequentialGroup()
                .addContainerGap(306, Short.MAX_VALUE)
                .addComponent(prgPromedio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );
        pnlPromedio2Layout.setVerticalGroup(
            pnlPromedio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPromedio2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(prgPromedio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pnlPromedio3.setBackground(new java.awt.Color(238, 238, 238));
        pnlPromedio3.setOpaque(true);

        prgPromedio2.setForeground(new java.awt.Color(0, 173, 181));
        prgPromedio2.setValue(90);
        prgPromedio2.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        prgPromedio2.setString("90");

        javax.swing.GroupLayout pnlPromedio3Layout = new javax.swing.GroupLayout(pnlPromedio3);
        pnlPromedio3.setLayout(pnlPromedio3Layout);
        pnlPromedio3Layout.setHorizontalGroup(
            pnlPromedio3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPromedio3Layout.createSequentialGroup()
                .addContainerGap(346, Short.MAX_VALUE)
                .addComponent(prgPromedio2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        pnlPromedio3Layout.setVerticalGroup(
            pnlPromedio3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPromedio3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(prgPromedio2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pantalla.setLayer(pnl, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pantalla.setLayer(pnlPromedio2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pantalla.setLayer(pnlPromedio3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout pantallaLayout = new javax.swing.GroupLayout(pantalla);
        pantalla.setLayout(pantallaLayout);
        pantallaLayout.setHorizontalGroup(
            pantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pantallaLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(pantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pantallaLayout.createSequentialGroup()
                        .addComponent(pnlPromedio2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlPromedio3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13))
        );
        pantallaLayout.setVerticalGroup(
            pantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pantallaLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlPromedio2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlPromedio3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlMenu.setColorPrimario(new java.awt.Color(0, 173, 181));
        pnlMenu.setColorSecundario(new java.awt.Color(0, 173, 181));

        lblLogo.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        lblLogo.setForeground(new java.awt.Color(238, 238, 238));
        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Logoblanco.png"))); // NOI18N

        btnPerfil.setBackground(new java.awt.Color(0, 173, 181));
        btnPerfil.setBorder(null);
        btnPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Iconos/user.png"))); // NOI18N
        btnPerfil.setText("Nombre Apellido");
        btnPerfil.setColorHover(new java.awt.Color(2, 133, 139));
        btnPerfil.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        btnPerfil.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);

        btnNotas.setBackground(new java.awt.Color(0, 173, 181));
        btnNotas.setBorder(null);
        btnNotas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Iconos/user.png"))); // NOI18N
        btnNotas.setText("Ver notas");
        btnNotas.setColorHover(new java.awt.Color(2, 133, 139));
        btnNotas.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        btnNotas.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);

        btnMaterias.setBackground(new java.awt.Color(0, 173, 181));
        btnMaterias.setBorder(null);
        btnMaterias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Iconos/user.png"))); // NOI18N
        btnMaterias.setText("Ver Materias");
        btnMaterias.setColorHover(new java.awt.Color(2, 133, 139));
        btnMaterias.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        btnMaterias.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);

        btnPublicar.setBackground(new java.awt.Color(0, 173, 181));
        btnPublicar.setBorder(null);
        btnPublicar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Iconos/user.png"))); // NOI18N
        btnPublicar.setText("Publicar Notas");
        btnPublicar.setColorHover(new java.awt.Color(2, 133, 139));
        btnPublicar.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        btnPublicar.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);

        btnAgregar.setBackground(new java.awt.Color(0, 173, 181));
        btnAgregar.setBorder(null);
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Iconos/user.png"))); // NOI18N
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
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Iconos/user.png"))); // NOI18N
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
        btnMoMat.setText("Materias");
        btnMoMat.setColorHover(new java.awt.Color(2, 133, 139));
        btnMoMat.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N

        btnMoProf.setBackground(new java.awt.Color(0, 173, 181));
        btnMoProf.setBorder(null);
        btnMoProf.setText("Profesores");
        btnMoProf.setColorHover(new java.awt.Color(2, 133, 139));
        btnMoProf.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N

        btnMoEst.setBackground(new java.awt.Color(0, 173, 181));
        btnMoEst.setBorder(null);
        btnMoEst.setText("Estudiantes");
        btnMoEst.setColorHover(new java.awt.Color(2, 133, 139));
        btnMoEst.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        btnMoEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoEstActionPerformed(evt);
            }
        });

        btnAgEst.setBackground(new java.awt.Color(0, 173, 181));
        btnAgEst.setBorder(null);
        btnAgEst.setText("Estudiantes");
        btnAgEst.setColorHover(new java.awt.Color(2, 133, 139));
        btnAgEst.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        btnAgEst.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnAgEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgEstActionPerformed(evt);
            }
        });

        btnAgProf.setBackground(new java.awt.Color(0, 173, 181));
        btnAgProf.setBorder(null);
        btnAgProf.setText("Profesores");
        btnAgProf.setColorHover(new java.awt.Color(2, 133, 139));
        btnAgProf.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        btnAgProf.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnAgProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgProfActionPerformed(evt);
            }
        });

        btnAgMat.setBackground(new java.awt.Color(0, 173, 181));
        btnAgMat.setBorder(null);
        btnAgMat.setText("Materias");
        btnAgMat.setColorHover(new java.awt.Color(2, 133, 139));
        btnAgMat.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        btnAgMat.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        lblGif.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        lblGif.setForeground(new java.awt.Color(238, 238, 238));
        lblGif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Iconos/user.png"))); // NOI18N

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnMoEst, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                .addComponent(btnMoProf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(btnAgProf, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                .addComponent(btnAgMat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                .addComponent(btnMoMat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addComponent(btnAgEst, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))
                    .addComponent(btnPublicar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMaterias, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNotas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPerfil, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlMenuLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblGif, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(lblLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        javax.swing.GroupLayout pnlBarraLayout = new javax.swing.GroupLayout(pnlBarra);
        pnlBarra.setLayout(pnlBarraLayout);
        pnlBarraLayout.setHorizontalGroup(
            pnlBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBarraLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnMin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnMax, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlBarraLayout.setVerticalGroup(
            pnlBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBarraLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnlBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMax, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
        pantalla.add(age);
        age.show();
    }//GEN-LAST:event_btnAgEstActionPerformed

    private void btnMoEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoEstActionPerformed
        Administracion admin = new Administracion();
        admin.GenerarMatricula("estudiantes", "id_estu");
        System.out.println(admin.mastricula);
    }//GEN-LAST:event_btnMoEstActionPerformed

    private void btnAgProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgProfActionPerformed

    }//GEN-LAST:event_btnAgProfActionPerformed

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
    private rojeru_san.rsbutton.RSButtonRoundEffect btnMaterias;
    private rojeru_san.complementos.RSButtonHover btnMax;
    private rojeru_san.complementos.RSButtonHover btnMin;
    private rojeru_san.rsbutton.RSButtonRoundEffect btnMoEst;
    private rojeru_san.rsbutton.RSButtonRoundEffect btnMoMat;
    private rojeru_san.rsbutton.RSButtonRoundEffect btnMoProf;
    private rojeru_san.rsbutton.RSButtonRoundEffect btnModificar;
    private rojeru_san.rsbutton.RSButtonRoundEffect btnNotas;
    private rojeru_san.rsbutton.RSButtonRoundEffect btnPerfil;
    private rojeru_san.rsbutton.RSButtonRoundEffect btnPublicar;
    private javax.swing.JLabel lblGif;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JDesktopPane pantalla;
    private LIB.JPanelRound pnl;
    private rojeru_san.rspanel.RSPanelGradiente pnlBarra;
    private rojeru_san.rspanel.RSPanelGradiente pnlBase;
    private rojeru_san.rspanel.RSPanelGradiente pnlMenu;
    private LIB.JPanelRound pnlPromedio2;
    private LIB.JPanelRound pnlPromedio3;
    private rojeru_san.rsprogress.RSProgressCircleAnimated prgPromedio;
    private rojeru_san.rsprogress.RSProgressCircle prgPromedio2;
    // End of variables declaration//GEN-END:variables
}
