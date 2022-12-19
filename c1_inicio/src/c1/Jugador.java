package c1;

import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private ArrayList<Gol> goles;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.goles = new ArrayList<>();
    }

    public void marcaPenalti(Equipo equipo, int minuto, String lado) {
        Gol gol = new Penalti(lado,minuto, this, equipo);
        this.goles.add(gol);
        equipo.addGol(gol);
    }
    
    public void marcaFalta(Equipo equipo, int minuto, boolean barrera) {
        Gol gol = new Falta(barrera,minuto, this, equipo);
        this.goles.add(gol);
        equipo.addGol(gol);
    }

    public int golesParte(int parte) {
        int numeroGoles = 0;
        for (Gol gol: this.goles) {
            if ((gol.getMinuto() <= 45) && (parte == 1)) numeroGoles++;
            if ((gol.getMinuto() > 45) && (parte == 2)) numeroGoles++;
        }
        return numeroGoles;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Gol> getGoles() {
        return goles;
    }
    
    public void addGol(Gol gol){
        goles.add(gol);
    } 
    
    public Jugador copia(){
        Jugador jugador = new Jugador(this.nombre);   
        for (int i=0; i<this.goles.size(); i++){
            jugador.addGol(this.getGoles().get(i));
        }
        return jugador;
    }
}