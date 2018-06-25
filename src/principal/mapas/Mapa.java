package principal.mapas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import principal.Constantes;
import principal.herramientas.CargadorRecursos;
import principal.sprites.HojaSprites;
import principal.sprites.Sprite;

//tenemos que generar un constructor que lea el archivo de texto y lo procese
public class Mapa {
	//atributos
	private String[] partes; //con esto, vamos a ir ingresando en las distintas lineas del archivo de texto (ancho, alto, hojas de sprites)
	
	private final int ancho;
	private final int alto;
	
	private final Sprite[] paleta; //obtendremos el indice de los sprites hechos en el .txt
	
	private final boolean [] colisiones;
	
	public ArrayList <Rectangle> areasColision = new ArrayList <Rectangle>();
	
	private final int []  sprites;
	
	private final int MARGEN_X = Constantes.ANCHO_VENTANA / 2 - Constantes.LADO_SPRITE / 2; //estas varaibles nos permitiran ubicar el mapa en (0, 0) desde la esquina superior izquierda
	private final int MARGEN_Y = Constantes.ALTO_VENTANA /2 - Constantes.LADO_SPRITE / 2;
	//constructor
	public Mapa(final String ruta) {
		
		String contenido = CargadorRecursos.leerArchivoTexto(ruta); //dentro de este string tenemos el archivo de texto
	
		partes = contenido.split("\\*"); //.split nos separa el texto por el caracter que hemos señalizado
	
		ancho = Integer.parseInt(partes[0]);
		alto =Integer.parseInt(partes[1]);
		
		String hojasUtilizadas = partes[2];
		String [] hojasSeparadas = hojasUtilizadas.split(",");

		//Lectura de la paleta de sprites
		String paletaEntera = partes[3];
		String [] partesPaleta = paletaEntera.split("#");
		
		//asignar sprites aqui
		paleta = asignarSprites(partesPaleta, hojasSeparadas);//tendra el tamaño de como sprites tengamos
		
		 
		
		String colisionesEnteras = partes [4]; //este String se refiere a la parte de colisiones del archivo de textos
		colisiones = extraerColisiones(colisionesEnteras);
		
		//lectura de la paleta de sprites
		String spritesEnteros = partes[5]; //accedemos al 6 elemento de la hoja de texto
		String [] cadenasSprites = spritesEnteros.split(" ");
		
		sprites = extraerSprites(cadenasSprites);
		
		
//		for (int i = 0; i < sprites.length; i++) { //con este bucle testeamos que funcionen los splits
//			System.out.println(sprites[i]);
//		} 
	}	
	//metodos
	
	private Sprite [] asignarSprites(final String [] partesPaleta, final String [] hojasSeparadas) {
		Sprite [] paleta = new Sprite [partesPaleta.length];
		
		HojaSprites hoja = new HojaSprites("/imagenes/hojasTexturas/" + hojasSeparadas[0] + ".png", 32, true); //se cargo la hoja
		
		for (int i = 0; i < partesPaleta.length; i++) { //sacamos los sprites
			String spriteTemporal = partesPaleta[i];//recorrer las partes de la paleta
			
			
			String [] partesSprite = spriteTemporal.split("-"); //rompemos la cadena con guion
			
			int indicePaleta = Integer.parseInt(partesSprite[0]);
			
			int indiceSpriteHoja = Integer.parseInt(partesSprite[2]);
			
			paleta [indicePaleta] = hoja.obtenerSprite(indiceSpriteHoja);
		}
		
		return paleta;
	}
	
	private boolean[] extraerColisiones(final String cadenasColisiones) {
		boolean [] colisiones = new boolean[cadenasColisiones.length()];
		
		for (int i = 0; i < cadenasColisiones.length(); i++) { //va a leer uno por uno todos los caracteres que existen del mapa colisiones
			if (cadenasColisiones.charAt(i) == '0') { //si el caraacter es 0 no hay pared, sino devuelve true
				colisiones[i] = false;
			} else {
				colisiones[i] = true;
			}
		}
		
		return colisiones;
	}
	
