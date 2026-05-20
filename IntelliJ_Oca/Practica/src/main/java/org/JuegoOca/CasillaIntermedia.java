package org.JuegoOca;
import java.util.ArrayList;

public class CasillaIntermedia {
    private ArrayList<CasillasOca> oca;
    private ArrayList<CasillasLaberinto> laberinto;
    private ArrayList<CasillasMeta> meta;
    private ArrayList<CasillasMuerte> muerte;
    private ArrayList<CasillasNormal> normal;
    private ArrayList<CasillasPosada> posada;
    private ArrayList<CasillasPuente> puente;

    public CasillaIntermedia() {
        oca = new ArrayList<>();
        laberinto = new ArrayList<>();
        meta = new ArrayList<>();
        muerte = new ArrayList<>();
        normal = new ArrayList<>();
        posada = new ArrayList<>();
        puente = new ArrayList<>();
    }

    public ArrayList<CasillasOca> getOca() {
        return oca;
    }

    public ArrayList<CasillasLaberinto> getLaberinto() {
        return laberinto;
    }

    public ArrayList<CasillasMeta> getMeta() {
        return meta;
    }

    public ArrayList<CasillasMuerte> getMuerte() {
        return muerte;
    }

    public ArrayList<CasillasNormal> getNormal() {
        return normal;
    }

    public ArrayList<CasillasPosada> getPosada() {
        return posada;
    }

    public ArrayList<CasillasPuente> getPuente() {
        return puente;
    }
}
