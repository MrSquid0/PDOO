
package civitas;

import java.util.ArrayList;

public class Casilla {
    
    TipoCasilla tipo;
    
    MazoSorpresas mazo;
    
    private String Nombre;
    private float precioCompra, precioEdificar, precioBaseAlquiler;

    private static float FACTORALQUILERCALLE = 1.0f, FACTORALQUILERCASA = 1.0f,
    FACTORALQUILERHOTEL = 4.0f;
    private int numCasas, numHoteles;
    
    Jugador propietario;
    
    private void init(){
        tipo = TipoCasilla.CALLE;
        mazo = new MazoSorpresas();
        Nombre = "";
        precioCompra = 0f;
        precioEdificar = 0f;
        precioBaseAlquiler = 0f;
        numCasas = 0;
        numHoteles = 0;
    }
    
    Casilla (TipoCasilla unTipo, String unNombre, float unPrecioCompra, float unPrecioEdificar, float unPrecioAlquilerBase){
        init();
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
        init();
        tipo = TipoCasilla.DESCANSO;
        this.Nombre = nombre;
    }
    
    Casilla (String titulo, float precioCompra, float precioEdificar, float precioBaseAlquiler){
        init();
        tipo = TipoCasilla.CALLE;
        this.precioEdificar = precioEdificar;
        this.precioBaseAlquiler = precioBaseAlquiler;
    }
    
    Casilla (String nombre, MazoSorpresas mazo){
        init();
        tipo = TipoCasilla.SORPRESA;
        this.Nombre = nombre;
        this.mazo = mazo;
    }
    
    
    
    boolean comprar (Jugador jugador){
        return true;
    }
    
    boolean construirCasa (Jugador jugador){
        return true;
    }

    boolean construirHotel (Jugador jugador){
        return true;
    }

    public boolean esEsteElPropietario(Jugador jugador){
        boolean esPropietario = false;
        if (jugador == propietario)
            esPropietario = true;
        return esPropietario;
    }

    boolean derruirCasas (int numero, Jugador jugador){
        int numCasasOriginal = numCasas;
        if (esEsteElPropietario(jugador) && numCasas >= numero)
            numCasas = numCasas - numero;
        
        if (numCasasOriginal != numCasas)
            return true;
        return false;
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
    
    void informe (int actual, ArrayList<Jugador> todos){
        Diario.getInstance().ocurreEvento(todos.get(actual).toString());
    }
    
    private boolean esJugadorCorrecto (int actual, ArrayList <Jugador> todos){
        boolean esCorrecto = false;
        
        if (actual >=0 && actual < todos.size())
            esCorrecto = true;
        return esCorrecto;
    }
    
    void recibeJugador(int iactual, ArrayList<Jugador> todos){
        
    }
    
    private void recibeJugador_calle(int iactual, ArrayList<Jugador> todos){
        
    }

    private void recibeJugador_sorpresa(int iactual, ArrayList<Jugador> todos){
        
    }
    
    public boolean tienePropietario(){
        boolean tiene = false;
        
        if (propietario != null)
            tiene = true;
        return tiene;
    }
    
    public void tramitarAlquiler(Jugador jugador){
        if (tienePropietario() && esEsteElPropietario(jugador)){
            jugador.pagaAlquiler(precioBaseAlquiler);
            jugador.recibe(precioBaseAlquiler);
        }
    }
    
    public String toString(){
        String cadena = Nombre + ". Precios: Compra: " + precioCompra + ", Edificar: " + precioEdificar +
                ", Alquiler base: " + precioBaseAlquiler + ", Casas: " + numCasas + ", Hoteles: " + numHoteles;
        return cadena;
    }
}
