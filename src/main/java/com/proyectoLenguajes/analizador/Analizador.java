package com.proyectoLenguajes.analizador;

import com.proyectoLenguajes.reportes.Errores;
import com.proyectoLenguajes.reportes.Reporte;
import com.proyectoLenguajes.reportes.Tokens;
import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author elvis_agui
 */
public class Analizador {

    private final MatrizEstados estados = new MatrizEstados();
    private ArrayList<String> movimientos = new ArrayList<>();
    private ArrayList<String> lexemas = new ArrayList<>();
    private final Alfabeto alfabeto = new Alfabeto();
    private final JTextArea cadena;
    private String texto;
    private final String Salto = "\n";
    private int posicion = 0;
    private int estadoActual;
    private String palabra = "";
    private Errores reporteErrores = new Errores();
    private Reporte reporte = new Reporte();

    public Analizador(JTextArea cadena) {
        this.reporte.setReporteErrores(reporteErrores);
        this.cadena = cadena;
    }

    /**
     * funcion encargada de analizar caracter por caracte haciedo llamads a la
     * matriz, alfabeto y el movimiento entre las mismas
     */
    public void anlaizar() {
        this.lexemas.clear();
        this.movimientos.clear();
        texto = cadena.getText();
        this.estadoActual = 0;
        char temporal;
        while (posicion < texto.length()) {
            temporal = texto.charAt(posicion);
            int estadoTemporal = getSiguienteEstado(estadoActual, alfabeto.alfabetoValueOf(estadoActual, temporal));
            reporteErrores.recopilador(temporal, estadoTemporal);
            this.reporte.recopilarReporte(temporal, estadoTemporal, texto.length());
            if (estadoTemporal == 10) {
                estadoTemporal = 0;
            }
            this.estadoActual = estadoTemporal;
            if (!siguinteToken(estadoActual, temporal) || reiniciar(estadoActual)) {
                System.out.println("se reinicio xd");
                estadoActual = 0;
            }
            posicion++;
        }
        this.reporte.pabrasReservadas();
        Tokens tokens = new Tokens("FINALIZAR", "FINALIZAR", 00, 00);
        reporte.getTokens().add(tokens);
        this.cadena.setText(this.cadena.getText());
    }

    /**
     * verifica si el estado es -2 para salto, -3 salto linea, -1 erro
     *
     * @param estadoActual el estado de la matriz
     * @return true si hay que reiniciar el automata
     */
    private boolean reiniciar(int estadoActual) {
        boolean reiniciar = false;
        if (estadoActual == -1 || estadoActual == -2 || estadoActual == -3) {
            reiniciar = true;
        }

        return reiniciar;
    }

    /**
     * Funcion que realiza los movimientos en la matriz
     *
     * @param estadoActual
     * @param caracter
     * @return el siguiente estado en la matriz
     */
    private int getSiguienteEstado(int estadoActual, int caracter) {
        int resultado = -1;
        if (caracter >= 0 && caracter <= 11) {
            resultado = estados.getMatriz()[estadoActual][caracter];
        } else if (caracter == -2) {
            resultado = -2;
        } else if (caracter == -3) {
            resultado = -3;
        } else if (caracter == -4){
            resultado = -4;
        }
        return resultado;
    }

    /**
     * verifica si el caracter en espacio o salto de linea
     *
     * @param caracter
     * @return
     */
    private boolean siguinteToken(int estadoActula, char caracter) {
        boolean seguir = true;
        if (Character.isSpaceChar(caracter)) {
            seguir = estadoActula == 4 || estadoActula == 2;
        } else if (Character.compare(caracter, this.Salto.charAt(0)) == 0) {
            seguir = false;
        }if (estadoActula == 10 || estadoActula == -4) {
            seguir = false;
        }
        return seguir;
    }

    /**
     * Controla los movimientos del estado anterio hacia el estado actual
     *
     * @param estadoAnterio
     * @param estadoActual
     * @param caracter
     */
    private void movimientos(int estadoAnterio, int estadoActual, char caracter) {
        String movimiento = "Me movi del estado " + estadoAnterio + " al estado " + estadoActual + " con el caracter " + caracter;
        if (estadoActual >= 0 && estadoAnterio >= 0) {
            this.palabra += caracter;
            this.movimientos.add(movimiento);
        } else {
            if (estadoActual == -2 || estadoActual == -3 || posicion == texto.length() - 1) {
                if (!"".equals(palabra)) {
                    this.lexemas.add(palabra);
                    this.lexemas.add("salto");
                }
            }
            this.palabra = "";
        }

    }

    /**
     * imprime en el jTexArea los movimientos
     *
     * @param area
     */
    public void listarMovimientos(JTextArea area) {
        int index = 0;
        for (String lexema : lexemas) {
            if (!lexema.equals("salto")) {
                area.append(lexema + "\n");
                for (int i = 0; i < lexema.length(); i++) {
                    area.append(movimientos.get(index) + "\n");
                    index++;
                }
                area.append("\n");
            }
        }
    }

    public Errores getReporteErrores() {
        return reporteErrores;
    }

    public Reporte getReporte() {
        return reporte;
    }

}
