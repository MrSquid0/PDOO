module Herencia
  class Corredores < Deportista

    def initialize(nombre, atributo_horas_entrenamiento)
      super
    end

    def andar
      tmp = super
      tmp += " y además soy corredor"
      puts tmp
    end

    def to_s
      tmp = super
      tmp += " y soy corredor"
      puts tmp
    end

  end
end