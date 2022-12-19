package c1;

import java.util.ArrayList;

public class Equipo {
    private String nombre;
    private ArrayList<Gol> goles;

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.goles = new ArrayList<>();
    }
    
    public Equipo() {
        this("Anónimo");
    }

    public void addGol(Gol gol) {
        this.goles.add(gol);
    }
    
    public boolean anulaGol(Jugador jugador, int minuto) {
        for (Gol gol: this.goles) {
            if ((gol.getJugador() == jugador) && (gol.getMinuto() == minuto)) {
                gol.setMinuto(-1);
                Gol.restaGol();
                return true;
            }
        }
        return false;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Gol> getGoles() {
        return goles;
    }
}
