
package com.proyectoLenguajes.archivos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author elvis_agui
 */
public class EscritorArchivo {
    FileOutputStream salida;
    File archivo;
    
    /**
     * escribe el texto que se guradara
     * @param archivo
     * @param texto 
     */
    public void escritorArchivo(File archivo, String texto){
        try {
        salida = new FileOutputStream(archivo);
        byte [] bytxt = texto.getBytes();
        salida.write(bytxt);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al Guardar El Archivo");
        }
    }
}
