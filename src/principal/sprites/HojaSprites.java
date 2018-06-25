package principal.sprites;

import java.awt.image.BufferedImage;

import principal.herramientas.CargadorRecursos;

public class HojaSprites {
	//atributos
	final private int anchoHojaEnPixeles;
	final private int altoHojaEnPixeles;
	
	final private int anchoHojaEnSprites; //medira cuantos sprites hay en una hoja
	final private int altoHojaEnSprites; //""
	
	final private int anchoSprites;	//en caso de que manejemos un sprite que no sea cuadrado
	final private int altoSprites;
	
	final private Sprite[] sprites;
	
	//constructor
	public HojaSprites(final String ruta, final int tamanoSprites, final boolean hojaOpaca) {
		final BufferedImage imagen;
		
		if (hojaOpaca) {
			imagen = CargadorRecursos.cargarImagenCompatibleOpaca(ruta);
		} else {
			imagen = CargadorRecursos.cargarImagenCompatibleTranslucida(ruta);
		}
		
		anchoHojaEnPixeles = imagen.getWidth();	//cant de pixeles en spriet
		altoHojaEnPixeles = imagen.getHeight();
		
		anchoHojaEnSprites = anchoHojaEnPixeles / tamanoSprites;//cuantos sprites existen en la hoja
		altoHojaEnSprites = altoHojaEnPixeles / tamanoSprites;
		
		anchoSprites = tamanoSprites;//tama�o de cada Sprite
		altoSprites = tamanoSprites;
		
		sprites =new Sprite[anchoHojaEnSprites * altoHojaEnSprites];
		
		rellenarSpritesDesdeImagen(imagen);
	}
	
	public HojaSprites(final String ruta, final int anchoSprites, final int altoSprites, final boolean hojaOpaca) {
		//constructor en caso de que los sprites no sean cuadrados
		final BufferedImage imagen;
		
		if (hojaOpaca) {
			imagen = CargadorRecursos.cargarImagenCompatibleOpaca(ruta);
		} else {
			imagen = CargadorRecursos.cargarImagenCompatibleTranslucida(ruta);
		}
		
		anchoHojaEnPixeles = imagen.getWidth();	//cant de pixeles en spriet
		altoHojaEnPixeles = imagen.getHeight();
		
		anchoHojaEnSprites = anchoHojaEnPixeles / anchoSprites;//cuantos sprites existen en la hoja
		altoHojaEnSprites = altoHojaEnPixeles / altoSprites;
		
		this.anchoSprites = anchoSprites;//tama�o de cada Sprite
		this.altoSprites = altoSprites;
		
		sprites =new Sprite[anchoHojaEnSprites * altoHojaEnSprites];
		
		rellenarSpritesDesdeImagen(imagen);
	}
	
	//metodos
	//metodo para sacar los Sprites de la hoja para meterlo en el array
	private void rellenarSpritesDesdeImagen(final BufferedImage imagen) {
		for (int y = 0; y < altoHojaEnSprites; y++) {
			for (int x = 0; x < anchoHojaEnSprites; x++) {
				final int posicionX = x * anchoSprites;
				final int posicionY = y * altoSprites;
				
				sprites[x + y * anchoHojaEnSprites] = new Sprite(imagen.getSubimage(posicionX, posicionY, anchoSprites, altoSprites));
				//la linea anterior va a sacar todos los sprites de una imagen
			}
		}
	}
	//getters
	public Sprite obtenerSprite (final int indice) {
		return sprites[indice];
	}
	
	public Sprite obtenerSprite(final int x, final int y) {
		return sprites[x + y * anchoHojaEnSprites];
	}
	
	//con estos getters, podemos acceder de ds formas distintas a los sprites, tanto como por indice, o por array
}
