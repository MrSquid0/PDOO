module Herencia
  class Nadadores < Deportista

    def nadar
      result = "Estoy nadando"
    end

    def to_s
      tmp = super
      tmp += " y además soy nadador"
    end
  end
end
