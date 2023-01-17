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
        Button play = new Button("PLAY");
        Button regles = new Button("REGLES");
        Button exit = new Button("EXIT");
        /* Creation de la fenetre du jeu */
        play.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Stage playWindows;
                playWindows = Quarto.quartoWindow(mainWindow);
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
        /* Insertion des boutons */
        mainLayout.getChildren().addAll(play, regles, exit);
        mainLayout.setAlignment(Pos.CENTER);
        
        /* Icone du jeu : */        
        mainWindow.getIcons().add(new Image("https://media.istockphoto.com/id/1171091296/vector/yellow-lines-geometric-vector-logo-letter-q.jpg?s=612x612&w=0&k=20&c=dHYiRhou9QfBogpOeHVgermyBixNl7dXYs6_ozrl69I="));
        /* Lancement de la scène */
        mainWindow.setTitle("QUARTO");
        Scene scene = new Scene(mainLayout, 150, 150);
        mainWindow.setScene(scene);
        mainWindow.show();
    }

    /* LANCE LE PROGRAMME */
    public static void startQUARTO(String[] args) {
        Menu.launch(args);
    }
}