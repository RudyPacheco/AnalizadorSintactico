/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectosLenguajes.analizadorSintactico;

/**
 *
 * @author AndaryuS
 */
public class alfabetoSintactico {

    public int getEstado(Producciones produci) {
        int valor = 0;
        switch (produci) {
            case INICIAR:
                valor = 0;
                break;
            case ESCRITURA:
                valor = 1;
                break;
            case LEXEMA:
                valor = 2;
                break;
            case REPETIR:
                valor = 3;
                break;
            case TERMINALH:
                valor = 4;
                break;
            case CONDICINAL:
                valor = 5;
                break;
            case BOOLEAN:
                valor = 6;
                break;
            case PRODUCCIONX:
                valor = 7;
                break;
            case PRODUCCIONXP:
                valor = 8;
                break;
            case PRODUCCIONT:
                valor = 9;
                break;
            case PRODUCCIONTP:
                valor = 10;
                break;
            case PRODUCCIONF:
                valor = 11;
                break;
            case ASIGNACION:
                valor = 12;
                break;
        }

        return valor;
    }

    public int getValorTernminal(String tipoToken) {
        int valor = 0;
        switch (tipoToken) {
            case "ESCRIBIR":
                valor = 0;
                break;
            case "FIN":
                valor = 1;
                break;
            case "REPETIR":
                valor = 5;
                break;
            case "INICIAR":
                valor = 6;
                break;
            case "SI":
                valor = 7;
                break;
            case "VERDADERO":
                valor = 9;
                break;
            case "FALSO":
                valor = 10;
                break;
            case "ENTONCES":
                valor = 8;
                break;
            case "id":
                valor = 4;
                break;
            case "Literal":
                valor = 2;
                break;
            case "Numero":
                valor = 3;
                break;
            case "+":
                valor = 11;
                break;
            case "*":
                valor = 12;
                break;
            case "(":
                valor = 13;
                break;
            case ")":
                valor = 14;
                break;
            case "FINALIZAR":
                valor = 15;
                break;

        }

        return valor;
    }

}
