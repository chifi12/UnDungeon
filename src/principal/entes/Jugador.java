package principal.entes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import principal.Constantes;
import principal.control.GestorControles;
import principal.mapas.Mapa;
import principal.sprites.HojaSprites;
import principal.sprites.Sprite;

public class Jugador {
//atributos
	private double posicionX;
	private double posicionY;
	
	private int direccion; //usamos char para no ocupar tanto como un String
	private double velocidad = 1;
	private boolean enMovimiento;
	
	private HojaSprites hs;
	
	private BufferedImage imagenActual;
	
//	private final int ANCHO_JUGADOR = 16; //limites de la colision
//	private final int ALTO_JUGADOR = 16;
	
	/*el sistema de colisiones estara compuesto por 4 rect (uno para cada direccion)
	 * que solo tendran 1 pixel (de ancho o largo, dependiendo si es horizontal o vertical)
	 * y del lado sobrante el tamaño correspondera al personaje*/
	private final Rectangle LIMITE_ARRIBA = new Rectangle(Constantes.CENTRO_VENTANA_X - 13, Constantes.CENTRO_VENTANA_Y + 12, 26, 1);
	private final Rectangle LIMITE_ABAJO = new Rectangle(Constantes.CENTRO_VENTANA_X - 13, Constantes.CENTRO_VENTANA_Y + 16, 26, 1);
	private final Rectangle LIMITE_IZQUIERDA = new Rectangle(Constantes.CENTRO_VENTANA_X - 15, Constantes.CENTRO_VENTANA_Y + 12, 1, 5);
	private final Rectangle LIMITE_DERECHA = new Rectangle(Constantes.CENTRO_VENTANA_X + 12, Constantes.CENTRO_VENTANA_Y + 12, 1, 5);
	
	private int animacion;
	private int estado;
	
	private Mapa mapa; //lo instanciamos a partir de la clase GestorJuego
//constructor	
	public Jugador(double posicionX, double posicionY, Mapa mapa) {
		this.posicionX = posicionX;
		this.posicionY = posicionY;
		this.mapa = mapa;
		
		direccion = 1; //n de la direccion cardinal "norte" y es la direccion por defecto en la que aparece nuestro pj
		
		enMovimiento = false;
		
		hs = new HojaSprites("/imagenes/hojasPersonajes/personajemago.png", Constantes.LADO_SPRITE, false); //hoja de sprites de los personajes
	
		imagenActual = hs.obtenerSprite(0).obtenerImagen();
		
		animacion = 0;
		estado = 0;
	}
	//metodos
	public void actualizar() {
		cambiarAnimacionEstado();
		enMovimiento = false; //cada vez que act el estado, el mov empieze como falso
		determinarDireccion();
		animar();
	}
	
	private void cambiarAnimacionEstado() { //obtenemos animaciones segun sprite tengamos, esto cambia de acuerdo a la divisibilada entre si de los numeros
		if (animacion < 30) {
			animacion++;
		} else {
			animacion = 0;
		}
		
		if (animacion < 15) {
			estado = 1;
		} else {
			estado = 2;
		}
	}
	
	private void determinarDireccion() {
		final int velocidadX = evaluarVelocidadX(); //estan inicializadad en evaluarVelocidad
		final int velocidadY = evaluarVelocidadY();
		
		if (velocidadX == 0 && velocidadY == 0) {
			return;
		}
		if ((velocidadX != 0 && velocidadY == 0) || (velocidadX == 0 && velocidadY != 0)){
			mover(velocidadX, velocidadY);
		} else {
			/*las siguientes condiciones establecen los movimientos en diagonales
		      para que solamente se pueda mover en 4 direcciones*/
			//izq y arriba
			if (velocidadX == -1 && velocidadY == -1) {
				if (GestorControles.teclado.izquierda.obtenerUltimaPulsacion() > GestorControles.teclado.arriba.obtenerUltimaPulsacion()){
					mover(velocidadX, 0); 
				} else {
					mover (0,velocidadY);
				}
			}
			//izq y abajo
			if (velocidadX == -1 && velocidadY == 1) {
				if (GestorControles.teclado.izquierda.obtenerUltimaPulsacion() > GestorControles.teclado.abajo.obtenerUltimaPulsacion()){
					mover(velocidadX, 0); 
				} else {
					mover (0,velocidadY);
				}
			}
			//derec y arriba
			if (velocidadX == 1 && velocidadY == -1) {
				if (GestorControles.teclado.derecha.obtenerUltimaPulsacion() > GestorControles.teclado.arriba.obtenerUltimaPulsacion()){
					mover(velocidadX, 0); 
				} else {
					mover (0,velocidadY);
				}
			}
			//derecha y abajo
			if (velocidadX == 1 && velocidadY == 1) {
				if (GestorControles.teclado.derecha.obtenerUltimaPulsacion() > GestorControles.teclado.abajo.obtenerUltimaPulsacion()){
					mover(velocidadX, 0); 
				} else {
					mover (0,velocidadY);
				}
			}
		}
	}
	
