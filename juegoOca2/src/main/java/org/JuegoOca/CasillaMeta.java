/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.JuegoOca;

public class CasillaMeta extends Casilla {

    // Constructor por defecto
    public CasillaMeta() {
        super();
    }

    // Constructor con solo número
    public CasillaMeta(int numero) {
        super(numero, "Meta");
    }

    // Constructor por parámetros
    public CasillaMeta(int numero, String nombre) {
        super(numero, nombre);
    }

    // Constructor de copia
    public CasillaMeta(CasillaMeta c) {
        super(c);
    }

    @Override
    public void aplicarEfecto(Jugador jugador) {
        System.out.println("EL JUGADOR " + jugador.getNombre() + " HA LLEGADO A LA META.");
        jugador.setPuedeRepetirTurno(false);
    }

    @Override
    public String toString() {
        return "Casilla META " + getNumero();
    }
}
