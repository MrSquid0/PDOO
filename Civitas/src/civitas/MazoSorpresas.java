
package civitas;

import java.util.ArrayList;

public class MazoSorpresas {
    private ArrayList<Sorpresa> sorpresas;
    private boolean barajada;
    int usadas;
    boolean debug;
    
    private void init(){
        barajada = false;
        usadas = 0;
    }
    
    MazoSorpresas(boolean d){
        debug = d;
        this.init();
    }
    
    MazoSorpresas(){
        debug = false;
        this.init();
    }
    
    void alMazo (Sorpresa s){
        if (!barajada){
            sorpresas.add(s);
        }
    }
    
    Sorpresa siguiente(){
        if ((!barajada || usadas >= sorpresas.size()) && debug == false){
            usadas = 0;
            barajada = true;
        }
    }
}
