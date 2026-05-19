/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegooca;

public class CasillaPuente extends Casilla {

    // Constructor por defecto
    public CasillaPuente() {
        super();
    }

    // Constructor con solo número
    public CasillaPuente(int numero) {
        super(numero, "Puente");
    }

    // Constructor por parámetros
    public CasillaPuente(int numero, String nombre) {
        super(numero, nombre);
    }

    // Constructor de copia
    public CasillaPuente(CasillaPuente c) {
        super(c);
    }

    @Override
    public void aplicarEfecto(Jugador jugador) {
        System.out.println("EL JUGADOR " + jugador.getNombre() + " HA CAÍDO EN EL PUENTE.");

        if (getNumero() == 6) {
            jugador.setPosicionActual(12);
            System.out.println("De puente a puente. Avanza a la casilla 12.");
        } else if (getNumero() == 12) {
            jugador.setPosicionActual(6);
            System.out.println("De puente a puente. Retrocede a la casilla 6.");
        }

        jugador.setPuedeRepetirTurno(false);
    }

    @Override
    public String toString() {
        return "Casilla PUENTE " + getNumero();
    }
}
