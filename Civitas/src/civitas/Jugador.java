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

    
    private ArrayList<Casilla> propiedades;
    
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
    
    boolean comprar (Casilla titulo){
        boolean result = false;
        if (puedeComprar){
            float precio = titulo.getPrecioCompra();
            if (puedoGastar(precio)){
                result = titulo.comprar(this);
                propiedades.add(titulo);
                Diario.getInstance().ocurreEvento("El jugador " + nombre + " compra la propiedad " + titulo + ".\n");
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
            Casilla propiedad = propiedades.get(ip);
            puedoEdificar = puedoEdificarCasa(propiedad);
            if(puedoEdificar){
                result = propiedad.construirCasa(this);
                Diario.getInstance().ocurreEvento("El jugador " + nombre + " construye casa en la propiedad " + ip + 
                        propiedades.get(ip)+ ".\n");                
            }
        }
        return result;
    }
    
    boolean construirHotel (int ip){
        boolean result = false;
        if (existeLaPropiedad(ip)){
            Casilla propiedad = propiedades.get(ip);
            boolean puedoEdificarHotel = puedoEdificarHotel(propiedad);
            if (puedoEdificarHotel){
                result = propiedad.construirHotel(this);
                propiedad.derruirCasas(CasasPorHotel, this);
                Diario.getInstance().ocurreEvento("El jugador " + nombre + " construye hotel en la propiedad " + ip + ".\n");
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
    
    private static int getCasasMax(){
        return CasasMax;
    }
    
    static int getCasasPorHotel(){
        return CasasPorHotel;
    }
    
    public int getCasillaActual(){
        return casillaActual;
    }
    
    private static int getHotelesMax(){
        return HotelesMax;
    }

    public String getNombre(){
        return nombre;
    }
    
    private static float getPremioPasoSalida(){
        return PasoPorSalida;
    }
    
    public ArrayList<Casilla> getPropiedades(){
        return propiedades;
    }
    
    boolean getPuedeComprar(){
        return puedeComprar;
    }
    
    protected float getSaldo(){
        return saldo;
    }
    
    boolean modificarSaldo(float cantidad){
        saldo = cantidad;
        Diario.getInstance().ocurreEvento("El saldo fue modificado de " 
                + saldo + " a " + cantidad + ".\n");
        return true;
    }
    
    boolean moverACasilla (int numCasilla){
        puedeComprar = false;
        Diario.getInstance().ocurreEvento("El jugador se ha movido de la casilla " 
                + casillaActual + " a la casilla " + numCasilla + ".\n");
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
    
    private boolean puedoEdificarCasa(Casilla propiedad){
        boolean puedoEdificar = false;
        
        if ( (puedoGastar(propiedad.getPrecioEdificar())) && (Jugador.CasasMax >= propiedad.getNumCasas())){
            puedoEdificar = true;
        }
        return puedoEdificar;
    }
    
    private boolean puedoEdificarHotel(Casilla propiedad){
        boolean puedoEdificar = false;
        
        if ( (puedoGastar(propiedad.getPrecioEdificar())) && (Jugador.HotelesMax >= propiedad.getNumHoteles())
                && (Jugador.CasasPorHotel >= propiedad.getNumCasas()) ){
            puedoEdificar = true;
        }
        return puedoEdificar;
    }
    
    boolean tieneAlgoQueGestionar(){
        boolean tieneAlgo = true;
        if (propiedades == null)
            tieneAlgo = false;
        return tieneAlgo;
    }
    
    public String toString(){
        String puede;
        if (puedeComprar)
            puede = "SÍ";
        else
            puede = "NO";
            
        String cadena = "Casilla actual: " + casillaActual +
                        "\nNombre del jugador: " + nombre +
                         ".\nPuede comprar: " + puede +
                         "\nSaldo: " + saldo + "\n";
        return cadena;
    }
}
