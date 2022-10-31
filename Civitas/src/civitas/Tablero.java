
package civitas;

import java.util.ArrayList;

public class Tablero {
    private ArrayList<Casilla> casillas;
    private boolean porSalida;
    private int numCasillas;
    
    public Tablero (){
        casillas = new ArrayList<>();
        Casilla casilla = new Casilla(TipoCasilla.CALLE,"Salida", 0,0,0);
        casillas.add(casilla);
        porSalida = false;
        numCasillas = 20;
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
    
    public Casilla getCasilla (int numCasilla){
        if (correcto(numCasilla))
            return casillas.get(numCasilla);
        else
            return null;
    }
    
    public ArrayList<Casilla> getCasillas(){
        return casillas;
    }
    
    int nuevaPosicion (int actual, int tirada){
        int pos = (actual+tirada) % numCasillas;
        
        if (pos != actual+tirada)
            porSalida = true;
        
        return pos;
    }
    
    
}
