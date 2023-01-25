package quarto.com;


public class Verification {
    /**
     * Méthode qui permet de change une pièce a partir d'un texte (Exple: "Noir_Carre_Long_Plein")
     * vers une pièce en binaire (Exple: "1110") sous ce modéle ci :
     * 
     * Couleur: Blanche ou Noire / 0 ou 1
     * Forme :  Ronde ou Carré   / 0 ou 1
     * Taille:  Courte ou Longue / 0 ou 1
     * Type:    Pleine ou Creuse  / 0 ou 1
     * 
     * @param pieceString Pièce reçu en texte (Exple: "Rond_Court_Creux_Blanc")
     */
    public static void binaireChange(String pieceString){
        String binPiece = " "; // Pièce en binaire

        String zero = "0"; // 0
        String un = "1"; // 1

        String[] arrOfStr = pieceString.split("_");
        for (String caracteristiques: arrOfStr){
            // On regarde si la pièce est blanche ou noire
            if (caracteristiques.equals("Blanc")) {
                binPiece = binPiece + zero;
            }else if(caracteristiques.equals("Noir")) {
                binPiece = binPiece + un;
            } // On regarde si la pièce est ronde ou carrée
            else if (caracteristiques.equals("Rond")) {
                binPiece = binPiece + zero;
            }else if(caracteristiques.equals("Carre")) {
                binPiece = binPiece + un;
            } // On regarde si la pièce est courte ou long 
            else if (caracteristiques.equals("Court")) {
                binPiece = binPiece + zero;
            }else if(caracteristiques.equals("Long")) {
                binPiece = binPiece + un;
            } // On regarde si la pièce est pleine ou creuse
            else if (caracteristiques.equals("Plein")) {
                binPiece = binPiece + zero;
            }else if(caracteristiques.equals("Creux")) {
                binPiece = binPiece + un;
            }
            System.out.println(binPiece);
        }
    }
}

