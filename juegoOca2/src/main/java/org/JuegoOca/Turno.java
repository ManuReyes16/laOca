package org.JuegoOca;
import java.util.List;

/**
 *
 * @author EAG
 */
public class Turno {
    private List<Jugador> jugadores;
    private int indiceActual;
    private boolean repetirTurno;

    public Turno(List<Jugador> jugadores) {
        if (jugadores == null || jugadores.isEmpty()) {
            throw new IllegalArgumentException("Debe haber al menos un jugador para empezar la partida.");
        }
        this.jugadores = jugadores;
        this.indiceActual = 0;
        this.repetirTurno = false;
    }

    public Jugador getJugadorActual() {
        return jugadores.get(indiceActual);
    }

    public void concederRepeticion() {
        this.repetirTurno = true;
    }

    public void avanzarTurno() {
        if (repetirTurno) {
            System.out.println("¡" + getJugadorActual().getNombre() + " repite turno!");
            repetirTurno = false;
            return;
        }
        indiceActual = (indiceActual + 1) % jugadores.size();

        while (getJugadorActual().getTurnosPerdidos() > 0) {
            System.out.println(getJugadorActual().getNombre() + " está penalizado y pierde su turno.");
            getJugadorActual().getTurnosPerdidos();
            indiceActual = (indiceActual + 1) % jugadores.size();
        }
    }
}
