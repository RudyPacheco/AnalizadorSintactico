/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectoLenguajes.recolector;

import com.proyectoLenguaje.tablaSimbolos.TablaSimbolo;
import com.proyectoLenguajes.reportes.Tokens;
import com.proyectosLenguajes.analizadorSintactico.Producciones;

/**
 *
 * @author AndaryuS
 */
public class recolectorGeneral {

    private final TablaSimbolo tabla = new TablaSimbolo();
    private final recolectorSintactico recolector = new recolectorSintactico();

    public void recolectorFucionesSalida(Producciones produccion, Tokens token) {
        if (token != null) {
            tabla.recolectarAsignacion(produccion, token);
            this.recolector.recolectar(token.getTipoToken(), token, tabla);

        } else {
            System.out.println("token null");
            this.recolector.setError(true);
        }

    }

    public TablaSimbolo getTabla() {
        return tabla;
    }

    public recolectorSintactico getRecolector() {
        return recolector;
    }

}
