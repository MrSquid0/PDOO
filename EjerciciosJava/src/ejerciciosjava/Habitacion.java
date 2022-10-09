/*
 */
package ejerciciosjava;

public class Habitacion {
    private int numero;
    private int capacidad;
    
    public Habitacion(int numero, int capacidad){
        this.numero = numero;
        this.capacidad = capacidad;
    }
    
    public int getCapacidad(){
        return capacidad;
    }
    
    public int getNumero(){
        return numero;
    }
}
