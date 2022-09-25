public class Parcela {
    private String nombre;
    private float precioCompra, precioEdificar, precioBaseAlquiler;

    private float FACTORALQUILERCALLE = 1.0f, FACTORALQUILERCASA = 1.0f,
    FACTORALQUILERHOTEL = 4.0f;
    private int numCasas, numHoteles;

    private String propietario;

    //Constructor por parámetros
    public Parcela(String nombre, float precioCompra, float precioEdificar, float precioBaseAlquiler, String propietario){
        this.nombre = nombre;
        this.precioCompra = precioCompra;
        this.precioEdificar = precioEdificar;
        this.precioBaseAlquiler = precioBaseAlquiler;
        this.propietario = propietario;
    }

    //Constructor sin parámetros
    public Parcela(){
        this.nombre = "";
        this.precioCompra = 0;
        this.precioEdificar = 0;
        this.precioBaseAlquiler = 0;
        this.propietario = "";
    }

    public String getNombre(){
        return nombre;
    }

    public float getPrecioCompra(){
        return precioCompra;
    }

    public float getPrecioEdificar(){
        return precioEdificar;
    }

    public float getPrecioAlquilerCompleto(){
        return precioBaseAlquiler * (FACTORALQUILERCASA + numCasas + numHoteles * FACTORALQUILERHOTEL);
    }

    public boolean construirCasa(){
        numCasas++;
        return true;
    }

    public boolean construirHotel(){
        numHoteles++;
        return true;
    }

    public int getNumCasas(){
        return numCasas;
    }

    public int getNumHoteles(){
        return numHoteles;
    }

    public String getPropietario(){
        return propietario;
    }

    public boolean igualdadIdentidad (Parcela otraParcela){
            boolean esIguall = false;
        if (this == otraParcela)
            esIguall = true;

        return esIguall;
    }


    public boolean igualdadEstado (Parcela otraParcela){
        boolean esIgual = false;

        if (this.nombre.equals(otraParcela.nombre) &&
                this.propietario.equals(otraParcela.propietario))
            esIgual = true;

        return esIgual;
    }

}