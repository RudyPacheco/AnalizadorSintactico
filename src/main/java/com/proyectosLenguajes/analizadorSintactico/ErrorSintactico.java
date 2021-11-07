/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.proyectosLenguajes.analizadorSintactico;

import com.proyectoLenguajes.reportes.Tokens;
import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 * 
 * @author AndaryuS
 */
public class ErrorSintactico {
    
      private final ArrayList<Tokens> Tokens = new ArrayList<>();

    
    public void camputrarErrorSintactico(Tokens token, String descipcion){
        token.setDescripcion(descipcion);
        this.Tokens.add(token);
        
    }
    
    public void enlistarErrores(JTextArea area){
        area.setText("");
        for (Tokens Token : Tokens) {
            area.append("ERROR SINTACTICO LEXEMA: "+ Token.getLexema());
            area.append("  POSICION Fila , Columna "+ Token.getFila()+", "+ Token.getColumna()+"\n");
            area.append("DESCRIPCION "+ Token.getDescripcion()+"\n\n");
        }
    }
    

}
