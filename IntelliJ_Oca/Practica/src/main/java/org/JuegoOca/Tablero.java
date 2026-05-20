/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegooca;

import java.io.FileNotFoundException;
import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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


    Gson traductor = new Gson();
    {
        try {
            FileReader fr = new FileReader("./datos/casillas.json");
            CasillaIntermedia objetoIntermedio = traductor.fromJson(fr, CasillaIntermedia.class);
            fr.close();

            //Creacion del Tablero
            ArrayList<Casilla> tablero = new ArrayList<>();

            tablero.addAll(objetoIntermedio.getOca());
            tablero.addAll(objetoIntermedio.getLaberinto());
            tablero.addAll(objetoIntermedio.getMeta());
            tablero.addAll(objetoIntermedio.getMuerte());
            tablero.addAll(objetoIntermedio.getNormal());
            tablero.addAll(objetoIntermedio.getPosada());
            tablero.addAll(objetoIntermedio.getPuente());


        } catch (FileNotFoundException e) {
            System.out.println("No se encontro el archivo");
        } catch (IOException e) {
            System.out.println("Error en el archivo");
        }
    }



    // Métodos
    private void generarTablero() {



    public Casilla getCasilla(int numero) {
        return casilla.get(numero);
    }

    @Override
    public String toString() {
        return "Tablero de " + numCasilla + " casillas";
    }
}