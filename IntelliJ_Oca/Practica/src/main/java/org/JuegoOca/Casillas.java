package org.JuegoOca;

public abstract class Casillas {

    //atributos protected x ser abtract
    protected int numero;
    protected String nombre;

    //constructor x defecto
    public Casillas(){
        this.numero = 0;
        this.nombre = "";
    }

    //constructor x parámetros
    public Casillas(int numero, String nombre){
        this.numero = numero;
        this.nombre = nombre;
    }

    //constructor de copia
    public Casillas(Casillas c){
        this.numero = c.numero;
        this.nombre = c.nombre;
    }

    //getters
    public int getNumero(){
        return this.numero;
    }
    public String getNombre(){
        return this.nombre;
    }

    //setters
    public void setNumero(int numero){
        this.numero = numero;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }


    //el método lo heredan las otras clases
    public abstract void aplicarEfecto(Jugador jugador);
}
