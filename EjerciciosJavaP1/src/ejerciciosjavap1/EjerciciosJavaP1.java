package ejerciciosjavap1;

public class EjerciciosJavaP1 {
    public static void main(String[] args) {
        Parcela parcelaEjercicio = new Parcela("parcelaUno", 5000, 2300, 500, "Gonzalo");

        parcelaEjercicio.construirCasa();
        parcelaEjercicio.construirCasa();
        parcelaEjercicio.construirHotel();

        System.out.println("Nombre: " + parcelaEjercicio.getNombre());
        System.out.println("Precio de compra: " + parcelaEjercicio.getPrecioCompra());
        System.out.println("Precio de edificar: " + parcelaEjercicio.getPrecioEdificar());
        System.out.println("Precio de alquiler: " + parcelaEjercicio.getPrecioAlquilerCompleto());
        System.out.println("Número de casas: " + parcelaEjercicio.getNumCasas());
        System.out.println("Número de hoteles: " + parcelaEjercicio.getNumHoteles());
        System.out.println("Propietario: " + parcelaEjercicio.getPropietario());

        System.out.println();
        Parcela parcelaVacia = new Parcela();

        System.out.println("Nombre: " + parcelaVacia.getNombre());
        System.out.println("Precio de compra: " + parcelaVacia.getPrecioCompra());
        System.out.println("Precio de edificar: " + parcelaVacia.getPrecioEdificar());
        System.out.println("Precio de alquiler: " + parcelaVacia.getPrecioAlquilerCompleto());
        System.out.println("Propietario: " + parcelaVacia.getPropietario());

        Parcela p = new Parcela("parcelaUno", 5000, 2300, 500, "Gonzalo");
        Parcela p1 = new Parcela("parcelaUno", 5000, 2300, 500, "Gonzalo");
        Parcela p2 = p;
        System.out.println("El objeto 0 y 1 son iguales en estado: " + p.igualdadEstado(p1));
        System.out.println("El objeto 0 y 1 son iguales en identidad: " + p.igualdadIdentidad(p1));
        System.out.println("El objeto 0 y 2 son iguales en identidad: " + p.igualdadIdentidad(p2));
        System.out.println("El objeto 0 y 2 son iguales en estado: " + p.igualdadEstado(p2));

    }
}