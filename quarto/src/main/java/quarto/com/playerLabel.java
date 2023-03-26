package quarto.com;


public class playerLabel {

    public static String labelPlayer(int tourJoueur) {

        String tour = "";
    
        if (tourJoueur == 0){
            tour = "Joueur 1: Choissiez une pièce";
        } 
        else if (tourJoueur == 1) {
            tour = "Joueur 2: Placer la pièce";
        }
        else if (tourJoueur == 2){
            tour = "Joueur 2: Choissiez une pièce";
        }
        else if (tourJoueur == 3){
            tour = "Joueur 1: Placer la pièce";
        }

        return tour;
    }
}
