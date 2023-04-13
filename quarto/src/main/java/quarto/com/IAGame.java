package quarto.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class IAGame {
    // Définition des variables utile
    private static String pieceSignature = " ";

    private static int cases = 0;

    private static int tourJoueur = 0;

    /**
     * Methode qui permet de renvoyer une fenetre de jeu dans le programme Menu.java. 
     * @param mainWindow Fenetre de jeu
     * @return La fenetre de jeu
     */
    public static Stage quartoWindow(Stage mainWindow){
        // Listes de buttons 
        List<Button> buttons_Img = new ArrayList<>();
        List<Button> grille = new ArrayList<>();
        
        // Liste de positions :
        ArrayList<String> posPions = new ArrayList<String>();

        // Liste de positions de tout les boutons de la grille :
        ArrayList<String> posGrille = new ArrayList<String>();
        // On ajoute toutes les positions de la grille : "00", "01", "02", "03", "10", "11", "12", "13", "20", "21", "22", "23", "30", "31", "32", "33"

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                posGrille.add(j + "" + i);
            }
        }
        
        // Les layouts utlisés dans ce programme pour la grille et la selection des pions
        GridPane grid = new GridPane();
        VBox vBox = new VBox();
        ScrollPane scrollRight = new ScrollPane();
        ScrollPane scrollLeft = new ScrollPane();
        BorderPane centralLayout = new BorderPane();
        // On centre la grille
        grid.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);

        // Création du plateau terminal
        String[][] plateau = Plateau.initPlateau();

        Label tour = new Label(" ");

        Label signLabel = new Label(" ");

        // On change le label de tour
        tour.setText(PlayerLabel.labelIA(tourJoueur));

        // On verifie le changement de joueur
        if (tourJoueur == 3) {
            tourJoueur = -1;
        }

        // Listes de toutes les pièces du quarto
        List<Piece> pieces = new ArrayList<>();
        List<Boolean> verfiBool = Arrays.asList(false, true);
        // On rempli la liste avec la signature des pieces c'est a dire (Exple: "Rond_Court_Creux_Blanc")
        for (Boolean estRond : verfiBool) {
            for (Boolean estPetit : verfiBool) {
                for (Boolean estCreux : verfiBool) {
                    for (Boolean estBlanc : verfiBool) {
                        pieces.add(new Piece(estRond, estPetit, estCreux, estBlanc));
            }}
        }}

        // Pour toutes les pièces, on créé un bouton avec une signature
        for (Piece piece : pieces) {
            // L'image des pieces dans la ScrollPane
            Image img = new Image(piece.toString() + ".png");
            ImageView imgView = new ImageView(img);
            imgView.setFitWidth(100);
            imgView.setFitHeight(100);
            // On met un texte pour identifier précisement la pièce
            Button button = new Button(piece.toString());
            buttons_Img.add(button);
            // On ajoute l'image au bouton créé
            button.setGraphic(imgView);
            // Un peu d'espace nan ?
            button.setPadding(new Insets(10, 20, 10, 10));
            // Quand on clique un bouton de la selection des pions cela enregistre la signature de la piece
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    pieceSignature = ((Button) event.getSource()).getText(); 
                    
                    // On change la couleur du bouton selectionné
                    button.setStyle("-fx-border-color: red; -fx-border-width: 5px;");
                    // on récupere le texte de la pieces (Exple: "Rond_Court_Creux_Blanc")
                             
                    // Label du joueur qui va jouer              
                    tourJoueur++;
                    if (tourJoueur == 1) {
                        // On place la piece avec son image grace a la piece signature sur le bouton qui a le texte 00
                        for (Button button : buttons_Img) {
                            if (button.getText().equals(pieceSignature)) {

                                String pos = posGrille.get((int) (Math.random() * posGrille.size()));

                                Image img = new Image(pieceSignature + ".png");
                                ImageView imgView = new ImageView(img);
                                imgView.setFitWidth(75);
                                imgView.setFitHeight(75);

                                
                                // on ajoute l'image a la grille avec le texte cacher dans le bouton et pas l'index des boutons :
                                for (Button buttonGrille : grille) {
                                    if (buttonGrille.getText().equals(pos)) {
                                        buttonGrille.setGraphic(imgView);
                                        buttonGrille.setText(pieceSignature);
                                        break;
                                    }
                                }
                                
                                // On supprime le button séléctionner pour pas pouvoir le reposer
                                int indexButtonIMG_tour1 = -1;
                                for (int z = 0; z < buttons_Img.size(); z++) {
                                    if (buttons_Img.get(z).getText().equals(pieceSignature)) {
                                        indexButtonIMG_tour1 = z;
                                        break;
                                    }
                                } 
                                
                                if (indexButtonIMG_tour1 != -1) {
                                    buttons_Img.get(indexButtonIMG_tour1).setVisible(false);
                                    // Les bouton de la grilles remonte dans la ScrollPane lorsqu'on enlève un bouton
                                    vBox.getChildren().remove(buttons_Img.get(indexButtonIMG_tour1));
                                    // On enleve le bouton de la liste pieces
                                    pieces.remove(indexButtonIMG_tour1);
                                }

                                int posX = Verification.intAt(pos, 0);
                                int posY = Verification.intAt(pos, 1);

                                // On transforme la PieceSignature en binaire
                                String signBinary = Verification.binaireChange(pieceSignature);

                                // On pose la piece sur le tableau console
                                Boolean i = Plateau.setPiece(posX, posY, signBinary,plateau); 

                                // On ajoute la piece sur la grille
                                plateau[posX][posY] = signBinary;

                                // On supprime la position de la grille
                                posGrille.remove(pos);

                                // Variable qui permet de savoir si on continue ou pas
                                boolean conditionWinIA = false;

                                // Liste utile que dans l'IA 
                                String[] listIA = {"IA"};

                                if (Verification.quartoLigne(posX,posY, plateau) == true || 
                                    Verification.quartoColonne(posX,posY, plateau) == true || 
                                    Verification.quartoDiagonale(pos, plateau) == true) {
                                    // On change la variable pour pas que le programme continue
                                    conditionWinIA = true;
                                    // On affiche la fenetre de victoire
                                    Stage stage = WinWindow.winWindow(cases, tourJoueur, listIA);
                                    stage.show();
                                    // Pour fermer la fenetre de jeu
                                    Stage winClose = (Stage) button.getScene().getWindow();
                                } else if(conditionWinIA == false) {
                                    // On ajoute 1 au nombre de cases
                                    cases++;                           
                                }

                                // On ajoute la position du pion sur la grille
                                posPions.add(pos);
                                // On enleve la position de la grille
                                posGrille.remove(pos);
                                // On enleve la piece de la selection
                                pieceSignature = " ";
                                tourJoueur++;

                            }
                        } 
                    }
                    if (tourJoueur == 2) {
                        // On prend au hasard une piece dans la liste de pieces
                        String pieceRandom = pieces.get((int) (Math.random() * pieces.size())).toString();

                        pieceSignature = pieceRandom;
                        
                        int indexButtonIMG_tour2 = -1;
                        for (int o = 0; o < buttons_Img.size(); o++) {
                            if (buttons_Img.get(o).getText().equals(pieceSignature)) {
                                indexButtonIMG_tour2 = o;
                                break;
                            }
                        } 
                        
                        if (indexButtonIMG_tour2 != -1) {
                            buttons_Img.get(indexButtonIMG_tour2).setVisible(false);
                            // Les bouton de la grilles remonte dans la ScrollPane lorsqu'on enlève un bouton
                            vBox.getChildren().remove(buttons_Img.get(indexButtonIMG_tour2));
                            // On enleve le bouton de la liste pieces
                        }

                        pieces.remove(pieceRandom);

                        tourJoueur++;
                    }
                    tour.setText(PlayerLabel.labelIA(tourJoueur));
                    if (tourJoueur == 3) {
                        tourJoueur = -1;
                    }
                    signLabel.setText(pieceSignature);
    
                }});
            vBox.getChildren().add(button);
            }
        scrollRight.setContent(vBox);
        // Un peu de css en java pour la selection des pions
        scrollRight.setFitToWidth(true);
        scrollRight.setStyle("-fx-background: transparent; -fx-background-color: transparent;"); 
        scrollRight.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollRight.setPadding(new Insets(10, 10, 10, 10));


        // On ajoute les boutons pour la grille
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
            
                // On créé le bouton
                Button buttonGrille = new Button(""+ j + i);
                // Un peu de css en java pour les boutons
                buttonGrille.setStyle("-fx-text-fill: transparent;");
                buttonGrille.setPrefSize(102, 102);
                GridPane.setMargin(buttonGrille, new Insets(10, 10, 10, 10));
                grille.add(buttonGrille);

                // Quand on clique un bouton de la grille on peut poser la piece sur la grille
                buttonGrille.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        // Condition qui verifie si il y a deja une piece sur la case
                        if (pieceSignature == " ") {
                            // Si il n'y a pas de piece selectionné on affiche une erreur
                            Alert alert = new Alert(AlertType.INFORMATION);
                            alert.setTitle("Erreur");
                            alert.setHeaderText("Erreur");
                            alert.setContentText("Vous n'avez pas selectionné de piece");
                            alert.showAndWait();
                        } else if (posPions.contains(buttonGrille.getText())) {
                            // Si il y a deja une piece sur la case on affiche une erreur
                            Alert alert = new Alert(AlertType.INFORMATION);
                            alert.setTitle("Erreur");
                            alert.setHeaderText("Erreur");
                            alert.setContentText("Il y a deja une piece sur cette case");
                            alert.showAndWait();
                        } else {
                            // On ajoute la position de la piece dans la liste pos
                            posPions.add(buttonGrille.getText());
                            posGrille.remove(buttonGrille.getText());

                            // Label du joueur qui va jouer
                            tourJoueur++;
                            tour.setText(PlayerLabel.labelIA(tourJoueur));
                            if (tourJoueur == 3) {
                                tourJoueur = -1;
                            }
                            
                            // Images des pieces une fois cliquer sur le plateau
                            ImagePion.placeImage(pieceSignature, buttonGrille);

                            // On supprime le button séléctionner pour pas pouvoir le reposer
                            int index = -1;
                            for (int i = 0; i < buttons_Img.size(); i++) {
                                if (buttons_Img.get(i).getText().equals(pieceSignature)) {
                                    index = i;
                                    break;
                                }
                            } 
                            
                            if (index != -1) {
                                buttons_Img.get(index).setVisible(false);
                                // Les bouton de la grilles remonte dans la ScrollPane lorsqu'on enlève un bouton
                                vBox.getChildren().remove(buttons_Img.get(index));
                            }

                            // Position du bouton dans la grille 
                            String coords = buttonGrille.getText();

                            // On transforme les Strings en int 
                            int pX = Verification.intAt(coords, 0);
                            int pY = Verification.intAt(coords, 1);

                            // On transforme la PieceSignature en binaire
                            String signBinary = Verification.binaireChange(pieceSignature);

                            // On pose la piece
                            Boolean i = Plateau.setPiece(pX,pY,signBinary,plateau);  
                            // ajout de la piece dans le plateau
                            plateau[pX][pY] = signBinary;

                            // Variable qui permet de savoir si on continue ou pas
                            boolean conditionWin = false;

                            // Liste utile que dans l'IA 
                            String[] listIA = {"IA"};

                            if (Verification.quartoLigne(pX,pY, plateau) == true || 
                                Verification.quartoColonne(pX,pY, plateau) == true || 
                                Verification.quartoDiagonale(coords, plateau) == true) {
                                // On change la variable pour pas que le programme continue
                                conditionWin = true;
                                // On affiche la fenetre de victoire
                                Stage stage = WinWindow.winWindow(cases, tourJoueur, listIA);
                                stage.show();
                                // Pour fermer la fenetre de jeu
                                Stage winClose = (Stage) buttonGrille.getScene().getWindow();
                            } else if(conditionWin == false) {
                                // On ajoute 1 au nombre de cases
                                cases++;                           
                            }

                            // On remet la signature de la piece a " " pour pas pouvoir la reposer
                            pieceSignature = " ";
                            // On remet le label de la piece a " "
                            signLabel.setText(" ");

                        }
                    }

                });
                grid.add(buttonGrille, i+1, j);
                // On affiche le plateau
            }
        }    

        // On créé un label de tour : 
        tour.setFont(new Font("Arial", 20));
        tour.setTextFill(Color.WHITE);
        // On ajoute le label au scroll Left
        scrollLeft.setContent(tour);
        scrollLeft.setStyle("-fx-background: transparent; -fx-background-color: transparent; "); 
        scrollLeft.setFitToWidth(true);

        // --------------------------------------------

        // On créé un label du label de la piece : 
        signLabel.setFont(new Font("Arial", 20));
        signLabel.setTextFill(Color.WHITE);
        // On ajoute le label au scroll Left
        scrollLeft.setContent(new VBox(tour, signLabel));
        scrollLeft.setStyle("-fx-background: transparent; -fx-background-color: transparent; "); 
        scrollLeft.setFitToWidth(true);

        // --------------------------------------------

        scrollRight.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollRight.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        // --------------------------------------------

        // On place dans le centralLayout
        centralLayout.setCenter(grid);
        centralLayout.setRight(scrollRight);
        centralLayout.setLeft(scrollLeft);
        /* Ajout d'un fond d'écran */
        Image image = new Image("fond.jpg");
        BackgroundSize backgroundSize = new BackgroundSize(1400, 700, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);
        // On ajoute le font
        centralLayout.setBackground(background);
        // On fait du css en java ! Et oui c'est possible :) 
        centralLayout.setStyle("-fx-background-image: url('fond.jpg'); " +
                               "-fx-background-size: cover; " +
                               "-fx-background-repeat: no-repeat; " +
                               "-fx-background-position: center;");
        /* Affichage de la scene : */
        Scene sceneWindow = new Scene(centralLayout, 1400, 700);
        Stage stageWindow = new Stage();
        /* Icone du jeu : */        
        stageWindow.getIcons().add(new Image("Q_Logo.jpg"));
        stageWindow.setTitle("QUARTO");
        stageWindow.setScene(sceneWindow);
        stageWindow.setResizable(false);
        // On return la fenetre
        return stageWindow;
    }
}
