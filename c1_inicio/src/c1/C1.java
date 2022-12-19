package c1;

public class C1 {

    public static void main(String[] args) {
        Jugador alexia = new Jugador("Alexia");
        Equipo granada = new Equipo("Granada");
        Equipo anonimo = new Equipo();        

        //a
        System.out.println("Apartado A:");
        alexia.marcaPenalti(granada, 10, "derecho");
        alexia.marcaFalta(anonimo, 90, true);
        alexia.marcaFalta(granada, 90, true);
        
        System.out.println(((Penalti)alexia.getGoles().get(0)).descripcion());
        for (int i=1; i<alexia.getGoles().size(); i++){
            System.out.println(((Falta)alexia.getGoles().get(i)).descripcion());
        }
        
        //b
        System.out.println("Apartado B:");
        ((Penalti)alexia.getGoles().get(0)).getJugador();
        ((Falta)alexia.getGoles().get(1)).quitarBarrera();
        
        //c
        System.out.println("Apartado C:");
        Jugador alexia2 = alexia.copia();
        System.out.println("Número de goles hasta el momento: "
        + Gol.numeroGoles());
        
        //d
        System.out.println("Apartado D:");
        
        Controlador controlador = new Controlador(granada, anonimo);
        Vista vista = new Vista(controlador);
    }    
}
