module Herencia
  class Nadadores < Deportista

    def initialize(nombre, atributo_horas_entrenamiento)
      super
    end

    def andar
      tmp = super
      tmp += " y además soy nadador"
      puts tmp
    end

    def to_s
      tmp = super
      tmp += " y soy nadador"
      tmp
    end
  end
end
