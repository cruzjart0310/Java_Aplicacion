/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Clases.ClEjemplar;
import Clases.ClGeneradorClaves;
import Clases.validarDatos;
import javax.swing.JOptionPane;
import Clases.ClHoraFecha;
import Clases.ClPrestamos;
import javax.swing.table.DefaultTableModel;
import Clases.ClUsuarios;

/**
 *
 * @author JART CRUZ
 */
public class JIFramePrestamos extends javax.swing.JInternalFrame {

    private DefaultTableModel modelTablaDetallePrestamo;
    //Objetos
    ClUsuarios objUsuario;
    ClPrestamos objPrestamo;
    ClEjemplar objEjemplar;
    String CantLibroPrestamos = "";

    /**
     * Creates new form JIFramePrestamos
     */
    public JIFramePrestamos() {
        initComponents();
        objUsuario = new ClUsuarios();
        objPrestamo = new ClPrestamos();
        objEjemplar = new ClEjemplar();
        this.txtCodigoPrestamo.setText(ClGeneradorClaves.GenerarCodigoPrestamo());
    }

    //funcion para limpiar campos de texto
    public void limpiarCampos() {
        txtClaveUsuario.setText("");
        txtNombre.setText("");
    }

    //Funcion para deshabilitarCampos
    public void deshabilitarBotones() {
        txtClaveUsuario.setEditable(false);
        txtNombre.setEditable(false);
        txtCodigoPrestamo.setEditable(false);
        txtFecha.setEditable(false);
        txtAdministrador.setEditable(false);
    }

    //funcion para limpiar los datos de la tabla
    public void limpiarTabla() {
        try {
            int Fila = 0;
            for (int f = 0; f < modelTablaDetallePrestamo.getColumnCount(); f++) {
                modelTablaDetallePrestamo.removeRow(Fila);
            }
        } catch (Exception ex) {
        }
    }

