
package civitas;

import java.util.ArrayList;


public class CasillaSorpresa extends Casilla{
    private MazoSorpresas mazo = new MazoSorpresas();
    
    CasillaSorpresa (String nombre, MazoSorpresas mazo){
        super(nombre);
        this.mazo = mazo;
    }
    
    void recibeJugador(int iactual, ArrayList<Jugador> todos){
        Sorpresa sorpresa = mazo.siguiente();
        informe(iactual, todos);
        sorpresa.aplicarAJugador(iactual, todos);
    }
    
    public String toString(){
        String cadena;
        cadena = "Acabas de llegar a una casilla de tipo sorpresa.";
        return cadena;
    }
}
