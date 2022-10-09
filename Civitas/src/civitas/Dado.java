
package civitas;

import java.util.Random;

public class Dado {
    private final Random random = new Random();
    
    private int ultimoResultado;
    private boolean debug;
    
    static final private Dado instance = new Dado();
    
    private static int VALORDEBUG = 1;
    private static int VALORESDADO = 6;
    
    private Dado(){
        ultimoResultado = 0;
        debug = false;
    }
    
    public static Dado getInstance(){
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
    
    public void setDebug (boolean d){
        debug = d;
        if (debug)
            Diario.getInstance().ocurreEvento("Modo debug activado");
        else
            Diario.getInstance().ocurreEvento("Modo debug desactivado");
    }
    
    public boolean getDebug(){
        return debug;
    }
    
    int getUltimoResultado(){
        return ultimoResultado;
    }
}
