package examen;

import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private ArrayList<Gol> goles;
    
    public Jugador(String nombre){
        this.nombre = nombre;
        goles = new ArrayList<>();
    }
    
    public void marcaGol(Equipo equipo, int minuto){
        Gol gol = new Gol(minuto);
        goles.add(gol);
        equipo.addGol(gol);
    }
    
    public ArrayList<Gol> getGoles(){
        return goles;
    }
    
    public int golesParte (int parte){
        int numeroGoles = 0;
        for (int i=0; i<goles.size(); i++){
            if ( (goles.get(i).getMinuto() <= 45) && (parte == 1) )
                numeroGoles++;
            if ( (goles.get(i).getMinuto() > 45) && (parte == 2) )
                numeroGoles++;
        }
        return numeroGoles;
    }
}
