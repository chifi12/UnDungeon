package principal.EleccionYCombate;

public class Mago { // Inicio Clase
    
        int Vit = 500;  int Atq = 80 ; int Def = 60 ; int Spd = 60 ; int Mana = 150;
        static int nivel = 1, exp = 0;
        
        
        public Mago (int nivel){
            this.nivel = nivel;
        }
        
        // Variables para el sistema de nivel y experiencia
        int xpnecesaria = 100;
        
        public int exp (int expganada){
            exp = exp + expganada;
            while (exp > xpnecesaria) {
                if (exp >= xpnecesaria) {
                    nivel ++;
                    Vit = Vit + 85;
                    Atq = Atq + 30;
                    Def = Def + 10;
                    Spd = Spd + 15;
                    Mana = Mana + 20;
                    xpnecesaria = xpnecesaria *2;
                    System.out.println("El heroe ha subido al nivel " + nivel);
                    System.out.println("Sus nuevos stats son: \n Vit: " + Vit + "\n Atq: " + Atq + "\n Def: " + Def + "\n Spd: " + Spd);
                }
            }
            return nivel;
        }
        
} // Fin Clase
