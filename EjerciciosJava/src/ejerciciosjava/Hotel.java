public class Hotel{
    private static int NUM_HOTELES;
    private String nombre;
    private String ciudad;
    private int estrellas;

    Director director;

    Hotel (String nombre, String ciudad, int estrellas){
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.estrellas = estrellas;
        NUM_HOTELES++;
    }

    static int getNUM_HOTELES(){
        return NUM_HOTELES;
    }

    void setDirector (Director director){
        this.director = director;
    }

    Director getDirector(){
        return director;
    }

}
