/*
 */
package ejercicios;

import java.util.ArrayList;


public class EjerciciosJavaP4 {
    public static void main(String[] args) {
        /*
        Casilla casilla = new Casilla("Granada");
        CasillaCalle casillaCalle = new CasillaCalle(3);
        ArrayList<Casilla> tablero = new ArrayList<>();
        
        //Pregunta 1 --> Por que el método recibeJugador() no está
        //redefinido en casillaHija, por lo que hereda el método
        //de la súperclase y obviamente el mismo resultado.
        System.out.println(casilla.recibeJugador());

        System.out.println(casillaCalle.recibeJugador());
        
        //Pregunta 2 --> Ha ejecutado el método de su clase, no
        //el de la clase padre.
        
        //Pregunta 3--> Ha ejecutado el método de su clase, no
        //el de la clase padre.
        
        //Pregunta 4
        
        casillaCalle.construirCasa();
        
        
        tablero.add(casilla);
        tablero.add(casillaCalle);
        
        //tablero.get(0).construirCasa();
        ((CasillaCalle)tablero.get(1)).construirCasa();
        
        //La línea 36 me da error en tiempo de compilación. No se
        //puede construir una casa en una casilla de tipo Casilla.
        //Sin embargo, sí se puede en una casilla de tipo CasillaCalle, 
        //pero da un error.
        //Este error del tipo casillaCalle se arregla haciendo un casting 
        //poniendo delante del objeto (tablero.get(1) entre paréntesis 
        //CasillaCalle
        
*/
        
        
        CasillaCalle casilla1 = new CasillaCalle(2);
        Casilla casilla2 = new Casilla ("casilla1");
        
        casilla1.recibeJugador();
        casilla2.recibeJugador();
        
        //En el objeto casilla1, se ha ejecutado el método de
        //CasillaCalle al ser este objeto de esta clase.
        
        //En el objeto casilla2, se ha ejecutado el método de
        //Casilla al ser este objeto de esta clase.
        
        //System.out.println();
        casilla1.construirCasa();
        //casilla2.construirCasa();
        
        //Lo que ocurre es que casilla1 sí construye una casa
        //y casilla2 no lo hace ya que en la clase Casilla
        //no está implementado el método construirCasa().
        
        
        //Modificación clase
        CasillaSorpresa sorpresa = new CasillaSorpresa();
    }
   
}
