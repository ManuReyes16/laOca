/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.JuegoOca;

import java.io.FileNotFoundException;
import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;    //sirve para ordenar

public class Tablero {

    // Atributos
    private ArrayList<Casilla> casillas;
    private int numCasillas;

    // Constructor por defecto
    public Tablero() {
        this.numCasillas = 40;
        this.casillas = new ArrayList<>();
        generarTablero();
    }

    // Constructor por parámetros
    public Tablero(int numCasillas) {
        this.numCasillas = numCasillas;
        this.casillas = new ArrayList<>();
        generarTablero();
    }

    // Constructor de copia
    public Tablero(Tablero t) {
        this.numCasillas = t.numCasillas;
        this.casillas = new ArrayList<>(t.casillas);
    }

    // Getters
    public ArrayList<Casilla> getCasillas() {
        return casillas;
    }
    public int getNumCasillas() {
        return numCasillas;
    }

    // Setters
    public void setCasillas(ArrayList<Casilla> casillas) {
        this.casillas = casillas;
    }
    public void setNumCasillas(int numCasillas) {
        this.numCasillas = numCasillas;
    }

    //métodos
    private void generarTablero(){
        Gson traductor = new Gson();
        try{
            FileReader fr = new FileReader("./datos/casilla.json");
            CasillaIntermedia objetoIntermedio = traductor.fromJson(fr, CasillaIntermedia.class);
            fr.close();


            //rellenamos el atributo real de la clase (this.casillas)
            this.casillas.addAll(objetoIntermedio.getOca());
            this.casillas.addAll(objetoIntermedio.getLaberinto());
            this.casillas.addAll(objetoIntermedio.getMeta());
            this.casillas.addAll(objetoIntermedio.getMuerte());
            this.casillas.addAll(objetoIntermedio.getNormal());
            this.casillas.addAll(objetoIntermedio.getPosada());
            this.casillas.addAll(objetoIntermedio.getPuente());
            this.casillas.addAll(objetoIntermedio.getDado());

            //ordenamos las casillas x su número para hacer el tablero lineal
            this.casillas.sort(Comparator.comparing(Casilla::getNumero));
        } catch (FileNotFoundException e){
            System.out.println("No se encontró el archivo casillas.json en ./datos/");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de casillas");
        }
    }

    public Casilla getCasilla(int numero){
        if (numero >= 0 && numero < this.casillas.size()) {
            return casillas.get(numero);
        }
        return null; //por seguridad , si piden una casilla fuera del rango
    }

    @Override
    public String toString() {
        return "Tablero de : " + numCasillas + " casillas";
    }
}