/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegooca;

public class CasillaMuerte extends Casilla {

    // Constructor por defecto
    public CasillaMuerte() {
        super();
    }

    // Constructor con solo número
    public CasillaMuerte(int numero) {
        super(numero, "Muerte");
    }

    // Constructor por parámetros
    public CasillaMuerte(int numero, String nombre) {
        super(numero, nombre);
    }

    // Constructor de copia
    public CasillaMuerte(CasillaMuerte c) {
        super(c);
    }

    @Override
    public void aplicarEfecto(Jugador jugador) {
        System.out.println("EL JUGADOR " + jugador.getNombre() + " HA CAÍDO EN LA MUERTE.");
        System.out.println("Vuelve a la casilla inicial.");

        jugador.setPosicionActual(0);
        jugador.setPuedeRepetirTurno(false);
    }

    @Override
    public String toString() {
        return "Casilla MUERTE " + getNumero();
    }
}