	private int[] extraerSprites(final String[] cadenaSprites) { //extraer los sprites para empezar a dibujar el mapa
		ArrayList<Integer> sprites = new ArrayList<Integer>();
		
		for (int i = 0; i < cadenaSprites.length; i++) {
			if (cadenaSprites[i].length() == 2) { //si el largo de un String es dos, se agrega a la cadena
				sprites.add(Integer.parseInt(cadenaSprites[i]));
			} else { //pero en caso de que sean 4 numeroos juntos (extremos) entonces...
				String uno = "";
				String dos = "";
				
				String error = cadenaSprites[i]; //los String con 4 caracteres se almacenan aca para luego ser dividos en 2 y poder generar el mapa
				
				uno += error.charAt(0); //se divide en un String que contenga dos caracteres (posicion 0  y 1)
				uno += error.charAt(1);
				
				dos += error.charAt(2);//se divide en otro String para los dos caracteres restantes (posicion 3 y 4)
				dos += error.charAt(3);
				
				sprites.add(Integer.parseInt(uno));
				sprites.add(Integer.parseInt(dos));
			}
		}
		
		int [] vectorSprites = new int [sprites.size()]; //llenamos el array de los String(pasados a int) y lo devolvemos
		
		for (int i = 0; i < sprites.size(); i++) {
			vectorSprites [i] = sprites.get(i);
		}
		
		return vectorSprites;
	}
	
	public void actualizar (final int posicionX, final int posicionY) {
		actualizarAreasColision(posicionX, posicionY);
	}
	
	private void actualizarAreasColision(final int posicionX, final int posicionY) {
		if (!areasColision.isEmpty()) {
			areasColision.clear();
		}
		/*Circula por el array de booleanos y si hay un valor true, creara un rectangulo en ese punto del mapa*/
		for (int y = 0; y < this.alto; y++) {
			for (int x = 0; x < this.ancho; x++) {
				int puntoX = x * Constantes.LADO_SPRITE - posicionX + MARGEN_X;
				int puntoY = y * Constantes.LADO_SPRITE - posicionY + MARGEN_Y;
				
				if (colisiones[x+ y * this.ancho]) {
					final Rectangle r = new Rectangle(puntoX, puntoY, Constantes.LADO_SPRITE, Constantes.LADO_SPRITE);
					areasColision.add(r);
				}
			}
		}
	}
	
	public void dibujar (Graphics g, final int posicionX, final int posicionY) {
		
		for (int y = 0; y < this.alto; y++) { //x e y son el ancho y el alto
			for (int x = 0; x < this.ancho; x++) {
				BufferedImage imagen =paleta[sprites[x + y * this.ancho]].obtenerImagen(); //obtenemos la iamgen de cada coordenada
				
				int puntoX = x * Constantes.LADO_SPRITE - posicionX + MARGEN_X;
				int puntoY = y * Constantes.LADO_SPRITE - posicionY + MARGEN_Y;
				
				g.drawImage(imagen, puntoX, puntoY, null); //permite el movimiento del mapa para el personaje
				
				g.setColor(Color.green);
				//bucle para mostrar en los bloques los cuadros de colisiones --> uso para debug en colisiones
//				for (int r = 0; r <areasColision.size(); r++) {
//					Rectangle area = areasColision.get(r);
//					g.drawRect(area.x, area.y, area.width, area.height);
//				}
			}
		}
	}
	
	public Rectangle obtenerBordes(final int posicionX, final int posicionY, final int anchoJugador, final int altoJugador) {
		
		int x = MARGEN_X - posicionX + anchoJugador;
		int y = MARGEN_Y - posicionY + altoJugador;
		int ancho = this.ancho * Constantes.LADO_SPRITE - anchoJugador * 2;
		int alto = this.alto * Constantes.LADO_SPRITE - altoJugador * 2;
		
		return new Rectangle(x, y, ancho, alto);
	}
}
