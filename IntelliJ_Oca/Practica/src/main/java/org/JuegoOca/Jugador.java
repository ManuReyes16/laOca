package org.JuegoOca;

public class Jugador {

    //atributos
    private String nombre;
    private int posicionActual;
    private boolean puedeRepetirTurno = false;


    //constructor x defecto
    public Jugador(){
        this.nombre = "Desconocido";
        this.posicionActual = 1;    //CasillaOca empieza en el 1
        this.puedeRepetirTurno = false;
    }

    //constructor x parámetros
    public Jugador(String nombre, int posicionActual, boolean puedeRepetirTurno){
        this.nombre = nombre;
        this.posicionActual = posicionActual;
        this.puedeRepetirTurno = puedeRepetirTurno;
    }

    //constructor de copia
    public Jugador(Jugador j){
        this.nombre = j.nombre;
        this.posicionActual = j.posicionActual;
        this.puedeRepetirTurno = j.puedeRepetirTurno;
    }

    //getters
    public String getNombre(){
        return this.nombre;
    }
    public int getPosicionActual(){
        return this.posicionActual;
    }
    public boolean getPuedeRepetirTurno(){
        return this.puedeRepetirTurno;
    }

    //setter
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setPosicionActual(int posicionActual){
        this.posicionActual = posicionActual;
    }
    public void setPuedeRepetirTurno(boolean repetir){
        this.puedeRepetirTurno = repetir;
    }

    //metodos
    @Override
    public String toString(){
        return "JUGADOR : " + nombre + " CASILLA : " + posicionActual;
    }

}
