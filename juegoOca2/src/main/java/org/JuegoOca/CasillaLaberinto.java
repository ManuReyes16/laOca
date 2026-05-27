/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.JuegoOca;

public class CasillaLaberinto extends Casilla {

    // Constructor por defecto
    public CasillaLaberinto() {
        super();
    }


    public CasillaLaberinto(int numero) {
        super(numero, "Laberinto");
    }

    // Constructor por parámetros
    public CasillaLaberinto(int numero, String nombre) {
        super(numero, nombre);
    }

    // Constructor de copia
    public CasillaLaberinto(CasillaLaberinto c) {
        super(c);
    }

    @Override
    public void aplicarEfecto(Jugador jugador) {
        System.out.println("EL JUGADOR " + jugador.getNombre() + " HA CAÍDO EN EL LABERINTO.");
        System.out.println("Retrocede a la casilla 30.");

        jugador.setPosicionActual(15);
        jugador.setPuedeRepetirTurno(false);
    }

    @Override
    public String toString() {
        return "Casilla LABERINTO " + getNumero();
    }
}
