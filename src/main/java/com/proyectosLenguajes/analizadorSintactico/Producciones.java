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
public enum Producciones {
    
   
   FINALIZAR("FINALIZAR"),
   INICIAR("ESCRIBIR, SI, REPETIR, O ID"),
   ESCRITURA("ESCRIBIR"),
   LEXEMA("LITERAL, ID, O NUMERO"),
   REPETIR("REPETIR"),
   TERMINALH("NUMERO O ID"),
   CONDICINAL("SI"),
   BOOLEAN("VERDADERO O FALSO"),
   PRODUCCIONX("NUMERO, ID, +, * (, ), O FIN"),
   PRODUCCIONXP("NUMERO, ID, +, * (, ), O FIN"),
   PRODUCCIONT("NUMERO, ID, +, * (, ), FIN"),
   PRODUCCIONTP("NUMERO, ID, +, * (, ), FIN"),
   PRODUCCIONF("NUMERO, ID, +, * (, ), O FIN"),
   ASIGNACION("ID"),
   EPCILONE("NUMERO, ID, +, * (, ), O FIN");
   
   private String espera;
   
   private Producciones(String Espera){
       this.espera = Espera;
   }

    public String getEspera() {
        return espera;
    }

    public void setEspera(String espera) {
        this.espera = espera;
    }
   
    
    
}
