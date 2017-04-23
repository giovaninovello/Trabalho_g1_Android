package com.example.giovani.km;

/**
 * Created by Giovani on 19/04/2017.
 */

public class Kilometro {



    private int id;
    private int kminicial;
    private int kmfinal;
    private  String Destino;

    public String getDestino() {
        return Destino;
    }

    public void setDestino(String destino) {
        Destino = destino;
    }

    public int getKminicial() {
        return kminicial;
    }

    public void setKminicial(Integer kminicial) {
        this.kminicial = kminicial;
    }

    public int getKmfinal() {
        return kmfinal;
    }

    public void setKmfinal(Integer kmfinal) {
        this.kmfinal = kmfinal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
