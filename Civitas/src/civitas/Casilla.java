
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
        mazo = new MazoSorpresas();
        Nombre = "";
        precioCompra = 0f;
        precioEdificar = 0f;
        precioBaseAlquiler = 0f;
        numCasas = 0;
        numHoteles = 0;
        propietario = null;
    }
    
    //Constructor para casillas de tipo calle
    Casilla (TipoCasilla tipo, String titulo, float precioCompra, 
            float precioEdificar, float precioBaseAlquiler){
        init();
        this.tipo = TipoCasilla.CALLE;
        this.Nombre = titulo;
        this.precioCompra = precioCompra;
        this.precioEdificar = precioEdificar;
        this.precioBaseAlquiler = precioBaseAlquiler;
    }
    
    
    //Constructor para casillas de tipo sorpresa
    Casilla (TipoCasilla tipo, String nombre, MazoSorpresas mazo){
        init();
        this.tipo = TipoCasilla.SORPRESA;
        this.Nombre = nombre;
        this.mazo = mazo;
    }    
    
    //Constructor para casillas de tipo descanso    
    Casilla (TipoCasilla tipo, String nombre){
        init();
        this.tipo = TipoCasilla.DESCANSO;
        this.Nombre = nombre;
    }
    
    public int cantidadCasasHoteles(){
        return numCasas + numHoteles;
    }    
    
    boolean comprar (Jugador jugador){
        propietario = jugador;
        return jugador.paga(precioCompra);
    }
    
    boolean construirCasa (Jugador jugador){
        jugador.paga(precioEdificar);
        numCasas++;
        return true;
    }

    boolean construirHotel (Jugador jugador){
        jugador.paga(precioEdificar);
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

    public String getNombre() {
        return Nombre;
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
        switch (tipo){
            case CALLE:
                recibeJugador_calle(iactual, todos);
                break;
            case SORPRESA:
                recibeJugador_sorpresa(iactual, todos);
                break;
            case DESCANSO:
                informe(iactual,todos);
                break;
        }
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
        if (tienePropietario() && !esEsteElPropietario(jugador)){
            float aPagar = precioBaseAlquiler + precioBaseAlquiler * numCasas
                    + precioBaseAlquiler * numHoteles;
            Diario.getInstance().ocurreEvento(jugador.getNombre() + " tiene que"
            + " pagar al propietario "+ propietario.getNombre() + " " + aPagar + ".\n");
            jugador.pagaAlquiler(aPagar);
            propietario.recibe(aPagar);
        }
    }
    
    public String toString(){
        String cadena = "";
        if (this.tienePropietario()){
            cadena = "\nEl propietario de esta casilla es " + propietario.getNombre()+ "."
                    + "\nAlquiler base: " + precioBaseAlquiler
                    + "\nCasas: " + numCasas
                    + "\nHoteles: " + numHoteles;
        } else {
            switch (tipo){
                case CALLE:
                    cadena = "Acabas de llegar a la siguiente casilla:" +
                    "\nNombre de la casilla: " + Nombre + 
                    "\n---- Precios: ----" +
                    "\n- Compra: " + precioCompra + 
                    "\n- Edificar: " + precioEdificar +
                    "\n- Alquiler base: " + precioBaseAlquiler +
                    "\n------------------" +
                    "\nCasas: " + numCasas + 
                    "\nHoteles: " + numHoteles + "\n";
                    break;
                
                case DESCANSO:
                    cadena = "Acabas de llegar a una casilla de descanso.";
                    break;
                
                case SORPRESA:
                    cadena = "Acabas de llegar a una casilla de sorpresa.";
                    break;
            }
        }
        return cadena;
    }
}