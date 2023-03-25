package quarto.com;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
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

public class SoloGame {
    // Définition des variables utile
    private static String pieceSignature = " ";

    private static int cases = 0;

    /**
     * Methode qui permet de renvoyer une fenetre de jeu dans le programme Menu.java. 
     * @param mainWindow Fenetre de jeu
     * @return La fenetre de jeu
     */
    public static Stage quartoWindow(Stage mainWindow){
        // Listes de buttons 
        List<Button> buttons_Img = new ArrayList<>();
        List<Button> grille = new ArrayList<>();
        // Les layouts utlisés dans ce programme pour la grille et la selection des pions
        GridPane grid = new GridPane();
        VBox vBox = new VBox();
        ScrollPane scroll = new ScrollPane();
        BorderPane centralLayout = new BorderPane();
        // On centre la grille
        grid.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);

        // Création du plateau terminal
        String[][] plateau = Plateau.initPlateau();


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
                    // on récupere le texte de la pieces (Exple: "Rond_Court_Creux_Blanc")
                    pieceSignature = ((Button) event.getSource()).getText();
                }});
            vBox.getChildren().add(button);
            }
        scroll.setContent(vBox);
        

        System.out.println(Plateau.affichePlateau(plateau));

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
                        System.out.println("coords: " + coords);


                        // On transforme les Strings en int 
                        int pX = Verification.intAt(coords, 0);
                        int pY = Verification.intAt(coords, 1);

                        System.out.println("px: " + pX);
                        System.out.println("py: " + pY);



                        // On transforme la PieceSignature en binaire
                        String signBinary = Verification.binaireChange(pieceSignature);

                        // On pose la piece
                        Boolean i = Plateau.setPiece(pX,pY,signBinary,plateau);  
                        // ajout de la piece dans le plateau
                        plateau[pX][pY] = signBinary;

                        System.out.println("plateau : " + plateau[pX][pY] + "\n");

                        // Variable qui permet de savoir si on continue ou pas
                        boolean tour = false;

                        
                        if (Verification.quartoLigne(pX,pY, plateau) == true ) {

                                System.out.println("Quarto en LIGNE!");
                                System.out.println(Plateau.affichePlateau(plateau));

                                tour = true;

                                Stage stage = WinWindow.winWindow("LIGNES");
                                stage.show();



                        } if (Verification.quartoColonne(pX,pY, plateau) == true ){ 

                            System.out.println("Quarto en COLONNE!");
                            System.out.println(Plateau.affichePlateau(plateau));

                            tour = true;


                        } if (Verification.quartoDiagonale(coords, plateau) == true) {

                            System.out.println("Quarto en DIAGONALE!");
                            System.out.println(Plateau.affichePlateau(plateau));

                            tour = true;


                        } if (cases == 16){
                            System.out.println("Match nul");

                            tour = true;

                        }
                        else if(tour == false) {
                            // Le tour continue et on print le plateau
                            System.out.println("Continuez le jeu");
                            System.out.println(Plateau.affichePlateau(plateau)); 
                            cases++;                           
                        }

                        // On remet la signature de la piece a " " pour pas pouvoir la reposer
                        pieceSignature = " ";
                    }

                });
                grid.add(buttonGrille, i+1, j);
                // On affiche le plateau
            }
        }    
        // On créé un label de tour : 
        Label tour = new Label("Tour du joueur 1");
        tour.setFont(new Font("Arial", 20));
        tour.setTextFill(Color.WHITE);
        // On ajoute le label au grid
        grid.add(tour, 0, 0);
        // On place dans le centralLayout
        centralLayout.setCenter(grid);
        centralLayout.setRight(scroll);
        /* Ajout d'un fond d'écran */
        Image image = new Image("fond.jpg");
        BackgroundSize backgroundSize = new BackgroundSize(1400, 700, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);
        // On ajoute le font
        centralLayout.setBackground(background);
        // On fait du css en java ! Et oui c'est possible
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
