/*
 */
package ejerciciosjava;

import java.util.ArrayList;

public class Empleado {
    private String nombre;
    private final int numMaxHotelPermitidosPorEmpleado = 2;
    private ArrayList<Hotel> trabaja;
    
    public Empleado(String nombre){
        this.nombre = nombre;
        trabaja = new ArrayList<>();
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public boolean addTrabajo(Hotel hotel){
        boolean sePuede = true;
        if (trabaja.size() < numMaxHotelPermitidosPorEmpleado){
            trabaja.add(hotel);
        } else
            sePuede = false;
        return sePuede;
    }
}
