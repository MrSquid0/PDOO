
package civitas;

import java.util.Random;

public class Dado {
    private Random random;
    
    private int ultimoResultado;
    private boolean debug;
    
    private static Dado instance;
    
    Dado(){
        ultimoResultado = random.nextInt();
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
        int jugador = random.nextInt(0, n-1);
        return jugador;
    }
    
    void setDebug (boolean d){
        debug = d;
    }
    
    int getUltimoResultado(){
        return ultimoResultado;
    }
}