	private int evaluarVelocidadX () { //este metodo nos sirve para inicializar velocidadX
		int velocidadX = 0; //vamos a tener 3 velocidades 0 (quieto) velocidad 1 (derecha) velocidad 2 (izquierda)
		
		if (GestorControles.teclado.izquierda.estaPulsada() && !GestorControles.teclado.derecha.estaPulsada()) {
			velocidadX = -1;
		} else if (GestorControles.teclado.derecha.estaPulsada() && !GestorControles.teclado.izquierda.estaPulsada()) {
			velocidadX = 1;
		}
		return velocidadX;
	}
	
	private int evaluarVelocidadY() {
		int velocidadY = 0; //vamos a tener 3 velocidades 0 (quieto) velocidad 1 (arriba) velocidad 2 (abajo)
		
		if (GestorControles.teclado.arriba.estaPulsada() && !GestorControles.teclado.abajo.estaPulsada()) {
			velocidadY = -1;
		} else if (GestorControles.teclado.abajo.estaPulsada() && !GestorControles.teclado.arriba.estaPulsada()) {
			velocidadY = 1;
		}
		return velocidadY;
	}
	
	private void mover (final int velocidadX, final int velocidadY) {
		enMovimiento = true;
		
		cambiarDireccion (velocidadX, velocidadY);
		
		if (!fueraMapa(velocidadX, velocidadY)) {
			if (velocidadX == -1 && !enColisionIzquierda(velocidadX)) {
				posicionX += velocidadX * velocidad;
			}
			if (velocidadX == 1 && !enColisionDerecha(velocidadX)) {
				posicionX += velocidadX * velocidad;
			}
			if (velocidadY == -1 && !enColisionArriba(velocidadY)) {
				posicionY += velocidadY * velocidad;
			}
			if (velocidadY == 1 && !enColisionAbajo(velocidadY)) {
				posicionY += velocidadY * velocidad;
			}
		}
		
	}
	
	private boolean fueraMapa(final int velocidadX, final int velocidadY) { //este metodo se va a llamar dentro de mover
		int posicionFuturaX = ((int) posicionX + (velocidadX) * (int)velocidad);
		int posicionFuturaY = ((int) posicionY + (velocidadY) * (int)velocidad);
		
		//TEMPORAL --> SE PUEDE CAMBIAR EL 32 PORQUE DESPUES SE LE ASIGNARIA COLISIONES A LOS BLOQUES (SPRITES PAREDES)
		final Rectangle bordesMapa = mapa.obtenerBordes( posicionFuturaX, posicionFuturaY, 26 + 32 , 5 + 32); //este rectangulo reptresenta los borde del mapa
		// le agrego al algoritmo de arriiba la suma de 32 para poder reducir el espacio de colisiones ya que hay paredes, pero puede presentar cambios ya que falta asignar colisiones a los Sprites
		final boolean fuera;
		
		if (LIMITE_ARRIBA.intersects(bordesMapa) || LIMITE_ABAJO.intersects(bordesMapa) || LIMITE_IZQUIERDA.intersects(bordesMapa) || LIMITE_DERECHA.intersects(bordesMapa)) {
			fuera = false;
		} else {
		fuera = true;
		}
		return fuera;
	}
	 /* estos metodos nos permiten recorrer todo el ArrayList y crear un rectangulo de colision arriba del Sprite encontrado*/
	private boolean enColisionArriba (int velocidadY) {
		for (int r = 0; r < mapa.areasColision.size(); r++) { //r --> rectangulo
			final Rectangle area = mapa.areasColision.get(r);
			
			int origenX = area.x;
			int origenY = area.y + velocidadY * (int) velocidad + 3 * (int) velocidad; //3--> significa que le sumamos 3 pixeles
			//1 pixel es el que vamos a detectar en un borde del rectangulo de colisiones del personajes
			//el 2 pixel es el que vamos a detectar del otro borde
			// y el 3 es el pixel que esta delante del rectangulo
			
			final Rectangle areaFutura = new Rectangle(origenX, origenY, Constantes.LADO_SPRITE, Constantes.LADO_SPRITE);
			
			if (LIMITE_ARRIBA.intersects(areaFutura)) { //comprobamos si hay una colision
				return true;
				}
			}
		return false;
		}
		
