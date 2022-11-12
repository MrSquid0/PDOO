
package ejerciciosjava;

public class Reserva {
    private String fechaEntrada;
    private String fechaSalida;
    Cliente cliente;
    Hotel hotel;
    
    public Reserva (String fechaEntrada, String fechaSalida, Cliente cliente, Hotel hotel){
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.cliente = cliente;
        this.hotel = hotel;
    }
    
    public String getFechaEntrada(){
        return fechaEntrada;
    }
    
    public Cliente getCliente(){
        return cliente;
    }
}
