
package c1;

import java.util.ArrayList;

public class Falta extends Gol {
    private boolean barrera;

    public Falta(boolean barrera, int minuto, Jugador jugador, 
            Equipo equipo) {
        super(minuto, jugador, equipo);
        this.barrera = barrera;
    }

    public boolean getBarrera() {
        return barrera;
    }
    
    public void quitarBarrera(){
        barrera = false;
    }
    
    @Override
    public String descripcion(){
        String hayBarrera;
        if (barrera)
            hayBarrera = "SÍ";
        else
            hayBarrera = "NO";
        
        String minutoYBarrera = "La falta se marcó en el minuto " 
                + super.getMinuto() + " y " + hayBarrera + 
                " hubo barrera.";
        return minutoYBarrera;
    }
    
    @Override
    public Gol copia(Gol otro){
        
        Falta falta = new Falta (((Falta)otro).getBarrera(), 
                otro.getMinuto(),otro.getJugador(), 
                otro.getEquipo());
        
        return falta;
    }

}
