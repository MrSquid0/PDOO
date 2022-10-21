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
      Modelo_laberinto::Elemento_separador::habitacion_al_otro_lado(habitacion_usuario)
    end

    def intentar_avanzar()
      @numaleatorio = Random.rand(0,3)
      if @habitacion_usuario == nil
        exit 0
      end
      #debe devolver siempre el número con la dirección de avance
    end

    attr_reader :estado
    attr_reader :vidas
    attr_reader :habitacion_usuario

  end
end