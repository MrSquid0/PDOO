
package c1;

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
        
        String minutoYBarrera = "El penalti se marcó en el minuto " 
                + super.getMinuto() + " y " + hayBarrera + 
                " hubo barrera.";
        return minutoYBarrera;
    }
}
