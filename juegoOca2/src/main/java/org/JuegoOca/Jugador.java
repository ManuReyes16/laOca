/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.JuegoOca;


public class Jugador {

    //atributos
    private String nombre;
    private int posicionActual;
    private boolean puedeRepetirTurno = false;
    private int turnosPerdidos;


    //constructor x defecto
    public Jugador(){
        this.nombre = "Desconocido";
        this.posicionActual = 1;    //CasillaOca empieza en el 1
        this.puedeRepetirTurno = false;
        this.turnosPerdidos = 0;
    }

    //constructor x parámetros
    public Jugador(String nombre, int posicionActual, boolean puedeRepetirTurno){
        this.nombre = nombre;
        this.posicionActual = posicionActual;
        this.puedeRepetirTurno = puedeRepetirTurno;
        this.turnosPerdidos = 0;
    }

    //constructor de copia
    public Jugador(Jugador j){
        this.nombre = j.nombre;
        this.posicionActual = j.posicionActual;
        this.puedeRepetirTurno = j.puedeRepetirTurno;
        this.turnosPerdidos = j.turnosPerdidos;
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
    public int getTurnosPerdidos() {
        return turnosPerdidos;
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
    public void setTurnosPerdidos(int turnosPerdidos) {
        this.turnosPerdidos = turnosPerdidos;
    }
    public void setPosicion(int posicion){this.posicionActual = posicion; }

    public void restarTurnoPerdido() {
        if (this.turnosPerdidos > 0) {
            this.turnosPerdidos--;
        }
    }

    //metodos
    @Override
    public String toString(){
        return "JUGADOR : " + nombre + " CASILLA : " + posicionActual;
    }

}
