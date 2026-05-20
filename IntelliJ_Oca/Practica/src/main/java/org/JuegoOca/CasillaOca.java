/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegooca;

public class CasillaOca extends Casilla {

    // Atributo constante: posiciones donde hay ocas
    private static final int[] POSICIONES_OCAS = {5, 9, 14, 18, 23, 27, 32, 36};

    // Constructor por defecto
    public CasillaOca() {
        super();
    }

    // Constructor con solo número
    public CasillaOca(int numero) {
        super(numero, "Oca");
    }

    // Constructor por parámetros
    public CasillaOca(int numero, String nombre) {
        super(numero, nombre);
    }

    // Constructor de copia
    public CasillaOca(CasillaOca c) {
        super(c);
    }

    @Override
    public void aplicarEfecto(Jugador jugador) {
        System.out.println("DE OCA EN OCA Y TIRO PORQUE ME TOCA");
        System.out.println("EL JUGADOR " + jugador.getNombre() + " HA CAÍDO EN LA OCA!");

        // Se calcula la siguiente posición de oca
        int nuevaPosicion = calcularSiguienteOca(this.getNumero());

        // Se mueve al jugador
        jugador.setPosicionActual(nuevaPosicion);

        // Puede volver a tirar
        jugador.setPuedeRepetirTurno(true);

        System.out.println("Avanza hasta la casilla " + nuevaPosicion);
    }

    private int calcularSiguienteOca(int posicionActual) {
        for (int oca : POSICIONES_OCAS) {
            if (oca > posicionActual) {
                return oca;
            }
        }

        // Si no hay más ocas, se queda donde está
        return posicionActual;
    }

    @Override
    public String toString() {
        return "Casilla de la OCA " + getNumero();
    }
}