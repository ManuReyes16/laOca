package org.JuegoOca;

public class CasillasLaberinto extends Casillas {

    //atributos
    public CasillasLaberinto(int numero){
        super();
    }
    //no se pueden cambiar
    private static int[] posiciones_laberinto = {10, 30};

    //constructor x parámetros
    public CasillasLaberinto(int numero, String nombre){
        super(numero, nombre);
    }

    //constructo de copia
    public CasillasLaberinto(CasillasLaberinto c){
        super(c);
    }

    //getter y setter

    //metodos
    @Override
    public void aplicarEfecto(Jugador jugador) {
        System.out.println("EN EL LABERINTO, ME HE BEBIO UN VINO TINTO... Y ME QUEDAO DORMIO");
        System.out.println("EL JUGADOR : " + jugador.getNombre() + "HAS CAÍDO EN EL LABERINTO !!");

        //definimos la casilla
        int casillaSalida = 6;


        //se mueve al jugador
        jugador.setPosicionActual(casillaSalida);
        System.out.println("Debes retroceder a la CASILLA 6...");

        //esta casilla no repite turno
        jugador.setPuedeRepetirTurno(false);

    }

    //encontramos el siguiente LABERINTO
    private int calcularSiguienteLaberinto(int posicionActual){
        for (int laberinto : posiciones_laberinto){
            if (laberinto > posicionActual){
                return laberinto;
            }
        }
        return posicionActual;
    }

    @Override
    public String toString(){
        return "CASILLA DEL LABERINTO " + getNumero();
    }
}