		private boolean enColisionAbajo (int velocidadY) {
			for (int r = 0; r < mapa.areasColision.size(); r++) { //r --> rectangulo
				final Rectangle area = mapa.areasColision.get(r);
				
				int origenX = area.x;
				int origenY = area.y + velocidadY * (int) velocidad - 3 * (int) velocidad; //3--> significa que le sumamos 3 pixeles
				//1 pixel es el que vamos a detectar en un borde del rectangulo de colisiones del personajes
				//el 2 pixel es el que vamos a detectar del otro borde
				// y el 3 es el pixel que esta delante del rectangulo
				
				final Rectangle areaFutura = new Rectangle(origenX, origenY, Constantes.LADO_SPRITE, Constantes.LADO_SPRITE);
				
				if (LIMITE_ABAJO.intersects(areaFutura)) { //comprobamos si hay una colision
					return true;
					}
				}
			return false;
			}
			
			private boolean enColisionIzquierda (int velocidadX) {
				for (int r = 0; r < mapa.areasColision.size(); r++) { //r --> rectangulo
					final Rectangle area = mapa.areasColision.get(r);
					
					int origenX = area.x + velocidadX * (int) velocidad + 3 * (int) velocidad; //3--> significa que le sumamos 3 pixeles;
					int origenY = area.y;
					//1 pixel es el que vamos a detectar en un borde del rectangulo de colisiones del personajes
					//el 2 pixel es el que vamos a detectar del otro borde
					// y el 3 es el pixel que esta delante del rectangulo
					
					final Rectangle areaFutura = new Rectangle(origenX, origenY, Constantes.LADO_SPRITE, Constantes.LADO_SPRITE);
					
					if (LIMITE_IZQUIERDA.intersects(areaFutura)) { //comprobamos si hay una colision
						return true;
						}
					}
				return false;
				}
				
				private boolean enColisionDerecha (int velocidadX) {
					for (int r = 0; r < mapa.areasColision.size(); r++) { //r --> rectangulo
						final Rectangle area = mapa.areasColision.get(r);
						
						int origenX = area.x + velocidadX * (int) velocidad - 3 * (int) velocidad;//3--> significa que le sumamos 3 pixeles
						int origenY = area.y; 
						//1 pixel es el que vamos a detectar en un borde del rectangulo de colisiones del personajes
						//el 2 pixel es el que vamos a detectar del otro borde
						// y el 3 es el pixel que esta delante del rectangulo
						
						final Rectangle areaFutura = new Rectangle(origenX, origenY, Constantes.LADO_SPRITE, Constantes.LADO_SPRITE);
						
						if (LIMITE_DERECHA.intersects(areaFutura)) { //comprobamos si hay una colision
							return true;
						}
					}
		return false;
	}
	
	private void cambiarDireccion(final int velocidadX, final int velocidadY) { //define el sprite de acuerdo donde miremos
		
		if (velocidadX == -1) {
			direccion = 2;
		} else if (velocidadX == 1) {
			direccion = 3;
		}
		
		if (velocidadY == -1) {
			direccion = 1;
		} else if (velocidadY == 1) {
			direccion = 0;
		}
	}
	
	private void animar () { //si no estamos en movimiento, el sprite es el parado
		if (!enMovimiento) {
			estado = 0;
			animacion = 0;
		}
		imagenActual = hs.obtenerSprite(direccion, estado).obtenerImagen(); //cargamos la imagen
	}
	
	public void dibujar(Graphics g) { //dbujar el personaje en el centro de la pantalla
		final int centroX =  Constantes.ANCHO_VENTANA / 2 - Constantes.LADO_SPRITE / 2;
		final int centroY =  Constantes.ALTO_VENTANA / 2 - Constantes.LADO_SPRITE / 2;
		
//		g.setColor(Color.green);
		g.drawImage(imagenActual, centroX, centroY, null);
//		g.drawRect(LIMITE_ARRIBA.x, LIMITE_ARRIBA.y, LIMITE_ARRIBA.width, LIMITE_ARRIBA.height); //sumandoles pixeles a los valores de centroX y centroY ajsutamos la caja para colisiones
//		g.drawRect(LIMITE_ABAJO.x, LIMITE_ABAJO.y, LIMITE_ABAJO.width, LIMITE_ABAJO.height);
//		g.drawRect(LIMITE_IZQUIERDA.x, LIMITE_IZQUIERDA.y, LIMITE_IZQUIERDA.width, LIMITE_IZQUIERDA.height);
//		g.drawRect(LIMITE_DERECHA.x, LIMITE_DERECHA.y, LIMITE_DERECHA.width, LIMITE_DERECHA.height);
	}
	
	//getters, setters
	public void establecerPosicionX (double posicionX) {
		this.posicionX = posicionX;
	}
	
	public void establecerPosicionY (double posicionY) {
		this.posicionY = posicionY;
	}
	
	public double obtenerPosicionX () {
		return posicionX;
	}
	public double obtenerPosicionY() {
		return posicionY;
	}
}