    //Funcion para insertar en la tabla detalleprestamo
    public void ejecutarPrestamo() {
        //Variables
        String isbnx = "";
        int codigoPrestamo = 0;
        int cantPrestada = 0;
        int ultimoid = ClGeneradorClaves.obtenerUltimoIdPrestamo();
        int noFilas = tblDetPrestamos.getRowCount();

        //Validamos que los campos contengan los datos necesarios
        if (txtClaveUsuario.getText().equals("") || txtNombre.getText().equals("") || noFilas < 1) {
            JOptionPane.showMessageDialog(this, "Rellene todos los campos,o asegurese de \n realizar un préstamo", "Msj.", JOptionPane.WARNING_MESSAGE);

        } else {
            //Ejecutamos la inserción en la tabla Prestamo
            objPrestamo.Pretamo(txtCodigoPrestamo.getText(), txtFecha.getText(), txtClaveUsuario.getText());

            //Recorrer todas las filas encontradas en la tabla
            for (int fila = 0; fila < noFilas; fila++) {
                //Capturamos los valores
                codigoPrestamo = Integer.parseInt(tblDetPrestamos.getValueAt(fila, 0).toString());
                isbnx = tblDetPrestamos.getValueAt(fila, 1).toString();
                cantPrestada = Integer.parseInt(tblDetPrestamos.getValueAt(fila, 3).toString());

                //Ejecutamos la inserción en la tabla detallePrestamo
                objPrestamo.DetallePretamo(codigoPrestamo, isbnx, cantPrestada);
                //Ejecutamos estas lineas para actualizar la cantidadExistente
                objPrestamo.ActualizarExistenciaMin(Integer.parseInt(String.valueOf(tblDetPrestamos.getValueAt(fila, 3))), String.valueOf(tblDetPrestamos.getValueAt(fila, 1)));

            }
            JOptionPane.showMessageDialog(this, "Prestámo ejecutado con éxito.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
            limpiarTabla();
        }
    }

    public boolean VerificarArticuloRegistradoTabla() {
        boolean valor = false;
        if (this.tblDetPrestamos.getRowCount() > 0) {
            int fila = this.tblDetPrestamos.getRowCount();
            
            DefaultTableModel detalle = (DefaultTableModel) this.tblDetPrestamos.getModel();
            DefaultTableModel ejemplar = (DefaultTableModel) this.tblEjemplar.getModel(); 
            
            int val=0;
            
            for (int f = 0; f < fila; f++) {
                        //Validamos que el registro este en la tabla detalle(Esta linea  de codigo no funciona del todo bien)
                if (tblEjemplar.getValueAt(tblEjemplar.getSelectedRow(), 0).equals(String.valueOf(tblEjemplar.getValueAt(f, 0)))) {
                    //JOptionPane.showMessageDialog(this, tblEjemplar.getValueAt(tblEjemplar.getSelectedRow(), 0));
                    valor = true;
                }
            }
        }
        return valor;
    }

    public void ActualizarCantidadProdTabla(String codigo, String cantAPrestar) {
        int sumaCantTabla = 0;
        int fila = this.tblDetPrestamos.getRowCount();
        DefaultTableModel modelo = (DefaultTableModel) this.tblDetPrestamos.getModel();
        for (int f = 0; f < fila; f++) {
            if (codigo.equals(String.valueOf(modelo.getValueAt(f, 1)))) {
                sumaCantTabla = Integer.parseInt(String.valueOf(cantAPrestar)) + Integer.parseInt(String.valueOf(modelo.getValueAt(f, 3)));
                modelo.setValueAt(String.valueOf(sumaCantTabla), f, 3);
                
                //JOptionPane.showMessageDialog(this,sumaCantTabla);
            }
        }
        
        //JOptionPane.showMessageDialog(this,sumaCantTabla);
    }

    /**
     * This method is called from withi // TODO add your handling code here: //
     * Registros n = new Registros(); // this.getDesktopPane().add(n); //
     * n.setVisible(true);n the constructor to initialize the form. WARNING: Do
     * NOT modify this code. The content of this method is always regenerated by
     * the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panel6 = new org.edisoncor.gui.panel.Panel();
        jToolBar1 = new javax.swing.JToolBar();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        panel1 = new org.edisoncor.gui.panel.Panel();
        panel2 = new org.edisoncor.gui.panel.Panel();
        txtClaveUsuario = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        panel3 = new org.edisoncor.gui.panel.Panel();
        jLabel1 = new javax.swing.JLabel();
        txtCodigoPrestamo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtBuscador = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEjemplar = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        panel4 = new org.edisoncor.gui.panel.Panel();
        jLabel2 = new javax.swing.JLabel();
        txtAdministrador = new javax.swing.JTextField();
        panel5 = new org.edisoncor.gui.panel.Panel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDetPrestamos = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Proceso de prestamos");
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

        jButton2.setFont(new java.awt.Font("Vrinda", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PkIconos/Img32/imgAgregar.png"))); // NOI18N
        jButton2.setText("Registrar");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jButton3.setFont(new java.awt.Font("Vrinda", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PkIconos/Img32/imgCancelar.png"))); // NOI18N
        jButton3.setText("Cancelar");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        panel1.setBackground(new java.awt.Color(255, 102, 0));
        panel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Préstamos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Vrinda", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        panel1.setForeground(new java.awt.Color(255, 255, 255));
        panel1.setColorPrimario(new java.awt.Color(50, 116, 53));
        panel1.setColorSecundario(new java.awt.Color(50, 116, 53));
        panel1.setFont(new java.awt.Font("Vrinda", 0, 12)); // NOI18N

        panel2.setBackground(new java.awt.Color(255, 153, 0));
        panel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Usuario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Vrinda", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        panel2.setColorPrimario(new java.awt.Color(50, 116, 53));
        panel2.setColorSecundario(new java.awt.Color(50, 116, 53));

        txtClaveUsuario.setBackground(new java.awt.Color(58, 145, 64));
        txtClaveUsuario.setFont(new java.awt.Font("Vrinda", 0, 16)); // NOI18N
        txtClaveUsuario.setForeground(new java.awt.Color(255, 255, 255));
        txtClaveUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/imgBuscar.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        txtNombre.setBackground(new java.awt.Color(58, 145, 64));
        txtNombre.setFont(new java.awt.Font("Vrinda", 0, 16)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        txtNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PkIconos/Img32/imgAgregar - copia.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtClaveUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton5))
                    .addComponent(txtNombre)
                    .addComponent(txtClaveUsuario, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        panel3.setBackground(new java.awt.Color(255, 153, 0));
        panel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Proceso General", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Vrinda", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        panel3.setColorPrimario(new java.awt.Color(50, 116, 53));
        panel3.setColorSecundario(new java.awt.Color(50, 116, 53));

        jLabel1.setFont(new java.awt.Font("Vrinda", 0, 13)); // NOI18N
        jLabel1.setText("Codigo Préstamo:");

        txtCodigoPrestamo.setBackground(new java.awt.Color(58, 145, 64));
        txtCodigoPrestamo.setFont(new java.awt.Font("Vrinda", 0, 16)); // NOI18N
        txtCodigoPrestamo.setForeground(new java.awt.Color(255, 255, 255));
        txtCodigoPrestamo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel3.setFont(new java.awt.Font("Vrinda", 0, 13)); // NOI18N
        jLabel3.setText("Fecha:");

        txtBuscador.setBackground(new java.awt.Color(58, 145, 64));
        txtBuscador.setForeground(new java.awt.Color(255, 255, 255));
        txtBuscador.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        txtBuscador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtBuscadorMouseReleased(evt);
            }
        });
        txtBuscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscadorKeyReleased(evt);
            }
        });

        tblEjemplar.setBackground(new java.awt.Color(50, 116, 53));
        tblEjemplar.setFont(new java.awt.Font("Arial Narrow", 0, 15)); // NOI18N
        tblEjemplar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblEjemplar.setGridColor(new java.awt.Color(255, 255, 255));
        tblEjemplar.setSelectionBackground(new java.awt.Color(58, 145, 64));
        tblEjemplar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEjemplarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEjemplar);

        jLabel4.setFont(new java.awt.Font("Vrinda", 0, 13)); // NOI18N
        jLabel4.setText("Buscar por: ISBN/Título");

        txtFecha.setBackground(new java.awt.Color(58, 145, 64));
        txtFecha.setFont(new java.awt.Font("Vrinda", 0, 16)); // NOI18N
        txtFecha.setForeground(new java.awt.Color(255, 255, 255));
        txtFecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jButton1.setText("add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigoPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(jButton1))
                    .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtFecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                        .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodigoPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panel4.setBackground(new java.awt.Color(255, 153, 0));
        panel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Encargado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Vrinda", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        panel4.setColorPrimario(new java.awt.Color(50, 116, 53));
        panel4.setColorSecundario(new java.awt.Color(50, 116, 53));

        jLabel2.setFont(new java.awt.Font("Vrinda", 0, 13)); // NOI18N
        jLabel2.setText("Usuario en turno:");

        txtAdministrador.setBackground(new java.awt.Color(58, 145, 64));
        txtAdministrador.setFont(new java.awt.Font("Vrinda", 0, 16)); // NOI18N
        txtAdministrador.setForeground(new java.awt.Color(255, 255, 255));
        txtAdministrador.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        javax.swing.GroupLayout panel4Layout = new javax.swing.GroupLayout(panel4);
        panel4.setLayout(panel4Layout);
        panel4Layout.setHorizontalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4Layout.createSequentialGroup()
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panel5.setBackground(new java.awt.Color(255, 153, 0));
        panel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle Préstamo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Vrinda", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        panel5.setColorPrimario(new java.awt.Color(50, 116, 53));
        panel5.setColorSecundario(new java.awt.Color(50, 116, 53));

        tblDetPrestamos.setBackground(new java.awt.Color(50, 116, 53));
        tblDetPrestamos.setFont(new java.awt.Font("Arial Narrow", 0, 15)); // NOI18N
        tblDetPrestamos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cód. Prestamo", " ISBN", " Autor", "Cant. prestada "
            }
        ));
        tblDetPrestamos.setGridColor(new java.awt.Color(255, 255, 255));
        tblDetPrestamos.setSelectionBackground(new java.awt.Color(50, 116, 53));
        tblDetPrestamos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDetPrestamosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDetPrestamos);

        javax.swing.GroupLayout panel5Layout = new javax.swing.GroupLayout(panel5);
        panel5.setLayout(panel5Layout);
        panel5Layout.setHorizontalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        panel5Layout.setVerticalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 265, Short.MAX_VALUE)
                        .addComponent(panel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panel6Layout = new javax.swing.GroupLayout(panel6);
        panel6.setLayout(panel6Layout);
        panel6Layout.setHorizontalGroup(
            panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panel6Layout.setVerticalGroup(
            panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel6Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        JIFrameAlumnos n = new JIFrameAlumnos();
        this.getDesktopPane().add(n);
        n.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        JIFrameRegistros n = new JIFrameRegistros();
        this.getDesktopPane().add(n);
        n.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tblEjemplarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEjemplarMouseClicked
        // TODO add your handling code here:
        int fila = this.tblEjemplar.rowAtPoint(evt.getPoint());

        try {
            int cantidadExistente = Integer.parseInt(String.valueOf(this.tblEjemplar.getValueAt(fila, 6)));
            //String CantLibroPrestamos = "";
            int cantidad;

            if (cantidadExistente == 1 || cantidadExistente == 0) {
                if (cantidadExistente == 0) {
                    JOptionPane.showMessageDialog(null, "No tiene suficiente ejemplares", "Msj.", JOptionPane.WARNING_MESSAGE);
                } else {
                    int i = JOptionPane.showConfirmDialog(this, "Desea ejecutar el préstamo de este ejemplar ?", "Msj.", JOptionPane.YES_NO_OPTION);
                    if (i == 0) {
                        if (cantidadExistente == 1) {
                            modelTablaDetallePrestamo.addRow(new Object[]{txtCodigoPrestamo.getText(),
                                tblEjemplar.getValueAt(tblEjemplar.getSelectedRow(), 0),
                                tblEjemplar.getValueAt(tblEjemplar.getSelectedRow(), 3), 1});
                            tblDetPrestamos.setModel(modelTablaDetallePrestamo);
                        }
                    }
                }
            } else {

                CantLibroPrestamos = JOptionPane.showInputDialog(null, "Introduce la cantidad de ejemplar a préstar:",
                        "Msj.", JOptionPane.INFORMATION_MESSAGE);

                while (CantLibroPrestamos != null && !validarDatos.esEntero(CantLibroPrestamos)) {
                    CantLibroPrestamos = JOptionPane.showInputDialog(null, "Introduce la cantidad de ejemplar a préstar:",
                            "Msj.", JOptionPane.INFORMATION_MESSAGE);
                }
                cantidad = Integer.parseInt(CantLibroPrestamos);

                if (cantidadExistente >= cantidad && cantidad > 0) {

                    if (VerificarArticuloRegistradoTabla() == false) {
                        //
                       
                        modelTablaDetallePrestamo.addRow(new Object[]{txtCodigoPrestamo.getText(),
                            tblEjemplar.getValueAt(tblEjemplar.getSelectedRow(), 0),
                            tblEjemplar.getValueAt(tblEjemplar.getSelectedRow(), 3), cantidad});
                        tblDetPrestamos.setModel(modelTablaDetallePrestamo);
                        
                        
                       
                    } 
                    else {
                        ActualizarCantidadProdTabla(tblEjemplar.getValueAt(tblEjemplar.getSelectedRow(), 0).toString(),CantLibroPrestamos);      
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "No tiene suficiente ejemplares", "Msj.", JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch (Exception e) {
        }//cierre del segundo Try
    }//GEN-LAST:event_tblEjemplarMouseClicked

    private void tblDetPrestamosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDetPrestamosMouseClicked
        // TODO add your handling code here:
        int i = JOptionPane.showConfirmDialog(this, "¿Está seguro de cancelar este ejeplar ?", "Msj.", JOptionPane.YES_NO_OPTION);
        if (i == 0) {
            int fila = tblDetPrestamos.getSelectedRow();

            if (fila >= 0) {
                modelTablaDetallePrestamo.removeRow(fila);

            }

        }
    }//GEN-LAST:event_tblDetPrestamosMouseClicked

    private void txtBuscadorMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscadorMouseReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_txtBuscadorMouseReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ejecutarPrestamo();
        limpiarCampos();
        this.tblEjemplar.setModel(objEjemplar.ConsultaEjemplar());
        this.txtCodigoPrestamo.setText(ClGeneradorClaves.GenerarCodigoPrestamo());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtBuscadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscadorKeyReleased
        // TODO add your handling code here:
        //if (cbxCodigo.isSelected()) {
        this.tblEjemplar.setModel(objEjemplar.ConsultaEjemplarPorNombre(txtBuscador.getText()));
//        } else {
//            objUsuario.getTablaUsuarios();
//        }
    }//GEN-LAST:event_txtBuscadorKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        limpiarCampos();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:

        this.modelTablaDetallePrestamo = new javax.swing.table.DefaultTableModel(
                null,
                new String[]{
                    "Cód. Préstamo", "ISBN", "Autor", " Cant. prestada ",});

        this.tblEjemplar.setModel(objEjemplar.ConsultaEjemplar());
        this.txtFecha.setText(ClHoraFecha.FechaFormatoDos());
        deshabilitarBotones();
        txtAdministrador.setText(JPanelLogin.txtUsuario.getText());
    }//GEN-LAST:event_formInternalFrameOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (this.tblDetPrestamos.getRowCount() > 0) {
            int fila = this.tblDetPrestamos.getRowCount();
            DefaultTableModel detalle = (DefaultTableModel) this.tblDetPrestamos.getModel();
            DefaultTableModel ejemplar = (DefaultTableModel) this.tblEjemplar.getModel();
            for (int f = 0; f < fila; f++) {
                
                JOptionPane.showMessageDialog(this, String.valueOf(detalle.getValueAt(f, 1))+"_________"+String.valueOf(ejemplar.getValueAt(f, 0)));
                   
                //Validamos que el registro este en la tabla detalle
                //if (String.valueOf(detalle.getValueAt(f, 1)).trim().equals(String.valueOf(tblEjemplar.getValueAt(f, 0)))) {
                     
                //}
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    private org.edisoncor.gui.panel.Panel panel1;
    private org.edisoncor.gui.panel.Panel panel2;
    private org.edisoncor.gui.panel.Panel panel3;
    private org.edisoncor.gui.panel.Panel panel4;
    private org.edisoncor.gui.panel.Panel panel5;
    private org.edisoncor.gui.panel.Panel panel6;
    private javax.swing.JTable tblDetPrestamos;
    private javax.swing.JTable tblEjemplar;
    private javax.swing.JTextField txtAdministrador;
    private javax.swing.JTextField txtBuscador;
    public static javax.swing.JTextField txtClaveUsuario;
    private javax.swing.JTextField txtCodigoPrestamo;
    private javax.swing.JTextField txtFecha;
    public static javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
