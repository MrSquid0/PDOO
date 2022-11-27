/*
 * Click nbfs://nbhSst/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package civitas;

import java.util.ArrayList;

public class Jugador implements Comparable<Jugador> {
    protected static int CasasMax = 4;
    protected static int CasasPorHotel = 4; 
    protected static int HotelesMax = 4;
    protected static float PasoPorSalida = 1000;

    
    private ArrayList<CasillaCalle> propiedades;
    
    private int casillaActual;
    private String nombre;
    
    private boolean puedeComprar;
    private float saldo;
    private static float SaldoInicial = 7500;
    
    Jugador(String nombre){
        this.nombre = nombre;
        propiedades = new ArrayList<>();
        casillaActual = 0;
        puedeComprar = false;
        saldo = SaldoInicial;
    }
    
    protected Jugador (Jugador otro){
        this.casillaActual = otro.casillaActual;
        this.nombre = otro.nombre;
        this.puedeComprar = otro.puedeComprar;
        this.saldo = otro.saldo;
        propiedades = new ArrayList<>();
    }
    
    int cantidadCasasHoteles(){
        int suma = 0;
        for (int i=0; i<propiedades.size(); i++){
            suma += propiedades.get(i).cantidadCasasHoteles();
        }
        return suma;
    }
    
    public int compareTo (Jugador otro){
        return Float.compare(saldo, otro.saldo);
    }
    
    boolean comprar (CasillaCalle titulo){
        boolean result = false;
        if (puedeComprar){
            float precio = titulo.getPrecioCompra();
            if (puedoGastar(precio)){
                result = titulo.comprar(this);
                propiedades.add(titulo);
                Diario.getInstance().ocurreEvento("El jugador " + nombre + " compra la propiedad " + titulo.getNombre() + ".\n");
                puedeComprar = false;
            } else{
                Diario.getInstance().ocurreEvento("El jugador " + nombre + " no tiene saldo para comprar "
                        + "la propiedad " + titulo + ".\n");
            }
        }
        return result;
    }
    
    boolean construirCasa (int ip){
        boolean result = false;
        boolean existe = existeLaPropiedad(ip);
        boolean puedoEdificar = false;
        if (existe){
            CasillaCalle propiedad = propiedades.get(ip);
            puedoEdificar = puedoEdificarCasa(propiedad);
            if(puedoEdificar){
                result = propiedad.construirCasa(this);
                Diario.getInstance().ocurreEvento("El jugador " + nombre + " construye casa en su propiedad " 
                        + propiedad.getNombre() + " y queda así:\n" + propiedad.toString() + "\n");
            }
        }
        return result;
    }
    
    boolean construirHotel (int ip){
        boolean result = false;
        if (existeLaPropiedad(ip)){
            CasillaCalle propiedad = propiedades.get(ip);
            boolean puedoEdificarHotel = puedoEdificarHotel(propiedad);
            if (puedoEdificarHotel){
                result = propiedad.construirHotel(this);
                propiedad.derruirCasas(CasasPorHotel, this);
                Diario.getInstance().ocurreEvento("El jugador " + nombre + " construye hotel en su propiedad " 
                        + propiedad.getNombre() + " y queda así:\n" + propiedad.toString() + "\n");
            }
        }
        return true;
    }
    
    boolean enBancarrota(){
        boolean arruinado = false;
        if (saldo < 0)
            arruinado = true;
        return arruinado;
    }
    
    private boolean existeLaPropiedad(int ip){
        boolean existe = false;
        if (propiedades.size() > ip)
            existe = true;
        return existe;
    }
    
    protected int getCasasMax(){
        return CasasMax;
    }
    
    static int getCasasPorHotel(){
        return CasasPorHotel;
    }
    
    public int getCasillaActual(){
        return casillaActual;
    }
    
    protected int getHotelesMax(){
        return HotelesMax;
    }

    public String getNombre(){
        return nombre;
    }
    
    private static float getPremioPasoSalida(){
        return PasoPorSalida;
    }
    
    public ArrayList<CasillaCalle> getPropiedades(){
        return propiedades;
    }
    
    boolean getPuedeComprar(){
        return puedeComprar;
    }
    
    protected float getSaldo(){
        return saldo;
    }
    
    boolean modificarSaldo(float cantidad){
        float saldoModificado = saldo+cantidad;
        Diario.getInstance().ocurreEvento("El saldo de " + nombre +
                " fue modificado de " 
                + saldo + " a " + saldoModificado + ".\n");
        saldo += cantidad;
        return true;
    }
    
    boolean moverACasilla (int numCasilla){
        puedeComprar = false;
        int casillaActualMasUno = casillaActual+1;
        int numCasillaMasUno = numCasilla+1;
        Diario.getInstance().ocurreEvento("El jugador " + this.getNombre() + " se ha movido de la casilla " 
                + casillaActualMasUno + " a la casilla " + numCasillaMasUno + ".\n");
        casillaActual = numCasilla;
        return true;
    }
    
    boolean paga (float cantidad){
        return modificarSaldo(cantidad * -1);
    }
    
    boolean pagaAlquiler (float cantidad){
        return paga (cantidad);
    }
    
    boolean recibe (float cantidad){
        return modificarSaldo(cantidad);
    }
    
    boolean pasaPorSalida(){
        recibe(PasoPorSalida);
        Diario.getInstance().ocurreEvento("Un jugador ha pasado por la casilla de salida y ha"
                + " recibido la cantidad de " + PasoPorSalida + ".\n");
        return true;
    }
    
    boolean puedeComprarCasilla(){
        puedeComprar = true;
        return puedeComprar;
    }
    
    private boolean puedoGastar(float precio){
        return saldo >= precio;
    }
    
    private boolean puedoEdificarCasa(CasillaCalle propiedad){
        boolean puedoEdificar = false;
        
        if ( (puedoGastar(propiedad.getPrecioEdificar())) 
                && (Jugador.CasasMax > propiedad.getNumCasas())
                && (propiedad.getNumHoteles() < Jugador.HotelesMax))
            puedoEdificar = true;
        else
            Diario.getInstance().ocurreEvento("\nNo has podido construir la casa "
                    + "por uno de los siguientes motivos: \n"
                    + "- No tienes dinero suficiente.\n"
                    + "- Has superado el número máximo de casas.\n"
                    + "- Has superado el número máximo de hoteles.\n");   
        return puedoEdificar;
    }
    
    private boolean puedoEdificarHotel(CasillaCalle propiedad){
        boolean puedoEdificar = false;
        
        if ( (puedoGastar(propiedad.getPrecioEdificar())) 
                && (Jugador.HotelesMax > propiedad.getNumHoteles())
                && (Jugador.CasasPorHotel == propiedad.getNumCasas()) )
            puedoEdificar = true;
        else
            Diario.getInstance().ocurreEvento("\nNo has podido construir el hotel "
                    + "por uno de los siguientes motivos: \n"
                    + "- No tienes dinero suficiente.\n"
                    + "- Has superado el número máximo de hoteles.\n"
                    + "- No tienes casas suficientes para construir un hotel. "
                    + "Necesitas al menos " + CasasPorHotel + " casas para "
                            + "construir uno.\n");
        return puedoEdificar;
    }
    
    boolean tieneAlgoQueGestionar(){
        boolean tieneAlgo = true;
        if (propiedades.isEmpty())
            tieneAlgo = false;
        return tieneAlgo;
    }
    
    protected JugadorEspeculador convertir(){
        JugadorEspeculador especulador = new JugadorEspeculador(this);
        return especulador;
    }
    
    public String toString(){
        int casillaActualMasUno = casillaActual+1;
            
        String cadena = "Casilla actual: " + casillaActualMasUno +
                        "\nNombre del jugador: " + nombre +
                         "\nSaldo: " + saldo + "\n";
        return cadena;
    }
}
