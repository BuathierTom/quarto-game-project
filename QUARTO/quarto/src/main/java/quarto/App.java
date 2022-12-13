package quarto;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage mainWindow) {
        /* Création des layouts pour les boutons */
        VBox mainLayout = new VBox();
        /* Création des boutons */
        Button play = new Button("PLAY");
        Button regles = new Button("REGLES");
        Button exit = new Button("EXIT");
        /* Insertion des boutons */
        /* Creation de la fenetre du jeu */
        play.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Stage playWindows = Quarto.quartoWindow(mainWindow);

                playWindows.show();
                
                Stage stage = (Stage) play.getScene().getWindow();
                stage.close();
        }});
        /* Chargement des regles dans une autre fenetre */
        regles.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Stage windowRules = Rules.windowRules(mainWindow);
                windowRules.show();
            }});    
        /* Bouton de exit de l'application */
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Stage stage = (Stage) exit.getScene().getWindow();
                stage.close();
        }});
        /* Insertion du layout StackPane dans le Vbox :) */
        mainLayout.setSpacing(10);
        mainLayout.getChildren().addAll(play, regles, exit);
        mainLayout.setAlignment(Pos.CENTER);
        /* Lancement de la scène */
        mainWindow.setTitle("QUARTO");
        Scene scene = new Scene(mainLayout, 150, 150);
        // scene.getStylesheets().add("stylesheet.css"); //Associer la feuille de style au contenu de la fenêtre
        mainWindow.setScene(scene);
        mainWindow.show();
    }

    /* LANCE LE PROGRAMME */
    public static void main(String[] args) {
        launch();
    }
}