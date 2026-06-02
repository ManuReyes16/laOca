/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.JuegoOca;

//import java.util.ArrayList;
//import java.util.Scanner;
import javafx.application.Application;

public class JuegoOcaMain {

    // MAIN
    public static void main(String[] args) {
        Application.launch(JuegoOcaView.class, args);
        }
    
/*
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
            Casilla c = tablero.getCasilla(i);
            String icono = "⬜"; // Normal
            
            // Cambia según el nombre o tipo que contenga tu objeto Casilla
            String nombre = c.toString().toLowerCase(); 
            
            if (nombre.contains("oca")) icono = "X";
            else if (nombre.contains("puente")) icono = "X";
            else if (nombre.contains("posada")) icono = "X";
            else if (nombre.contains("muerte")) icono = "X";
            else if (nombre.contains("laberinto")) icono = "X";
            else if (nombre.contains("meta")) icono = "X";
            else if (nombre.contains("dado")) icono = "X";

            System.out.print(icono + " " + i + "\t");
            
            if (i % 8 == 0) System.out.println(); // Filas de 8 casillas
        }

        System.out.println("\n");


        System.out.println("Comienza el juego... ... ...");

        

        // dado en el main
        
        DadoC dado = new DadoC();


        // el juego no parará mientras 'hayGanador' sea falso
        boolean hayGanador = false;


        while (!hayGanador) {
            
            for (Jugador j : listaJugadores) {
                
                ejecutarTurno(j, dado, tablero);

                System.out.println("-- pulsa ENTER para el siguiente turno ... ...");
                teclado.nextLine();
                
                // Comprobamos tras cada turno si este jugador ha llegado a la META (Casilla 40)
                if (j.getPosicionActual() == tablero.getNumCasillas()) {
                    System.out.println("\n==============================================");
                    System.out.println("¡¡¡ TENEMOS UN GANADOR !!!");
                    System.out.println("Enhorabuena " + j.getNombre() + ", has ganado la partida.");
                    System.out.println("==============================================");
                    
                    hayGanador = true; 
                    break; // Rompe el bucle de jugadores si alguien ya ganó
                }
            }
        }
        


        //cerramos el teclado al final
        teclado.close();
    




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
    */
}
    

