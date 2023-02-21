package quarto.com;

import java.util.Arrays;

public class Verification {

	// Variables de plateau pour la vérification des cases

    public static String[][] plateau;
	public static int cases = 0;
    public static int ligne;
	public static int colonne;
    
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
    public static String binaireChange(String pieceString){
        String binPiece = ""; // Pièce en binaire

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
        return binPiece;
    }

    /** 
     * Génération du plateau vide 
    */
	public static void generationPlateau() {
		for (int i = 0; i < ligne; i++) {
			for (int j = 0; j < colonne; j++) {
				plateau[i][j] = " ";
			}
		}
	}

    /** Permet de verifier si il y a un quarto ou non
	 *  elle reçoit en paramêtre 16 chiffres 0 ou 1 et verifie si il y a une
	 * correspondance entre les premiers, deuxiemes, troisieme et quatrieme chiffre de chaque piece
	 * @return true si il y a une correspondance false si il n'y en a pas
	 */
	public static boolean binaryCheck (String case1, String case2, String case3, String case4) {

		String binaire = (case1 + case2 + case3 + case4);                     // 0000  0001  0010  0011
		binaire = binaire.replaceAll("\\s", "");           // 0000000100100011

		if (binaire.charAt(0) == binaire.charAt(4) && binaire.charAt(8)== binaire.charAt(12)) {
			return true;
		}
		if (binaire.charAt(1)== binaire.charAt(5) && binaire.charAt(9)== binaire.charAt(13)) {
			return true;
		}
		if (binaire.charAt(2)== binaire.charAt(6) && binaire.charAt(10)== binaire.charAt(14)) {
			return true;
		}
		if (binaire.charAt(3)== binaire.charAt(7) && binaire.charAt(11)== binaire.charAt(15)) {
			return true;
		} else {
			return false;
		}
	}

    /** Verifie la ligne de la derniere piece joué.
	 * 	Check d'abord si il y a des cases vide sur la ligne 
	 * 	si ce n'est pas le cas verifie le quarto
	 * @param x
	 * @param y
	 * @return true or false
	 */
	public static boolean quartoLigne(int x, int y) {
	
		int bis = y + 1;

		while (bis >= 0 && bis <= 3) {

			if (plateau[x][bis].equals("      ")) return false;
			else bis++;
		}

		bis = y - 1;

		while (bis <= 3 && bis >= 0) {

			if (plateau[x][bis].equals("      ")) return false;
			else bis--;
		}

		if (binaryCheck(plateau[x][0], plateau[x][1], plateau[x][2], plateau[x][3])== true){

			return true;
		}
		return false;
	}

    /** Verifie la colonne de la derniere piece joué.
	 * 	Check d'abord si il y a des cases vide sur la colonne 
	 * 	si ce n'est pas le cas verifie le quarto
	 * @param x
	 * @param y
	 * @return true or false
	 */
	public static boolean quartoColonne(int x, int y) {

		int bis = x + 1;

		while (bis >= 0 && bis <= 3) {

			if (plateau[bis][y].equals("      ")) return false;
			else bis++;
		}

		bis = x - 1;

		while (bis <= 3 && bis >= 0) {

			if (plateau[bis][y].equals("      ")) return false;
			else bis--;
		}

		if (binaryCheck(plateau[0][y], plateau[1][y], plateau[2][y], plateau[3][y]) == true ){
			return true;
		}
		return false;
	}

	/** Verifie les quarto sur les deux diagonales possibles
	 *  Cette fonction contient deux tableau avec toutes les cases presente en diagonale
	 *  elle verifie d'abord si la case est presente sur une des deux diagonales
	 * 	puis la suite elle verife si il y a des cases vides sur cette diagonale
	 *  et enfin elle verifie le quarto
	 * @param x
	 * @param y
	 * @return true or false
	 */
	public static boolean quartoDiagonale(String coordo) {

		String[] tab_diago1 = {"00","11","22","33"};
		String[] tab_diago2 = {"03","12","21","30"};

		if ( Arrays.asList(tab_diago1).contains(coordo)) {

			if (plateau[0][0].equals("      ") || plateau[1][1].equals("      ") ||
			     plateau[2][2].equals("      ") || plateau[3][3].equals("      ")) {

					return false;

			} else {

				if (binaryCheck(plateau[0][0], plateau[1][1], plateau[2][2], plateau[3][3]) == true) {

					return true;
				}
			}
		}
		if ( Arrays.asList(tab_diago2).contains(coordo)) {

			if (plateau[0][3].equals("      ") || plateau[1][2].equals("      ") ||
			     plateau[2][1].equals("      ") || plateau[3][0].equals("      ")) {

					return false;

			} else {

				if (binaryCheck(plateau[0][3], plateau[1][2], plateau[2][1], plateau[3][0]) == true) {

					return true;
				}
			}
		}
		return false;
	}

	/** Verifie l'egalite
	 *  Si toute les cases sont prises et qu'il n 'y pas de quarto retourne 'true'
	 * @return true or false
	 */
	public static boolean egalite() {
		if (cases == 16) return true;
		return false;
	}

	/**
	 * Transforme les positions récuperer par les boutons et les tranformes en position utilisable
	 * @param posX
	 * @param posY
	 * @return
	 */
	public static String tranfoPositions(double posX, double posY){

		String positionX = "";
		String positionY = "";

		String positions = "";

		// On verifie et attribue des valeurs pour la position en X
		if (posX == 336.8) {
			positionX += "0";
		}
		else if (posX == 457.6) {
			positionX += "1";
		}
		else if (posX == 579.2) {
			positionX += "2";
		}
		else if (posX == 700.0) {
			positionX += "3";
		}

		// On verifie et attribue des valeurs pour la position en X
		if (posY == 118.4) {
			positionY += "0";
		}
		else if (posY == 240.0) {
			positionY += "1";
		}
		else if (posY == 360.8) {
			positionY += "2";
		}
		else if (posY == 481.6) {
			positionY += "3";
		}

		positions = positionX + positionY;

		return positions;
	}

}

