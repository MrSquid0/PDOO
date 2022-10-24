require_relative './modelo_laberinto/laberinto'
require_relative './controlador_laberinto/controlador'
require_relative './vista2_laberinto'

modelo = Modelo_laberinto::Laberinto.new

controlador = Controlador_laberinto::Controlador.new(modelo)

test = Vista2_laberinto.new(controlador, modelo)

test.menu_usuario