package examen;

public class Examen {
    public static void main(String[] args) {
        
        //************ APARTADO A *************
        System.out.println("Apartado A:");
        System.out.println("Número de goles marcados hasta el momento: " + Gol.numeroGoles());
        
        
        //************ APARTADO B *************
        Jugador alexia = new Jugador ("Alexia");
        Jugador karim = new Jugador ("Karim");
        Equipo granada = new Equipo ("Granada");
        Equipo defecto = new Equipo ();
        
        alexia.marcaGol(granada, 10);
        alexia.marcaGol(defecto, 20);
        karim.marcaGol(granada, 60);
        karim.marcaGol(defecto, 90);
        System.out.println("Apartado B:");
        System.out.println("Número de goles marcados hasta el momento: " + Gol.numeroGoles());
        
        //************ APARTADO C *************
        
        System.out.println("Apartado C:");
        if (defecto.anulaGol(karim, 60)){
            System.out.println("Se ha anulado el gol de Karim en " + defecto.getNombre() + " en el minuto 60");
        } else
            System.out.println("NO se ha podido anular el gol de Karim en " + defecto.getNombre() + " en el minuto 60");
        
        if (defecto.anulaGol(karim, 90)){
            System.out.println("Se ha anulado el gol de Karim en " + defecto.getNombre() + " en el minuto 90");
        } else
            System.out.println("NO se ha podido anular el gol de Karim en " + defecto.getNombre() + " en el minuto 90");
        
        System.out.println("Número de goles marcados hasta el momento: " + Gol.numeroGoles());
        
        //************ APARTADO D *************
        
        System.out.println("Apartado D:");
        System.out.println("Alexia ha marcado " + alexia.golesParte(1) + " goles en las primeras"
                + " partes de los partidos");
        System.out.println("Alexia ha marcado " + alexia.golesParte(2) + " goles en las segundas"
                + " partes de los partidos");
    }
    
}
