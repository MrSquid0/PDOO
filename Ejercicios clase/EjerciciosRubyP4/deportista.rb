module Herencia
  class Deportista < Persona
    #def initialize (nombre, horas_entrenamiento)
    #super(nombre)
    # @horas_entrenamiento = horas_entrenamiento
    #end

    def competicion_deportiva
      result = "Voy a una competición deportiva"
    end

    def to_s
      tmp = super
      tmp += " y además soy deportista que entrena #{@horas_entrenamiento} horas"
    end
  end
end