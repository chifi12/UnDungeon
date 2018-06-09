package principal.maquinaestado.estados.juego;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import principal.control.GestorControles;
import principal.entes.Jugador;
import principal.herramientas.CargadorRecursos;
import principal.mapas.Mapa;
import principal.maquinaestado.EstadoJuego;
import principal.sprites.HojaSprites;

//esta clase es la que ejecutara el juego mientras nos estemos moviendo
public class GestorJuego implements EstadoJuego{
	
	Mapa mapa = new Mapa ("/texto/prueba");
	Jugador jugador = new Jugador (242, 445, mapa); //ingresar valores donde queramos que aparezca el jugador
	
	public void actualizar() { //desplazamiento en el mapa con controles
		jugador.actualizar();
		mapa.actualizar((int) jugador.obtenerPosicionX(), (int) jugador.obtenerPosicionY());
	}
	public void dibujar(Graphics g) {
		mapa.dibujar(g, (int) jugador.obtenerPosicionX(), (int) jugador.obtenerPosicionY());;
		jugador.dibujar(g);
		
		g.setColor(Color.red);
		g.drawString("X = "+ jugador.obtenerPosicionX(), 20, 20);
		g.drawString("Y = "+ jugador.obtenerPosicionY(), 20, 30);
	}
	
}
