# Doc Dev Quarto
# Jeu console :

## Main.java :

- >__Main.java__ permet le lancement du jeu ainsi que l'affichage de la partie.

## Piece.java :

- >__Piece.java__ est le fichier de gestion des pieces de notre jeu.

La classe Piece s'occupe de gestion des pieces du jeu tel qu'afficher les
pieces restantes d'une partie remettre les pieces en jeu ou encore 
verifier si l'usage d'une pièce est possible ou non.

### __Explication des méthodes :__  

- __nettoyagePieces()__ est une méthode qui permet le nettoyage du tableau en y mettant un caractère vide dans chaque case.

- __piecesEnJeu()__ est une méthode qui affiche les pièces n'étant pas encore utlisé.

- __check()__ est une méthode qui permet de verifier si la piece choisis et belle est bien dans le tableau __piecesInGame__.

- __removePieces()__ est une méthode qui permet de retirer la piece placer de le tableau des pieces restantes.

- __getPieces()__ est une méthode qui permet de recuperer via le terminal la derniere entrée de l'utilisateur et de verifier si la piece est utilisable grace aux autres fonctions de la classe Piece. Ce menu offre egalement la possibilite de choisir une autre piece si elle n'est pas valide ou de quitter le jeu avec la touche 'q'.

## Menu.java :

__Menu.java__ gère l'interface et lance une partie, recupère les commandes utilisateurs dans le terminal et fait office de 'main' terminal. Le Menu s'occupe de la globalité des étapes du jeu à l'exception du stockage des données. Fournit diverses commandes dont "__h__" / "__help__" qui affiche toutes les commandes disponible pour une bonne utilisation de notre jeu.

__affichage()__ est une méthode qui gère la récupération de toutes les entrées terminal. Cette méthode va gèrer les erreurs mais aussi les exceptions. 

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

    toutes ces options seront aussi gérés  

>__help()__ est une méthode d'affichage de toutes les options disponibles.  

>__intAt()__ pour les integrer avec une conversion string to integer. Permet de recuperer des characteres specifique d'une string en int (ici elle me permet d'entrer des coordonnees en une fois mais de les distinguer en plusieurs variables).  


>__nettoyage()__ est une méthode qui reinitialise le tableau des pieces, le plateau et les tours des joueurs.

## Plateau.java :

- __Plateau.java__ Génération du plateau, placement des pièces et controleur de victoire ou d'égalité.  

- __Plateau__ est une méthode qui permet d'initialisé la taille du tableau.  

- __generationPlateau__ est une méthode qui fais la génération du plateau vide.  

- __setPiece__ est méthode qui place le coup du joueur en verifiant si la case est disponible.  

- __checkRange__ est une méthode qui vérifie la taille du tableau.  

- __plateauTerminal__ est une méthode qui print le plateau de jeu sur le terminal et met a jour le placement des pieces.  

- __quartoLigne__ est une méthode qui verifie la ligne de la derniere piece joué. Check d'abord si il y a des cases vide sur la ligne si ce n'est pas le cas verifie le quarto.  

- __quartoColonne__ est une méthode qui verifie la colonne de la derniere piece joué. Check d'abord si il y a des cases vide sur la colonne si ce n'est pas le cas verifie le quarto.  

- __quartoDiagonale__ est méthode qui verifie les quartos sur les deux diagonales possibles. Cette fonction contient deux tableau avec toutes les cases presente en diagonale elle verifie d'abord si la case est presente sur une des deux diagonales puis la suite elle verife si il y a des cases vides sur cette diagonale et enfin elle verifie le quarto.

- __egalite__ est méthode qui verifie l'égalite. Si toute les cases sont prises et qu'il n 'y pas de quarto retourne 'true'.

- __binaryCheck__ est une méthode qui verifie si il y a un quarto ou non, elle recoit en parametre 16 chiffre 0 ou 1 et verifie si il y a une correspondance entre les premiers, deuxiemes, troisieme et quatrieme chiffre de chaque pieces.

- __afficheWin__ est une méthode qui permet de mettre en valeur les cases du quarto gagnant en passant en revu toutes les cases du tableau.  

- __quartoCarre__ est une méthode qui permet de verifier les quartos en block de 4. De lire vers 3 grandes sous fonction: verifie si la case est dans un angle sur un bord ou au milieu. Pour les angles et les bords verifie cas par cas le quarto (4 verifs differentes, 1 quarto pour les angles 2 pour les bord). Sinon pour les cases du milieu verifie tout autour les 4 quartos possible.  

- __angleCarre__  est une méthode qui permet de verifier les quartos pour les cases en angle du plateau.

- __bordCarre__ est une méthode qui permet de verifier les quartos pour les cases en bord de plateau.

- __milieuCarre__ est une méthode qui permet de verifier les quartos pour les cases en milieu de plateau.

#
# Jeu Interface

## Main.java :

>__Main.java__ permet le lancement du jeu ainsi que l'affichage de la partie.  

## Menu.java :

>__Menu.java__ permet l'affichage de notre menu et de donner l'accès différente fonctionnalités.  

## Piece.java :

>__Piece.java__ permet l'identification de nos pièces en fonction de leur carctèristiques.

## Plateau.java :

>__Plateau.java__ nous sert à afficher la partie dans la console.

## Verification.java :

>__Verification.java__ gére de façon booléene les conditions de victoire en colonne, en diagonnale et en ligne.

## Rules.java :

>__Rules.java__ stock les régles et les places dans une liste. Ensuite les régles sont envoyées au __Menu.java__ qui les récupéres et les affiches.  

## IAGame.java :

>__IAGame.java__ reprend le code d'origine du quarto tout en y ajoutant le placement aléatoire des pieces par l'IA lorque le joueur 2 doit jouer. Dans vos partie l'IA va donc représenter le joueur 2.  


## ImagePion.java :

>__ImagePion.Java__ va nous permettre de récupérer les images des pieces du Quarto pour les utiliser dans les boutons.

## PlayerLabel.java :

>__PlayerLabel.java__ nous sert juste à alterner les tours entre joueurs.

## SoloGame.java :

>__SoloGame.java__ nous renvoie une fenetre avec le jeu au __Menu.java__. Le menu lui gère tout.

## WinWindow.java :

>__WinWindow.java__ affiche la fenetre en cas de victoire d'un joueur.


#
## A savoir :
* Le jeu console est fonctionne parfaitement, toutes les options disponibles vous ont été spécifié dans la rublique 'help' du jeu.
* Le jeu en interface a cette fois ci abouti et vous pouvez profiter d'une experience de jeu complète. 
#
(_les explications de l'interface graphique sont moins précise que le jeu en terminale puis que l'interface est plus intuitive que le jeu console, mais aussi suite a un léger manque de temps._)