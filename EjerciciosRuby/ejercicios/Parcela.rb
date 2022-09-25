
class Parcela

  #Atributos de clase
  @num_casas = 0
  @num_hoteles = 0
  @factoralquilercalle = 1.0
  @factoralquilercasa = 1.0
  @factoralquilerhotel = 4.0


  def initialize (nombre, precio_compra, precio_edificar, precio_base_alquiler, propietario)
    new(nombre, precio_compra, precio_edificar, precio_base_alquiler, propietario)
  end

  def get_nombre
    @nombre
  end

  def get_precio_compra
    @precio_compra
  end

  def precio_edificar
    @precio_edificar
  end

  def get_precio_alquiler_completo
    @precio_base_alquiler * (@factoralquilercasa + @num_casas + @num_hoteles * @factoralquilerhotel)
  end

  def construir_casa
    @num_casas = @num_casas + 1
  end

  def construir_hotel
    @num_hoteles = @num_hoteles + 1
  end

  def get_num_casas
    @num_casas
  end

  def get_propietario
    @propietario
  end

  def igualdad_identidad (otra_parcela)
    if this == otra_parcela
      puts "true"
    else
      puts "false"
    end
  end

  def igualdad_estado (otra_parcela)
    if @nombre == otra_parcela
      puts "true"
    else
      puts "false"
    end
  end


end
