/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package civitas;

import java.util.ArrayList;
import java.util.Collections;

public class CivitasJuego {
    private int indiceJugadorActual;
    private ArrayList<Jugador> jugadores;
    private GestorEstados gestorEstados;
    private EstadosJuego estado;
    MazoSorpresas mazo;
    Tablero tablero;
    private final int numMaxJugadores = 4;
    
    private void inicializaMazoSorpresas(){
        mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR, "Se te ha multado por evasión de impuestos, paga 1000.", -1000));
        mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR, "Has ganado la lotería, recibes 800.", 800));
        mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR, "Debido a la inflación, recibes 550.", 550));
        mazo.alMazo(new Sorpresa(TipoSorpresa.PAGARCOBRAR, "Se te ha multado por exceso de velocidad, pagas 1200.", -1200));
        mazo.alMazo(new Sorpresa(TipoSorpresa.PORCASAHOTEL, "Tus bienes han sido revalorizados, recibes 60 por cada casa u hotel.", 60));
        mazo.alMazo(new Sorpresa(TipoSorpresa.PORCASAHOTEL, "Una inspección ha detectado fugas de gas en tus construcciones, pagas 100 por cada construcción.", -100));
        mazo.alMazo(new Sorpresa(TipoSorpresa.PORCASAHOTEL, "Te ha llegado el recibo del IBI, paga 80 por cada casa u hotel.", -80));
        mazo.alMazo(new Sorpresa(TipoSorpresa.PORCASAHOTEL, "El Colegio de Arquitectos te ha premiado por tener las mejores construcciones, recibes 20 por cada casa u hotel.", 20));
    }
    
    private void inicializaTablero(MazoSorpresas mazo){
        //Casilla de salida ya agregada al estar inicializado el tablero
        tablero.añadeCasilla(new Casilla(TipoCasilla.CALLE,"Velázquez", 60f, 30f, 20f));
        tablero.añadeCasilla(new Casilla(TipoCasilla.CALLE,"Salamanca", 80f, 40f, 27f));
        tablero.añadeCasilla(new Casilla(TipoCasilla.CALLE,"Castellana", 100f, 50f, 33f));
        tablero.añadeCasilla(new Casilla(TipoCasilla.CALLE,"Tirso de M.", 120f, 60f, 40f));
        tablero.añadeCasilla(new Casilla(TipoCasilla.SORPRESA,"Sorpresa", mazo));
        tablero.añadeCasilla(new Casilla(TipoCasilla.CALLE,"Lavapiés", 140f, 70f, 47f));
        tablero.añadeCasilla(new Casilla(TipoCasilla.CALLE,"Goya", 150f, 75f, 50f));
        tablero.añadeCasilla(new Casilla(TipoCasilla.SORPRESA,"Sorpresa", mazo));
        tablero.añadeCasilla(new Casilla(TipoCasilla.CALLE,"Mataelpino", 200f, 100f, 67f));
        tablero.añadeCasilla(new Casilla(TipoCasilla.DESCANSO,"Puro Relax"));
        tablero.añadeCasilla(new Casilla(TipoCasilla.CALLE,"Leganitos", 220f, 110f, 73f));
        tablero.añadeCasilla(new Casilla(TipoCasilla.CALLE,"Serrano", 240f, 120f, 80f));
        tablero.añadeCasilla(new Casilla(TipoCasilla.CALLE,"P. del Prado", 260f, 130f, 87f));
        tablero.añadeCasilla(new Casilla(TipoCasilla.CALLE,"Sorpresa", mazo));
        tablero.añadeCasilla(new Casilla(TipoCasilla.CALLE,"Valdelatas", 280f, 140f, 93f));
        tablero.añadeCasilla(new Casilla(TipoCasilla.CALLE,"Méndez A.", 300f, 150f, 100f));
        tablero.añadeCasilla(new Casilla(TipoCasilla.SORPRESA,"Sorpresa", mazo));
        tablero.añadeCasilla(new Casilla(TipoCasilla.CALLE,"O`Donell", 350f, 175f, 117f));
        tablero.añadeCasilla(new Casilla(TipoCasilla.CALLE,"San Jerónimo", 400f, 200f, 133f));
    }    
    
    public CivitasJuego(ArrayList<String> nombres, boolean debug){
        if (nombres.size() <= numMaxJugadores){
        jugadores = new ArrayList<>(); 
        for (int i = 0; i<nombres.size(); i++){
          jugadores.add(new Jugador(nombres.get(i)));
        }
        gestorEstados = new GestorEstados();
        estado = gestorEstados.estadoInicial();
        Dado.getInstance().setDebug(debug);
        indiceJugadorActual = Dado.getInstance().quienEmpieza(jugadores.size());
        System.out.println("Comienza el juego Civitas. El primer turno es para el jugador " + 
                jugadores.get(indiceJugadorActual).getNombre() + ".\n");
        mazo = new MazoSorpresas(debug);
        inicializaMazoSorpresas();
        tablero = new Tablero();
        inicializaTablero(mazo);
        } else{
            System.err.println("El número máximo de jugadores permitidos es " + 
                    numMaxJugadores + ".\n");
            System.exit(1);
        }
    }
    
    private void avanzaJugador(){
        Jugador jugadorActual = getJugadorActual();
        int posicionActual = jugadorActual.getCasillaActual();
        int tirada = Dado.getInstance().tirar();
        int posicionNueva = tablero.nuevaPosicion(posicionActual, tirada);
        Casilla casilla = tablero.getCasilla(posicionNueva);
        Diario.getInstance().ocurreEvento("Has sacado un " + tirada + ".");
        contabilizarPasosPorSalida();
        jugadorActual.moverACasilla(posicionNueva);
        casilla.recibeJugador(indiceJugadorActual, jugadores);
    }
    
    public boolean comprar(){
        boolean res;
        Jugador jugadorActual = getJugadorActual();
        int numCasillaActual = jugadorActual.getCasillaActual();
        Casilla casilla = tablero.getCasilla(numCasillaActual);
        res = jugadorActual.comprar(casilla);
        return res;
    }
    
    public boolean construirCasa(int ip){
        return jugadores.get(indiceJugadorActual).construirCasa(ip);
    }
    
    public boolean construirHotel(int ip){
        return jugadores.get(indiceJugadorActual).construirHotel(ip);
    }
    
    private void contabilizarPasosPorSalida(){
        if (tablero.computarPasoPorSalida())
            jugadores.get(indiceJugadorActual).pasaPorSalida();
    }
    
    public boolean finalDelJuego(){
        boolean finalJuego = false;
        for (int i=0; i<jugadores.size(); i++){
            if (jugadores.get(i).enBancarrota())
                finalJuego = true;
        }
        return finalJuego;
    }
    
    public int getIndiceJugadorActual(){
        return indiceJugadorActual;
    }
    
    public Jugador getJugadorActual(){
        return jugadores.get(indiceJugadorActual);
    }
    
    public ArrayList<Jugador> getJugadores(){
        return jugadores;
    }
    
    public Tablero getTablero(){
        return tablero;
    }
    
    private void pasarTurno(){
        if (indiceJugadorActual != jugadores.size()-1)
            indiceJugadorActual++;
        else
            indiceJugadorActual = 0;
    }
    
    public ArrayList<Jugador> ranking(){
        ArrayList <Jugador> ranking = new ArrayList<>();
        for(int i = 0; i < jugadores.size(); i++)
            ranking.add(jugadores.get(i));
        
        Collections.sort(ranking);
        return ranking;
    }
    

    public OperacionJuego siguientePaso(){
        Jugador jugadorActual = getJugadorActual();
        OperacionJuego operacion = gestorEstados.siguienteOperacion(jugadorActual, estado);
        if (operacion == OperacionJuego.PASAR_TURNO){
            pasarTurno();
            siguientePasoCompletado(operacion);
        } if (operacion == OperacionJuego.AVANZAR){
            avanzaJugador();
            siguientePasoCompletado(operacion);
        }
        return operacion;
    }
    
    public void siguientePasoCompletado(OperacionJuego operacion){
        estado = gestorEstados.siguienteEstado(jugadores.get(indiceJugadorActual), estado, operacion);
    }
    
}
