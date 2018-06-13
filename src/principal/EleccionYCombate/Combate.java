package principal.EleccionYCombate;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Combate { // Inicio Clase

    Scanner sc = new Scanner(System.in); // Se crea el Lector de Datos
    int turno; // Esta variable controlara todo el combate, si es 1 atacara el usuario si es 0 atacara el monstruo
    public Enemigos enemigo;
    public Enemigos enemigo2;

    public void Combate(Mago player) {
        try {
            // Metodo del Combate

            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Combate.class.getName()).log(Level.SEVERE, null, ex);
        }

        enemigo = new Enemigos();
        int miniom = 0;
        enemigo.Enemigo(miniom);
        boolean pelea = true; // Esta variable controla el combate, si esta en TRUE significa que hay un combate

        // Antes de empezar el combate comparamos las velocidades del Heroe y del Monstruo, el que tenga la mas alta empieza atacando
        if (player.Spd < enemigo.MSpd) { // Si la del Monstruo es mas rapida
            System.out.println("El Monstruo es mas rapido, atacara primero"); // Informamos que pasa al Usuario
            turno = 0; // Empieza el Monstruo el combate
        } // Fin if
        else if (enemigo.MSpd < player.Spd) { // Sino
            System.out.println("El Heroe es mas rapido, atacara primero"); // Informamos que pasa al Usuario
            turno = 1; // Empieza el Heroe el combate
        } // Fin Else

        // Ahora si, la pelea...
        while (pelea = true) { // Para empezar esto pelea debe ser True, sino no habra ningun combate

            //while ((Vit > 0 )||(MVit > 0)) {
            if (turno == 1) { // Si el turno esta en 1, le toca realizar la accion al Heroe 

                System.out.println("Es el turno del Heroe");
                System.out.println("La vida del Heroe es: " + player.Vit);

                // Le damos al usuario a elegir que desea hacer, si atacar o huir
                String menu = "¿Que deseas hacer? \n 1- Atacar \n 2- Huir";
                System.out.println(menu);
                String eleccion = sc.nextLine(); // Pedimos por teclado
                int confir = Integer.parseInt(eleccion); // Convertimos y guardamos

                if (confir == 1) { // Si el usuario desea atacar...
                    System.out.println("El Heroe ataca a " + enemigo.Monstruos[miniom]);
                    enemigo.MVit = enemigo.MVit - (player.Atq - enemigo.MDef); // Para calcular el daño realizado, simplemente a la Vida del Monstruo le restamos el Ataque del Heroe menos la Defensa del Mob
                    System.out.println("El Heroe le quita: " + (player.Atq - enemigo.MDef) + " pts de vida"); // Mostramos el daño causado
                    turno = 0; // Cambiamos el turno
                } else { // Si no desea atacar...
                    System.out.println("El heroe intenta huir");
                    System.out.println("Y encuentra la oportunidad de correr!");
                    System.out.println("¡El heroe logro huir!");
                    pelea = false; // Finalizamos la pelea
                    break; // Con esta sentencia evitamos que nos salga el dialogo de K.O
                } // Fin If / Else

            } // Termino el turno del Heroe
            else if (turno == 0) { // Turno Mob

                System.out.println("Es el turno de " + enemigo.Monstruos[miniom]);
                System.out.println("La vida de " + enemigo.Monstruos[miniom] + " es: " + enemigo.MVit);
                System.out.println(enemigo.Monstruos[miniom] + " ataca al Heroe");
                player.Vit = player.Vit - (enemigo.MAtq - player.Def);
                System.out.println("El Monstruo te quita: " + (player.Atq - enemigo.MDef) + " pts de vida");
                turno = 1; // Cambiamos el turno

            } // Fin turno Mob

            if (player.Vit <= 0) { // Si la vida del HEROE es menor o igual a 0 entonces...

                System.out.println("El Heroe ha muerto");
                System.out.println("El ganador es el Monstruo");
                System.out.println("Game Over");
                pelea = false; // Terminamos el combate
                break; // Finalizamos el bucle Wh

            } // Terminamos el If
            else { // Si la vida del Monstruo es menor o igual a 0 entonces...

                System.out.println("El Monstruo quedo K.O");
                System.out.println("El ganador es el Heroe");
                System.out.println("El heroe ha ganado 150 pts de exp");
                player.exp(150);
                pelea = false; // Terminamos el combate
                break; // Finalizamos el Bucle

            } // Fin del else
        } // Fin While

    } // Fin del Combate

    public void PeleaJefe(Mago player) {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Combate.class.getName()).log(Level.SEVERE, null, ex);
        }

        enemigo2 = new Enemigos();
        int jefecito = 0;
        enemigo2.Jefe(jefecito);

        turno = 0;
        boolean pelea = true;

        System.out.println("El jefe es mas rapido que el heroe, atacara primero");

        while (pelea = true) {

            if (turno == 1) { // Si el turno esta en 1, le toca realizar la accion al Heroe 

                System.out.println("Es el turno del Heroe");
                System.out.println("La vida del Heroe es: " + player.Vit);

                System.out.println("El Heroe ataca a " + enemigo2.Jefe[jefecito]);
                enemigo2.JVit = enemigo2.JVit - (player.Atq - enemigo2.JDef); // Para calcular el daño realizado, simplemente a la Vida del Monstruo le restamos el Ataque del Heroe menos la Defensa del Mob
                System.out.println("El Heroe le quita: " + (player.Atq - enemigo2.JDef) + " pts de vida"); // Mostramos el daño causado
                turno = 0; // Cambiamos el turno

            } // Termino el turno del Heroe
            else if (turno == 0) { // Turno Mob

                System.out.println("Es el turno de " + enemigo2.Jefe[jefecito]);
                System.out.println("La vida de " + enemigo2.Jefe[jefecito] + " es: " + enemigo2.JVit);
                System.out.println(enemigo2.Jefe[jefecito] + " ataca al Heroe");
                player.Vit = player.Vit - (enemigo2.JAtq - player.Def);
                System.out.println("El Jefe te quita: " + (player.Atq - enemigo2.JDef) + " pts de vida");
                turno = 1; // Cambiamos el turno

            } // Fin turno Mob

            if (player.Vit <= 0) { // Si la vida del HEROE es menor o igual a 0 entonces...

                System.out.println("El Heroe ha muerto");
                System.out.println("El ganador es el Monstruo");
                System.out.println("Game Over");
                pelea = false; // Terminamos el combate
                break; // Finalizamos el bucle Wh

            } // Terminamos el If
            else { // Si la vida del Monstruo es menor o igual a 0 entonces...

                System.out.println("El Jefe ha muerto");
                System.out.println("El ganador es el Heroe");
                System.out.println("El heroe ha ganado 500 pts de exp");
                player.exp(500);
                pelea = false; // Terminamos el combate
                break; // Finalizamos el Bucle

            } // Fin del else
        }
    }

} // Fin Clase
