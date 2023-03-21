package quarto.com;

public class Plateau {
    // Class de création du plateau en 2D dans le termine et pouvoir les placer par la suite dedans

    /**
     * Methode qui permet de renvoyer une fenetre de jeu dans le programme Menu.java. 
     * @param mainWindow Fenetre de jeu
     * @return La fenetre de jeu
     */

    // Création d'un tableau de 4 par 4 qui représente un plateau de quarto
    public static String[][] initPlateau() {
        String[][] plateau = new String[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                plateau[i][j] = "      ";
            }
        }
        return plateau;
    }


    /** 
     * Affiche le plateau de jeu
     * 
     */

    private static int ligne = 4;
    private static int colonne = 4;

    public static String affichePlateau(String[][] plateau) {
        String stringPlateau= "";
		for (int i = 0; i < ligne; i++) {
			for(int j = 0; j < colonne; j++) {
				if(j == colonne-1)
					stringPlateau += plateau[i][j];
				else
					stringPlateau += plateau[i][j] + "|";
			}
			if (i != ligne-1) {
				stringPlateau += "\n";
				for (int j=0;j< colonne;j++) {
					if (j == colonne-1)
						stringPlateau += "______";
					else
						stringPlateau +="_______";
				}
				stringPlateau += "\n";
			}
		}
		return stringPlateau;
    }

    /** Place le coup du joueur en verifiant si la case est disponible
     * @param int x Coordonnées x (lignes)
     * @param int y Coordonnées y (colonnes)
     * @param String pieceJoueur Piece du joueur
     * @return true: la case est vide, false: la case est prise
     */
    public static boolean setPiece(int x, int y, String pieceJoueur, String[][] plateau) {
        if (plateau[x][y].equals("null")) {
            plateau[x][y] = " " + pieceJoueur + " ";
            return true;
        }
        return false;

    }


    
}
