/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.Lenguajes.funcionesUI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author AndaryuS
 */
public class funcionesUI {

    JFileChooser seleccionar = new JFileChooser();
    FileInputStream entrada;
    FileOutputStream salida;
    File archivo;

    public void cargarArchivo(JTextArea jTextArea1) {
        if (seleccionar.showDialog(null, "Abrir") == JFileChooser.APPROVE_OPTION) {
            archivo = seleccionar.getSelectedFile();
            if (archivo.canRead()) {
                if (archivo.getName().endsWith("txt")) {
                    String documento = abrirArchivo(archivo);
                    jTextArea1.setText(documento);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al abrir archivo");
                }
            }
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

    public String guardarComoArchivo(String documento) {
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
    
    public void guardarComo(JTextArea jTextArea1){
                if (seleccionar.showDialog(null, "guaradar") == JFileChooser.APPROVE_OPTION) {
            archivo = seleccionar.getSelectedFile();
            if (archivo.getName().endsWith("txt")) {
                String documento = jTextArea1.getText();
                String mensaje = guardarComoArchivo(documento);
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

    public String guardarCambiosArchivo(String documento) {
        String mensaje = null;
        if (archivo != null) {
            mensaje = guardarComoArchivo(documento);
        } else {

            if (seleccionar.showDialog(null, "guaradar") == JFileChooser.APPROVE_OPTION) {
                archivo = seleccionar.getSelectedFile();
                if (archivo.getName().endsWith("txt")) {
                    //    String documneto = jTextArea1.getText();
                    mensaje = guardarComoArchivo(documento);
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

    public void archivoNuevo( JTextArea jTextArea1) {
        String documento = jTextArea1.getText();
        String mensaje;
        if (archivo == null && documento != null) {
            int eleccion = JOptionPane.showConfirmDialog(null, "¿Desea guardar el archivo antes de cerrarlo?");
            if (eleccion == JOptionPane.YES_OPTION) {
                //guardarComoArchivo(archivo, documneto);
                if (seleccionar.showDialog(null, "guaradar") == JFileChooser.APPROVE_OPTION) {
                    archivo = seleccionar.getSelectedFile();
                    if (archivo.getName().endsWith("txt")) {
                        //   String documneto = jTextArea1.getText();
                        mensaje = guardarComoArchivo(documento);
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
                guardarCambiosArchivo(documento);
                archivo = null;
                jTextArea1.setText("");
            }
            if (eleccion == JOptionPane.NO_OPTION) {
                archivo = null;
                jTextArea1.setText("");
            }

        }

    }

}
