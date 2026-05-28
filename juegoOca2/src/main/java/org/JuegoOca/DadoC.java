/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.JuegoOca;
import java.util.Random;
/**
 *
 * @author User
 */
public class DadoC {

    // Atributos
    private int caras;
    private Random aleatorio;

    // Constructor por defecto
    public DadoC() {
        this.caras = 6;
        this.aleatorio = new Random();
    }

    // Constructor por parámetros
    public DadoC(int caras) {
        this.caras = caras;
        this.aleatorio = new Random();
    }

    // Constructor de copia
    public DadoC(DadoC d) {
        this.caras = d.caras;
        this.aleatorio = new Random();
    }

    // Getters
    public int getCaras() {
        return caras;
    }

    // Setters
    public void setCaras(int caras) {
        this.caras = caras;
    }

    // Métodos
    public int lanzar() {
        return aleatorio.nextInt(caras) + 1;
    }

    @Override
    public String toString() {
        return "Dado de " + caras + " caras";
    }
}