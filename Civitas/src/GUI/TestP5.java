
package GUI;

import civitas.CivitasJuego;
import controladorCivitas.Controlador;
import java.util.ArrayList;


public class TestP5 {
    public static void main (String[] args){
        CivitasView vista = new CivitasView();
        CapturaNombres captura = new CapturaNombres(vista, true);
        
        ArrayList<String> nombres = new ArrayList<>();
        
        nombres = captura.getNombres();
        
        
        Dado.createInstance(vista);
        
        CivitasJuego juego = new CivitasJuego(nombres, false);
        
        Controlador controlador = new Controlador(juego, vista);
        
        vista.setCivitasJuego(juego);
        
        controlador.juega();
        
    }
}
