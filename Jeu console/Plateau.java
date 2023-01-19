import java.util.Arrays;

/** Génération du plateau, placement des pièces et controleur de victoire ou d'égalité */
public class Plateau {
    
    private static String[][] plateau;
	private static int cases = 0;
    private int ligne, colonne;

    /** Constructeur
	 * @param int l (ligne du plateau)
	 * @param int c (colonne du plateau)
	 */
    public Plateau(int l, int c) {
		ligne = l;
		colonne = c;
		plateau = new String[ligne][colonne];
		this.generationPlateau();
	}

    /** Génération du plateau vide */
	public void generationPlateau() {
		for (int i = 0; i < ligne; i++) {
			for (int j = 0; j < colonne; j++) {
				plateau[i][j] = "      ";
			}
		}
	}

    /** Place le coup du joueur en verifiant si la case est disponible
	 * @param int x Coordonnées x (lignes)
	 * @param int y Coordonnées y (colonnes)
	 * @param String
	 * @return true: la case est vide, false: la case est prise
	 */
	public static boolean setPiece(int x, int y, String pieceJoueur) {
		if (checkRange(x,y) == true && plateau[x][y].equals("      ")) {
			plateau[x][y] = " " + pieceJoueur + " ";
			cases ++;
			return true;
		}
		if (checkRange(x,y) == false) {
			System.out.println( "\n"+"Cette case n'est pas comprise dans les 16 cases du plateau"+"\n");
			return false;
		} else {
			System.out.println("\n"+ "Cette case est deja prise avec la piece" + plateau[x][y] +"\n");
			return false;
		}
	}

	private static boolean checkRange(int x, int y) {
		if (x < 0 || x > 3 || y < 0 || y > 3)
			return false;
		else
			return true;					
	}


