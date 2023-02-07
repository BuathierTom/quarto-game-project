# Doc Utilisateur Quarto

## Le QUARTO - KEZAKO

`Presentation :`

> Le Quarto est un jeu de societe pour deux joueurs. Il se joue sur un plateau de jeu avec 16 pieces, chaque pieces ayant des caracteristiques differentes parmi les suivantes : couleur (noir ou blanc), hauteur (haut ou bas), remplissage (creux ou plein) et forme (carre ou rond).

`But du jeu :`

> Le but du jeu est de creer une ligne de quatre pieces qui ont au moins une caracteristique en commun. La ligne peut être verticale, horizontale ou diagonale. Il est aussi possible de realiser un carre.

`Deroulement d'une partie :`
	
- Tour a tour un joueur va choisir la piece que son adversaire devra poser.
- Le joueur qui a pose la premiere piece choisit ensuite la piece que le second joueur devra poser. 
  Le second joueur doit alors poser cette piece sur le plateau de jeu.
- Le premier joueur choisit a nouveau la piece que le second joueur doit poser, et ainsi de suite.
- Si un joueur pense qu'il peut creer une ligne de quatre pieces qui ont au moins une caracteristique en commun, il peut 
  declarer "Quarto" et essayer de le faire. Si le joueur reussit, il a gagne la partie. Si le joueur se trompe, l'autre joueur 
  peut essayer de creer une ligne gagnante a son tour.

`Fin de la partie :`

> La partie se termine lorsqu'un joueur reussit a creer une ligne de quatre pieces qui ont au moins une caracteristique en commun, ou lorsque toutes les pieces ont ete posees sur le plateau de jeu et qu'aucune ligne gagnante n'a ete crée. Dans ce dernier cas, la partie est declaree nulle.

`Durée de la partie :`

> La duree d'une partie de Quarto depend du nombre de coups joues et de la strategie des joueurs. En general, une partie peut durer de quelques minutes a une demi-heure (pour les parties les plus longues).

## Guide d'installation :

Le jeu en version terminal a été entièrement codé en Java, et c'est pour cette raison que vous devez installer Java 

Sur votre environement de développement (VSCode)  
Vous installez l'extension Maven, cette extension java vous permettra d'avoir les prêt requis pour le jeu version terminal et interface graphique  
#
## Jeu console :

### Guide de démarrage rapide :

-> le lancement se fait dans le fichier main   
Au démarrage du jeu plusieurs options sont disponible comme tout d'abord l'option "help".  
-> une liste de toutes les possibilitées disponible et leur utilisations vous seras disponible

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


### Guide de gestion des pieces :

    couleur: blanche ou noire / 0 ou 1
    forme :  ronde ou carré   / 0 ou 1
    taille:  petite ou grande / 0 ou 1
    type:    plate ou creuse  / 0 ou 1

#

## Jeu interface :

### Guide de démarrage rapide :

-> le lancement se fait dans le fichier main  
Au lancement du jeu un petite fenetre va s'ouvrir et 3 options s'offre à vous :

* Jouer  
`Lancement de la partie `
* Règles  
`Affichage des règles `
* Exit  
`Ferme l'application `

### Guide de gestion du jeu :

Lors du lancement de la partie vous devez cliquer sur les pieces puis ensuite sur les cases pour les placer, tout en respectant les règles du jeu.



