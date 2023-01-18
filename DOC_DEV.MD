# Doc Dev Quarto
## Main.java :

- __Main.java__ permet le lancement du jeu ainsi que l'affichage de la partie.

## Piece.java :

- __Piece.java__ est le fichier de gestion des pieces de notre jeu.

La classe Piece s'occupe de gestion des pieces du jeu tel qu'afficher les
pieces restantes d'une partie remettre les pieces en jeu ou encore 
verifier si l'usage d'une piece est possible ou non.

### __Explication des méthodes :__  

- __nettoyagePieces()__ est une méthodes qui permet le nottoyage du tableau en y mettant un caractère vide dans chaque case.

- __piecesEnJeu()__ est une méthode qui affiche les pieces n'étant pas encore utlisé.

- __check()__ est une méthode qui permet de verifier si la piece choisis et belle est bien dans mon tableau __piecesInGame__.

- __removePieces()__ est une méthode qui permet de retirer la piece placer de mon tableau des pieces restantes.

- __getPieces()__ est une méthode qui permet de recuperer via le terminal la derniere entré de l'utilisateur et de verifier si la pieces est utilisable grace aux autres fonctions de la classe Piece. Ce menu offre egalement la possibilite de chosiir une autre piece si elle n'est pas valide ou de quitter le jeu avec la touche 'q'.

## Menu.java :

__Menu.java__ gère l'interface et lance une partie, recupère les commandes utilisateurs dans le terminal et fait office de 'main' terminal. Le Menu s'occupe de la globalité des étapes du jeu à l'exception du stockage des données. Fournit diverse commande dont "__h__" / "__help__" qui affiche toutes les commandes disponnible pour une bonne utilisation de notre jeu

__affichage()__ est une méthode qui gère la récupération de toutes les entrées terminal. Cette méthode va gèrer les erreurs mais aussi les exceptions 

    Taper "h" ou "help" pour lister les commandes disponibles

    OPTION:
    q ou quit -> quitte le jeu           n ou new   -> nouvelle partie
    h ou help -> you're in atm           r ou regle -> regles du jeu

    COMMENT JOUER:
    s ou select -> permet de passer une piece a son adversaire
    p ou place  -> permet de placer la piece recu

    MODE COMPETITIF (redemarre une nouvelle partie):
    c ou square -> active la verification de QUARTO en carre
    t ou timer  -> active un timer de jeu (1 min par tour)

    toutes ces options seront aussi géré  

__help()__ est une méthode d'affichage de toutes les options disponibles  

__intAt()__ pour les integer avec une conversion string to integer. Permet de recuperer des characteres specifique d'une string en int (ici elle me permet d'entrer des coordonnees en une fois mais de les distinguer en plusieurs variables)  


__nettoyage()__ est une méthode qui reinitialise le tableau des pieces, le plateau et les tour des joueurs

## Plateau.java :

- __Plateau.java__ Génération du plateau, placement des pièces et controleur de victoire ou d'égalité  

- __Plateau__ est une métode qui permet d'initialisé la taille du tableau  

- __generationPlateau__ est une méthode qui fais la génération du plateau vide  

- __setPiece__ est méthode qui place le coup du joueur en verifiant si la case est disponible  

- __checkRange__ est une méthode qui vérifie la taille du tableau  

- __plateauTerminal__ est une méthode qui print le plateau de jeu sur le terminal et met a jour le placement des pieces  

- __quartoLigne__ est une méthode qui verifie la ligne de la derniere piece joué. Check d'abord si il y a des cases vide sur la ligne si ce n'est pas le cas verifie le quarto  

- __quartoColonne__ est une méthode qui verifie la colonne de la derniere piece joué. Check d'abord si il y a des cases vide sur la colonne si ce n'est pas le cas verifie le quarto  

- __quartoDiagonale__ est méthode qui verifie les quarto sur les deux diagonales possibles. Cette fonction contient deux tableau avec toutes les cases presente en diagonale elle verifie d'abord si la case est presente sur une des deux diagonales puis la suite elle verife si il y a des cases vides sur cette diagonale et enfin elle verifie le quarto

- __egalite__ est méthode qui verifie l'egalite. Si toute les cases sont prises et qu'il n 'y pas de quarto retourne 'true'

- __binaryCheck__ est une méthode qui verifie si il y a un quarto ou non, elle recoit en parametre 16 chiffre 0 ou 1 et verifie si il y a une correspondance entre les premiers, deuxiemes, troisieme et quatrieme chiffre de chaque pieces

- __afficheWin__ est une méthode qui permet de mettre en valeur les case du quarto gagnant en passant en revu toutes les cases du tableau  

- __quartoCare__ est une méthode qui permet de verifier les quartos en block de 4. De lire vers 3 grandes sous fonction: verifie si la case est dans un angle sur un bord ou au milieu. Pour les angles et les bords verifie cas par cas le quarto (4 verif differentes, 1 quarto pour les angles 2 pour les bord). Sinon pour les cases du milieu verifie tout autour les 4 quartos possible  

- __angleCare__  est une méthode qui permet de verifier les quarto pour les cases en angle du plateau

- __bordCare__ est une méthode qui permet de verifier les quarto pour les cases en bord de plateau

- __milieuCare__ est une méthode qui permet de verifier les quarto pour les cases en milieu de plateau