package civitas;

/**
 *
 * @author gonzalo
 */
        


public class Civitas {

    public static void main(String[] args) {
        Dado dado = new Dado();
        
        
        System.out.println("****Apartado 1****");
        for (int i=0; i<100; i++){
            System.out.println(dado.quienEmpieza(4));
        }
        
        System.out.println("****Apartado 2****");
        
        for (int i=0; i<5; i++){
            System.out.print("Tirada " + i + "--> ");
            dado.tirar();
            System.out.print(dado.getDebug() + "\n");
        }
        
        
        
        
        
    }
    
  
    
}
