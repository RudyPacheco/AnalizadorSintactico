
package com.proyectoLenguajes.archivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JTextArea;

/**
 *
 * @author elvis_agui
 */
public class LectorArchivo {
    /**
     * encargado de leer el archivo de entrada y escribirlo en el JTextArea
     * @param archivo
     * @param text
     * @throws FileNotFoundException
     * @throws IOException 
     */
     public void leerFichero(File archivo,JTextArea text) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        while ((linea = br.readLine()) != null) {
            text.append(linea+"\n");
           
        }
        fr.close();
    }
}
