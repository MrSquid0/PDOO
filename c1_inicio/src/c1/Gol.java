package c1;

public abstract class Gol {
    private static int TOTAL_GOLES = 0;
    private int minuto;
    private Jugador jugador;
    private Equipo equipo;

    public Gol(int minuto, Jugador jugador, Equipo equipo) {
        this.minuto = minuto;
        this.jugador = jugador;
        this.equipo = equipo;
        
        TOTAL_GOLES++;
    }
    
    static public int numeroGoles() {
        return Gol.TOTAL_GOLES;
    }

    public int getMinuto() {
        return minuto;
    }
    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }
    public Jugador getJugador() {
        return jugador;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public static void restaGol() {
        Gol.TOTAL_GOLES--;
    }
    
    public abstract String descripcion();
}
