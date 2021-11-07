package com.proyectoLenguajes.principal;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

/**
 *
 * @author elvis_agui
 */
public class Busqueda {

    private String text;
    private int contadorTexto = 0;
    private int contadorPalabra = 0;
    private int p0 = -1;
    private int p1 = -1;

    private void buscarPatron(char caracterTexto, char caracterPalabra) {
        if (Character.compare(caracterTexto, caracterPalabra) == 0) {
            if ((p0 == -1)) {
                p0 = contadorTexto;
            }
            contadorPalabra++;
        } else {
            p0 = -1;
            p1 = -1;
            contadorPalabra = 0;
        }
        contadorTexto++;
    }

    /**
     * encargado de buscar y pintar las palabras que encuentra en el texto
     *
     * @param areaTexto
     * @param texto
     */
    public void buscarpalabra(JTextArea areaTexto, String texto) {
        if (texto.length() >= 1) {
            DefaultHighlighter.DefaultHighlightPainter highlightPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.GREEN);
            Highlighter h = areaTexto.getHighlighter();
            h.removeAllHighlights();
            text = areaTexto.getText();          
            while (contadorTexto < text.length()) {
                buscarPatron(text.charAt(contadorTexto), texto.charAt(contadorPalabra));
                if (contadorPalabra == texto.length() - 1) {
                    p1 = contadorTexto+1;
                    try {
                        h.addHighlight(p0, p1, highlightPainter);
                    } catch (BadLocationException ex) {
                        JOptionPane.showMessageDialog(null, "color inexistente");
                    }
                    p0 = -1;
                    p1 = -1;
                    contadorPalabra = 0;
                }

            }
        } else {
            JOptionPane.showMessageDialog(null, "debe escribir primero");
        }
    }
}
