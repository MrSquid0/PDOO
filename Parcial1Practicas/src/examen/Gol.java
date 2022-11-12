package examen;

public class Gol {
    private int minuto;
    private static int TOTAL_GOLES = 0;
    
    public Gol (int minuto){
        this.minuto = minuto;
        Gol.TOTAL_GOLES++;
    }
    
    public static int numeroGoles(){
        return TOTAL_GOLES;
    }
    
    public static void reducirNumeroGoles(){
        Gol.TOTAL_GOLES--;
    }
    
    public int getMinuto(){
        return minuto;
    }
    
    public void setMinuto(int minuto){
        this.minuto = minuto;
    }
}
