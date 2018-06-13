package principal.EleccionYCombate;

public class Combate extends Clase{ // Inicio Clase
        
    
    int turno = 1; // Esta variable controlara todo el combate, si es 1 atacara el usuario si es 0 atacara el monstruo
    
    public void Combate (Caballero player) { // Metodo del Combate
        
        
        boolean pelea = true; // Esta variable controla el combate, si esta en TRUE significa que hay un combate
        
        // Antes de empezar el combate comparamos las velocidades del Heroe y del Monstruo, el que tenga la mas alta empieza atacando
        if (MSpd > Spd) { // Si la del Monstruo es mas rapida
            System.out.println("El Monstruo es mas rapido, atacara primero"); // Informamos que pasa al Usuario
            turno = 0; // Empieza el Monstruo el combate
        } // Fin if
        else { // Sino
            System.out.println("El Heroe es mas rapido, atacara primero"); // Informamos que pasa al Usuario
            turno = 1; // Empieza el Heroe el combate
        } // Fin Else
        
        
        // Ahora si, la pelea...
        while (pelea = true) { // Para empezar esto debe ser True, sino no habra ningun combate
            
            //while ((Vit > 0 )||(MVit > 0)) {

                if (turno == 1){ // Si el turno esta en 1, le toca realizar la accion al Heroe 

                    System.out.println("Es el turno del Heroe");
                    System.out.println("La vida del Heroe es: " + player.Vit);
                    
                    // Le damos al usuario a elegir que desea hacer, si atacar o huir
                    String menu = "¿Que deseas hacer? \n 1- Atacar \n 2- Huir";
                    System.out.println(menu);
                    String eleccion = sc.nextLine(); // Pedimos por teclado
                    int confir = Integer.parseInt(eleccion); // Convertimos y guardamos
                    
                    if (confir == 1){ // Si el usuario desea atacar...
                        System.out.println("El Heroe ataca a " + Monstruos [enemigo]);
                        MVit = MVit - (player.Atq - MDef); // Para calcular el daño realizado, simplemente a la Vida del Monstruo le restamos el Ataque del Heroe menos la Defensa del Mob
                        System.out.println("El Heroe le quita: " + (player.Atq - MDef) + " pts de vida"); // Mostramos el daño causado
                        turno = 0; // Cambiamos el turno
                    }
                    else { // Si no desea atacar...
                        System.out.println("El heroe intenta huir");
                        System.out.println("Y encuentra la oportunidad de correr!");
                        System.out.println("¡El heroe logro huir!");
                        pelea = false; // Finalizamos la pelea
                        break; // Con esta sentencia evitamos que nos salga el dialogo de K.O
                    } // Fin If / Else
                    
                } // Termino el turno del Heroe
                
                else { // Turno Mob

                    System.out.println("Es el turno de " + Monstruos [enemigo]);
                    System.out.println("La vida de " + Monstruos [enemigo] +" es: " + MVit);
                    System.out.println(Monstruos [enemigo] + " ataca al Heroe");
                    player.Vit = player.Vit - (MAtq - player.Def);
                    System.out.println("El Mounstro te quita: " + (player.Atq - MDef) + " pts de vida");
                    turno = 1; // Cambiamos el turno

                } // Fin turno Mob
            
            if (player.Vit <= 0) { // Si la vida del HEROE es menor o igual a 0 entonces...
                
                System.out.println("El Heroe quedo K.O");
                System.out.println("El ganador es el Monstruo");
                System.out.println("Game Over");
                pelea = false; // Terminamos el combate
                break; // Finalizamos el bucle Wh
                
            } // Terminamos el If
            
            else { // Si la vida del Monstruo es menor o igual a 0 entonces...
                
                System.out.println("El Monstruo quedo K.O");
                System.out.println("El ganador es el Heroe");
                System.out.println("El heroe ha ganado 150 pts de exp");
                player.exp(50);
                pelea = false; // Terminamos el combate
                break; // Finalizamos el Bucle
                
            } // Fin del else
        } // Fin While
    } // Fin del Combate

