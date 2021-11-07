/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectosLenguajes.analizadorSintactico;

import com.proyectoLenguajes.reportes.Tokens;
import java.util.ArrayList;

/**
 *
 * @author AndaryuS
 */
public class analizadorSintactico {

    private final Pila pila = new Pila();
    private matrizTransicion matriz = new matrizTransicion();
    private Producciones produccion;
    private alfabetoSintactico alfabeto = new alfabetoSintactico();
    private Tokens token;
    private ArrayList<Tokens> Tokens = new ArrayList<>();
    private ErrorSintactico errores = new ErrorSintactico();
    private recolectorSintactico recolector= new recolectorSintactico();

    public void analizar(ArrayList<Tokens> Tokens) {
        this.Tokens = Tokens;
        int index = 0;
        while (!this.pila.getPila().empty() && index < this.Tokens.size()) {
            System.out.println("entre a anlizar");
            if (this.token == null) {
                this.token = this.Tokens.get(index);
                System.out.println("Asignando nuevo token " + this.token.getTipoToken());
                index++;
            }
            while (comprobar(this.pila.getPila().peek())) {
                System.out.println("valor de pila en producciones " + this.pila.getPila().peek());
                this.produccion = (Producciones) this.pila.getPila().peek();
                String valorMatriz = this.matriz.getMatriz()[this.alfabeto.getEstado(produccion)][this.alfabeto.getValorTernminal(this.token.getTipoToken())];
                System.out.println("valor de matriz a apilar " + valorMatriz);
                if (valorMatriz == null) {
                    String descripError = "El analizador sintactico esperba " + produccion.getEspera();
                    this.errores.camputrarErrorSintactico(token, descripError);
                    token = null;
                    break;
                } else {
                    this.pila.Apilar(valorMatriz, this.token.getTipoToken());
                }

            }
            if (!comprobar(this.pila.getPila().peek())) {
                System.out.println("valor de pila en terminal " + this.pila.getPila().peek());
                if (token.getTipoToken().equalsIgnoreCase((String) this.pila.getPila().peek())) {
                    recolector.recolectar(token.getTipoToken(), token);
                    this.pila.getPila().pop();
                    this.token = null;
                } else {
                    String descripError = "El analizador sintactico esperba un token " + this.pila.getPila().peek();
                    recolector.recolectar("ERROR", token);
                    this.errores.camputrarErrorSintactico(token, descripError);
                    this.token = null;
                }
            }

        }

        System.out.println("todo termino xd");
    }

    public ArrayList<Tokens> getTokens() {
        return Tokens;
    }

    public void setTokens(ArrayList<Tokens> Tokens) {
        this.Tokens = Tokens;
    }

    private boolean comprobar(Object ob) {
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
    
     public ErrorSintactico getErrores() {
        return errores;
    }

    public void setErrores(ErrorSintactico errores) {
        this.errores = errores;
    }


}
