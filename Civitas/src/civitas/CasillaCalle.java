
package civitas;

import java.util.ArrayList;

public class CasillaCalle extends Casilla{
    private float precioCompra, precioEdificar, precioBaseAlquiler;

    private static float FACTORALQUILERCALLE = 1.0f, FACTORALQUILERCASA = 1.0f,
    FACTORALQUILERHOTEL = 4.0f;
    
    private int numCasas, numHoteles;
    
    Jugador propietario;
    
    private void init(){
        numCasas = 0;
        numHoteles = 0;
        propietario = null;
    }
    
    //Constructor para casillas de tipo calle
    CasillaCalle (String titulo, float precioCompra, 
            float precioEdificar, float precioBaseAlquiler){
        super(titulo);
        this.precioCompra = precioCompra;
        this.precioEdificar = precioEdificar;
        this.precioBaseAlquiler = precioBaseAlquiler;
    }
    
    void recibeJugador(int iactual, ArrayList<Jugador> todos){
        informe (iactual, todos);
        Jugador jugador = todos.get(iactual);
        if (!this.tienePropietario()){
            jugador.puedeComprarCasilla();
        } else{
            tramitarAlquiler(jugador);
        }
    }
    
    public String toString(){
        String cadena;
        if (this.tienePropietario()){
            float aPagar = getPrecioAlquilerCompleto();
            cadena = "\nEl propietario de esta casilla es " + propietario.getNombre()+ "."
                    + "\nCasas: " + numCasas
                    + "\nHoteles: " + numHoteles
                    + "\nAlquiler total: " + aPagar;
        } else {        
        
        cadena = "Acabas de llegar a la siguiente casilla:" +
                "\nNombre de la casilla: " + super.getNombre() + 
                "\n---- Precios: ----" +
                "\n- Compra: " + precioCompra + 
                "\n- Edificar: " + precioEdificar +
                "\n- Alquiler: " + getPrecioAlquilerCompleto() +
                "\n------------------" +
                "\nCasas: " + numCasas + 
                "\nHoteles: " + numHoteles + "\n";
        }
        return cadena;
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
        return precioBaseAlquiler * (FACTORALQUILERCASA * numCasas + numHoteles * FACTORALQUILERHOTEL);
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
    
    protected void actualizaPropietarioPorConversion(Jugador jugador){
        this.propietario = jugador;
    }
    
}
