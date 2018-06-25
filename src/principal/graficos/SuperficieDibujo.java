package principal.graficos;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import principal.control.GestorControles;
import principal.control.Teclado;
import principal.maquinaestado.GestorEstados;

public class SuperficieDibujo extends Canvas{
		//atributos
	//el id para cuando queramos guardar la partida no nos genere problemas
	private static final long serialVersionUID = -6227038142688953660L; //canvas, clase ligera que se utiliza para interfaces graficas (no ocupa mucha memoria)
	
	private int ancho;
	private int alto;
	

	
		//constructores
	public SuperficieDibujo(final int ancho, final int alto) {
		this.alto = alto;
		this.ancho = ancho;
		

		
		setIgnoreRepaint(true); //hace que java no intente forzar el repintado automatico del canvas, solo nosotros estaremos a cargo de pintar en el canvas
		setPreferredSize (new Dimension(ancho, alto));
		addKeyListener(GestorControles.teclado); //registra que botones se pulsa cuando esta enfocado el canvas
		setFocusable(true);
		requestFocus(); //solo con iniciar el juego el canvas esta enfocado
	}
	
	public void dibujar (final GestorEstados ge) {
		BufferStrategy buffer = getBufferStrategy();
		
		if (buffer == null) {
			createBufferStrategy(3);//nro entre parentesis nos dice cuantas imagenes en memoria se almacenan antes de presentarlas en pantallas
			return;
		}
		
		Graphics g = buffer.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, ancho, alto);
		
		ge.dibujar(g);
		
		Toolkit.getDefaultToolkit().sync();//pinta solo entre actualizaciones de pantallas
		
		g.dispose();
		
		buffer.show();
	}
	
	public int obtenerAncho() {
		return ancho;
	}
	
	public int obtenerAlto() {
		return alto;
	}
	
}
