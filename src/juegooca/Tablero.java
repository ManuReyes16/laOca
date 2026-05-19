/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegooca;

public class Tablero {

    // Atributos
    private Casilla[] casillas;
    private int numCasillas;

    // Constructor por defecto
    public Tablero() {
        this.numCasillas = 40;
        this.casillas = new Casilla[numCasillas + 1];
        generarTablero();
    }

    // Constructor por parámetros
    public Tablero(int numCasillas) {
        this.numCasillas = numCasillas;
        this.casillas = new Casilla[numCasillas + 1];
        generarTablero();
    }

    // Constructor de copia
    public Tablero(Tablero t) {
        this.numCasillas = t.numCasillas;
        this.casillas = t.casillas;
    }

    // Getters
    public Casilla[] getCasillas() {
        return casillas;
    }

    public int getNumCasillas() {
        return numCasillas;
    }

    // Setters
    public void setCasillas(Casilla[] casillas) {
        this.casillas = casillas;
    }

    public void setNumCasillas(int numCasillas) {
        this.numCasillas = numCasillas;
    }

    // Métodos
    private void generarTablero() {

        // Primero rellenamos todo el tablero con casillas normales
        for (int i = 1; i <= numCasillas; i++) {
            casillas[i] = new CasillaNormal(i);
        }


        casillas[5] = new CasillaOca(5);
        casillas[9] = new CasillaOca(9);
        casillas[14] = new CasillaOca(14);
        casillas[18] = new CasillaOca(18);
        casillas[23] = new CasillaOca(23);
        casillas[27] = new CasillaOca(27);
        casillas[32] = new CasillaOca(32);
        casillas[36] = new CasillaOca(36);

        // Puentes
        casillas[6] = new CasillaPuente(6);
        casillas[12] = new CasillaPuente(12);

        // Posada
        casillas[19] = new CasillaPosada(19);

        // Laberinto
        casillas[30] = new CasillaLaberinto(30);

        // Muerte
        casillas[38] = new CasillaMuerte(38);

        // Meta
        casillas[40] = new CasillaMeta(40);
    }

    public Casilla getCasilla(int numero) {
        return casillas[numero];
    }

    @Override
    public String toString() {
        return "Tablero de " + numCasillas + " casillas";
    }
}