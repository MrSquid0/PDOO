package ejerciciosjava;

import java.util.ArrayList;

public class Hotel{
    private static int NUM_HOTELES;
    private String nombre;
    private String ciudad;
    private int estrellas;
    private ArrayList<Reserva> reservas;
    private ArrayList<Empleado> trabaja;
    private ArrayList<Habitacion> habitaciones;

    Director director;

    public Hotel (String nombre, String ciudad, int estrellas){
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.estrellas = estrellas;
        NUM_HOTELES++;
        reservas = new ArrayList<>();
        trabaja = new ArrayList<>();
    }

    public static int getNUM_HOTELES(){
        return NUM_HOTELES;
    }

    public void setDirector (Director director){
        this.director = director;
    }

    public Director getDirector(){
        return director;
    }
    
    public void addReserva (Cliente cliente, String fechaEntrada, String fechaSalida){
        reservas.add(new Reserva(fechaEntrada, fechaSalida, cliente, this));
    }
    
    public ArrayList<Reserva> getReservas(){
        return reservas;
    }
    
    public boolean addEmpleado(Empleado empleado){
        if (trabaja.contains(empleado))
            return false;
        return true;
    }
    
    public void addHabitacion(int numero, int cantidad){
        habitaciones.add(new Habitacion(numero, cantidad));
    }
    
    public int buscarHabitacionCapacidad(int capacidad){
        for (int i=0; i<habitaciones.size(); i++){
            if (habitaciones.get(i).getCapacidad() >= capacidad)
                return habitaciones.get(i).getNumero();
        }
        return -1;
    }

}
