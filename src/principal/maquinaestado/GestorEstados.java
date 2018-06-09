package principal.maquinaestado;

import java.awt.Graphics;

import principal.maquinaestado.estados.juego.GestorJuego;

//controlar en que estados estamos
public class GestorEstados {//maquina de estado es un mecanismo maestro que controla en que punto del juego estamos (combate, menu, etc..)
	
	private EstadoJuego[] estados; //guardaremos todos los estados que tenga el juego (menu inicial, menu de juego,etc..)
	private EstadoJuego estadoActual; //segun el etado que estemos, ese estado sera el estadoActual

	public GestorEstados() {
		iniciarEstados();
		iniciarEstadoActual();
	}



	private void iniciarEstados() {
		estados = new EstadoJuego[1]; //de acuerdo a los estados se ira agrandando
		estados [0] = new GestorJuego(); //para que no tire error hay que implementarla interfaz en gestorjuego
	//añador e iniciar los demas estados a medida que los creemos
	}
	
	private void iniciarEstadoActual() {
		estadoActual = estados[0]; //estado actual sea igual al gestor del juego
	}
	
	public void actualizar() {
		estadoActual.actualizar();
	}
	
	public void dibujar (final Graphics g) {
		estadoActual.dibujar(g);
	}
	
	public void cambiarEstadoActual(final int nuevoEstado) {//accederemos a un nuevo estado del array EstadosJuego
		estadoActual = estados[nuevoEstado];
	}
	
	public EstadoJuego obtenerEstadoActual() { //nos va a indicar en que estado nos encontramos
		return estadoActual;
	}
}
