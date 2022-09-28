
package civitas;

import java.util.ArrayList;

public class Tablero {
    private ArrayList<Casilla> casillas;
    private boolean porSalida;
    private int numCasillas = 20;
    
    Tablero (ArrayList lasCasillas, boolean pasoPorSalida){
        lasCasillas.add("Salida");
        pasoPorSalida = false;
    }
    
    private boolean correcto (int numCasilla){
        boolean esCorrecto = false;
        if (numCasilla >= 1)
            esCorrecto = true;
        return esCorrecto;
    }
    
    boolean computarPasoPorSalida(){
        boolean salida = porSalida;
        porSalida = false;
        return salida;
    }
    
    void añadeCasilla (Casilla casilla){
        casillas.add(casilla);
    }
    
    Casilla getCasilla (int numCasilla){
        if (correcto(numCasilla))
            return casillas.get(numCasilla);
        else
            return null;
    }
    
    int nuevaPosicion (int actual, int tirada){
        int pos = (actual+tirada) % numCasillas;
        
        if (pos != actual+tirada)
            porSalida = true;
        
        return pos;
    }
    
    
}