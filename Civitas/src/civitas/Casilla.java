
package civitas;

public class Casilla {
    
    TipoCasilla tipo;
    
    private String Nombre;
    private float precioCompra, precioEdificar, precioBaseAlquiler;

    private static float FACTORALQUILERCALLE = 1.0f, FACTORALQUILERCASA = 1.0f,
    FACTORALQUILERHOTEL = 4.0f;
    private static int numCasas, numHoteles;
    
    Casilla (TipoCasilla unTipo, String unNombre, float unPrecioCompra, float unPrecioEdificar, float unPrecioAlquilerBase){
        tipo = unTipo;
        Nombre = unNombre;
        precioCompra = unPrecioCompra;
        precioEdificar = unPrecioEdificar;
        precioBaseAlquiler = unPrecioAlquilerBase;
    }
    
    public float getPrecioAlquilerCompleto(){
        return precioBaseAlquiler * (FACTORALQUILERCASA + numCasas + numHoteles * FACTORALQUILERHOTEL);
    }
    
    public String toString(){
        String cadena = Nombre + ". Precios: Compra: " + precioCompra + ", Edificar: " + precioEdificar +
                ", Alquiler base: " + precioBaseAlquiler + ", Casas: " + numCasas + ", Hoteles: " + numHoteles;
        return cadena;
    }
}