	/** Print le plateau de jeu sur le terminal
	 * et met a jour le placement des pieces
	 * @param ligne
	 * @param colonne
	 * @return Le plateau avec ses modification
	 */
	public String plateauTerminal(int ligne, int colonne) {
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


	/** Ma fonction de genie pour verifier si il y a un quarto ou non
	 *  elle recoit en parametre 16 chiffre 0 ou 1 et verifie si il y a une
	 * correspondance entre les premiers, deuxiemes, troisieme et quatrieme chiffre de chaque piece
	 * @return true si il y a une correspondance false si il n'y en a pas
	 */
	public static boolean binaryCheck (String case1, String case2, String case3, String case4) {

		String binaire = (case1 + case2 + case3 + case4);                     // 0000  0001  0010  0011
		binaire = binaire.replaceAll("\\s", "");           // 0000000100100011

		if (binaire.charAt(0)== binaire.charAt(4) && binaire.charAt(8)== binaire.charAt(12)) {
			afficheWin(case1, case2, case3, case4);
			return true;
		}
		if (binaire.charAt(1)== binaire.charAt(5) && binaire.charAt(9)== binaire.charAt(13)) {
			afficheWin(case1, case2, case3, case4);
			return true;
		}
		if (binaire.charAt(2)== binaire.charAt(6) && binaire.charAt(10)== binaire.charAt(14)) {
			afficheWin(case1, case2, case3, case4);
			return true;
		}
		if (binaire.charAt(3)== binaire.charAt(7) && binaire.charAt(11)== binaire.charAt(15)) {
			afficheWin(case1, case2, case3, case4);
			return true;
		} else {
			return false;
		}
	}

	/** Fonction afficheWin qui permet de mettre en valeur les case du quarto gagnant
	 *  en passant en revu toutes les cases du tableau
	 *  (un peu barbare mais me faire economiser beaucoup de ligne de code)
	 * @param case1
	 * @param case2
	 * @param case3
	 * @param case4
	 * @return
	 */
	public static String afficheWin(String case1, String case2, String case3, String case4){

		String res ="";																				// mon return inutile

		for(int i = 0 ; i < plateau.length ; i++) {
			for(int y = 0 ; y < plateau.length ; y++) {

				//System.out.println(i + "   " + y);
				if (case1 == plateau[i][y]) {
					plateau[i][y] = plateau[i][y].replaceAll("\\s", "|");
				}
				if (case2 == plateau[i][y]) {
					plateau[i][y] = plateau[i][y].replaceAll("\\s", "|");
				}
				if (case3 == plateau[i][y]) {
					plateau[i][y] = plateau[i][y].replaceAll("\\s", "|");
				}
				if (case4 == plateau[i][y]) {
					plateau[i][y] = plateau[i][y].replaceAll("\\s", "|");
				}
			}
		}
		return res;
	}



	/** FONCTION OPTIONNEL (activable en mode competition)
	 *  Verifie les quarto en block de 4
	 * 	Lie vers 3 grande sous fonction: verifie si la case est dans un angle sur un bord ou au milieu
	 * 	pour les angles et les bord verifie cas par cas le quarto (4 verif differentes, 1 quarto pour les angles 2 pour les bord)
	 *  sinon pour les case du milieu verifie tout autour les 4 quarto possible
	 * @param coordo (coordonnees en str)
	 * @param x
	 * @param y
	 * @return true or false
	 */
	public static boolean quartoCarre(String coordo, int x, int y) {
		
		String[] angle  = {"00","03","30","33"};
		String[] bord   = {"01","02","10","20","13","23","31","32"};
		String[] milieu = {"11","12","21","22"};

		if ( Arrays.asList(angle).contains(coordo)) {

			if (angleCarre(coordo,x,y) == true) {
				return true;
			} return false;

		}

		if ( Arrays.asList(bord).contains(coordo)) {

			if (bordCarre(coordo,x,y) == true) {
				return true;
			} return false;
		}

		if ( Arrays.asList(milieu).contains(coordo)) {

			if (milieuCarre(coordo,x,y) == true) {
				return true;
			} return false;
		} return false;
	}


	/** Verifier les quarto pour les cases en angle du plateau
	 * 
	 * @param coordo
	 * @param x
	 * @param y
	 * @return
	 */
	public static boolean angleCarre(String coordo, int x, int y) {

		switch(coordo) {
				
			case "00":

				if (!plateau[0][1].equals("      ") && !plateau[1][1].equals("      ") && !plateau[1][0].equals("      ")) {

					if (binaryCheck(plateau[0][0], plateau[0][1], plateau[1][1], plateau[1][0])) {

						return true;
					}
				} return false;
			
			case "03":

				if (!plateau[0][2].equals("      ") && !plateau[1][2].equals("      ") && !plateau[1][3].equals("      ")) {

					if (binaryCheck(plateau[0][3], plateau[0][2], plateau[1][2], plateau[1][3]) == true) {

					return true;
					}
				} return false;
				
			case "30":

				if (!plateau[2][0].equals("      ") && !plateau[2][1].equals("      ") && !plateau[3][1].equals("      ")) {
				
					if (binaryCheck(plateau[3][0], plateau[2][0], plateau[2][1], plateau[3][1]) == true) {

					return true;
					}
				} return false;

			case "33":

				if ((!plateau[3][2].equals("      ") && !plateau[2][2].equals("      ") && !plateau[2][0].equals("      "))) {
				
					if (binaryCheck(plateau[3][3], plateau[3][2], plateau[2][2], plateau[2][0]) == true) {

						return true;
					}
				} return false;
		} return false;
	}

	/** Verifier les quarto pour les cases en bord de plateau
	 * 
	 * @param coordo
	 * @param x
	 * @param y
	 * @return
	 */
	public static boolean bordCarre(String coordo, int x, int y) {

		switch(coordo) {

			case "01":
			case "02":

				if (!plateau[x+1][y].equals("      ") ) {          // verifie si la case commune au deux quarto possible n'est pas vide

					if (!plateau[x][y-1].equals("      ") && !plateau[x+1][y-1].equals("      ")) {

						if (binaryCheck(plateau[x][y], plateau[x+1][y], plateau[x][y-1], plateau[x+1][y-1])) {

							return true;
						}
					}
					if (!plateau[x][y+1].equals("      ") && !plateau[x+1][y+1].equals("      ")) {

						if (binaryCheck(plateau[x][y], plateau[x+1][y], plateau[x][y+1], plateau[x+1][y+1])) {

							return true;
						}
					}
				} return false;

			case "10":
			case "20":
				
				if (!plateau[x][y+1].equals("      ") ) { 

					if (!plateau[x-1][y].equals("      ") && !plateau[x-1][y+1].equals("      ")) {

						if (binaryCheck(plateau[x][y], plateau[x][y+1], plateau[x-1][y], plateau[x-1][y+1])) {

							return true;
						}
					}
					if (!plateau[x+1][y].equals("      ") && !plateau[x+1][y+1].equals("      ")) {

						if (binaryCheck(plateau[x][y], plateau[x][y+1], plateau[x+1][y], plateau[x+1][y+1])) {

							return true;
						}
					}
				} return false;
	 
			case "31":
			case "32":
					
				if (!plateau[x-1][y].equals("      ") ) {

					if (!plateau[x][y-1].equals("      ") && !plateau[x-1][y-1].equals("      ")) {

						if (binaryCheck(plateau[x][y], plateau[x-1][y], plateau[x][y-1], plateau[x-1][y-1])) {

							return true;
						}
					}
					if (!plateau[x][y+1].equals("      ") && !plateau[x-1][y+1].equals("      ")) {

						if (binaryCheck(plateau[x][y], plateau[x-1][y], plateau[x][y+1], plateau[x-1][y+1])) {

							return true;
						}
					}
				} return false;

			case "13":
			case "23":
					
				if (!plateau[x][y-1].equals("      ") ) { 

					if (!plateau[x-1][y].equals("      ") && !plateau[x-1][y-1].equals("      ")) {

						if (binaryCheck(plateau[x][y], plateau[x][y-1], plateau[x-1][y], plateau[x-1][y-1])) {

							return true;
						}
					}
					if (!plateau[x+1][y].equals("      ") && !plateau[x+1][y-1].equals("      ")) {

						if (binaryCheck(plateau[x][y], plateau[x][y-1], plateau[x+1][y], plateau[x+1][y-1])) {

							return true;
						}
					}
				} return false;
		} return false;
	}

	/** Verifier les quarto pour les cases en milieu de plateau
	 * 
	 * @param coordo
	 * @param x
	 * @param y
	 * @return
	 */
	public static boolean milieuCarre(String coordo, int x, int y) {
		
		//String[] milieu = {"11","12","21","22"};
		if (!plateau[x][y-1].equals("      ")) {

			if (!plateau[x-1][y-1].equals("      ") && !plateau[x-1][y].equals("      ")) {

				if (binaryCheck(plateau[x][y], plateau[x][y-1], plateau[x-1][y-1], plateau[x-1][y])) {

					return true;
				}
			}
			if (!plateau[x+1][y].equals("      ") && !plateau[x+1][y-1].equals("      ")) {

				if (binaryCheck(plateau[x][y], plateau[x][y-1], plateau[x+1][y], plateau[x+1][y-1])) {

					return true;
				}
			}
		}

		if (!plateau[x][y+1].equals("      ")) {

			if (!plateau[x-1][y+1].equals("      ") && !plateau[x-1][y].equals("      ")) {

				if (binaryCheck(plateau[x][y], plateau[x][y+1], plateau[x-1][y+1], plateau[x-1][y])) {

					return true;
				}
			}
			if (!plateau[x+1][y].equals("      ") && !plateau[x+1][y+1].equals("      ")) {

				if (binaryCheck(plateau[x][y], plateau[x][y+1], plateau[x+1][y], plateau[x+1][y+1])) {

					return true;
				}
			}
		} return false;
	}
}