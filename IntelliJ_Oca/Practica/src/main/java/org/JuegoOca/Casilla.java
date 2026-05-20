/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegooca;


//hacemos esta clase abstracta porque es la CLASE PADRE

public abstract class Casilla {
    
    //atributos protected x ser abstract
    protected int numero;
    protected String nombre;
    
    //constructor x defecto
    public Casilla(){
        this.numero = 0;
        this.nombre = "";
    }
    
    //constructor x parámetros    
    public Casilla(int numero, String nombre){
        this.numero = numero;
        this.nombre = nombre;
    }    
    
    //constructor de copia
    public Casilla(Casilla c){
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

   @override
   public String toString(){

       return  "numero de la casilla: "+ this.numero \\
       return  "nombre de la casilla: " + this.nombre
   }
}
