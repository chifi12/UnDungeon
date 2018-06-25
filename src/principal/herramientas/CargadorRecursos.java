package principal.herramientas;

import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

//esta clase va a cargar imagenes, sonidos, fuentes, etc..
public class CargadorRecursos {
	//leera una imagen desde el ordenador creara una BufferedImage compatible con nuestra pantalla y nos la devolvera
	public static BufferedImage cargarImagenCompatibleOpaca(final String ruta) {
		Image imagen = null;
		
		try {
			imagen = ImageIO.read(ClassLoader.class.getResource(ruta));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
		//obtendremos la configuracion grafica del monitor que estamos usando
		
		BufferedImage imagenAcelerada = gc.createCompatibleImage(imagen.getWidth(null), imagen.getHeight(null), Transparency.OPAQUE);//Transparency.OPAQUE Java asume que esta imagen no va a tener una transparencia
		//creamos una BufferedImage del mismo tamaño de la imagen que hemos cargado
		
		Graphics g = imagenAcelerada.getGraphics(); //los graficos g sirven,en general, para dibujar en pantalla
		//vamos a usarla para dibujar en la buffered image
		g.drawImage(imagen,  0, 0, null); //dibujamos la imagen que hemos cargado, en la posicion 0, 0 (esquina)
		g.dispose();
		
		return imagenAcelerada;
}

public static BufferedImage cargarImagenCompatibleTranslucida(final String ruta) {
	Image imagen = null;
	
	try {
		imagen = ImageIO.read(ClassLoader.class.getResource(ruta));
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
	//obtendremos la configuracion grafica del monitor que estamos usando
	
	BufferedImage imagenAcelerada = gc.createCompatibleImage(imagen.getWidth(null), imagen.getHeight(null), Transparency.TRANSLUCENT);
	//creamos una BufferedImage del mismo tamaño de la imagen que hemos cargado
	
	Graphics g = imagenAcelerada.getGraphics(); //los graficos g sirven,en general, para dibujar en pantalla
	//vamos a usarla para dibujar en la buffered image
	g.drawImage(imagen,  0, 0, null); //dibujamos la imagen que hemos cargado, en la posicion 0, 0 (esquina)
	g.dispose();
	
	return imagenAcelerada;
	}

public static String leerArchivoTexto(final String ruta) {
	//este metodo va a leer un archivo y devolvera un String
	String contenido = ""; //alamacena todo el contenido del texto
	
	InputStream entradaBytes = ClassLoader.class.getResourceAsStream(ruta); //recuperar la informacion en forma binaria (flujo de bytes)
	BufferedReader lector = new BufferedReader(new InputStreamReader(entradaBytes));
	
	String linea;//leer cada linea del texto
	
	try {
		while ((linea = lector.readLine()) != null) {//devuelve true si esa linea existe o false en caso contrario
			contenido += linea;
		}
	} catch (IOException e) {
		e.printStackTrace();
	} finally { //finally se va a ejecutar siempre, si hay o no excepcion
		try {
			if (entradaBytes != null) {//para este null podria llegar a ser si el reclector no la a borrado
				entradaBytes.close();
			}
			if (lector != null) { //los mismo que el if anterior, pero para el archivo lector
				lector.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	return contenido;
}
}
