/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.JuegoOca;


public class JuegoOcaMain {

    // MAIN
    public static void main(String[] args) {

        // Creo tableroooo
        Tablero tablero = new Tablero();

        // muestro info del juegorrr
        System.out.println("=== JUEGO DE LA OCA ===");
        System.out.println(tablero);
        System.out.println();

        // se recorren todas las casillas del tablero
        for (int i = 1; i <= tablero.getNumCasillas(); i++) {

            Casilla casilla = tablero.getCasilla(i);

            System.out.println(casilla);
        }

        // dado en el main
        System.out.println();
        Dado miDado = new Dado();
        //int tirada = miDado.lanzar();

        //System.out.println("Tirada del dado: " + tirada);
    }
}
