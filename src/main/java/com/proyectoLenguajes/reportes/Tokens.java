
package com.proyectoLenguajes.reportes;

/**
 *
 * @author AndaryuS
 */
public class Tokens {
    
    private String tipoToken;
    private String lexema;
    private int fila;
    private int columna;
     private String descripcion;

    public Tokens(String tipoToken, String lexema, int fila, int columna) {
        this.tipoToken = tipoToken;
        this.lexema = lexema;
        this.fila = fila;
        this.columna = columna;
    }

    
    
    public String getTipoToken() {
        return tipoToken;
    }

    public void setTipoToken(String tipoToken) {
        this.tipoToken = tipoToken;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
    
       public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
    
    
}
