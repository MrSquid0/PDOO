/*
 */
package ejercicios;

public class Casilla {
    private String nombre;
    
    Casilla (String nombre){
        this.nombre = nombre;
    }
    
    
    protected boolean recibeJugador(){
        System.out.print("He recibido un jugador ");
        return true;
    }
}
