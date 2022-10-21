modelo = Modelo_laberinto::Laberinto.new

controlador = Controlador_laberinto::Controlador.new(modelo)

test = Vista2_laberinto.new(controlador, modelo)

test.menu_usuario