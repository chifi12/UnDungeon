package principal.mapas;

import java.awt.Rectangle;

import principal.sprites.Sprite;

public class Tile {
		//atributos
	private final Sprite sprite;
	private final int id; //identificador unico para cada tile
	private boolean solido;
	
	
	//constructores
	public Tile(final Sprite sprite, final int id) {
		this.sprite = sprite;
		this.id = id;
		solido = false; //por defecto asumimos que los tiles no son colicionables
	}
	
	public Tile (final Sprite sprite, final int id, final boolean solido) {
		this.sprite = sprite;
		this.id =id;
		this.solido = solido; //este cnstructor nos da la oportunidad de dejar como solido a un tile, osea darle valor "true"	
	}
	
	//getters
	public Sprite obtenerSprite() {
		return sprite;
	}
	
	public int obtenerId() {
		return id;
	}
	//setters
	public void establecerSolido(final boolean solido) {
		this.solido = solido;
	}
	//metodos
	
	public Rectangle obtenerLimites (final int x, final int y) {
		return new Rectangle(x, y, sprite.obtenerAncho(), sprite.obtenerAlto());
		//devolvemos un rect con el tamaño desde la izq superrior del tile, y la anchura del sprite y altura del sprite y la mima ubicacion del tile que representa
		
	}
	
}
