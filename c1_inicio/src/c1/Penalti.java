
package c1;

import static c1.Gol.numeroGoles;
import java.util.ArrayList;

public class Penalti extends Gol {
    private String lado;

    public Penalti(String lado, int minuto, Jugador jugador, 
            Equipo equipo) {
        super(minuto, jugador, equipo);
        this.lado = lado;
    }

    public String getLado() {
        return lado;
    }
    
    @Override
    public String descripcion() {
        String minutoYLado = "El penalti se marcó en el minuto " 
                + super.getMinuto() + " y en el lado " + this.lado;
        return minutoYLado;
    }
    
    public Jugador getJugador() {
        Jugador jugador = super.getJugador();
        System.out.println(jugador.getNombre() + "-killer");
        return jugador;
    }
    
    @Override
    public Gol copia(Gol otro){
        
        Penalti penalti = new Penalti (((Penalti)otro).getLado(), 
                otro.getMinuto(),otro.getJugador(), 
                otro.getEquipo());

        return penalti;
    }
}
