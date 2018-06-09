package principal;

import principal.control.GestorControles;
import principal.graficos.SuperficieDibujo;
import principal.graficos.Ventana;
import principal.maquinaestado.GestorEstados;

public class GestorPrincipal {
	
	private boolean enFuncionamiento = false; //asegura que el bucle funcione
	private String titulo;
	private int ancho;
	private int alto;
	
	private SuperficieDibujo sd;
	private Ventana ventana;
	private GestorEstados ge;
	
	private GestorPrincipal (final String titulo, final int ancho, final int alto) {
		this.titulo = titulo;
		this.ancho = ancho;
		this.alto = alto;
	}

	public static void main(String[] args) {
		GestorPrincipal gp = new GestorPrincipal ("UN-DUNGEON", 640, 360);
		

		
		gp.iniciarJuego();
		gp.iniciarBuclePrincipal();
	}

	private void iniciarJuego() {
		enFuncionamiento = true;
		inicializar();
	}
	
	private void inicializar() { //iniciar todos los componentes que vamos a usar en el juego
		sd = new SuperficieDibujo(ancho, alto);
		ventana = new Ventana(titulo, sd);
		ge = new GestorEstados();
	}

	private void iniciarBuclePrincipal() {
		int aps = 0;
		int fps = 0;
		
		final int NS_POR_SEGUNDO = 1000000000; //variable para temporizador
		final int APS_OBJETIVO = 60; //variable para actualizaciones de controles (Que tan rapido va el juego), valor maximo de byte es 127 (sino usar int) 
		final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJETIVO;
		
		long referenciaActualizacion = System.nanoTime();
		long referenciaContador= System.nanoTime();
		
		double tiempoTranscurrido;
		double delta = 0;  //la cant de tiempo que transcurre hasta que se realiza una actualizacion
		
		
		while (enFuncionamiento) { //bucle principal del juego
			
			final long inicioBucle = System.nanoTime();  //inicio del cronometro
			
			tiempoTranscurrido = inicioBucle - referenciaActualizacion;  //cuant a pasado entre el lon g y este while
			referenciaActualizacion = inicioBucle;
			
			delta += tiempoTranscurrido / NS_POR_ACTUALIZACION;
			
			while (delta >= 1) { //temporizador
				actualizar();
				aps ++;
				Constantes.APS = aps;
				delta--;
			}
			
			dibujar();
			fps++;
			
			
			if (System.nanoTime() - referenciaContador > NS_POR_SEGUNDO) {
				System.out.println ("FPS: "+ fps + " APS: "+ aps);
				
				aps = 0;
				Constantes.APS = aps;
				fps = 0;
				referenciaContador = System.nanoTime();
			}
		}
	}		

	private void actualizar () {
		ge.actualizar(); //para actualizar donde estemos en el juego, tanto e el menu, ocmo in-game
	}
	
	private void dibujar() {
		sd.dibujar(ge); 
	}
}
