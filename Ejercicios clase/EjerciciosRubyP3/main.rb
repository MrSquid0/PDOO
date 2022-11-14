require_relative './modelo_laberinto/berinto'
require_relative './controlador_laberinto/controlador'
require_relative './vista_laberinto'

modelo = Modelo_laberinto::Laberinto.new

controlador = Controlador_laberinto::Controlador.new(modelo)

test = EjerciciosRuby::Vista_laberinto.new(controlador)

test.menu_usuario