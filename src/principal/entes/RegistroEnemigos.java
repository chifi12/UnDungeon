package principal.entes;

public class RegistroEnemigos {
//al tener un registro unico las instancias del objeto seran iguales
	public static Enemigo obtenerEnemigo(final int idEnemigo) {
		Enemigo enemigo = null;
		
		switch (idEnemigo) {
		case 1:
			enemigo = new Imp (idEnemigo, "Imp", 10);
			break;
		}
		
		return enemigo;
	}
}
