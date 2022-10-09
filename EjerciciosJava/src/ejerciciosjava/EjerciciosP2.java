public class EjerciciosP2 {
    public static void main(String[] args) {
        Hotel hotel1 = new Hotel("Hotel Palace", "Granada", 5);
        Hotel hotel2 = new Hotel("Hotel NH Luz", "Huelva", 4);

        System.out.println(Hotel.getNUM_HOTELES());

        Director director1 = new Director("Gonzalo", 655324021);

        hotel1.setDirector(director1);

        System.out.println("El director del primer hotel es " + hotel1.getDirector().getNombre());

    }
}
