package principal.EleccionYCombate;

public class Caballero { // Inicio Clase
    
        int Vit = 650;  int Atq = 90 ; int Def = 70 ; int Spd = 70 ; int Mana = 65;
        static int nivel = 1, exp = 0, expnecesaria = 100;

        public Caballero (int nivel){
            this.nivel = nivel;
        }
        
        // Variables para el sistema de nivel y experiencia
        int xpnecesaria = 100;
        
        public int exp (int expganada){
            exp = exp + expganada;
            while (exp > xpnecesaria) {
                if (exp >= xpnecesaria) {
                    nivel ++;
                    Vit = Vit + 100;
                    Atq = Atq + 25;
                    Def = Def + 20;
                    Spd = Spd + 10;
                    Mana = Mana + 5;
                    xpnecesaria = xpnecesaria *2;
                    System.out.println("El heroe ha subido al nivel " + nivel);
                    System.out.println("Sus nuevos stats son: \n Vit: " + Vit + "\n Atq: " + Atq + "\n Def: " + Def + "\n Spd: " + Spd);
                }
            }
            return nivel;
        }
        
} // Fin Clase
