
class Parcela

  #Atributos de clase
  @@num_casas = 0
  @@num_hoteles = 0
  @@factoralquilercalle = 1.0
  @@factoralquilercasa = 1.0
  @@factoralquilerhotel = 4.0


  def initialize (nombre, precio_compra, precio_edificar, precio_base_alquiler, propietario)
    #new(nombre, precio_compra, precio_edificar, precio_base_alquiler, propietario)
    @nombre = nombre
    @precio_compra = precio_compra
    @precio_edificar = precio_edificar
    @precio_base_alquiler = precio_base_alquiler
    @propietario = propietario
  end

  attr_reader :nombre

  attr_reader :precio_compra

  attr_reader :precio_edificar

  attr_reader :precio_base_alquiler

  def construir_casa
    @num_casas = @num_casas + 1
  end

  def construir_hotel
    @num_hoteles = @num_hoteles + 1
  end

  attr_reader :num_casas

  attr_reader :num_hoteles

  attr_reader :propietario

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

parcelaEjercicio = Parcela.new("parcela_uno", 5000, 2300, 500, "Gonzalo")

puts "Nombre: " + parcelaEjercicio.nombre
puts "Precio de compra: " + parcelaEjercicio.precio_compra.to_s
puts "Precio de edificar: " + parcelaEjercicio.precio_edificar.to_s
puts "Precio de alquiler: " + parcelaEjercicio.precio_base_alquiler.to_s
puts "Número de casas: " + parcelaEjercicio.num_casas.to_s
puts "Número de hoteles: " + parcelaEjercicio.num_hoteles.to_s
puts "Propietario: " + parcelaEjercicio.propietario