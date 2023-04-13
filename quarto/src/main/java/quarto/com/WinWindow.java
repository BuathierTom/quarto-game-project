package quarto.com;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class WinWindow {

    /**
     * Méthode qui permet de créer une fenetre de victoire
     * @param cases Nombre de cases jouées
     * @param tourJoueur Tour du joueur
     * @param listIA Liste de si IA
     * @return La fenetre de victoire
     */
    public static Stage winWindow(int cases, int tourJoueur, String[] listIA) {
        BorderPane centralLayout = new BorderPane();
        Label labelVictoire = new Label("");
        String winner = "";
        // On verifie si la listIA est vide ou non avec un boolean :
        boolean listIAEmpty = false;
        if (listIA.length == 0){
            listIAEmpty = true;
        }

        // On verifie qui a gagné :
        if (tourJoueur == -1 || tourJoueur == 0){
            winner = "Joueur 1";
        } else if (tourJoueur == 1) {
            if (listIAEmpty){
                winner = "Joueur 2";
            } else {
                winner = "l'IA";
            }
        }

        // Match nul ?
        if (cases == 16){
            labelVictoire.setText("Match nul !");
        } else {
            labelVictoire.setText("QUARTO de "+ winner +" !");
        }
        // Fenetre de victoire :
        labelVictoire.setStyle("-fx-font-size: 50px; -fx-text-fill: #000000;");
        centralLayout.setTop(labelVictoire);
        BorderPane.setAlignment(labelVictoire, Pos.CENTER);
        BorderPane.setMargin(labelVictoire, new Insets(50, 0, 0, 0));
        
        // Bouton pour quitter le jeu :
        Button buttonQuitter = new Button("Quitter");
        buttonQuitter.setStyle("-fx-font-size: 30px; -fx-background-color: #ffffff; -fx-text-fill: #000000;");
        centralLayout.setBottom(buttonQuitter);
        BorderPane.setAlignment(buttonQuitter, Pos.CENTER);
        BorderPane.setMargin(buttonQuitter, new Insets(0, 0, 50, 0));
        buttonQuitter.setOnAction(e -> {
            System.exit(0);
        });

        Scene sceneWindow = new Scene(centralLayout, 700, 600);
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
