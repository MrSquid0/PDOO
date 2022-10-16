# encoding:utf-8

module Controlador_laberinto

  require_relative './estado_juego'
  class Controlador
    def initialize (modelo)
      @vidas = 0
      @modelo = modelo
      @estado = Estado_juego.EN_ENTRADA_LABERINTO
    end

    def estado()

    end

    def entrar(vidas)

    end

    def intentar_avanzar()

    end

    def vidas()
      @vidas
    end

    def habitacion_usuario

    end

  end
end