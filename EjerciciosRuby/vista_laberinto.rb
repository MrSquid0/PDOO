# encoding:utf-8

module EjerciciosRuby
  require_relative 'controlador_laberinto/controlador'
  require_relative 'controlador_laberinto/estado_juego'
  class Vista_laberinto
    def initialize (controlador)
      @controlador = controlador
    end

    def menu_usuario()
      estado=@controlador.estado

      case estado
      when Estado_juego::EN_ENTRADA_LABERINTO
        puts "Introduce el número de vidas para empezar el juego (1 a 10)"
        num = gets.to_s.chomp

        while num < 0 || num > 10 do
          puts "Introduce el número de vidas para empezar el juego (1 a 10)"
          num = gets.to_s.chomp
        end

      when Estado_juego::DENTRO_VIVO
        informe_dentro @controlador, @vidas
        puts "Pulsa la tecla ENTER para continuar"
        puts controlador.intentar_avanzar

      when Estado_juego::EN_SALIDA_LABERINTO
        informe_final controlador.vidas
        exit 0

      when Estado_juego::DENTRO_MUERTO
        informe_final controlador.vidas
        exit 0
      end

      menu_usuario
    end

    def informe_dentro(habitacion, vidas)
      puts "La habitación actual es " + habitacion.to_s + " y el número de vidas restantes es " + vidas.to_s
    end

    def informe_final(vidas)
      puts "El número de vidas restantes es " + vidas.to_s
    end
  end

  controlador = Controlador_laberinto::Controlador.new(0)

  test = Vista_laberinto.new(controlador)

  test.menu_usuario
end