package org.JuegoOca;

public class JuegoOcaController {
    private final Tablero tablero;

    public JuegoOcaController() {
        // Al arrancar el controlador, se inicializa el tablero que lee vuestro JSON
        this.tablero = new Tablero();
    }

    // Método para que la vista sepa cuántas casillas tiene que pintar
    public int getNumeroCasillas() {
        return tablero.getNumCasillas();
    }

    // Método para que la vista le pida los datos de una casilla concreta (tipo, nombre...)
    public Casilla getCasilla(int numero) {
        return tablero.getCasilla(numero);
    }
}