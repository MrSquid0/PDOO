/*
 */
package controladorCivitas;

import civitas.CivitasJuego;
import civitas.OperacionJuego;
import vistaTextualCivitas.VistaTextual;
import civitas.OperacionInmobiliaria;
import civitas.GestionInmobiliaria;

public class Controlador {
    CivitasJuego juegoModel;
    VistaTextual vista;
    
    public Controlador(CivitasJuego juegoModel, VistaTextual vista){
        this.juegoModel = juegoModel;
        this.vista = vista;
    }
    
    public void juega(){
        while (!juegoModel.finalDelJuego()){
            vista.actualiza();
            vista.pausa();
            OperacionJuego siguientePaso = juegoModel.siguientePaso();
            vista.mostrarSiguienteOperacion(siguientePaso);
            if (siguientePaso != OperacionJuego.PASAR_TURNO)
                vista.mostrarEventos();
            switch(siguientePaso){
                case COMPRAR:
                    if (vista.comprar() == Respuesta.SI)
                        juegoModel.comprar();
                    juegoModel.siguientePasoCompletado(siguientePaso);
                    break;
                case GESTIONAR:
                    OperacionInmobiliaria oper = vista.elegirOperacion();
                    if (oper != OperacionInmobiliaria.TERMINAR){
                        int propiedad = vista.elegirPropiedad();
                        if (oper == OperacionInmobiliaria.CONSTRUIR_CASA)
                            juegoModel.construirCasa(propiedad);
                        else
                            juegoModel.construirHotel(propiedad);
                        
                    } else
                        juegoModel.siguientePasoCompletado(siguientePaso);
                    break;      
            }
        }
        juegoModel.ranking();
        System.out.println("==== RANKING ====");
        vista.actualiza();
    }
    
    
}
