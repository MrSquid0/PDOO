package vistaTextualCivitas;

import civitas.Casilla;
import civitas.CivitasJuego;
import civitas.Diario;
import civitas.OperacionJuego;
import controladorCivitas.Respuesta;
import civitas.OperacionInmobiliaria;
import civitas.Jugador;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



public class VistaTextual implements Vista {
  
    
    private static String separador = "=====================";
  
    private Scanner in;
  
    CivitasJuego juegoModel;
  
    public VistaTextual (CivitasJuego juegoModel) {
        in = new Scanner (System.in);
        this.juegoModel=juegoModel;
    }
  
  
    @Override         
    public  void pausa() {
        System.out.println("Pulsa una tecla\n");
        in.nextLine();
    }

    int leeEntero (int max, String msg1, String msg2) {
        Boolean ok;
        String cadena;
        int numero = -1;
        do {
            System.out.print (msg1);
            cadena = in.nextLine();
            try {  
                numero = Integer.parseInt(cadena);
                ok = true;
            } catch (NumberFormatException e) { // No se ha introducido un entero
                System.out.println (msg2);
                ok = false;  
            }
            if (ok && (numero < 0 || numero >= max)) {
                System.out.println (msg2);
                ok = false;
            }
        } while (!ok);

        return numero;
  }

    int menu (String titulo, ArrayList<String> lista) {
        String tab = "  ";
        int opcion;
        System.out.println (titulo);
        for (int i = 0; i < lista.size(); i++) {
            System.out.println (tab+i+"-"+lista.get(i));
        }

        opcion = leeEntero(lista.size(),
                          "\n"+tab+"Elige una opción: ",
                          tab+"Valor erróneo");
        return opcion;
    }
  
  
  @Override
    public void actualiza(){
        String propiedades = "";
        
        ArrayList<Casilla> propiedadesCasilla = new ArrayList<>();
        propiedadesCasilla = juegoModel.getJugadorActual().getPropiedades();
        
        if(propiedadesCasilla.isEmpty())
            propiedades = "No tiene propiedades\n";
        else{
            int tamanio = propiedadesCasilla.size();
            for (int i=0; i<tamanio; i++){
                propiedades = propiedadesCasilla.get(i).toString();
            }
            
            if (!juegoModel.finalDelJuego()){
                int indice = juegoModel.getJugadorActual().getCasillaActual();
                Casilla casillaActual = propiedadesCasilla.get(indice);
                propiedades += "Casilla actual: " + casillaActual.toString();
            }
        }
        
        if (juegoModel.finalDelJuego()){
            ArrayList<Jugador> top = new ArrayList<>();
            top = juegoModel.ranking();
            for (int i=0; i<juegoModel.getJugadores().size(); i++)
                propiedades += "Posición " + i + ": " + top.get(i).getNombre() + "\n";
        }
        System.out.println(propiedades);
    }

    @Override
    public Respuesta comprar(){
        int indiceCasillaActual = juegoModel.getJugadorActual().getCasillaActual();
        String casillaActual = juegoModel.getJugadorActual().getPropiedades().get(indiceCasillaActual).toString();
      
        int opcionElegida = menu ("Acabas de llegar a la casilla " + casillaActual + "\n¿Quieres comprarla?",
                        new ArrayList<> (Arrays.asList("SI","NO")));
    
        return (Respuesta.values()[opcionElegida]);        
    }

    @Override
    public OperacionInmobiliaria elegirOperacion(){
        int opcion = menu ("¿Qué gestión inmobiliaria quieres llevar a cabo?",
            new ArrayList<> (Arrays.asList("-> CONSTRUIR_CASA","-> CONSTRUIR_HOTEL","-> TERMINAR")));
      return OperacionInmobiliaria.values()[opcion];
    }

    @Override
    public int elegirPropiedad(){
        int numMaxPropiedades = juegoModel.getJugadorActual().getPropiedades().size();
        int propiedadElegida = leeEntero(numMaxPropiedades, 
                "¿En qué propiedad quieres realizar la gestión?\n", 
                "\nPropiedad no válida");
        return propiedadElegida;
    }

    @Override
    public void mostrarSiguienteOperacion(OperacionJuego operación){
        String operacion = operación.toString();
        System.out.println(operacion);
    }

    @Override
    public void mostrarEventos(){
        while(Diario.getInstance().eventosPendientes())
            System.out.println(Diario.getInstance().leerEvento());
    }
}
