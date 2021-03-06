package Interfaces;

import Clases.ClPrestamos;

public class JIFrameConsultaPrestamos extends javax.swing.JInternalFrame {

    //Objeto de tipo ClPrestamo
    ClPrestamos miPrestamo;

    public JIFrameConsultaPrestamos() {
        initComponents();
        miPrestamo = new ClPrestamos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu2 = new javax.swing.JPopupMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jdBuscar = new javax.swing.JDialog();
        panel2 = new org.edisoncor.gui.panel.Panel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDetalleIndividual = new javax.swing.JTable();
        jToolBar2 = new javax.swing.JToolBar();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        panel6 = new org.edisoncor.gui.panel.Panel();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        panel1 = new org.edisoncor.gui.panel.Panel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPrestamos = new javax.swing.JTable();
        txtBuscador = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jMenuItem3.setText("Ver Detalle");
        jPopupMenu2.add(jMenuItem3);

        panel2.setColorPrimario(new java.awt.Color(50, 116, 53));
        panel2.setColorSecundario(new java.awt.Color(50, 116, 53));

        tblDetalleIndividual.setBackground(new java.awt.Color(58, 145, 64));
        tblDetalleIndividual.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDetalleIndividual.setSelectionBackground(new java.awt.Color(58, 145, 64));
        jScrollPane2.setViewportView(tblDetalleIndividual);

        jToolBar2.setBackground(new java.awt.Color(50, 116, 53));
        jToolBar2.setForeground(new java.awt.Color(50, 116, 53));
        jToolBar2.setRollover(true);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PkIconos/Img32/imgReportes.png"))); // NOI18N
        jButton3.setText("Imprimir");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(jButton3);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PkIconos/Img32/imgCategorias.png"))); // NOI18N
        jButton4.setText("Observación");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(jButton4);

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 983, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jdBuscarLayout = new javax.swing.GroupLayout(jdBuscar.getContentPane());
        jdBuscar.getContentPane().setLayout(jdBuscarLayout);
        jdBuscarLayout.setHorizontalGroup(
            jdBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jdBuscarLayout.setVerticalGroup(
            jdBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdBuscarLayout.createSequentialGroup()
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setClosable(true);
        setIconifiable(true);
        setTitle("Consulta de préstamos");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        panel6.setColorPrimario(new java.awt.Color(50, 116, 53));
        panel6.setColorSecundario(new java.awt.Color(50, 116, 53));

        jToolBar1.setBackground(new java.awt.Color(50, 116, 53));
        jToolBar1.setForeground(new java.awt.Color(50, 116, 53));
        jToolBar1.setRollover(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PkIconos/Img32/imgDetalles.png"))); // NOI18N
        jButton1.setText("Ver Estadística");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PkIconos/Img32/imgReportes.png"))); // NOI18N
        jButton2.setText("Reportes");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton2);

        panel1.setBackground(new java.awt.Color(255, 153, 0));
        panel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Área de consultas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Vrinda", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        panel1.setForeground(new java.awt.Color(255, 255, 255));
        panel1.setColorPrimario(new java.awt.Color(50, 116, 53));
        panel1.setColorSecundario(new java.awt.Color(50, 116, 53));
        panel1.setFont(new java.awt.Font("Vrinda", 0, 12)); // NOI18N

        tablaPrestamos.setBackground(new java.awt.Color(50, 116, 53));
        tablaPrestamos.setFont(new java.awt.Font("Arial Narrow", 0, 16)); // NOI18N
        tablaPrestamos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaPrestamos.setGridColor(new java.awt.Color(255, 255, 255));
        tablaPrestamos.setSelectionBackground(new java.awt.Color(58, 145, 64));
        tablaPrestamos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPrestamosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPrestamos);

        txtBuscador.setBackground(new java.awt.Color(58, 145, 64));
        txtBuscador.setForeground(new java.awt.Color(255, 255, 255));
        txtBuscador.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        txtBuscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscadorKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Vrinda", 0, 12)); // NOI18N
        jLabel4.setText("Buscar por: Nombre");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(679, Short.MAX_VALUE))
            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(402, Short.MAX_VALUE))
            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                    .addContainerGap(41, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jLabel3.setFont(new java.awt.Font("Vrinda", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("UTS Rayón");

        javax.swing.GroupLayout panel6Layout = new javax.swing.GroupLayout(panel6);
        panel6.setLayout(panel6Layout);
        panel6Layout.setHorizontalGroup(
            panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 1104, Short.MAX_VALUE)
                    .addGroup(panel6Layout.createSequentialGroup()
                        .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );
        panel6Layout.setVerticalGroup(
            panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel6Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaPrestamosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPrestamosMouseClicked
        // TODO add your handling code here:
        //Abrimos el JIFrame
        JIFrameDetallePrestamo objDetalle = new JIFrameDetallePrestamo();
        this.getDesktopPane().add(objDetalle);
        objDetalle.setVisible(true);
        //Al seleccionar un registro, capturamos el nombre y luego mostramos la tabla.
        try {
            String nombre = "";
            int fila = this.tablaPrestamos.rowAtPoint(evt.getPoint());
            nombre = this.tablaPrestamos.getValueAt(fila, 1).toString();
            //Mostramos la tabla con el detalle del prestamo de manera individual
            JIFrameDetallePrestamo.tblDetalleIndividual.setModel(miPrestamo.DetallePrestamo(nombre));
        } catch (Exception e) {
            e.getMessage();
        }
    }//GEN-LAST:event_tablaPrestamosMouseClicked

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
        this.tablaPrestamos.setModel(miPrestamo.ConsultarPrestamos(txtBuscador.getText()));
    }//GEN-LAST:event_formInternalFrameOpened

    private void txtBuscadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscadorKeyReleased
        // TODO add your handling code here:
        this.tablaPrestamos.setModel(miPrestamo.ConsultarPrestamos(txtBuscador.getText()));
    }//GEN-LAST:event_txtBuscadorKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JDialog jdBuscar;
    private org.edisoncor.gui.panel.Panel panel1;
    private org.edisoncor.gui.panel.Panel panel2;
    private org.edisoncor.gui.panel.Panel panel6;
    private javax.swing.JTable tablaPrestamos;
    private javax.swing.JTable tblDetalleIndividual;
    private javax.swing.JTextField txtBuscador;
    // End of variables declaration//GEN-END:variables
}
