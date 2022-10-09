package civitas;

/**
 *
 * @author gonzalo
 */
        


public class Civitas {

    public static void main(String[] args) {
        Dado dado = Dado.getInstance();
        
        
        System.out.println("****Apartado 1****");
        for (int i=0; i<100; i++){
            System.out.println(dado.quienEmpieza(4));
        }
        
        System.out.println("****Apartado 2****");
        
        dado.setDebug(false);
        
        System.out.print("\nModo debug ");
        if (dado.getDebug())
            System.out.print("activado");
        else
            System.out.print("desactivado" + "\n");
        System.out.println();
        
        for (int i=1; i<=5; i++){
            System.out.print("Tirada " + i + ": ");
            System.out.println(dado.tirar());
        }
        
        System.out.println("****Apartado 3****");
        
        System.out.println("El último resultado fue: " + dado.getUltimoResultado());
        
        System.out.println("****Apartado 4****");
        
        TipoCasilla PuertaDelSol = TipoCasilla.CALLE;
        
        System.out.println("****Apartado 5****");
        
        Tablero tablero = new Tablero();
        
        Casilla casilla1 = new Casilla("Puerta del Sol", 50, 30, 30);
        Casilla casilla2 = new Casilla("Alberto Aguilera", 20, 15, 30);
        Casilla casilla3 = new Casilla("Calle Mayor", 30, 15, 30);
        Casilla casilla4 = new Casilla("Calle Preciados", 35, 15, 30);
        
        tablero.añadeCasilla(casilla1);
        tablero.añadeCasilla(casilla2);
        tablero.añadeCasilla(casilla3);
        tablero.añadeCasilla(casilla4);
        
        System.out.println(casilla1.toString());
        System.out.println(casilla2.toString());
        System.out.println(casilla3.toString());
        System.out.println(casilla4.toString());
        
        System.out.println("****Apartado 7****");
        
        Diario diario = Diario.getInstance();
        
        System.out.println(diario.getEventos());
        
        System.out.println("****Apartado 8****");
        
        int pos = 0;

        for (int i=1; i<=10; i++){
            System.out.print("Tirada " + i + ": ");
            int tirada = dado.tirar();
            System.out.print(tirada + "--> Nueva posición: ");
            pos = tablero.nuevaPosicion(pos, tirada);
            System.out.print(pos + "\n");
        }
        
    }
    
  
    
}
