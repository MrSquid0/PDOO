
package civitas;

public class TestP4 {
    public static void main (String[] args){
        Jugador jugador = new Jugador("Gonzalo");
        
        CasillaCalle casilla = new CasillaCalle("Velázquez", 60f, 30f, 20f);
        
        jugador.comprar(casilla);
        
        jugador.convertir();
        
        System.out.println(jugador.toString());
    }
}