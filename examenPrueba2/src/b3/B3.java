package b3;

import java.util.ArrayList;

public class B3 {

    public static void main(String[] args) {
        // a) 
        ArrayList<Contenido> contenidos = new ArrayList<>();
        contenidos.add(new Foto(100, 100, 50, "paisaje"));
        contenidos.add(new Video(60, 50, "Baile"));
        
        for (Contenido con: contenidos){
            con.visualizar();
        }
        
        // b) 
        ((Foto)contenidos.get(0)).imprimir();
        
        // c)
        Usuario usuario1 = new Usuario("Usuario1");
        for (Contenido con: contenidos){
            usuario1.addLike(con);
        }
        Usuario usuario2 = new Usuario(usuario1);
        
        // d)
        System.out.println("El peso más pesado es " 
                + usuario2.contenidoMasPesado().getPeso());
        
        // e) 
        Controlador controlador = new Controlador(contenidos);
        Vista vista = new Vista(controlador);
    }    
}
