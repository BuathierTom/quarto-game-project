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
     * @param winner Le gagnant
     * @return La fenetre de victoire
     */
    public static Stage winWindow(String winner) {
        BorderPane centralLayout = new BorderPane();
        // Fenetre de victoire :
        Label labelVictoire = new Label("QUARTO EN " + winner +"!");
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

        Scene sceneWindow = new Scene(centralLayout, 500, 500);
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
