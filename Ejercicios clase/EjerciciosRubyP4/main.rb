require './persona'
require "./deportista"
require "./nadadores"
require "./corredores"

  #Instanciamos objetos de las clases
  persona = Herencia::Persona.new("Gonzalo")
  deportista = Herencia::Deportista.new("Gonzalo",5)
  corredor = Herencia::Corredores.new("Gonzalo", 10)
  nadador = Herencia::Nadadores.new("Gonzalo", 15)

  #Mandamos a "andar" a cada uno de ellos
  persona.andar
  deportista.andar
  corredor.andar
  nadador.andar

corredor.to_s