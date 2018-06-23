package principal.sprites;

import java.awt.image.BufferedImage;

public class Sprite {
	
	//atributos
	private final BufferedImage imagen;
	
	private final int ancho;
	private final int alto;
	
	//constructores
	public Sprite(final BufferedImage imagen) {
		this.imagen = imagen;
		
		ancho = imagen.getWidth();
		alto = imagen.getHeight();
	}
	
	
	//getters
	public BufferedImage obtenerImagen() {
		return imagen;
	}
	
	public int obtenerAncho() {
		return ancho;
	}
	
	public int obtenerAlto() {
		return alto;
	}
}