        public void Combate (Mago player) { // Metodo del Combate
        
        
        boolean pelea = true; // Esta variable controla el combate, si esta en TRUE significa que hay un combate
        
        // Antes de empezar el combate comparamos las velocidades del Heroe y del Monstruo, el que tenga la mas alta empieza atacando
        if (MSpd > Spd) { // Si la del Monstruo es mas rapida
            System.out.println("El Monstruo es mas rapido, atacara primero"); // Informamos que pasa al Usuario
            turno = 0; // Empieza el Monstruo el combate
        } // Fin if
        else { // Sino
            System.out.println("El Heroe es mas rapido, atacara primero"); // Informamos que pasa al Usuario
            turno = 1; // Empieza el Heroe el combate
        } // Fin Else
        
        
        // Ahora si, la pelea...
        while (pelea = true) { // Para empezar esto debe ser True, sino no habra ningun combate
            
            //while ((Vit > 0 )||(MVit > 0)) {

                if (turno == 1){ // Si el turno esta en 1, le toca realizar la accion al Heroe 

                    System.out.println("Es el turno del Heroe");
                    System.out.println("La vida del Heroe es: " + player.Vit);
                    
                    // Le damos al usuario a elegir que desea hacer, si atacar o huir
                    String menu = "¿Que deseas hacer? \n 1- Atacar \n 2- Huir";
                    System.out.println(menu);
                    String eleccion = sc.nextLine(); // Pedimos por teclado
                    int confir = Integer.parseInt(eleccion); // Convertimos y guardamos
                    
                    if (confir == 1){ // Si el usuario desea atacar...
                        System.out.println("El Heroe ataca a " + Monstruos [enemigo]);
                        MVit = MVit - (player.Atq - MDef); // Para calcular el daño realizado, simplemente a la Vida del Monstruo le restamos el Ataque del Heroe menos la Defensa del Mob
                        System.out.println("El Heroe le quita: " + (player.Atq - MDef) + " pts de vida"); // Mostramos el daño causado
                        turno = 0; // Cambiamos el turno
                    }
                    else { // Si no desea atacar...
                        System.out.println("El heroe intenta huir");
                        System.out.println("Y encuentra la oportunidad de correr!");
                        System.out.println("¡El heroe logro huir!");
                        pelea = false; // Finalizamos la pelea
                        break; // Con esta sentencia evitamos que nos salga el dialogo de K.O
                    } // Fin If / Else
                    
                } // Termino el turno del Heroe
                
                else { // Turno Mob

                    System.out.println("Es el turno de " + Monstruos [enemigo]);
                    System.out.println("La vida de " + Monstruos [enemigo] +" es: " + MVit);
                    System.out.println(Monstruos [enemigo] + " ataca al Heroe");
                    player.Vit = player.Vit - (MAtq - player.Def);
                    System.out.println("El Mounstro te quita: " + (player.Atq - MDef) + " pts de vida");
                    turno = 1; // Cambiamos el turno

                } // Fin turno Mob
            
            if (player.Vit <= 0) { // Si la vida del HEROE es menor o igual a 0 entonces...
                
                System.out.println("El Heroe quedo K.O");
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
        
        
    // Creacion Monstruos
    
    String Monstruos [] = {"Libelula" , "Cangrejo" , "Zombie"};
    int enemigo = 0; // Esta variable decide que Mob va a aparecer en cada combate al igual que sus stats
    int jefe = 1; // Esta variable controla cuando aparece el Jefe y su dificultad
    // Atributos del monstruo
    
    int MVit, MAtq, MDef , MSpd;
        
    // Fin atributos del monstruo
    
    
    public void Enemigo (int enemigo) { // Creacion de Monstruos
        
        // Primero hay que ver contra que Monstruo hay que pelear
        enemigo =  (int) (Math.random() * 2) + 1; // Tenemos 3 mobs distintos, asique lo decidimos al azar
        System.out.println(Monstruos [enemigo] + " ha aparecido"); // Mostramos que mob aparecio
        // Ya terminamos de elegir el Monstuo
        
        if (enemigo == 1) { // Atributos para Monstruo 1
            MVit = 150; MAtq = 35; MDef = 20; MSpd = 50;
        }
        if (enemigo == 2) {// Atributos para Monstruo 2
            MVit = 250; MAtq = 45; MDef = 40; MSpd = 30;
        }        
        if (enemigo == 3) {// Atributos para Monstruo 3
            MVit = 100; MAtq = 25; MDef = 30; MSpd = 40;
        }      
        
    } // Fin Creacion Enemigo
    
    // En desarrollo...
    public void Jefe (int jefe){
        
        if (jefe == 1) { // Atributos para el Big Boss / Dificultad Facil
            MVit = 500; MAtq = 85; MDef = 35; MSpd = 60;
        }
        if (jefe == 2) { // Atributos para el Big Boss / Dificultad Normal
            MVit = 1500; MAtq = 105; MDef = 55; MSpd = 30;
        }
        if (jefe == 3) { // Atributo para el Big Boss / Dificultad Dificil
            MVit = 2500; MAtq = 150; MDef = 100; MSpd = 10;
        }
    } // Fin Creacion Jefe
        
} // Fin Clase
