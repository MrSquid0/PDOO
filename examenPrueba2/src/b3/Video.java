
package b3;


public class Video extends Contenido {
    private int duracion;

    public Video(int duracion, int peso, String archivo) {
        super(peso, archivo);
        this.duracion = duracion;
    }
    
    @Override
    public void visualizar(){
        System.out.println("Duración del vídeo: " + duracion + ", peso: "
                + this.getPeso() + " y nombre de archivo: " + this.getArchivo());
    }
    
    @Override
    public int getPeso(){
        return this.duracion * super.getPeso();
    }
    
    @Override
    public Contenido copia(){
        Video copia = new Video(this.duracion, super.getPeso(), this.getArchivo());
        for (Usuario usu : this.getLikes());
        return copia;
    }
    
    @Override
    public String getTipo(){
        return "Video";
    }
    
}
