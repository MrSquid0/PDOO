module Herencia
  class Corredores < Deportista

    def correr
      result = "Estoy corriendo"
    end

    def to_s
      tmp = super
      tmp += " y además soy corredor"
    end

  end
end