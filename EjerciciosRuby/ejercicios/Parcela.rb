# encoding:utf-8

class Parcela

  #Atributos de clase
  @@num_casas = 0
  @@num_hoteles = 0
  @@FACTORIALALQUILERCALLE = 1.0
  @@FACTORALQUILERCASA = 1.0
  @@FACTORALQUILERHOTEL = 4.0


  #Constructor con parámetros
  def initialize (nombre, precio_compra, precio_edificar, precio_base_alquiler, propietario)
    #new(nombre, precio_compra, precio_edificar, precio_base_alquiler, propietario)
    @nombre = nombre
    @precio_compra = precio_compra
    @precio_edificar = precio_edificar
    @precio_base_alquiler = precio_base_alquiler
    @propietario = propietario
    @num_casas = 0
    @num_hoteles = 0
  end

  attr_reader :nombre

  attr_reader :precio_compra

  attr_reader :precio_edificar

  attr_reader :precio_base_alquiler

  def get_precio_alquiler_completo
    precio_base_alquiler = @precio_base_alquiler * (@@FACTORALQUILERCASA + num_casas + num_hoteles * @@FACTORALQUILERHOTEL)
    precio_base_alquiler
  end

  def construir_casa
    @num_casas = @num_casas + 1
  end

  def construir_hotel
    @num_hoteles = @num_hoteles + 1
  end

  attr_reader :num_casas

  attr_reader :num_hoteles

  attr_reader :propietario

end

parcela_ejercicio = Parcela.new("parcela_ejercicio", 5000, 2300, 500, "Gonzalo")

parcela_ejercicio.construir_casa
parcela_ejercicio.construir_hotel
parcela_ejercicio.construir_hotel

puts "Nombre: " + parcela_ejercicio.nombre
puts "Precio de compra: " + parcela_ejercicio.precio_compra.to_s
puts "Precio de edificar: " + parcela_ejercicio.precio_edificar.to_s
puts "Precio de alquiler: " + parcela_ejercicio.get_precio_alquiler_completo.to_s
puts "Número de casas: " + parcela_ejercicio.num_casas.to_s
puts "Número de hoteles: " + parcela_ejercicio.num_hoteles.to_s
puts "Propietario: " + parcela_ejercicio.propietario

parcela_uno = Parcela.new("parcela_uno", 5000, 2600, 450, "Juan")
parcela_dos = Parcela.new("parcela_uno", 5000, 2600, 450, "Juan")