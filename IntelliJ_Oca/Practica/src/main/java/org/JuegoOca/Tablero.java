package org.JuegoOca;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class Tablero {

    Gson traductor = new Gson();
    {
        try {
            FileReader fr = new FileReader("./datos/casillas.json");
            CasillaIntermedia objetoIntermedio = traductor.fromJson(fr, CasillaIntermedia.class);
            fr.close();

            //Creacion del Tablero
            ArrayList<Casillas> tablero = new ArrayList<>();

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
}
