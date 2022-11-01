
package civitas;

import java.util.Random;

public class Dado {
    private final Random random;
    
    private int ultimoResultado;
    private boolean debug;
    
    static final private Dado instance = new Dado();
    
    private final static int VALORDEBUG = 1;
    private final static int VALORESDADO = 6;
    
    private Dado(){
        random = new Random();
        ultimoResultado = 0;
        debug = false;
    }
    
    public static Dado getInstance(){
        return instance;
    }
    
    int tirar(){
        int numero;
        if (!debug){
            numero = random.nextInt(1, 7); //7 no incluido
        } else
            numero = 1;
        ultimoResultado = numero;
        return numero;
    }
    
    int quienEmpieza (int n){
        int jugador = random.nextInt(0,n);
        return jugador;
    }
    
    public void setDebug (boolean d){
        debug = d;
        if (debug)
            Diario.getInstance().ocurreEvento("Modo debug activado.\n");
        else
            Diario.getInstance().ocurreEvento("Modo debug desactivado.\n");
    }
    
    public boolean getDebug(){
        return debug;
    }
    
    int getUltimoResultado(){
        return ultimoResultado;
    }
}
