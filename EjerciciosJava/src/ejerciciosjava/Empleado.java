/*
 */
package ejerciciosjava;

public class Empleado {
    private String nombre;
    
    public Empleado(String nombre){
        this.nombre = nombre;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public boolean addTrabajo(Hotel hotel){
        return true;
    }
}
