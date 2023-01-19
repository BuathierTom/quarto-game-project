import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/** Gère l'interface et lance une partie, recupère les commandes utilisateurs
 *  dans le terminal et fait office de 'main' terminal.
 *  Le Menu s'occupe de la globalité des étapes du jeu à l'exception du stockage des données
 *  Fournit diverse commande dont "h" / "help" qui affiche toutes les commandes disponnible
 */
public class Menu {

    private static int ligne = 4;                                      // initialise un tableau
	private static int colonne = 4;                                    // en 4x4 cases
    private static Plateau partie = new Plateau(ligne, colonne);       // initialise le plateau
    String piece_choisie = "";                                         // sauvegarde la piece choisis par le joueur
    boolean tour = true;                                               // true = donne une piece,  false= pose une piece
    int joueur = 1;                                                    // permet de jongler entre le joueur 1 et 2
    boolean square = false;                                            // permet d'activer la verification de quarto en carre


    /**Récupère les commandes de l'utilisateur et appelle la plupart
     * des autres fonctions. Permet également:
     * d'afficher les regles, de quitter le programme, de recommencer
     * une partie ainsi que de passer ou placer une piece en appellant
     * "Jeu", "Plateau" et "Piece"
     * 
     * @throws FileNotFoundException
     */
    public void affichage() throws FileNotFoundException {

        Scanner sc = new Scanner(System.in);            // recupere constament les entrees terminal

        System.out.println( "\n" + "Taper \"h\" ou \"help\" pour lister les commandes disponibles" +"\n");
        System.out.println( "Tour du joueur " + joueur + ", choisis une piece a donner ('s')"+"\n");

        while (true) {
            
            System.out.print("->");                  // fleche qui indique que le terminal est pret a recevoir une commande utilisateur
            String  entrer = "";                       // stockage en str de la derniere entree terminale

            try {
                entrer = sc.nextLine();
            } catch (Exception e) {
                System.err.println( "Erreur avec l'entree:" + e +"\n");
            }

            entrer = entrer.trim().toLowerCase();

            switch (entrer) {
            
                //
                // Option système
                // (quitter, afficher les règles, redémarer la partie)
                //

                // kill le programme
                case "q":
                case "quit":
                    System.out.println( "\n"+"A plus"+"\n" );
                    sc.close();
                    return;
                
                // affiche les regles sur un .txt
                case "r":
                case "rules":
                    InputStream regle = new FileInputStream("../regle.txt");
                    Scanner obj = new Scanner(regle);
                    while (obj.hasNextLine()) {
                        System.out.println("\n"+obj.nextLine()+"\n");
                    }
                    break;
                
                // affiche les commandes et leurs utilité
                case "h":
                case "help":
                    System.out.println(help());
                    break;

                // restart une partie
                case "n":
                case "new":
                    nettoyage();
                    break;

                //
                // Entrée joueur
                // (Selectionner une piece, donner une piece)
                //

                // selectionne une piece
                case"s":
                case"select":
                    if( tour == true ) {

                        System.out.println( "\n"+"Pieces restantes: " +"\n");
                        System.out.println( Piece.piecesEnJeu());               // liste les pieces restantes de la partie
                        piece_choisie=Piece.getPieces();                        // recupere la piece selectionné si valide

                        if (piece_choisie.equals("q")){               // permet de faire demi tour pour quitter ou autre

                            System.out.println( "\n"+"A plus" +"\n");
                            sc.close();
                            return;
                    
                        } else {

                        //fin getPieces
                        if (joueur == 1 ) {                                     // changement de joueur
                            joueur ++;
                        } else {
                            joueur--;
                        }
                        tour = false;                                           // tour false pour jongler entre le choix de la piece et le placement
                        System.out.println( "\n"+"Au joueur: "+ joueur + " de poser la piece ('p')" + "\n" );
                        break;
                        }

                    } else {

                        System.out.println( "\n"+"Tu ne peux pas faire cette action ce tour la " + "\n");                  // si tour == false
                        continue;                                               
                    }
                
                // pose une piece
                case"p":
                case"place":
                    if ( tour == false) {

                        int n,e;                                                                                        // mes coordonées en int pour verifier une partie gagnantes
                        String co;                                                                                      // mes coordonées en string pour verifier une partie gagnantes
                        Boolean i = false;                                                                              // pour initier la boucle do while      
                        System.out.println("\n"+"Tu dois placer la piece: " + piece_choisie + "\n");                         // affiche la piece que le joueur doit poser
                        System.out.println(partie.plateauTerminal(ligne, colonne) + "\n");                              // retourne le palteau de la partie en cour
                        System.out.println("\n"+"Choisis une case vide de 00 a 33 (x et y entre 0 et 3): "+ "\n");
                        Scanner scan = new Scanner(System.in);

                        do {

                            System.out.print("->");
                            String coord = "";
                            coord = scan.nextLine();
                            int x = intAt(coord, 0);                                                       // appelle la fonction intAt pour recuperer
                            int y = intAt(coord, 1);                                                       // des int séparer d'un entree terminale
                            n = x; 
                            e = y;
                            co = coord;
                            i = Plateau.setPiece(x,y,piece_choisie);                                              // verifie si la case est libre ou pose la piece
                                                                                                                  // gère les erreurs et retourne un booleen pour
                        } while (i == false);                                                                     // fermer le do while
                        //fin place

                        if (Plateau.quartoLigne(n,e) == true || Plateau.quartoColonne(n,e) == true || Plateau.quartoDiagonale(co) == true    // verifie la victoire
                            || ( square == true && Plateau.quartoCare(co,n,e) == true)) {

                            System.out.println("\n" +"Felicitation au joueur " + joueur + " pour son QUARTO !" + "\n");
                            System.out.println("\n" + partie.plateauTerminal(ligne, colonne)+ "\n");
                            nettoyage();
                            break;
                        }

                        if (Plateau.egalite() == true) {                                                          // verifie l'egalite

                            System.out.println( "\n"+"Bravo, vous avez reussie une egalite"+ "\n");
                            System.out.println("\n" + partie.plateauTerminal(ligne, colonne)+ "\n");  
                            nettoyage();

                        } else {

                        System.out.println("\n" + partie.plateauTerminal(ligne, colonne)+ "\n");                  // retourne le plateau avec la piece poser
                        System.out.println("\n"+"Piece pose, maintenant passe une piece a ton adversaire ('s')" + "\n");
                        tour = true;
                        }

                    } else {
                        System.out.println( "\n"+"Tu ne peux pas faire cette action ce tour la " + "\n");
                        continue;
                    } break;

                //
                // MODE COMPETITIF
                // (verif en carre et timer)
                //

                case "c":
                case "square":
                    if( square == false) {
                        System.out.println( "\n"+" Verification de QUARTO en carre activer, lancement d'une nouvelle partie... " + "\n");
                        square = true;
                        nettoyage();
                        break;
                    } else {
                        System.out.println( "\n"+" Desactivation de la verification en carre, lancement d'une nouvelle partie... " + "\n");
                        square = false;
                        nettoyage();
                        break;
                    }

                case "t":
                case "timer":
                    System.out.println( "\n"+" A VENIR..." + "\n");
                    break;
            }
        }
    }

