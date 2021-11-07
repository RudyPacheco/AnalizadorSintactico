/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.proyectosLenguajes.analizadorSintactico;

import java.util.Stack;
import javax.swing.JOptionPane;

/**
 * 
 * @author AndaryuS
 */
public class Pila {
    
     private Stack pila = new Stack();

    public Pila() {
        this.pila.push(Producciones.FINALIZAR.name());
        this.pila.push(Producciones.INICIAR);
    }

    /**
     * apilamos dependiendo el valor del string que venga de la matriz
     *
     * @param pila
     * @param tokenEvaluado
     * @param palabra
     */
    public void Apilar(String palabra, String tokenEvaluado) {
        if (palabra != null) {
            if (!palabra.equals("Ɛ")) {
                this.pila.pop();
                switch (palabra) {
                    case "ES":
                        pila.push(Producciones.INICIAR);
                        pila.push(Producciones.ESCRITURA);
                        break;
                    case "AS":
                        pila.push(Producciones.INICIAR);
                        pila.push(Producciones.ASIGNACION);
                        break;
                    case "RS":
                        pila.push(Producciones.INICIAR);
                        pila.push(Producciones.REPETIR);
                        break;
                    case "CS":
                        pila.push(Producciones.INICIAR);
                        pila.push(Producciones.CONDICINAL);
                        break;
                    case "$":
                        pila.push(Producciones.EPCILONE);
                        break;
                    case "ESCRIBIR L FIN E":
                        pila.push(Producciones.ESCRITURA);
                        pila.push("FIN");
                        pila.push(Producciones.LEXEMA);
                        pila.push("ESCRIBIR");
                        break;
                    case "Literal":
                        pila.push("Literal");
                        break;
                    case "Numero":
                        pila.push("Numero");
                        break;
                    case "id":
                        pila.push("id");
                        break;
                    case "REPETIR H INICIAR E FIN R":
                        pila.push(Producciones.REPETIR);
                        pila.push("FIN");
                        pila.push(Producciones.ESCRITURA);
                        pila.push("INICIAR");
                        pila.push(Producciones.TERMINALH);
                        pila.push("REPETIR");
                        break;
                    case "Si B ENTONCES E FIN C":
                        pila.push(Producciones.CONDICINAL);
                        pila.push("FIN");
                        pila.push(Producciones.ESCRITURA);
                        pila.push("ENTONCES");
                        pila.push(Producciones.BOOLEAN);
                        pila.push("SI");
                        break;
                    case "VERDADERO":
                        pila.push("VERDADERO");
                        break;
                    case "FALSO":
                        pila.push("FALSO");
                        break;
                    case "TX’":
                        pila.push(Producciones.PRODUCCIONXP);
                        pila.push(Producciones.PRODUCCIONT);
                        break;
                    case "+TX’":
                        pila.push(Producciones.PRODUCCIONXP);
                        pila.push(Producciones.PRODUCCIONT);
                        pila.push("+");
                        break;
                    case "FT’":
                        pila.push(Producciones.PRODUCCIONTP);
                        pila.push(Producciones.PRODUCCIONF);
                        break;
                    case "*FT’":
                        pila.push(Producciones.PRODUCCIONTP);
                        pila.push(Producciones.PRODUCCIONF);
                        pila.push("*");
                        break;
                    case "(X)":
                        pila.push(")");
                        pila.push(Producciones.PRODUCCIONX);
                        pila.push("(");
                        break;
                    case "id = X FIN A":
                        pila.push(Producciones.ASIGNACION);
                        pila.push("FIN");
                        pila.push(Producciones.PRODUCCIONX);
                        pila.push("=");
                        pila.push("id");
                        break;
                          default:
                        JOptionPane.showMessageDialog(null, "UN ERROR EN LA MATRIX, este error nu lo pude manejar XD");
                        System.exit(0);
                        break;
                }

            } else {
                if (terminalExistenteEnPila(tokenEvaluado)) {
                    while (comprobar(this.pila.peek())) {
                        this.pila.pop();
                    }
                } else {
                    if (this.pila.contains(Producciones.PRODUCCIONXP)) {
                        while (!Producciones.PRODUCCIONXP.equals(this.pila.peek())) {
                            this.pila.pop();
                        }
                    } else {
                        //hasta encontrar Produccion INICIAR
                        while (!Producciones.INICIAR.equals(this.pila.peek())) {
                            this.pila.pop();
                        }
                    }

                }

            }
        } else {
            //es un error 
        }

    }

    public Stack getPila() {
        return pila;
    }

    public void setPila(Stack pila) {
        this.pila = pila;
    }

    public boolean comprobar(Object ob) {
        boolean esEnum = false;
        Producciones[] pro = Producciones.values();
        for (Producciones producciones : pro) {
            esEnum = producciones.equals(ob);
            if (esEnum) {
                break;
            }
        }

        return esEnum;
    }

    private boolean terminalExistenteEnPila(String tokenEvaluando) {
        return this.pila.contains(tokenEvaluando);
    }

}
