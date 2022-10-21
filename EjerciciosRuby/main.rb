modelo = Modelo_laberinto::Laberinto.new

controlador = Controlador_laberinto::Controlador.new(modelo)

test = Vista_laberinto.new(controlador)

test.menu_usuario