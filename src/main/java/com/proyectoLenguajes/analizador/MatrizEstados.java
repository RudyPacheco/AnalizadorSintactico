
package com.proyectoLenguajes.analizador;

/**
 *
 * @author elvis_agui
 */
public class MatrizEstados {

    private int matriz[][] = new int[12][12];

    public MatrizEstados() {
        this.inicializacionEstados();
        this.asignarErrores();
    }

    private void inicializacionEstados() {
        this.matriz[0][0] = 3;
        this.matriz[0][1] = 7;
        this.matriz[0][2] = 1;
        this.matriz[0][3] = -1;
        this.matriz[0][4] = 10;
        this.matriz[0][5] = 11;
        this.matriz[0][6] = -1;
        this.matriz[0][7] = 5;
        this.matriz[0][8] = 4;
        this.matriz[0][9] = 3;
        this.matriz[0][10] = 3;
        this.matriz[0][11] = 9;
        this.matriz[1][0] = -1;
        this.matriz[1][1] = -1;
        this.matriz[1][2] = 2;
        this.matriz[1][3] = -1;
        this.matriz[1][4] = -1;
        this.matriz[1][5] = -1;
        this.matriz[1][6] = -1;
        this.matriz[1][7] = -1;
        this.matriz[1][8] = -1;
        this.matriz[1][9] = 8;
        this.matriz[1][10] = -1;
        this.matriz[1][11] = -1;
        this.matriz[2][0] = 2;
        this.matriz[2][1] = 2;
        this.matriz[2][2] = 2;
        this.matriz[2][3] = 2;
        this.matriz[2][4] = 2;
        this.matriz[2][5] = 2;
        this.matriz[2][6] = 2;
        this.matriz[2][7] = 2;
        this.matriz[2][8] = 2;
        this.matriz[2][9] = 2;
        this.matriz[2][9] = 2;
        this.matriz[2][10] = 2;
        this.matriz[2][11] = 2;
        this.matriz[3][0] = 3;
        this.matriz[3][1] = 3;
        this.matriz[3][2] = -1;
        this.matriz[3][3] = -1;
        this.matriz[3][4] = -4;
        this.matriz[3][5] = -1;
        this.matriz[3][6] = 3;
        this.matriz[3][7] = 3;
        this.matriz[3][8] = -1;
        this.matriz[3][9] = -1;
        this.matriz[3][10] = 3;
        this.matriz[3][11] = -1;
        this.matriz[4][0] = 4;
        this.matriz[4][1] = 4;
        this.matriz[4][2] = 4;
        this.matriz[4][3] = 4;
        this.matriz[4][4] = 4;
        this.matriz[4][5] = 4;
        this.matriz[4][6] = 4;
        this.matriz[4][7] = 4;
        this.matriz[4][8] = 6;
        this.matriz[4][9] = 4;
        this.matriz[4][10] = 4;
        this.matriz[4][11] = 4;
        this.matriz[7][1] = 7;
        this.matriz[7][4] = -4;

    }
    
    
    public void asignarErrores(){
         for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == 0) {
                    matriz[i][j] = -1;
                }
            }
            
        }
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }
    
    
    

}
