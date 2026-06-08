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
import java.util.Comparator;   

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



    //enseña el tablero por consola con el método GENERARTABLERO
    private void generarTablero(){

        Gson traductor = new Gson();

        try {

            java.io.InputStream is = getClass().getClassLoader().getResourceAsStream("casillas.json");

            if (is == null) {
                System.out.println("ERROR: No se encontró casillas.json dentro de src/main/resources");
                return;
            }

            java.io.InputStreamReader isr = new java.io.InputStreamReader(is);
            CasillaIntermedia objetoIntermedio = traductor.fromJson(isr, CasillaIntermedia.class);
            isr.close();
            is.close();

            this.casillas.addAll(objetoIntermedio.getOca());
            this.casillas.addAll(objetoIntermedio.getLaberinto());
            this.casillas.addAll(objetoIntermedio.getMeta());
            this.casillas.addAll(objetoIntermedio.getMuerte());
            this.casillas.addAll(objetoIntermedio.getNormal());
            this.casillas.addAll(objetoIntermedio.getPosada());
            this.casillas.addAll(objetoIntermedio.getPuente());
            this.casillas.addAll(objetoIntermedio.getDado());

            this.casillas.sort(Comparator.comparing(Casilla::getNumero));

        } catch (IOException e) {
            System.out.println("Error al leer el archivo de casillas");
        }
    }
    

    public Casilla getCasilla(int numero) {
    for (Casilla casilla : this.casillas) {
        if (casilla != null && casilla.getNumero() == numero) {
            return casilla;
        }
    }
    return null;    
    }

    @Override
    public String toString() {
        return "Tablero de : " + numCasillas + " casillas";
    }
}