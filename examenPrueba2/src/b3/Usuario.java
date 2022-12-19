package b3;

import java.util.ArrayList;

public class Usuario {
    private String nombre;
    private ArrayList<Contenido> likes;
    
    private static ArrayList<Usuario> Usuarios = new ArrayList<>();

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.likes = new ArrayList<>();
        Usuario.Usuarios.add(this);
    }
    
    public Usuario(Usuario otro){
        this(otro.nombre);
        for (Contenido con : otro.likes){
            Contenido copia = con.copia();
            this.likes.add(con);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Contenido> getLikes() {
        return likes;
    }

    public void setNombre(String nombre) {
        for(Usuario usu: Usuario.Usuarios) {
            if ((usu.nombre == nombre) && (usu != this)) {
                System.out.println("El nombre ya está en uso");
                return;
            }
        }
        this.nombre = nombre;
    }
    
    public void addLike(Contenido foto) {
        this.likes.add(foto);
        foto.addLike(this);
    }
    
    public static Usuario usuarioMasActivo() {
        Usuario masActivo = null;
        int maxLikes = 0;
        for(Usuario usu: Usuario.Usuarios) {
            if (usu.likes.size() > maxLikes) {
                maxLikes = usu.likes.size();
                masActivo = usu;
            }
        }
        return masActivo;
    }

    public Contenido gustoRaro() {
        Contenido raro = null;
        int minLikes = Integer.MAX_VALUE;
        ArrayList<Contenido> likes = this.getLikes();
        for (Contenido foto: likes) {
            int likesFoto = foto.numeroLikes();
            if (likesFoto < minLikes) {
                raro = foto;
                minLikes = likesFoto;
            }
        }
        return raro;
    }
    
    public Contenido contenidoMasPesado(){
        Contenido masPesado = null;
        int max = -9999;
        for (Contenido con : likes){
            if (con.getPeso() > max){
                masPesado = con;
                max = con.getPeso();
            }
        }
        return masPesado;
    }
}
