package principal.EleccionYCombate;

import java.util.Scanner;


public class Clase { // Inicio Clase
        
    String razas [] = {"Caballero" , "Mago"};
    static int conclase = 0; // Variable de confirmacion de clase
    Scanner sc = new Scanner (System.in); // Se crea el Lector de Datos
    
    // Atributos del player
    
    int Vit, Atq, Def , Spd , Mana;
    static int nivel = 1, exp = 0;
    
    // Fin atributos del player
    
    public int EleccionClase () { // Vamos a dar a elegir las clases disponibles y explicar cada una...
        
        // Mostramos en pantalla las clases disponibles y un breve resumen de las mismas
        System.out.println("Por favor elija la clase que desea: ");
        System.out.println(razas [0]);
        System.out.println("Siempre listos para el combate, llevan su espada con honor esperando encontrar adversarios que les brinden un combate epico");
        System.out.println(razas [1]);
        System.out.println("Expertos en el combate a distancia, los magos son temidos por todos por gran manejo de los 4 elementos y el gran abanico de posibilidades que estos les brindan");
        System.out.println(" ");
        // Terminamos de mostrar en pantalla las clases y su breve resumen
        
        // Comenzamos con la eleccion de la clase 
        int banderawh = 0; // Variable que controla el sgte While
        while (banderawh == 0) { // Con este while haremos que el player elija su main class
           
            System.out.println("¿Cual de todas las clases deseas ser?\n 1- Caballero \n 2- Mago "); // Mostramos las clases disponibles para que la elijan
            String eleccion = sc.nextLine(); // Aca se tomara por teclado lo que se elija
            conclase = Integer.parseInt(eleccion); // Lo convertimos a int y lo guardamos en la variable que va a contener esa desicion
            
            switch (conclase) { // En este Switch confirmamos la eleccion del Usuario
                case 1:  // Si elije ser CABALLERO
                    String confirmacion = "¿Seguro que quieres ser " + razas [0] +"? \n 1- Si \n 2- No"; // Confirmacion
                    System.out.println(confirmacion); // Mostramos el mensaje Confirmacion
                    eleccion = sc.nextLine(); // Pedimos por teclado
                    int confir = Integer.parseInt(eleccion); // Convertimos y guardamos
                    if (confir == 1) { // Si la confirmacion es 1
                        System.out.println("Elegiste ser " + razas [0] + "\n Ahora empezara tu aventura, preparate para desafiar al mundo"); // El usuario acepta ser CABALLERO
                        
                        banderawh = 1;  // Cambiamos la bandera del While asi terminamos el bucle
                    }
                    break; // Finalizamos
                case 2:  // Si elije ser MAGO
                    String confirmacion2 = "¿Seguro que quieres ser " + razas [1] +"? \n 1- Si \n 2- No"; // Confirmacion
                    System.out.println(confirmacion2); // Mostramos el mensaje Confirmacion
                    eleccion = sc.nextLine(); // Pedimos por Teclado
                    int confir2 = Integer.parseInt(eleccion); // Convertimos y guardamos
                    if (confir2 == 1) { // Si la confirmacion es 1 
                        System.out.println("Elegiste ser " + razas [1] + "\n Ahora empezara tu aventura, preparate para desafiar al mundo"); // El usuario acepta ser MAGO
                        banderawh = 1; // Cambiamos la bandera del While asi terminamos el bucle
                    } 
                    break; // Finalizamos
                default: // Por si el usuario ingresa otro valor que no sea 1 o 2
                    System.out.println("Por favor elija una opcion de las anteriormente dadas");;
            } // Fin Switch
        } // Fin While
        // Terminamos de elegir la clase con el Usuario
        
        return conclase;
    } // Fin Eleccion Clase
        
} // Fin Clase
