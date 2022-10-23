
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
    
    Casilla (String titulo, float precioCompra, float precioEdificar, float precioBaseAlquiler){
        init();
        tipo = TipoCasilla.CALLE;
        this.precioCompra = precioCompra;
        this.precioEdificar = precioEdificar;
        this.precioBaseAlquiler = precioBaseAlquiler;
    }
    
    Casilla (String nombre, MazoSorpresas mazo){
        init();
        tipo = TipoCasilla.SORPRESA;
        this.Nombre = nombre;
        this.mazo = mazo;
    }    
    
    Casilla (String nombre){
        init();
        tipo = TipoCasilla.DESCANSO;
        this.Nombre = nombre;
    }
    
    public int cantidadCasasHoteles(){
        return numCasas + numHoteles;
    }    
    
    //DUDA: ¿Esto es así?
    boolean comprar (Jugador jugador){
        propietario = jugador;
        return jugador.paga(precioCompra);
    }
    
    boolean construirCasa (Jugador jugador){
        numCasas++;
        return true;
    }

    boolean construirHotel (Jugador jugador){
        numHoteles++;
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
        if (tipo == TipoCasilla.CALLE)
            recibeJugador_calle(iactual, todos);
        
        if (tipo == TipoCasilla.SORPRESA)
            recibeJugador_sorpresa(iactual, todos);
        
        if (tipo == TipoCasilla.DESCANSO)
            informe(iactual,todos);
    }
    
    private void recibeJugador_calle(int iactual, ArrayList<Jugador> todos){
        informe (iactual, todos);
        Jugador jugador = todos.get(iactual);
        if (!this.tienePropietario()){
            jugador.puedeComprarCasilla();
        } else{
            tramitarAlquiler(jugador);
        }
    }

    private void recibeJugador_sorpresa(int iactual, ArrayList<Jugador> todos){
        Sorpresa sorpresa = mazo.siguiente();
        informe(iactual, todos);
        sorpresa.aplicarAJugador(iactual, todos);
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