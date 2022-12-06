import java.util.Arrays;
import java.util.Scanner;

/** La classe Piece s'occupe de gestion des pieces du jeu tel qu'afficher les pieces restantes d'une partie remettre les pieces en jeu
 * ou encore verifier si l'usage d'une piece est possible ou non
 */
public class Piece {

    //
    // 4 particularité et 2 possibilité par particularité
    // 
    // couleur: blanche ou noire / 0 ou 1
    // forme :  ronde ou carré   / 0 ou 1
    // taille:  petite ou grande / 0 ou 1
    // type:    plate ou creuse  / 0 ou 1
    //
    // Soit 4 bits en binaire
    //
    // Exemple: la piece blanche, carré, grande et plate -> 0110
    //

    /** Tableau remplis contenant le total des pieces */
    private static String[] pieces = {"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111",
                                      "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"}; 
    
    /** Tableau des pieces remplis par copie ayant pour but de se vider au fil de la partie a chaque piece choisi */
    private static String[] piecesInGame = pieces; 

    /** Permet de remettre a 0 le tableau piecesInGame pour pouvoir reprendre une partie de 0 */
    public static String nettoyagePieces() {
        String space= "";
        piecesInGame = pieces;
        return space;
    }

    /** Retourne le tableau piecesInGame qui affiche les pieces inutilise au cour d'une partie */
    public static String piecesEnJeu() {
        String space= "";
        System.out.println(Arrays.toString(piecesInGame));
        return space;
    }

    /** check permet de verifier si la piece choisis et belle est bien dans mon tableau piecesInGame
     * ce qui me permet de verifier que la pieces est conforme et criteres et qu'elle n'a pas deja etait utilisé
     * @param string du tableau des pieces restantes
     * @param string de la piece entrer de l'utilisateur
     * @return true or false
     */
    public static boolean check(String[] tab, String str) {
        boolean contains = Arrays.stream(tab).anyMatch(str::equals);
        return contains;
    }

    /** removePieces Me permet de retirer la piece placer de mon tableau des pieces restantes
     * @param String[] mon tableau de piece restantes
     * @param String removed qui represente la piece a retirer de la liste
     * @return mon tableau des pieces restantes soit mon tableau moins la piece "removed"
     */
    public static String[] removePieces( String [] piecesInGame, String removed ){
        return Arrays.stream(piecesInGame)
            .filter(s -> !s.equals(removed))
            .toArray(String[]::new);
    }

    /** getPieces permet de recuperer via terminal la derniere entrer de l'utilisateur
     *  et de verifier si la pieces est utilisable grace au autres fonction de la classe Piece.
     *  Ce menu offre egalement la possibilite de chosiir une autre piece si elle n'est pas valide
     *  ou de quitter le jeu avec la touche 'q'
     * @return La piece entrer en parametre pour pouvoir l'utiliser dans les autres classe
     */
    public static String getPieces() {
        Scanner sc = new Scanner(System.in);
        String entrer = "";

        System.out.println( "\n"+"Choisis une piece pour ton adversaire ou q pour quitter" +"\n");

        while(true) {
            System.out.print("->");

            try {
                entrer = sc.nextLine();
            } catch (Exception e) {
                System.err.println( "\n"+"Erreur dans le choix de la pièce" + e +"\n");
            }

            if (entrer.equals("q")) {
                return entrer;
            }

            if (check(piecesInGame, entrer)) {
                piecesInGame = removePieces(piecesInGame,entrer);
                return entrer;

            } else {
                System.out.println("\n"+"Cette piece est deja sur le jeu ou est invalide, recommence stp"+"\n");
                continue;
            }
        }
    }

}