/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectoLenguajes.interfazG;

import com.proyecto.Lenguajes.funcionesUI.funcionesUI;
import com.proyectoLenguajes.analizador.Analizador;
import com.proyectoLenguajes.archivos.LectorArchivo;
import com.proyectoLenguajes.principal.Busqueda;
import com.proyectoLenguajes.reportes.Tokens;
import com.proyectosLenguajes.analizadorSintactico.analizadorSintactico;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.undo.UndoManager;

/**
 *
 * @author AndaryuS
 */
public class home extends javax.swing.JFrame {

    private Busqueda busqueda;
    private Analizador analizador;
    private ReporteError ventanaRpo = new ReporteError();
    private LectorArchivo lector = new LectorArchivo();
    private NumeroLinea numeroLinea;
    private Reportes reporteVentan = new Reportes();
    private MovimientoVentan movimiento = new MovimientoVentan();
    private funcionesUI funciones = new funcionesUI();
    private analizadorSintactico sintactico;
    private UndoManager manager;
    /**
     * Creates new form home
     */
    //validarToken validar = new validarToken();
    JFileChooser seleccionar = new JFileChooser();
    // buscarPalabra buscarPalabra ;
    File archivo;
    FileInputStream entrada;
    FileOutputStream salida;
    // NumeroLinea numeroLinea;

    public home() {
        initComponents();
        this.manager = new UndoManager();
        jTextArea1.getDocument().addUndoableEditListener(
                new UndoableEditListener() {
            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                manager.addEdit(e.getEdit());
            }
        });
        this.setExtendedState(MAXIMIZED_BOTH);
        numeroLinea = new NumeroLinea(jTextArea1);
        jScrollPane1.setRowHeaderView(numeroLinea);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenuClickDerecho = new javax.swing.JPopupMenu();
        jMenuItem3Copiar = new javax.swing.JMenuItem();
        jMenuItem3Cortar = new javax.swing.JMenuItem();
        jMenuItem3Pegar = new javax.swing.JMenuItem();
        jPanelSuperior = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jPanelDerecho = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButtonValidar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButtonReporte = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButtonAnalisisSintactico = new javax.swing.JButton();
        jPanelIzquierdo = new javax.swing.JPanel();
        jPanelInferior = new javax.swing.JPanel();
        jTextFieldBuscar = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        jPanelCentral = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemCopiar = new javax.swing.JMenuItem();
        jMenuItemCortar = new javax.swing.JMenuItem();
        jMenuItemPegar = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();

