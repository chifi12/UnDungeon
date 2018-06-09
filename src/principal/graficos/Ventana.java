package principal.graficos;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import principal.herramientas.CargadorRecursos;

public class Ventana extends JFrame{

	private static final long serialVersionUID = 5979421777239930009L; //nro de identificacion de Java al guardar un archivo
	
	private String titulo;
	
	private final ImageIcon icono;
	
	public Ventana (final String titulo, final SuperficieDibujo sd) {
		this.titulo = titulo;
		
		BufferedImage imagen = CargadorRecursos.cargarImagenCompatibleTranslucida("/imagenes/icono/icono.png");
		this.icono = new ImageIcon(imagen); //icono de laventana
		
		configurarVetnana(sd);
	}

	private void configurarVetnana(final SuperficieDibujo sd) {
		setTitle(titulo);
		setIconImage(icono.getImage()); //establecer icono imagen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(new BorderLayout());
		add(sd, BorderLayout.CENTER);
		//setUndecorated(true); //deja sin borde la ventana
		pack(); //tamaño y formato apropiado a la ventana
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
