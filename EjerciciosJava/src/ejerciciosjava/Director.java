package ejerciciosjava;

public class Director {
    private String nombre;
    private long telefono;

    public Director (String nombre, long telefono){
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getNombre(){
        return nombre;
    }
}
