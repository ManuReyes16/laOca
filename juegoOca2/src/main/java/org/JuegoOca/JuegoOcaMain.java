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




        
        //cerramos el teclado al final
        teclado.close();


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


        
        
        DadoC dado = new DadoC();

        Jugador jugadorPrueba = new Jugador();
        jugadorPrueba.setNombre("Manuel");
        jugadorPrueba.setPosicionActual(0);
        jugadorPrueba.setPuedeRepetirTurno(false);

    ejecutarTurno(jugadorPrueba, dado, tablero);
        
        
        
    
    }
    
    public static void ejecutarTurno(Jugador jugador, DadoC dado, Tablero tablero) {

        jugador.setPuedeRepetirTurno(false);

        System.out.println();
        System.out.println("Turno de " + jugador.getNombre());
        System.out.println("Posición inicial: " + jugador.getPosicionActual());

        int tirada = dado.lanzar();
        System.out.println(jugador.getNombre() + " ha sacado un " + tirada);

        int nuevaPosicion = jugador.getPosicionActual() + tirada;

        if (nuevaPosicion > tablero.getNumCasillas()) {
            int exceso = nuevaPosicion - tablero.getNumCasillas();
            nuevaPosicion = tablero.getNumCasillas() - exceso;

            System.out.println("Te has pasado de la meta.");
            System.out.println("Rebotas hasta la casilla " + nuevaPosicion);
        }

        jugador.setPosicionActual(nuevaPosicion);

        System.out.println(jugador.getNombre() + " cae en la casilla " + jugador.getPosicionActual());

        Casilla casillaActual = tablero.getCasilla(jugador.getPosicionActual());

        casillaActual.aplicarEfecto(jugador);

        System.out.println(jugador.getNombre() + " termina en la casilla " + jugador.getPosicionActual());

        if (jugador.getPuedeRepetirTurno()) {
            System.out.println(jugador.getNombre() + " puede repetir turno.");
        } else {
            System.out.println(jugador.getNombre() + " no repite turno.");
        }
    }
}
    

