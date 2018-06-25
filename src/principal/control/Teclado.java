package principal.control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclado implements KeyListener{

	public Tecla arriba = new Tecla();
	public Tecla abajo = new Tecla();
	public Tecla izquierda = new Tecla();
	public Tecla derecha = new Tecla();
	public Tecla arriba1 = new Tecla();
	public Tecla abajo1 = new Tecla();
	public Tecla izquierda1 = new Tecla();
	public Tecla derecha1 = new Tecla();

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			arriba.teclaPulsada();
			break;
		case KeyEvent.VK_UP:
			arriba1.teclaPulsada();
			break;
		case KeyEvent.VK_S:
			abajo.teclaPulsada();
			break;
		case KeyEvent.VK_DOWN:
			abajo1.teclaPulsada();
			break;
		case KeyEvent.VK_A:
			izquierda.teclaPulsada();
			break;
		case KeyEvent.VK_LEFT:
			izquierda1.teclaPulsada();
			break;
		case KeyEvent.VK_D:
			derecha.teclaPulsada();
			break;
		case KeyEvent.VK_RIGHT:
			derecha1.teclaPulsada();
			break;
		}

	}


	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			arriba.teclaLiberada();
			break;
		case KeyEvent.VK_S:
			abajo.teclaLiberada();
			break;
		case KeyEvent.VK_A:
			izquierda.teclaLiberada();
			break;

		case KeyEvent.VK_D:
			derecha.teclaLiberada();
			break;
		}

	}

	public void keyTyped(KeyEvent e) {}
}
