/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegooca;


public class CasillaOca extends Casilla {

    //atributos
    public CasillaOca(int numero){
        super(numero);
    }
    
    //constructor x defecto
    public CasillaOca(){
        super(5);
    }
    //constructor x parámetros
    public CasillaOca(int numero){
        super(numero);
    }
    
    //constructor de copia
    public CasillaOca(CasillaOca otraCasilla){
        super(otraCasilla.getNumero());
    }
    
    //getter
    //setter


    //métodos
    
    //en el método debería ir a la siguiente CasillaOca
    
    @Override
    public void aplicarEfecto(Jugador jugador) {
        System.out.println("DE OCA EN OCA Y TIRO PORQUE ME TOCA");
        
        //se calcula la siguiente posición de la oca
        int nuevaPosicion = calcularSiguienteOca(this.getNumero());
        
        //se mueve al jugador
        jugador.setPosicionActual(nuevaPosicion);
        
        //para voler a tirar se repite el turno
        jugador.setPuedeRepetirTurno(true);
        
        private int calcularSiguienteOca(int posicionActual){
            //aquí se pone un array con las posiciones de CasillaOca
            int[] ocas = {3, 9, 12};
            
        }
    }
        
    @Override
    public String toString(){
    return "Casilla de la OCA " + getNumero();
    }
}
