
package civitas;

import java.util.ArrayList;


public class SorpresaConvertirme extends Sorpresa{
    SorpresaConvertirme(){
        super("¡Ahora eres un jugador especulador!", 0);
    }
    
    void aplicarAJugador(int actual, ArrayList<Jugador> todos){
        informe (actual, todos);
        
        Jugador jugador = todos.get(actual).convertir();
        JugadorEspeculador especulador = new JugadorEspeculador(jugador);
        
        todos.set(actual, especulador);
    }
}
