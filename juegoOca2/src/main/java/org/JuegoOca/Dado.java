package org.JuegoOca;

public class Dado extends Casilla {
    //constructor x defecto
    public Dado() {
        super();
    }

    //constructor x número
    public Dado(int numero) {
        super(numero);
    }

    //constructor x parámetros
    public Dado(int numero, String nomnbre){
        super(numero, nombre);
    }

    //constructor de copia
    public Dado(Dado c) {
        super(c);
    }

    @Override
    public void aplicarEfecto(Jugador jugador) {
        System.out.println("DE DADO EN DADO Y TIRO PORQUE ME HA TOCADO");
        System.out.println("El jugador " + jugador.getNombre() + " ha caído en una casilla de dado y tira el dado.");

        //lógica para saltar al siguiente dado
        int nuevaPosicion = this.getNumero();
        if(this.getNumero() == 8) {
            nuevaPosicion = 20;
        } else if(this.getNumero() == 20) {
            nuevaPosicion = 34;
        } else if(this.getNumero() == 34) {
            nuevaPosicion = 8;
        }

        jugador.setPosicion(nuevaPosicion);
        jugador.setPuedeRepetirTurno(true); //puede volver a lanzar

        System.out.println("Se mueve a la casilla " + nuevaPosicion + " y repite turno.");
    }

    @Override
    public String toString() {
        return "Dado{" +
                "numero=" + getNumero() +
                ", nombre='" + getNombre() + '\'' +
                '}';
    }
}
