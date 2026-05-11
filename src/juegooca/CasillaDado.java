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
public class CasillaDado extends Casilla{
    //atributos
    public CasillaDado(int numero){
        super();
    }
    // no se pueden cambiar
    private static int[] posiciones_ocas = {3,7,12,17,22,28,33,39};
    
    //constructor x defecto
    public CasillaDado(){
        super();
    }
    
    //constructor x parámetros
    public CasillaDado(int numero, String nombre){
        super(numero, nombre);
    }
    
    //constructor de copia
    public CasillaDado(CasillaDado c){
        super(c);
    }
    
    
    @Override
    public String toString(){
    return "El número es: " + getNumero() +"\n" +
            "El nombre es : " + getNombre();
    }

    @Override
    public void aplicarEfecto(Jugador jugador) {
        System.out.println("DE DADO EN DADO Y TIRO XQ ME HAN DADO UN DADO....");
    }
    
}
