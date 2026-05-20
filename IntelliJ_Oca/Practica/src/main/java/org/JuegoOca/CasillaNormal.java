/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegooca;

/**
 *
 * @author EAG
 */


public class CasillaNormal extends Casilla {

    // Constructor por defecto
    public CasillaNormal() {
        super();
    }

    // Constructor con solo número
    public CasillaNormal(int numero) {
        super(numero, "Normal");
    }

    // Constructor por parámetros
    public CasillaNormal(int numero, String nombre) {
        super(numero, nombre);
    }

    // Constructor de copia
    public CasillaNormal(CasillaNormal c) {
        super(c);
    }

    @Override
    public void aplicarEfecto(Jugador jugador) {
        System.out.println("Casilla normal. No ocurre nada.");
        jugador.setPuedeRepetirTurno(false);
    }

    @Override
    public String toString() {
        return "Casilla NORMAL " + getNumero();
    }
}
