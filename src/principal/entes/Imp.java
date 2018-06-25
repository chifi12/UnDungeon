package principal.entes;

import java.awt.Graphics;

import principal.Constantes;
import principal.sprites.HojaSprites;

public class Imp extends Enemigo{
	
	private static HojaSprites hojaImp;

	public Imp (final int idEnemigo, final String nombre, final int vidaMaxima) {
		super(idEnemigo, nombre, vidaMaxima);
		
		if (hojaImp == null) {
			hojaImp = new HojaSprites(Constantes.RUTA_ENEMIGOS + idEnemigo + ".png", Constantes.LADO_SPRITE, false);
		}
	}
	//metodos
	
	public void dibujar (final Graphics g, final int puntoX, final int puntoY) {
		
	}
}
