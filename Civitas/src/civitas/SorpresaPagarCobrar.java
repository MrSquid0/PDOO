
package civitas;

import java.util.ArrayList;

public class SorpresaPagarCobrar extends Sorpresa {
    
    SorpresaPagarCobrar(String texto, int valor){
        super(texto, valor);
    }
    
    void aplicarAJugador(int actual, ArrayList<Jugador> todos){
        informe (actual, todos);
        todos.get(actual).modificarSaldo(super.getValor());
    }
}
