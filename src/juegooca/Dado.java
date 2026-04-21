/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegooca;

//importamos esta clase 
import java.util.Random;

public class Dado {
    private int caras;
    private Random generador;
    
    //constructor x defecto
    public Dado(){
        this.caras = 6;  //por defecto va a ser simple con 6 caras
        this.generador = new Random();
    }
    
    //constructor x parámetros
    public Dado(int caras){
        this.caras = caras;
        this.generador = new Random();
    }
    
    //getters
    public int getCaras(){
        return caras;
    }
    
    //setters
    public void setCaras(int caras){
        this.caras = caras;
    }
    
    //metodos
    public int lanzar(){
        int resultado = generador.nextInt(caras) + 1;
        System.out.println("TU NÚMERO ES : " + resultado);
        return resultado;
    }
}
