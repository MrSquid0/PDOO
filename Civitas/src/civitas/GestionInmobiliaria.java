/*
 */
package civitas;

public class GestionInmobiliaria {
    private OperacionInmobiliaria valor; //Valor del enumerado
    private int indice; //Índice de la propiedad
    
    public GestionInmobiliaria(OperacionInmobiliaria valor, int indice){
        this.valor = valor;
        this.indice = indice;
    }
    
    public OperacionInmobiliaria getValor(){
        return valor;
    }
    
    int getIndicePropiedad(){
        return indice;
    }
    
    
    
}
