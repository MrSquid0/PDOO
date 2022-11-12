package examen;

import java.util.ArrayList;
import java.util.Random;

public class Equipo {
    private String nombre;
    private ArrayList<Gol> goles;
    
    public Equipo (String nombre){
        this.nombre = nombre;
        goles = new ArrayList<>();
    }
    
    public Equipo (){
        nombre = "Anónimo";
        goles = new ArrayList<>();
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void addGol (Gol gol){
        goles.add(gol);
    }
    
    public boolean anulaGol(Jugador jugador, int minuto){
        boolean seAnula = false;
        for (int i=0; i<jugador.getGoles().size(); i++){
            if (minuto == goles.get(i).getMinuto()){
                jugador.getGoles().get(i).setMinuto(-1);
                Gol.reducirNumeroGoles();
                seAnula = true;
            }
        }
        return seAnula;
    }
    
    
}
