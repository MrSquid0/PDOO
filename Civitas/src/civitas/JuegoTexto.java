/*
 */
package civitas;

import java.util.ArrayList;
import controladorCivitas.Controlador;
import vistaTextualCivitas.VistaTextual;

public class JuegoTexto {
    public static void main (String[] args){
        ArrayList<String> jugadores = new ArrayList<>();
        jugadores.add("Gonzalo");
        jugadores.add("Carlos");
        jugadores.add("Miguel");
        jugadores.add("Juanma");
        CivitasJuego juego = new CivitasJuego(jugadores, false);
        
        VistaTextual vista = new VistaTextual(juego);
        
        Controlador controlador = new Controlador (juego, vista);
        
        controlador.juega();
    }
}
