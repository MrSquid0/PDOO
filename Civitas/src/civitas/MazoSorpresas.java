
package civitas;

import java.util.ArrayList;
import java.util.Collections;

public class MazoSorpresas {
    private ArrayList<Sorpresa> sorpresas;
    private boolean barajada;
    private int usadas;
    private boolean debug;
    
    private void init(){
        sorpresas = new ArrayList<Sorpresa>();
        barajada = false;
        usadas = 0;
    }
    
    MazoSorpresas(boolean d){
        debug = d;
        this.init();
        if (debug)
            Diario.getInstance().ocurreEvento("el Modo debug está activado");
    }
    
    MazoSorpresas(){
        this.init();
        debug = false;
    }
    
    void alMazo (Sorpresa s){
        if (!barajada){
            sorpresas.add(s);
        }
    }
    
    Sorpresa siguiente(){
        if ((!barajada || usadas >= sorpresas.size())){
            if (!debug){
                    Collections.shuffle(sorpresas);
                }
            }
            usadas = 0;
            barajada = true;
            
            usadas++;
            Sorpresa sorpresaUsada = sorpresas.get(0);
            sorpresas.remove(0);
            sorpresas.add(sorpresaUsada);
            
            return sorpresaUsada;
        }
}