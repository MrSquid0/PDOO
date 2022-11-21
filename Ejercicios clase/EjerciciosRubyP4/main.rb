require './persona'
require "./deportista"
require "./nadadores"
require "./corredores"

  #Instanciamos objetos de las clases
  persona = Herencia::Persona.new("Gonzalo")
  deportista = Herencia::Deportista.new("Gonzalo",5 )
  corredor = Herencia::Corredores.new("Gonzalo", 7)
  nadador = Herencia::Nadadores.new("Gonzalo", 10)

  #Mandamos a "andar" a cada uno de ellos
  puts persona.andar
  puts deportista.andar
  puts corredor.correr
  puts nadador.nadar

  puts persona.to_s
  puts deportista.to_s
  puts corredor.to_s
  puts nadador.to_s

  #Preguntas de autoevaluación de la sesión

  #¿Es necesario el constructor de la clase Corredor? ¿Por qué?
  # No es necesario, ya que hereda el constructor de Deportista. No hay
  # nuevos atributos en la clase Corredor como para crear un constructor,
  # por lo que heredaría completamente el constructor de Deportista.

  #¿Es necesario el constructor de la clase Deportista? ¿Por qué?
  # Sí es necesario, ya que añadimos un nuevo atributo (horas_entrenamiento).
  # De la misma manera, heredamos nombre del constructor Persona