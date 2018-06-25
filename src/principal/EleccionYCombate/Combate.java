package principal.EleccionYCombate;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Combate { // Inicio Clase

    Scanner sc = new Scanner(System.in); // Se crea el Lector de Datos
    int turno; // Esta variable controlara todo el combate, si es 1 atacara el usuario si es 0 atacara el monstruo
    public Enemigos enemigo;
    public Enemigos enemigo2;
    int confir;

    public void Combate(Mago player) {
        try {
            // Metodo del Combate
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Combate.class.getName()).log(Level.SEVERE, null, ex);
        }

        enemigo = new Enemigos();
        int miniom = (int) (Math.random() * 3);
        enemigo.Enemigo(miniom);
        boolean pelea = true; // Esta variable controla el combate, si esta en TRUE significa que hay un combate

        JOptionPane.showMessageDialog(null, "¡Has entrado en combate!");
        // Antes de empezar el combate comparamos las velocidades del Heroe y del Monstruo, el que tenga la mas alta empieza atacando
        if (player.Spd < enemigo.MSpd) { // Si la del Monstruo es mas rapida
            JOptionPane.showMessageDialog(null, "El Monstruo es mas rapido, atacara primero"); // Informamos que pasa al Usuario
            turno = 0; // Empieza el Monstruo el combate
        } // Fin if
        else if (enemigo.MSpd < player.Spd) { // Sino
            JOptionPane.showMessageDialog(null, "El Heroe es mas rapido, atacara primero"); // Informamos que pasa al Usuario
            turno = 1; // Empieza el Heroe el combate
        } // Fin Else

        // Ahora si, la pelea...
        while (pelea = true) { // Para empezar esto pelea debe ser True, sino no habra ningun combate

            //while ((Vit > 0 )||(MVit > 0)) {
            if (turno == 1) { // Si el turno esta en 1, le toca realizar la accion al Heroe 

                JOptionPane.showMessageDialog(null, "Es el turno del Heroe");
                JOptionPane.showMessageDialog(null, "La vida del Heroe es: " + player.Vit);

                // Le damos al usuario a elegir que desea hacer, si atacar o huir
                int control = 1;
                while (control == 1) {
                    String menu = JOptionPane.showInputDialog("¿Que deseas hacer? \n 1- Atacar \n 2- Huir");
                    switch (menu) {
                        case "1":
                            confir = Integer.parseInt(menu); // Convertimos y guardamos
                            control = 0;
                            break;
                        case "2":
                            confir = Integer.parseInt(menu); // Convertimos y guardamos
                            control = 0;
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Por favor ingrese una opcion correcta");
                    }
                }
                //String eleccion = sc.nextLine(); // Pedimos por teclado

                if (confir == 1) { // Si el usuario desea atacar...
                    JOptionPane.showMessageDialog(null, "El Heroe ataca a " + enemigo.Monstruos[miniom]);
                    enemigo.MVit = enemigo.MVit - (player.Atq - enemigo.MDef); // Para calcular el daño realizado, simplemente a la Vida del Monstruo le restamos el Ataque del Heroe menos la Defensa del Mob
                    JOptionPane.showMessageDialog(null, "El Heroe le quita: " + (player.Atq - enemigo.MDef) + " pts de vida"); // Mostramos el daño causado
                    turno = 0; // Cambiamos el turno
                } else { // Si no desea atacar...
                    JOptionPane.showMessageDialog(null, "El heroe intenta huir");
                    JOptionPane.showMessageDialog(null, "Y encuentra la oportunidad de correr!");
                    JOptionPane.showMessageDialog(null, "¡El heroe logro huir!");
                    pelea = false; // Finalizamos la pelea
                    break; // Con esta sentencia evitamos que nos salga el dialogo de K.O
                } // Fin If / Else

            } // Termino el turno del Heroe
            else if (turno == 0) { // Turno Mob

                JOptionPane.showMessageDialog(null, "Es el turno de " + enemigo.Monstruos[miniom]);
                JOptionPane.showMessageDialog(null, "La vida de " + enemigo.Monstruos[miniom] + " es: " + enemigo.MVit);
                JOptionPane.showMessageDialog(null, enemigo.Monstruos[miniom] + " ataca al Heroe");
                player.Vit = (player.Vit - (enemigo.MAtq - player.Def));
                JOptionPane.showMessageDialog(null, "El Monstruo te quita: " + (enemigo.MAtq - player.Def) + " pts de vida");
                turno = 1; // Cambiamos el turno

            } // Fin turno Mob

            if (player.Vit <= 0) { // Si la vida del HEROE es menor o igual a 0 entonces...

                JOptionPane.showMessageDialog(null, "El Heroe ha muerto");
                JOptionPane.showMessageDialog(null, "El ganador es el Monstruo");
                JOptionPane.showMessageDialog(null, "Game Over");
                pelea = false; // Terminamos el combate
                break; // Finalizamos el bucle Wh

            } // Terminamos el If
            else if (enemigo.MVit <= 0) { // Si la vida del Monstruo es menor o igual a 0 entonces...

                JOptionPane.showMessageDialog(null, "El Monstruo quedo K.O");
                JOptionPane.showMessageDialog(null, "El ganador es el Heroe");
                JOptionPane.showMessageDialog(null, "El heroe ha ganado 250 pts de exp");
                player.exp(250);
                pelea = false; // Terminamos el combate
                break; // Finalizamos el Bucle

            } // Fin del else
        } // Fin While

    } // Fin del Combate

    public void PeleaJefe(Mago player) {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Combate.class.getName()).log(Level.SEVERE, null, ex);
        }

        enemigo2 = new Enemigos();
        int jefecito = (int) (Math.random() * 3);
        enemigo2.Jefe(jefecito);

        turno = 0;
        boolean pelea = true;

        JOptionPane.showMessageDialog(null, "Has entrado en pelea contra un Jefe, ten cuidado...");
        JOptionPane.showMessageDialog(null, "El jefe es mas rapido que el heroe, atacara primero");

        while (pelea = true) {

            if (turno == 1) { // Si el turno esta en 1, le toca realizar la accion al Heroe 

                JOptionPane.showMessageDialog(null, "Es el turno del Heroe");
                JOptionPane.showMessageDialog(null, "La vida del Heroe es: " + player.Vit);

                JOptionPane.showMessageDialog(null, "El Heroe ataca a " + enemigo2.Jefe[jefecito]);
                enemigo2.JVit = enemigo2.JVit - (player.Atq - enemigo2.JDef); // Para calcular el daño realizado, simplemente a la Vida del Monstruo le restamos el Ataque del Heroe menos la Defensa del Mob
                JOptionPane.showMessageDialog(null, "El Heroe le quita: " + (player.Atq - enemigo2.JDef) + " pts de vida"); // Mostramos el daño causado
                turno = 0; // Cambiamos el turno

            } // Termino el turno del Heroe
            else if (turno == 0) { // Turno Mob

                JOptionPane.showMessageDialog(null, "Es el turno de " + enemigo2.Jefe[jefecito]);
                JOptionPane.showMessageDialog(null, "La vida de " + enemigo2.Jefe[jefecito] + " es: " + enemigo2.JVit);
                JOptionPane.showMessageDialog(null, enemigo2.Jefe[jefecito] + " ataca al Heroe");
                player.Vit = player.Vit - (enemigo2.JAtq - player.Def);
                JOptionPane.showMessageDialog(null, "El Jefe te quita: " + (enemigo2.JAtq - player.Def) + " pts de vida");
                turno = 1; // Cambiamos el turno

            } // Fin turno Mob

            if (player.Vit <= 0) { // Si la vida del HEROE es menor o igual a 0 entonces...

                JOptionPane.showMessageDialog(null, "El Heroe ha muerto");
                JOptionPane.showMessageDialog(null, "El ganador es el Monstruo");
                JOptionPane.showMessageDialog(null, "Game Over");
                pelea = false; // Terminamos el combate
                System.exit(0);
                break; // Finalizamos el bucle Wh

            } // Terminamos el If
            else if (enemigo2.JVit <= 0) { // Si la vida del Monstruo es menor o igual a 0 entonces...

                JOptionPane.showMessageDialog(null, "El Jefe ha muerto");
                JOptionPane.showMessageDialog(null, "El ganador es el Heroe");
                JOptionPane.showMessageDialog(null, "El heroe ha ganado 500 pts de exp");
                player.exp(500);
                pelea = false; // Terminamos el combate
                break; // Finalizamos el Bucle

            } // Fin del else
        }
    }
} // Fin Clase
