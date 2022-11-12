/*
 */
package ejercicios;

import java.util.ArrayList;


public class EjerciciosJavaP4 {
    public static void main(String[] args) {
        /*
        Casilla casillaPadre = new Casilla("Granada");
        CasillaCalle casillaHija = new CasillaCalle(3);
        ArrayList<Casilla> tablero = new ArrayList<>();
        
        //Pregunta 1 --> Por que el método recibeJugador() no está
        //redefinido en casillaHija, por lo que hereda el método
        //de la súperclase y obviamente el mismo resultado.
        System.out.println(casillaPadre.recibeJugador());

        System.out.println(casillaHija.recibeJugador());
        
        //Pregunta 2 --> Ha ejecutado el método de su clase, no
        //el de la clase padre.
        
        //Pregunta 3--> He ejecutado el métood de su clase, no
        //el de la clase padre.
        
        //Pregunta 4
        
        casillaHija.construirCasa();
        
        tablero.add(casillaPadre);
        tablero.add(casillaHija);
        
        tablero.get(1).construirCasa();
        
        //El error se arregla definiendo (sin implementar) el método
        //construirCasa() en la clase Casilla, ya que el ArrayList
        //es de tipo Casilla.
        */
        
        CasillaCalle casilla1 = new CasillaCalle(2);
        Casilla casilla2 = new Casilla ("casilla1");
        
        casilla1.recibeJugador();
        casilla2.recibeJugador();
        
        //En el objeto casilla1, se ha ejecutado el método de
        //CasillaCalle al ser este objeto de esta clase.
        
        //En el objeto casilla2, se ha ejecutado el método de
        //Casilla al ser este objeto de esta clase.
        
        System.out.println();
        casilla1.construirCasa();
        casilla2.construirCasa();
        
        //Lo que ocurre es que casilla1 sí construye una casa
        //y casilla2 no lo hace ya que en la clase Casilla
        //no está implementado el método construirCasa().
        
    }
   
}
