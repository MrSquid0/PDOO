public class Director {
    private String nombre;
    private long telefono;

    Director (String nombre, long telefono){
        this.nombre = nombre;
        this.telefono = telefono;
    }

    String getNombre(){
        return nombre;
    }
}
