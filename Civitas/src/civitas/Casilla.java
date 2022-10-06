
package civitas;

public class Casilla {
    
    TipoCasilla tipo;
    
    MazoSorpresas mazo;
    
    private String Nombre;
    private float precioCompra, precioEdificar, precioBaseAlquiler;

    private static float FACTORALQUILERCALLE = 1.0f, FACTORALQUILERCASA = 1.0f,
    FACTORALQUILERHOTEL = 4.0f;
    private int numCasas, numHoteles;
    
    void init(){
        
    }
    
    Casilla (TipoCasilla unTipo, String unNombre, float unPrecioCompra, float unPrecioEdificar, float unPrecioAlquilerBase){
        tipo = unTipo;
        Nombre = unNombre;
        precioCompra = unPrecioCompra;
        precioEdificar = unPrecioEdificar;
        precioBaseAlquiler = unPrecioAlquilerBase;
    }
    
    public int cantidadCasasHoteles(){
        return numCasas + numHoteles;
    }
    
    Casilla (String nombre){
        tipo = TipoCasilla.DESCANSO;
        this.Nombre = nombre;
    }
    
    Casilla (String titulo, float precioCompra, float precioEdificar, float precioBaseAlquiler){
        tipo = TipoCasilla.CALLE;
        this.precioEdificar = precioEdificar;
        this.precioBaseAlquiler = precioBaseAlquiler;
    }
    
    Casilla (String nombre, MazoSorpresas mazo){
        tipo = TipoCasilla.SORPRESA;
        this.Nombre = nombre;
        this.mazo = mazo;
    }
    
    /*
    
    boolean comprar (Jugador jugador){
        
    }
    
    boolean construirCasa (Jugador jugador){
    
    }

    boolean construirHotel (Jugador jugador){
    
    }

*/
    boolean derruirCasas (int numero, Jugador jugador){
        
    }
    
    public float getPrecioAlquilerCompleto(){
        return precioBaseAlquiler * (FACTORALQUILERCASA + numCasas + numHoteles * FACTORALQUILERHOTEL);
    }
    
    float getPrecioCompra(){
        return precioCompra;
    }
    
    float getPrecioEdificar(){
        return precioEdificar;
    }
    
    int getNumCasas(){
        return numCasas;
    }
    
    int getNumHoteles(){
        return numHoteles;
    }
    
    public String toString(){
        String cadena = Nombre + ". Precios: Compra: " + precioCompra + ", Edificar: " + precioEdificar +
                ", Alquiler base: " + precioBaseAlquiler + ", Casas: " + numCasas + ", Hoteles: " + numHoteles;
        return cadena;
    }
}
