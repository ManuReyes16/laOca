package org.JuegoOca;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class JuegoOca {
    public static void main(String[] args) {

        Dado miDado = new Dado();
        int tirada = miDado.lanzar(); // Guardas el resultado para mover al jugador
    }
}