module Herencia
  class Persona
    def initialize (nombre, horas_entrenamiento=0)
      @nombre = nombre
      @horas_entrenamiento = horas_entrenamiento #Añadido por la sesión de autoevaluación
    end

    def andar
      result = "Soy #{@nombre} y estoy andando"
    end

    def to_s
      result = "Soy una persona y mi nombre es #{@nombre}"
    end
  end
end