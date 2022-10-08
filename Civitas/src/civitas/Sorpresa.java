/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package civitas;

import java.util.ArrayList;

public class Sorpresa {
    private String texto;
    int valor;
    TipoSorpresa tipo;
    
    Sorpresa(TipoSorpresa tipo, String texto, int valor){
        this.tipo = tipo;
        this.texto = texto;
        this.valor = valor;
    }
    
    void informe (int actual, ArrayList<Jugador> todos){
        Diario.getInstance().ocurreEvento("Se está aplicando una sorpresa al jugador " + todos.get(actual).getNombre());
    }
    
    void aplicarAJugador_pagarCobrar(int actual, ArrayList<Jugador> todos){
        informe(actual, todos);
        todos.get(actual).modificarSaldo(valor);
    }
    
    void aplicarAJugador_porCasaHotel(int actual, ArrayList<Jugador> todos){
        informe (actual, todos);
        todos.get(actual).modificarSaldo(valor * todos.get(actual).cantidadCasasHoteles());        
    }
    
    protected void aplicarAJugador(int actual, ArrayList<Jugador> todos){
        if (tipo == TipoSorpresa.PAGARCOBRAR)
            aplicarAJugador_pagarCobrar(actual, todos);
        else
            aplicarAJugador_porCasaHotel(actual, todos);
    }
    
    public String toString(){
        return texto;
    }

}
