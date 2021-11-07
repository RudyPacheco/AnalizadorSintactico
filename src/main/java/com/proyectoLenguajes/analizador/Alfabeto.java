package com.proyectoLenguajes.analizador;

import java.util.ArrayList;

/**
 *
 * @author elvis_agui
 */
public class Alfabeto {

    private ArrayList<Character> agrupacion;
    private ArrayList<Character> operador;
    private ArrayList<Character> CaracterEspecial;
    private ArrayList<Character> variados;
    private String igual = "=";
    private char diagonal = '/';
    private char guionMedio = '-';
    private char guionBajo = '_';
    private char comillas = '"';
    private String Salto = "\n";
    private String tabulador = "\t";

    public Alfabeto() {
        this.defAlfabeto();
    }

    private void defAlfabeto() {
        defAgrupacion();
        defOperador();
        defPuntuacion();
        defCareacteresEspeciales();
    }

    private void defAgrupacion() {
        agrupacion = new ArrayList<>();
        this.agrupacion.add('(');
        this.agrupacion.add(')');
    }

    private void defPuntuacion() {
        variados = new ArrayList<>();
        this.variados.add('.');
        this.variados.add(':');
        this.variados.add(';');
        this.variados.add(',');
        this.variados.add('>');
        this.variados.add('<');
        this.variados.add('<');
        this.variados.add('‘');
        this.variados.add('‘');
        this.variados.add('\'');

    }

    private void defOperador() {
        operador = new ArrayList<>();
        this.operador.add('+');
        this.operador.add('*');
        this.operador.add('%');
    }

    private void defCareacteresEspeciales() {
        this.CaracterEspecial = new ArrayList<>();
        this.CaracterEspecial.add('n');
        this.CaracterEspecial.add('r');
        this.CaracterEspecial.add('t');
        this.CaracterEspecial.add('f');
    }

    public int alfabetoValueOf(int estadoActual, char caracter) {
        int valor = -1;
        if (CaracterEspecial.contains(caracter)) {
            if (estadoActual == 3) {
                valor = 0;
            } else {
                valor = 9;
            }
        } else if (Character.isDigit(caracter)) {
            valor = 1;
        } else if (Character.compare(caracter, diagonal) == 0) {
            valor = 2;
        } else if (agrupacion.contains(caracter)) {
            valor = 4;
        } else if (operador.contains(caracter)) {
            valor = 5;
        } else if (variados.contains(caracter)) {
            valor = 3;
        } else if (Character.isSpaceChar(caracter) || Character.compare(caracter, tabulador.charAt(0)) == 0) {
            switch (estadoActual) {
                case 4:
                    valor = 4;
                    break;
                case 2:
                    valor = 2;
                    break;
                default:
                    valor = -2;
                    break;
            }
        } else if (Character.compare(caracter, this.Salto.charAt(0)) == 0) {
            valor = -3;
        } else if (Character.compare(caracter, guionMedio) == 0) {
            valor = 6;
        } else if (Character.compare(caracter, comillas) == 0) {
            valor = 8;
        } else if (Character.isLetter(caracter)) {
            valor = 0;
        } else if (Character.compare(caracter, guionBajo) == 0) {
            valor = 10;
        } else if (Character.compare(caracter, igual.charAt(0)) == 0) {
            valor = 11;
        }
        return valor;
    }

    public ArrayList<Character> getAgrupacion() {
        return agrupacion;
    }

    public void setAgrupacion(ArrayList<Character> agrupacion) {
        this.agrupacion = agrupacion;
    }

    public ArrayList<Character> getOperador() {
        return operador;
    }

    public void setOperador(ArrayList<Character> operador) {
        this.operador = operador;
    }

    public ArrayList<Character> getCaracterEspecial() {
        return CaracterEspecial;
    }

    public void setCaracterEspecial(ArrayList<Character> CaracterEspecial) {
        this.CaracterEspecial = CaracterEspecial;
    }

    public ArrayList<Character> getVariados() {
        return variados;
    }

    public void setVariados(ArrayList<Character> variados) {
        this.variados = variados;
    }

    public String getIgual() {
        return igual;
    }

    public void setIgual(String igual) {
        this.igual = igual;
    }

    public char getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(char diagonal) {
        this.diagonal = diagonal;
    }

    public char getGuionMedio() {
        return guionMedio;
    }

    public void setGuionMedio(char guionMedio) {
        this.guionMedio = guionMedio;
    }

    public char getGuionBajo() {
        return guionBajo;
    }

    public void setGuionBajo(char guionBajo) {
        this.guionBajo = guionBajo;
    }

    public char getComillas() {
        return comillas;
    }

    public void setComillas(char comillas) {
        this.comillas = comillas;
    }

    public String getSalto() {
        return Salto;
    }

    public void setSalto(String Salto) {
        this.Salto = Salto;
    }

}
