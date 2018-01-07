package Reproductor;

import java.io.*;
import java.util.ArrayList;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

/**
 *
 * @author Lenovo
 */
public class Reproductor {

    public String modo;
    private int posicion;
    public Cancion actual;
    private boolean is_play;
    private Thread HiloPlay;
    private AdvancedPlayer reproductor;
    private ArrayList<Cancion> lista;

    public Reproductor() {
        modo = "";
        posicion = 0;
        is_play = false;
    }

    public void reproducir(ArrayList<Cancion> lista) {
        this.lista = lista;
        cambiar(0);
        is_play = true;
        reproducir();
    }
    
    private void cambiar(int i){
        if (lista == null || lista.isEmpty())
            return;
        posicion += i;
        if(posicion < 0)
            posicion = lista.size() - 1;
        else if(posicion >= lista.size())
            posicion = 0;
        actual = lista.get(posicion);
    }

    public void reproducir() {
        if(is_play){
            HiloPlay = new Thread() {
                @Override
                public void run() {
                    try {
                        reproductor = new AdvancedPlayer(new FileInputStream(actual.getPath()));
                        reproductor.play();
                        cambiar(1);
                        reproducir();
                    } catch (FileNotFoundException | JavaLayerException e) {}
                }
            };
            HiloPlay.start();
        }else{
            try {
                HiloPlay.resume();
                is_play = true;
            } catch (Exception e) {}
        }
    }

    public void detener() {
        try {
            HiloPlay.stop();
            reproductor.close();
            is_play = false;
        } catch (Exception e) {}
    }

    public void pausar() {
        try {
            HiloPlay.suspend();
            is_play = false;
        } catch (Exception e) {}
    }

    public void siguiente() {
        try {
            detener();
            cambiar(+1);
            is_play = true;
            reproducir();
        } catch (Exception e) {}
    }

    public void anterior() {
        try {
            detener();
            cambiar(-1);
            is_play = true;
            reproducir();
        } catch (Exception e) {}
    }
}
