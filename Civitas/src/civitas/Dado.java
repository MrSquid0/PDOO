
package civitas;

import java.util.Random;

public class Dado {
    private Random random = new Random();
    
    private int ultimoResultado;
    private boolean debug;
    
    private static Dado instance = new Dado();
    
    Dado(){
        ultimoResultado = 0;
        debug = false;
    }
    
    Dado getInstance(){
        return instance;
    }
    
    int tirar(){
        int numero;
        if (!debug){
            numero = random.nextInt(1, 6);
        } else
            numero = 1;
        ultimoResultado = numero;
        return numero;
    }
    
    int quienEmpieza (int n){
        int jugador = random.nextInt(1, n+1);
        return jugador;
    }
    
    void setDebug (boolean d){
        debug = d;
        if (debug)
            Diario.getInstance().ocurreEvento("Modo debug activado");
        else
            Diario.getInstance().ocurreEvento("Modo debug desactivado");
    }
    
    boolean getDebug(){
        return debug;
    }
    
    int getUltimoResultado(){
        return ultimoResultado;
    }
}
