/*
 */
package ejercicios;

public class CasillaCalle extends Casilla{
    private int numCasas;
    
    CasillaCalle(int numCasas){
        super("calle");
        this.numCasas = numCasas;
    }
    
    //reutilizando código del padre
    @Override
    protected boolean recibeJugador(){
        if(super.recibeJugador()){
            System.out.println("y además soy una casilla calle.");
            return true;
        }
        return false;
    }
    
    @Override
    protected void construirCasa(){
        numCasas++;
        System.out.println(numCasas);
    }
}