# encoding:utf-8

module Controlador_laberinto

  require_relative './tado_juego'
  require_relative '../modelo_laberinto/habitacion'
  require_relative '../modelo_laberinto/elemento_separador'
  require_relative '../modelo_laberinto/laberinto'
  class Controlador
    def initialize (modelo)
      @vidas = 0
      @modelo = modelo
      @estado = Controlador_laberinto::Estado_juego::EN_ENTRADA_LABERINTO
      @habitacion_usuario = nil
    end

    def entrar(vidas)
      @vidas = vidas
      @estado = Controlador_laberinto::Estado_juego::DENTRO_VIVO
      hab_actual = @modelo.puerta_entrada.habitacion_al_otro_lado(nil);
      nueva_pared=Elemento_separador.nueva_pared(hab_actual, nil)
      hab_actual.set_lado(Direccion::SUR, nueva_pared)
      @habitacion_usuario = hab_actual
    end

    def intentar_avanzar()
      numaleatorio = rand(3)

      if @habitacion_usuario.pasar(numaleatorio)
        hab_actual = @habitacion_usuario.get_lado(numaleatorio).habitacion_al_otro_lado(habitacion_usuario)
        @habitacion_usuario = hab_actual
        @estado = Controlador_laberinto::Estado_juego::DENTRO_VIVO
      else
        @vidas = vidas-1
        if @vidas < 0
          @estado = Controlador_laberinto::Estado_juego::DENTRO_MUERTO
        end
      end

      if @habitacion_usuario == nil
        puts "¡Enhorabuena! Has salido del laberinto.\n"
        @estado = Controlador_laberinto::Estado_juego::EN_SALIDA_LABERINTO
      end
    end

    attr_reader :estado
    attr_reader :vidas
    attr_reader :habitacion_usuario

  end
end