package org.JuegoOca;

public class CasillasOca extends Casillas {

    //atributos
    public CasillasOca(int numero){
        super();
    }
    // no se pueden cambiar
    private static int[] posiciones_ocas = {5, 9, 14, 18, 23, 27, 32, 36};

    //constructor x defecto
    public CasillasOca(){
        super();
    }

    //constructor x parámetros
    public CasillasOca(int numero, String nombre){
        super(numero, nombre);
    }

    //constructor de copia
    public CasillasOca(CasillasOca c){
        super(c);
    }

    //getter
    //setter


    //métodos

    @Override
    public void aplicarEfecto(Jugador jugador) {
        System.out.println("DE OCA EN OCA Y TIRO PORQUE ME TOCA");
        System.out.println("EL JUGADOR " + jugador.getNombre() + " HA CAÍDO EN LA OCA !");


        //se calcula la siguiente posición de la oca
        int nuevaPosicion = calcularSiguienteOca(this.getNumero());

        //se mueve al jugador
        jugador.setPosicionActual(nuevaPosicion);

        //para voler a tirar se repite el turno
        jugador.setPuedeRepetirTurno(true);
    }

    //encontramos la siguiente CasillaOca
    private int calcularSiguienteOca(int posicionActual){
        for (int oca : posiciones_ocas){
            if (oca > posicionActual){
                return oca; //en cuanto encuntra la siguiente, devuelve el número
            }
        }
        return posicionActual; //si no hay más, llegó a la ultima
    }

    @Override
    public String toString(){
        return "Casilla de la OCA " + getNumero();
    }
}
