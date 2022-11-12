package ejerciciosjava;

public class EjerciciosJavaP2 {
    public static void main(String[] args) {
        Hotel hotel1 = new Hotel("Hotel Palace", "Granada", 5);
        Hotel hotel2 = new Hotel("Hotel NH Luz", "Huelva", 4);

        System.out.println(Hotel.getNUM_HOTELES());

        Director director1 = new Director("Gonzalo", 648283923);

        hotel1.setDirector(director1);

        System.out.println("El director del primer hotel es " + hotel1.getDirector().getNombre());
        
        Cliente cliente1 = new Cliente("38282821F", "Gonzalo");
        
        hotel2.addReserva(cliente1, "09/10/2022", "12/10/2022");
        
        hotel2.addReserva(cliente1, "15/11/2022", "18/11/2022");
        
        
        System.out.println("Reservas del hotel 2:");
        for (int i=0; i<hotel2.getReservas().size(); i++){
            System.out.println("Nombre del cliente: " + hotel2.getReservas().get(i).getCliente().getNombre());
            System.out.println("Fecha de entrada: " + hotel2.getReservas().get(i).getFechaEntrada() + "\n");
        }
        
        System.out.println("\nReservas del cliente " + cliente1.getNombre() + ":");
        for (int i=0; i<cliente1.getReservas().size(); i++){
            System.out.println("Fecha de entrada: " + cliente1.getReservas().get(i).getFechaEntrada() + "\n");
        }

    }
}
