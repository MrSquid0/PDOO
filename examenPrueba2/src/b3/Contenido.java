package b3;

import java.util.ArrayList;

public abstract class Contenido {
    private int peso;
    private String archivo;
    private ArrayList<Usuario> likes;

    public Contenido(int peso, String archivo) {
        this.peso = peso;
        this.archivo = archivo;
        
        this.likes = new ArrayList<>();
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public int numeroLikes() {
        return likes.size();
    }

    public void addLike(Usuario usu) {
        this.likes.add(usu);
    }
    
    public abstract void visualizar();
    
    public abstract Contenido copia();

    public ArrayList<Usuario> getLikes() {
        return likes;
    }
    
    public abstract String getTipo();
}
