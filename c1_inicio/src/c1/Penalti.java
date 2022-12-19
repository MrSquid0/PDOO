
package c1;

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
    
}
