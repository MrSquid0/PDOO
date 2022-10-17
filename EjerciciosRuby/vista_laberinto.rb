# encoding:utf-8

module EjerciciosRuby
  require_relative 'controlador_laberinto/controlador'
  require_relative 'controlador_laberinto/estado_juego'
  require_relative 'modelo_laberinto/laberinto'
  class Vista_laberinto
    def initialize (controlador)
      @controlador = controlador
    end

    def menu_usuario()
      while true do
        estado=@controlador.estado
        values=[*1..10].map!(&:to_s)

        case estado
        when Controlador_laberinto::Estado_juego::EN_ENTRADA_LABERINTO
          puts "Introduce el número de vidas para empezar el juego (1 a 10)"
          vidas = gets.chomp

          while !values.include? vidas do
            puts "Introduce el número de vidas para empezar el juego (1 a 10)"
            vidas = gets.chomp
          end

        when Controlador_laberinto::Estado_juego::DENTRO_VIVO
          informe_dentro @controlador, @vidas
          puts "Pulsa la tecla ENTER para continuar"
          puts controlador.intentar_avanzar

        when Controlador_laberinto::Estado_juego::EN_SALIDA_LABERINTO
          informe_final controlador.habitacion, controlador.vidas
          exit 0

        when Controlador_laberinto::Estado_juego::DENTRO_MUERTO
          informe_final controlador.habitacion, controlador.vidas
          exit 0
        end
      end
    end

    def informe_dentro(habitacion, vidas)
      puts "La habitación actual es " + habitacion.to_s + " y el número de vidas restantes es " + vidas.to_s
    end

    def informe_final(habitacion, vidas)
      puts "La habitación actual es " + habitacion.to_s + " y el número de vidas restantes es " + vidas.to_s
    end
  end

  laberinto = Modelo_laberinto::Laberinto.new

  controlador = Controlador_laberinto::Controlador.new(laberinto)

  test = Vista_laberinto.new(controlador)

  test.menu_usuario
end