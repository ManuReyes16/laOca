package juegooca;

import java.util.ArrayList;

public class CasillaIntermedia {
    private ArrayList<CasillaOca> oca;
    private ArrayList<CasillaLaberinto> laberinto;
    private ArrayList<CasillaMeta> meta;
    private ArrayList<CasillaMuerte> muerte;
    private ArrayList<CasillaNormal> normal;
    private ArrayList<CasillaPosada> posada;
    private ArrayList<CasillaPuente> puente;

    public CasillaIntermedia() {
        oca = new ArrayList<>();
        laberinto = new ArrayList<>();
        meta = new ArrayList<>();
        muerte = new ArrayList<>();
        normal = new ArrayList<>();
        posada = new ArrayList<>();
        puente = new ArrayList<>();
    }

    public ArrayList<CasillaOca> getOca() {
        return oca;
    }

    public ArrayList<CasillaLaberinto> getLaberinto() {
        return laberinto;
    }

    public ArrayList<CasillaMeta> getMeta() {
        return meta;
    }

    public ArrayList<CasillaMuerte> getMuerte() {
        return muerte;
    }

    public ArrayList<CasillaNormal> getNormal() {
        return normal;
    }

    public ArrayList<CasillaPosada> getPosada() {
        return posada;
    }

    public ArrayList<CasillaPuente> getPuente() {
        return puente;
    }
}
