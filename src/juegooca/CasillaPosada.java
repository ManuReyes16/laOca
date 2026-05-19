/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegooca;

public class CasillaPosada extends Casilla {

    // Constructor por defecto
    public CasillaPosada() {
        super();
    }

    // Constructor con solo número
    public CasillaPosada(int numero) {
        super(numero, "Posada");
    }

    // Constructor por parámetros
    public CasillaPosada(int numero, String nombre) {
        super(numero, nombre);
    }

    // Constructor de copia
    public CasillaPosada(CasillaPosada c) {
        super(c);
    }

    @Override
    public void aplicarEfecto(Jugador jugador) {
        System.out.println("EL JUGADOR " + jugador.getNombre() + " HA CAÍDO EN LA POSADA.");
        System.out.println("Pierde un turno.");

        jugador.setTurnosPerdidos(1);
        jugador.setPuedeRepetirTurno(false);
    }

    @Override
    public String toString() {
        return "Casilla POSADA " + getNumero();
    }



}