        jMenuItem3Copiar.setText("Copiar");
        jMenuItem3Copiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3CopiarActionPerformed(evt);
            }
        });
        jPopupMenuClickDerecho.add(jMenuItem3Copiar);

        jMenuItem3Cortar.setText("Cortar");
        jMenuItem3Cortar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3CortarActionPerformed(evt);
            }
        });
        jPopupMenuClickDerecho.add(jMenuItem3Cortar);

        jMenuItem3Pegar.setText("Pegar");
        jMenuItem3Pegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3PegarActionPerformed(evt);
            }
        });
        jPopupMenuClickDerecho.add(jMenuItem3Pegar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelSuperior.setBackground(new java.awt.Color(0, 153, 255));

        jLabelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setFont(new java.awt.Font("MesloLGS NF", 1, 36)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setText("Analizador Sintactico");
        jLabelTitulo.setToolTipText("");
        jLabelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelTitulo.setVerticalAlignment(SwingConstants.CENTER);

        javax.swing.GroupLayout jPanelSuperiorLayout = new javax.swing.GroupLayout(jPanelSuperior);
        jPanelSuperior.setLayout(jPanelSuperiorLayout);
        jPanelSuperiorLayout.setHorizontalGroup(
            jPanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSuperiorLayout.createSequentialGroup()
                .addGap(0, 125, Short.MAX_VALUE)
                .addComponent(jLabelTitulo)
                .addGap(0, 125, Short.MAX_VALUE))
        );
        jPanelSuperiorLayout.setVerticalGroup(
            jPanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSuperiorLayout.createSequentialGroup()
                .addGap(0, 26, Short.MAX_VALUE)
                .addComponent(jLabelTitulo)
                .addGap(0, 27, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelSuperior, java.awt.BorderLayout.PAGE_START);

        jPanelDerecho.setBackground(new java.awt.Color(0, 153, 255));
        jPanelDerecho.setLayout(new javax.swing.BoxLayout(jPanelDerecho, javax.swing.BoxLayout.Y_AXIS));

        jLabel1.setText(" ");
        jPanelDerecho.add(jLabel1);

        jButtonValidar.setText("Validar tokens");
        jButtonValidar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValidarActionPerformed(evt);
            }
        });
        jPanelDerecho.add(jButtonValidar);

        jLabel2.setText("     ");
        jPanelDerecho.add(jLabel2);

        jButtonReporte.setText("Reporte");
        jButtonReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReporteActionPerformed(evt);
            }
        });
        jPanelDerecho.add(jButtonReporte);

        jLabel4.setText("   ");
        jPanelDerecho.add(jLabel4);

        jButtonAnalisisSintactico.setText("Analisis sintactico");
        jButtonAnalisisSintactico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnalisisSintacticoActionPerformed(evt);
            }
        });
        jPanelDerecho.add(jButtonAnalisisSintactico);

        getContentPane().add(jPanelDerecho, java.awt.BorderLayout.LINE_END);

        jPanelIzquierdo.setBackground(new java.awt.Color(0, 153, 255));

        javax.swing.GroupLayout jPanelIzquierdoLayout = new javax.swing.GroupLayout(jPanelIzquierdo);
        jPanelIzquierdo.setLayout(jPanelIzquierdoLayout);
        jPanelIzquierdoLayout.setHorizontalGroup(
            jPanelIzquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 207, Short.MAX_VALUE)
        );
        jPanelIzquierdoLayout.setVerticalGroup(
            jPanelIzquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 456, Short.MAX_VALUE)
        );

        getContentPane().add(jPanelIzquierdo, java.awt.BorderLayout.LINE_START);

        jPanelInferior.setBackground(new java.awt.Color(0, 153, 255));

        jTextFieldBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBuscarActionPerformed(evt);
            }
        });

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelInferiorLayout = new javax.swing.GroupLayout(jPanelInferior);
        jPanelInferior.setLayout(jPanelInferiorLayout);
        jPanelInferiorLayout.setHorizontalGroup(
            jPanelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInferiorLayout.createSequentialGroup()
                .addContainerGap(420, Short.MAX_VALUE)
                .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonBuscar)
                .addContainerGap())
        );
        jPanelInferiorLayout.setVerticalGroup(
            jPanelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInferiorLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscar))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelInferior, java.awt.BorderLayout.PAGE_END);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setComponentPopupMenu(jPopupMenuClickDerecho);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel3.setText("Area de errores");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        javax.swing.GroupLayout jPanelCentralLayout = new javax.swing.GroupLayout(jPanelCentral);
        jPanelCentral.setLayout(jPanelCentralLayout);
        jPanelCentralLayout.setHorizontalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
            .addGroup(jPanelCentralLayout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelCentralLayout.setVerticalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCentralLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelCentral, java.awt.BorderLayout.CENTER);

        jMenu1.setText("Archivo");

        jMenuItem1.setText("Abrir Archivo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem5.setText("Nuevo");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem6.setText("Guardar");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem2.setText("Guardar Como");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edicion");

        jMenuItemCopiar.setText("Copiar");
        jMenuItemCopiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCopiarActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemCopiar);

        jMenuItemCortar.setText("Cortar");
        jMenuItemCortar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCortarActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemCortar);

        jMenuItemPegar.setText("Pegar");
        jMenuItemPegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPegarActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemPegar);

        jMenuItem3.setText("Deshacer");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("Rehacer");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Acerca de");
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });

        jMenuItem7.setText("Informacion");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonValidarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValidarActionPerformed
        // TODO add your handling code here:
        //   String txt = jTextPane1.getText();
        //  validar.recibiriCadena(txt, this);
        // this.setVisible(false);
        this.analizador = new Analizador(jTextArea1);
        this.sintactico = new analizadorSintactico();
        if (jTextArea1.getText() != null) {
            this.analizador.anlaizar();
            this.ventanaRpo.setReportErrores(this.analizador.getReporteErrores());
            if (this.analizador.getReporteErrores().isExisteErrores()) {
                this.ventanaRpo.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Texto sin Errores");
            }

        }

    }//GEN-LAST:event_jButtonValidarActionPerformed


    private void jTextFieldBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBuscarActionPerformed


    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        // TODO add your handling code here:
        this.busqueda = new Busqueda();
        //   busqueda.buscarpalabra(jTextPane1, jTextFieldBuscar.getText());

        //  buscarpalabra(jTextPane1, jTextFieldBuscar.getText());
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReporteActionPerformed
        // TODO add your handling code here:

        try {
            if (!this.analizador.getReporteErrores().isExisteErrores()) {
                this.reporteVentan.setReportErrores(this.analizador.getReporte());
                this.reporteVentan.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Solucionar Errores Primero");
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Debe Analizar Primero");

        }
    }//GEN-LAST:event_jButtonReporteActionPerformed

    private void jButtonAnalisisSintacticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnalisisSintacticoActionPerformed
        // TODO add your handling code here:
