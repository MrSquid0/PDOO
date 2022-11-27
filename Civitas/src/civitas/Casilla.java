
package civitas;

import java.util.ArrayList;

public class Casilla {
    
    private String Nombre;
    
    private void init(){
        Nombre = "";
    }
    
    //Constructor para casillas de tipo descanso    
    Casilla (String nombre){
        init();
        this.Nombre = nombre;
    }
     
    public String getNombre() {
        return Nombre;
    }
    
    void informe (int actual, ArrayList<Jugador> todos){
        Diario.getInstance().ocurreEvento(todos.get(actual).toString());
    }
    
    private boolean esJugadorCorrecto (int actual, ArrayList <Jugador> todos){
        boolean esCorrecto = false;
        
        if (actual >=0 && actual < todos.size())
            esCorrecto = true;
        return esCorrecto;
    }
    
    void recibeJugador(int iactual, ArrayList<Jugador> todos){
        informe(iactual,todos);
    }
    
    public String toString(){
        String cadena;
        cadena = "Acabas de llegar a una casilla de tipo descanso.";
        return cadena;
    }
}