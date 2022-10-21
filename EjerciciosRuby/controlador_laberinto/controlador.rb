# encoding:utf-8

module Controlador_laberinto

  require_relative './estado_juego'
  require_relative '../modelo_laberinto/habitacion'
  class Controlador
    def initialize (modelo)
      @vidas = 0
      @modelo = modelo
      @estado = Controlador_laberinto::Estado_juego::EN_ENTRADA_LABERINTO
      @habitacion_usuario = nil
    end

    def entrar(vidas)

    end

    def intentar_avanzar()

    end

    attr_reader :estado
    attr_reader :vidas
    attr_reader :habitacion_usuario

  end
end