//        ArrayList<Tokens> tokens= this.analizador.getReporte().getTokens();
//        if (tokens.size()>0) {
//          for (int i = 0; i < tokens.size(); i++) {
//         jTextArea2.append(tokens.get(i).getLexema()+" ");
//        }
//        }

        if (this.sintactico != null) {
            this.sintactico.analizar(this.analizador.getReporte().getTokens());
            this.sintactico.getErrores().enlistarErrores(jTextArea2);
        }


    }//GEN-LAST:event_jButtonAnalisisSintacticoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
//        if (seleccionar.showDialog(null, "Abrir") == JFileChooser.APPROVE_OPTION) {
//            archivo = seleccionar.getSelectedFile();
//            System.out.println(archivo.getAbsolutePath());
//            if (archivo.canRead()) {
//                if (archivo.getName().endsWith("txt")) {
//                    String documento = abrirArchivo(archivo);
//                    jTextArea1.setText(documento);
//                } else {
//                    JOptionPane.showMessageDialog(null, "Error al abrir archivo");
//                }
//            }
//        }
    this.funciones.cargarArchivo(jTextArea1);


    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        
       // this.funciones.guardarCambiosArchivo(jTextArea1.getText());
       this.funciones.guardarComo(jTextArea1);
        
//        if (seleccionar.showDialog(null, "guaradar") == JFileChooser.APPROVE_OPTION) {
//            archivo = seleccionar.getSelectedFile();
//            if (archivo.getName().endsWith("txt")) {
//                String documneto = jTextArea1.getText();
//                String mensaje = guardarComoArchivo(archivo, documneto);
//                if (mensaje != null) {
//                    JOptionPane.showMessageDialog(null, "Archivo guardado");
//                } else {
//                    JOptionPane.showMessageDialog(null, "Error al guarda archivo");
//                }
//            } else {
//                JOptionPane.showMessageDialog(null, "Guardar texto");
//            }
//        }

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItemCopiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCopiarActionPerformed
        // TODO add your handling code here:
        jTextArea1.copy();
    }//GEN-LAST:event_jMenuItemCopiarActionPerformed

    private void jMenuItemPegarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPegarActionPerformed
        // TODO add your handling code here:
        jTextArea1.paste();
    }//GEN-LAST:event_jMenuItemPegarActionPerformed

    private void jMenuItemCortarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCortarActionPerformed
        // TODO add your handling code here:
        jTextArea1.cut();
    }//GEN-LAST:event_jMenuItemCortarActionPerformed

    private void jMenuItem3CopiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3CopiarActionPerformed
        // TODO add your handling code here:
        jTextArea1.copy();
    }//GEN-LAST:event_jMenuItem3CopiarActionPerformed

    private void jMenuItem3CortarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3CortarActionPerformed
        // TODO add your handling code here:
        jTextArea1.cut();
    }//GEN-LAST:event_jMenuItem3CortarActionPerformed

    private void jMenuItem3PegarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3PegarActionPerformed
        // TODO add your handling code here:
        jTextArea1.paste();
    }//GEN-LAST:event_jMenuItem3PegarActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        manager.undo();

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        manager.redo();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        String documento = jTextArea1.getText();
     //   guardarCambiosArchivo(archivo, documento);
        
        this.funciones.guardarCambiosArchivo(documento);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
       //archivoNuevo();
        this.funciones.archivoNuevo( jTextArea1);

    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
        // TODO add your handling code here:
        AcercaDe info = new AcercaDe();
        info.setVisible(true);
    }//GEN-LAST:event_jMenu3ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
                AcercaDe info = new AcercaDe();
        info.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

