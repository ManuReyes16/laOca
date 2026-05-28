/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.JuegoOca;

import java.util.ArrayList;
import java.util.Scanner;


public class JuegoOcaMain {

    // MAIN
    public static void main(String[] args) {

        // Creamos el tablero que carga el archivo JSON con las casillas
        Tablero tablero = new Tablero();

        // muestro info del juegorrr
        System.out.println("==============================================");
        System.out.println("BIENVENIDO / BIENVENIDA AL JUEGO DE LA OCA");
        System.out.println("Una aventura de azar, peligros y estrategia");
        System.out.println("Hecha por Alberto, Manuel y Nacho :)");
        System.out.println("==============================================");
        System.out.println();

        //creamos el scanner para escribir
        Scanner teclado = new Scanner(System.in);

        //creamos una lista donde se guardarán los jugadores
        ArrayList<Jugador> listaJugadores = new ArrayList<>();

        System.out.println("El tablero se ha creado correctamente, con " + tablero.getNumCasillas() + " casillas en total.");
        System.out.println("Esperando a los jugadores ... ...");

        
        //PARTE DE CREACIÓN DE JUGADORES

        //preguntamos número de jugadores
        System.out.println("¿Cuántos participantes van a jugar?");
        int numParticipantes = teclado.nextInt();
        teclado.nextLine(); // limpiar el salto de línea

        //bucle que se repite según jugadores
        for (int i = 1; i <= numParticipantes; i++) {
            System.out.println("Introduce el nombre del jugador " + i + ":");
            String nombreJugador = teclado.nextLine();
            Jugador jugador = new Jugador(nombreJugador);
            listaJugadores.add(jugador);
        } 

        System.out.println("Los jugadores están listos... ... ...");



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
