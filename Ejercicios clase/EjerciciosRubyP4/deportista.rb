module Herencia
  class Deportista < Persona
    def initialize (nombre, atributo_horas_entrenamiento)
      @nombre = nombre
      @atributo_horas_entrenamiento = atributo_horas_entrenamiento
    end

    def andar
      super
    end

    def competicion_deportiva
      @atributo_horas_entrenamiento
    end
  end
end
