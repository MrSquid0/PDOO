
package c1;

import java.util.ArrayList;

public class Controlador {
    private Vista vista;
    private int equipoActual;
    private Equipo equipo1;
    private Equipo equipo2;
    
    public Controlador(Equipo equipo1, Equipo equipo2){
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.equipoActual = 0;
        this.vista = null;
    }
    
    public void setVista(Vista vista) {
        this.vista = vista;
    }
    
    public String getEquipo(){
        if (equipoActual == 0)
            return equipo1.getNombre();
        else
            return equipo2.getNombre();
    }
    
    public int getGoles(){
        if (equipoActual == 0)
            return this.equipo1.getGoles().size();
        else
            return this.equipo2.getGoles().size();     
    }
    
    public void siguiente(){
        equipoActual = (equipoActual+1)%2;
        this.vista.actualizar();
    }
}
