package principal.EleccionYCombate;

/**
 * @author Chifi
 */
public class Enemigos { // Inicio Programa General

    // Creacion Monstruos
    String Monstruos[] = {"Goblin", "Kobold", "Zombie"};
    String Jefe[] = {"Giordanninimon", "Monettimon", "Carlomon"};
    int enemigo; // Esta variable decide que Mob va a aparecer en cada combate al igual que sus stats
    int jefe; // Esta variable controla cuando aparece el Jefe y su dificultad
    // Atributos del monstruo

    int MVit, MAtq, MDef, MSpd;

    // Fin atributos del monstruo
    public void Enemigo(int enemigo) { // Creacion de Monstruos

        boolean bandera = true;
        while (bandera = true) {
            if ((enemigo <= 2) || (enemigo >= 0)) {
                bandera = false;
                break;
            } else {
                enemigo = (int) (Math.random() * 3);
            }
        }
        switch (enemigo) {
            case 0:
                System.out.println("Goblin ha aparecido");
                MVit = 150;
                MAtq = 35;
                MDef = 20;
                MSpd = 50;
                break;
            case 1:
                System.out.println("Kobold ha aparecido");
                MVit = 250;
                MAtq = 45;
                MDef = 40;
                MSpd = 30;
                break;
            case 2:
                System.out.println("Zombie ha aparecido");
                MVit = 100;
                MAtq = 25;
                MDef = 30;
                MSpd = 40;
                break;
        }

    } // Fin Creacion Enemigo

    int JVit, JAtq, JDef, JSpd;

    public void Jefe(int enemigo2) {
        
        switch (enemigo2) {
            case 0:
                System.out.println("Giordanninimon ha aparecido");
                JVit = 500;
                JAtq = 85;
                JDef = 35;
                JSpd = 60;
                break;
            case 1:
                System.out.println("Monettimon ha aparecido");
                JVit = 1500;
                JAtq = 105;
                JDef = 55;
                JSpd = 30;
                break;
            case 2:
                System.out.println("Carlomon ha aparecido");
                JVit = 2500;
                JAtq = 150;
                JDef = 100;
                JSpd = 10;
                break;
        }

    } // Fin Creacion Jefe

} // Fin Programa General