    /** Affiche les informations des diverses commandes du programme
     * @return
     */
    public String help() {
        String help = "";
        
         help += "\n"
               + "OPTION: \n"
               + "q ou quit -> quitte le jeu           n ou new   -> nouvelle partie\n"
               + "h ou help -> you're in atm           r ou regle -> regles du jeu\n"
               + "\n"
               + "COMMENT JOUER: \n"
               + "s ou select -> permet de passer une piece a son adversaire \n"
               + "p ou place  -> permet de placer la piece recu\n"
               + "\n"
               + "MODE COMPETITIF (redemarre une nouvelle partie): \n"
               + "c ou square -> active la verification de QUARTO en carre \n"
               + "t ou timer  -> active un timer de jeu (1 min par tour)\n";
         return help;
    }


    /**charAt pour les integer avec une conversion string to integer
     * Permet de recuperer des characteres specifique d'une string en int
     * (ici elle me permet d'entrer des coordonnees en une fois mais de
     * les distinguer en plusieurs variables)
     * @param num
     * @param index
     * @return
     */
    public int intAt(String num, int index){

	    int r = Integer.parseInt(num.substring(index, index+1));
        return r;
    }

    /** reinitialise le tableau des pieces, le plateau, les tour des joueurs
     */
    public void nettoyage(){
        
        Piece.nettoyagePieces();
        partie.generationPlateau();
        piece_choisie = "";
        tour = true;
        joueur = 1;

        
        System.out.println( "\n"+"Nouvelle partie:" +  "\n");
        System.out.println( "\n"+ "Taper \"h\" ou \"help\" pour lister les commandes disponibles"+"\n");
        System.out.println( "Tour du joueur " + joueur + ", choisis une piece a donner" +"\n");
        return;
    }
}
