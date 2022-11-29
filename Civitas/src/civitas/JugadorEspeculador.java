
package civitas;

public class JugadorEspeculador extends Jugador{
    private static final int FactorEspeculador = 2;
    
    protected JugadorEspeculador(Jugador jugador){
        super (jugador);
        
        for (int i=0; i<super.getPropiedades().size(); i++)
            super.getPropiedades().get(i).actualizaPropietarioPorConversion(this);
    }
    
    public String toString(){
        String cadenaEspeculador = "Este jugador es especulador.\n";
        cadenaEspeculador += super.toString();
        return cadenaEspeculador;
    }
    
    protected int getCasasMax(){
        return super.getCasasMax() * FactorEspeculador;
    }
    
    protected int getHotelesMax(){
        return super.getHotelesMax() * FactorEspeculador;
    }
    
    boolean paga (float cantidad){
        return modificarSaldo((cantidad * -1)/2);
    }
    
    public boolean esEspeculador(){
        return true;
    }    
        
}
