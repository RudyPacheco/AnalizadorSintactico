/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectoLenguajes.recolector;

import com.proyectoLenguaje.tablaSimbolos.TablaSimbolo;
import com.proyectoLenguajes.reportes.Tokens;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author AndaryuS
 */
public class recolectorSintactico {

    JFileChooser seleccionar = new JFileChooser();
    FileInputStream entrada;
    FileOutputStream salida;
    File archivo;

    String tokenGuia;
    String cadea;
    String documento;
    boolean error = false;
    ArrayList<String> cadenas = new ArrayList<>();
    int ciclo;
    String iniciarR;
    String tokenSubGUIA;
    String tokenACCION;

    public void recolectar(String tipoToken, Tokens token, TablaSimbolo tabla) {

        if (token != null) {
            if (!tipoToken.equals("ERROR")) {
                if (tokenGuia == null) {
                    if (tipoToken.equals("ESCRIBIR")) {
                        tokenGuia = tipoToken;
                    } else if (tipoToken.equals("REPETIR")) {
                        tokenGuia = tipoToken;
                    } else if (tipoToken.equals("SI")) {
                        tokenGuia = tipoToken;
                    }

                } else {
                    if (tokenGuia.equals("ESCRIBIR")) {

                        if (tipoToken.equals("FIN")) {
                            System.out.println(cadea);

                            documento += "\n" + cadea;
                            tokenGuia = null;
                            cadea = null;
                        } else {
                            cadea = quitarComillas(token, tabla);
                        }
                    } else if (tokenGuia.equals("REPETIR")) {
                        if (tipoToken.equals("Numero")) {
                            ciclo = Integer.parseInt(token.getLexema());
                        }
                        if (tipoToken.equals("INICIAR")) {
                            iniciarR = "INICIAR";
                        }

                        if (iniciarR != null && tipoToken.equals("ESCRIBIR")) {
                            tokenACCION = "ESCRIBIR";
                        }

                        if (tipoToken.equals("Literal")) {
                            //  cadea = token.getLexema();
                            cadenas.add(quitarComillas(token, tabla));
                        }
                        //X
                        if (tipoToken.equals("FIN") && tokenACCION != null) {
                            tokenACCION = null;
                        } else if (tipoToken.equals("FIN") && tokenACCION == null) {

                            impirmirCiclo();
                            // System.out.println("CONDICION : " + cadea);
                            //documento += cadea;
                            cadenas.clear();
                            cadea = null;
                            tokenGuia = null;
                            tokenACCION = null;
                            tokenSubGUIA = null;
                        }

                    } else if (tokenGuia.equals("SI")) {
                        if (tipoToken.equals("VERDADERO")) {
                            tokenSubGUIA = "VERDADERO";
                        }
                        if (tipoToken.equals("FALSO")) {
                            tokenSubGUIA = "FALSO";
                        }
                        if (tipoToken.equals("ESCRIBIR")) {
                            tokenACCION = "ESCRIBIR";
                        }
                        if (tipoToken.equals("Numero") || tipoToken.equals("Literal")) {
                            cadea = quitarComillas(token, tabla);
                        }
                        if (tipoToken.equals("FIN") && tokenACCION != null) {
                            tokenACCION = null;
                        } else if (tipoToken.equals("FIN") && tokenACCION == null) {
                            if (tokenSubGUIA.equals("VERDADERO")) {
                                System.out.println("CONDICION : " + cadea);
                                documento += "\n" + cadea;
                            } else {
                                System.out.println("CONDICION FALSA");
                            }

                            cadea = null;
                            tokenGuia = null;
                            tokenACCION = null;
                            tokenSubGUIA = null;
                        }

                    }

                 
                }

            } else {
                error = true;
            }
        } else {
            System.out.println("error verdadero");
            error = true;
        }
        
           if (tipoToken.equals("FINALIZAR")) {
                        if (error == false) {
                            System.out.println("ENTRO  A FINALIZAR");
                            archivoSalida();
                        }
                    }


    }

    public void archivoSalida() {
        if (seleccionar.showDialog(null, "guaradar") == JFileChooser.APPROVE_OPTION) {
            archivo = seleccionar.getSelectedFile();
            
            String documentoS = this.documento.substring(4);
            String mensaje = guardarComoArchivo(documentoS);
            if (mensaje != null) {
                JOptionPane.showMessageDialog(null, "Archivo guardado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al guarda archivo");
            }

        }
    }

    public String guardarComoArchivo(String documento) {
        String mensaje = null;
        try {
            salida = new FileOutputStream(archivo);
            byte[] bytxt = documento.getBytes();
            salida.write(bytxt);
            mensaje = "archivo guardado";
        } catch (IOException e) {
            System.out.println("error en guardar");
        }
        return mensaje;
    }

    public void impirmirCiclo() {
        for (int i = 0; i < ciclo; i++) {

            for (int j = 0; j < cadenas.size(); j++) {
                documento += "\n" + cadenas.get(j);
                System.out.println("REPETIR: " + cadenas.get(j));

            }

        }

    }

//    public String quitarComillas(String input_str){
//        
//       String result = input_str.replaceAll("^\"+|\"+$", "");
//       
//       return result;
//    }
//    
    public String quitarComillas(Tokens token, TablaSimbolo tabla) {
        String salidaR = "";
        switch (token.getTipoToken()) {
            case "id":
                salidaR += tabla.valorEnSimbolo(token.getLexema());
                break;
            case "Literal":
                salidaR += token.getLexema().replace("\"", "");
                break;
            default:
                salidaR += token.getLexema();
                break;
        }

        return salidaR;
    }
    
    
    public void setError(boolean  error){
        this.error=error;
    }

}
