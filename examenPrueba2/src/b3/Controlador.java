
package b3;

import java.util.ArrayList;

public class Controlador {
    private int actual;
    private Vista vista;
    private ArrayList<Contenido> contenidos;

    public Controlador(ArrayList<Contenido> contenidos) {
        this.contenidos = contenidos;
        this.actual = 0;
        this.vista = null;
    }

    public void setVista(Vista vista) {
        this.vista = vista;
    }
    
    public void cambiar(){
        actual = (actual+1)%2;
        this.vista.actualizar();
    }
    
    public String getArchivo(){
        return contenidos.get(this.actual).getArchivo();
    }
    
    public String getTipo(){
        return contenidos.get(this.actual).getTipo();
    }    
    
}