//    public void buscarpalabra(JTextPane area1, String texto) {
//        if (texto.length() >= 1) {
//            DefaultHighlighter.DefaultHighlightPainter highlightPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.GREEN);
//            Highlighter h = area1.getHighlighter();
//            h.removeAllHighlights();
//            String text = area1.getText();
//            String caracteres = texto;
//            Pattern p = Pattern.compile("(?i)" + caracteres);
//            Matcher m = p.matcher(text);
//            while (m.find()) {
//                try {
//                    h.addHighlight(m.start(), m.end(), highlightPainter);
//                } catch (BadLocationException ex) {
//                   // Logger.getLogger(color.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        } else {
//             Highlighter h = area1.getHighlighter();
//            h.removeAllHighlights();
//         //   JOptionPane.showMessageDialog(area1, "la palabra a buscar no puede ser vacia");
//        }
//    
//    }
    public void buscarpalabra(JTextPane area1, String texto) {
        if (texto.length() >= 1) {
            DefaultHighlighter.DefaultHighlightPainter highlightPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.GREEN);
            Highlighter h = area1.getHighlighter();
            h.removeAllHighlights();
            String text = area1.getText();
            String caracteres = texto;
            Pattern p = Pattern.compile("(?i)" + caracteres);
            Matcher m = p.matcher(text);
            while (m.find()) {
                try {
                    h.addHighlight(m.start(), m.end(), highlightPainter);
                } catch (BadLocationException ex) {
                    // Logger.getLogger(color.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            Highlighter h = area1.getHighlighter();
            h.removeAllHighlights();
            //   JOptionPane.showMessageDialog(area1, "la palabra a buscar no puede ser vacia");
        }

    }

    public String abrirArchivo(File archivo) {
        String documento = "";
        try {
            entrada = new FileInputStream(archivo);
            int ascc;
            while ((ascc = entrada.read()) != -1) {
                char caracter = (char) ascc;
                documento += caracter;

            }
        } catch (Exception e) {
        }
        return documento;
    }

    public String guardarComoArchivo(File archivo, String documento) {
        String mensaje = null;
        try {
            salida = new FileOutputStream(archivo);
            byte[] bytxt = documento.getBytes();
            salida.write(bytxt);
            mensaje = "archivo guardado";
        } catch (IOException e) {
            System.out.println("error en guardar");
        }
        return mensaje;
    }

    public String guardarCambiosArchivo(File archivo, String documento) {
        String mensaje = null;
        if (archivo != null) {
            mensaje = guardarComoArchivo(archivo, documento);
        } else {

            if (seleccionar.showDialog(null, "guaradar") == JFileChooser.APPROVE_OPTION) {
                archivo = seleccionar.getSelectedFile();
                if (archivo.getName().endsWith("txt")) {
                    String documneto = jTextArea1.getText();
                    mensaje = guardarComoArchivo(archivo, documneto);
                    if (mensaje != null) {
                        JOptionPane.showMessageDialog(null, "Archivo guardado");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al guarda archivo");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Guardar texto");
                }
            }

        }

        return mensaje;
    }

    public void archivoNuevo() {
        String documneto = jTextArea1.getText();
        String mensaje;
        if (archivo == null && documneto != null) {
            int eleccion = JOptionPane.showConfirmDialog(null, "¿Desea guardar el archivo antes de cerrarlo?");
            if (eleccion == JOptionPane.YES_OPTION) {
                //guardarComoArchivo(archivo, documneto);
                     if (seleccionar.showDialog(null, "guaradar") == JFileChooser.APPROVE_OPTION) {
                archivo = seleccionar.getSelectedFile();
                if (archivo.getName().endsWith("txt")) {
                 //   String documneto = jTextArea1.getText();
                    mensaje = guardarComoArchivo(archivo, documneto);
                    if (mensaje != null) {
                        JOptionPane.showMessageDialog(null, "Archivo guardado");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al guarda archivo");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Guardar texto");
                }
            }
                
            }
            if (eleccion == JOptionPane.NO_OPTION) {
                archivo = null;
                jTextArea1.setText("");
            }

        } else if (archivo != null) {
            int eleccion = JOptionPane.showConfirmDialog(null, "¿Desea guardar los cambios antes de cerrar el archivo?");
            if (eleccion == JOptionPane.YES_OPTION) {
                guardarCambiosArchivo(archivo, documneto);
                archivo = null;
                jTextArea1.setText("");
            }
            if (eleccion == JOptionPane.NO_OPTION) {
                archivo = null;
                jTextArea1.setText("");
            }

        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnalisisSintactico;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonReporte;
    private javax.swing.JButton jButtonValidar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem3Copiar;
    private javax.swing.JMenuItem jMenuItem3Cortar;
    private javax.swing.JMenuItem jMenuItem3Pegar;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItemCopiar;
    private javax.swing.JMenuItem jMenuItemCortar;
    private javax.swing.JMenuItem jMenuItemPegar;
    private javax.swing.JPanel jPanelCentral;
    private javax.swing.JPanel jPanelDerecho;
    private javax.swing.JPanel jPanelInferior;
    private javax.swing.JPanel jPanelIzquierdo;
    private javax.swing.JPanel jPanelSuperior;
    private javax.swing.JPopupMenu jPopupMenuClickDerecho;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextFieldBuscar;
    // End of variables declaration//GEN-END:variables
}