
package civitas;

import java.util.ArrayList;


public class SorpresaConvertirme extends Sorpresa{
    SorpresaConvertirme(String texto, int valor){
        super(texto, valor);
    }
    
    void aplicarAJugador(int actual, ArrayList<Jugador> todos){
        informe (actual, todos);
        todos.get(actual).convertir();
    }
}
