package principal.EleccionYCombate;

import javax.swing.JOptionPane;

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
                JOptionPane.showMessageDialog(null, "Goblin ha aparecido");
                this.MVit = 150;
                this.MAtq = 85;
                this.MDef = 20;
                this.MSpd = 50;
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Kobold ha aparecido");
                this.MVit = 250;
                this.MAtq = 105;
                this.MDef = 40;
                this.MSpd = 30;
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Zombie ha aparecido");
                this.MVit = 100;
                this.MAtq = 95;
                this.MDef = 30;
                this.MSpd = 40;
                break;
        }
    } // Fin Creacion Enemigo

    int JVit, JAtq, JDef, JSpd;

    public void Jefe(int enemigo2) {
        
        boolean bandera = true;
        while (bandera = true) {
            if ((enemigo2 <= 2) || (enemigo2 >= 0)) {
                bandera = false;
                break;
            } else {
                enemigo2 = (int) (Math.random() * 3);
            }
        }
        switch (enemigo2) {
            case 0:
                JOptionPane.showMessageDialog(null, "Giordanninimon ha aparecido");
                this.JVit = 500;
                this.JAtq = 185;
                this.JDef = 35;
                this.JSpd = 60;
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Monettimon ha aparecido");
                this.JVit = 1500;
                this.JAtq = 205;
                this.JDef = 55;
                this.JSpd = 30;
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Carlomon ha aparecido");
                this.JVit = 2500;
                this.JAtq = 350;
                this.JDef = 100;
                this.JSpd = 10;
                break;
        }

    } // Fin Creacion Jefe

} // Fin Programa General
