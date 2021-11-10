package com.proyectoLenguajes.reportes;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AndaryuS
 */
public class Errores {

    private ArrayList<String> cadena = new ArrayList<>();
    private ArrayList<Character> caracter = new ArrayList<>();
    private ArrayList<Integer> fila = new ArrayList<>();
    private ArrayList<Integer> columna = new ArrayList<>();
    private int filaActual = 1;
    private int columnaActual = 0;
    private JTable tabla;
    private String cadenaActual = "";
    private boolean existeErrores = false;

    /**
     *imprime los errores recopilados
     * @param tabla
     */
    public void enlistarErrores(JTable tabla) {
        this.tabla = tabla;
        int index = 0;
        DefaultTableModel modelo = new DefaultTableModel();
        this.tabla.setModel(modelo);
        modelo.addColumn("SIMBOLO");
        modelo.addColumn("CADENA");
        modelo.addColumn("FILA");
        modelo.addColumn("COLUMNA");
        for (String cadena : cadena) {
            modelo.addRow(new Object[]{this.caracter.get(index), cadena, this.fila.get(index), this.columna.get(index)});
            index++;
        }
    }
    
     public void imprimirErrores(JTextArea jTextArea) {

        int index = 0;
     
        for (String cadena : cadena) {

            jTextArea.append("\n"+"ERROR : "+this.caracter.get(index)+" ("+this.fila.get(index)+" , "+this.columna.get(index)+")");
            index++;
        }
    }

    /**
     * recopila los errores que puede encontrar en el texto caracater por carater
     * @param Caracter
     * @param estado 
     */
    public void recopilador(char Caracter, int estado) {
        if (estado == -3) {
            this.filaActual++;
            this.columnaActual = 0;
            this.cadenaActual = "";
        } else {
            if (estado == -1) {
                this.existeErrores = true;
                this.columnaActual++;
                this.cadenaActual += Caracter;
                this.caracter.add(Caracter);
                this.cadena.add(cadenaActual);
                this.fila.add(this.filaActual);
                this.columna.add(this.columnaActual);
                this.cadenaActual = "";
            } else {
                this.columnaActual++;
                if (estado == -2) {
                    this.cadenaActual = "";
                } else {
                    this.cadenaActual += Caracter;
                }

            }
        }

    }

    public boolean isExisteErrores() {
        return existeErrores;
    }

   

}
