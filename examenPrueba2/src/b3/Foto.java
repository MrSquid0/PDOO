
package b3;


public class Foto extends Contenido {
    private int alto;
    private int ancho;

    public Foto(int alto, int ancho, int peso, String archivo) {
        super(peso, archivo);
        this.alto = alto;
        this.ancho = ancho;
    }
    
    @Override
    public void visualizar(){
        System.out.println("Foto de alto: " + alto + ", ancho: " + ancho +
                ", peso: " + this.getPeso() + " y nombre de archivo: " 
                + this.getArchivo());
    }
    
    public void imprimir(){
        System.out.println("Imprimiendo la foto " + this.getArchivo());
    }
    
    @Override
    public Contenido copia(){
        Foto copia = new Foto(this.alto, this.ancho, this.getPeso(), this.getArchivo());
        for (Usuario usu : this.getLikes());
        return copia;
    }
    
    @Override
    public String getTipo(){
        return "Foto";
    }
}
