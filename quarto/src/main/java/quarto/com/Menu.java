package quarto.com;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;

/**
 * JavaFX App
 */
public class Menu extends Application {

    @Override
    public void start(Stage mainWindow) {
        /* Création des layouts pour les boutons */
        VBox mainLayout = new VBox();
        /* Création des boutons */
        Button play_solo = new Button("PLAY SOLO");
        Button play_IA = new Button("PLAY IA");
        Button regles = new Button("REGLES");
        Button exit = new Button("EXIT");
        /* Creation de la fenetre du jeu */
        play_solo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Stage playWindows;
                playWindows = SoloGame.quartoWindow(mainWindow);
                playWindows.show();
                Stage stage = (Stage) play_solo.getScene().getWindow();
                stage.close();
        }});

        play_IA.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Stage playWindows;
                playWindows = IAGame.quartoWindow(mainWindow);
                playWindows.show();
                Stage stage = (Stage) play_IA.getScene().getWindow();
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
        /* Insertion des boutons */
        mainLayout.getChildren().addAll(play_solo, play_IA, regles, exit);
        mainLayout.setAlignment(Pos.CENTER);
        /* Icone du jeu : */        
        mainWindow.getIcons().add(new Image("Q_Logo.jpg"));
        /* Lancement de la scène */
        mainWindow.setTitle("QUARTO");
        Scene scene = new Scene(mainLayout, 150, 150);
        mainWindow.setScene(scene);
        mainWindow.show();
    }

    /**
     * Lance le programme
     * @param args
     */
    public static void startQUARTO(String[] args) {
        Menu.launch(args);
    }
}