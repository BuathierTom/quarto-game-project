package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage mainWindow) {
        /* Création des layouts pour les boutons */
        BorderPane b1 = new BorderPane();
        VBox v1 = new VBox();
        /* Création des boutons */
        Button play = new Button("PLAY");
        Button regles = new Button("REGLES");
        Button exit = new Button("EXIT");
        /* Insertion des boutons */
        // v1.getChildren().add(play);
        v1.setSpacing(10);
        v1.setPadding(new Insets(10,10,10,10));

        /* Chargement des regles dans une autre fenetre */
        // v1.getChildren().add(regles);
        regles.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Stage windowRules = Rules.windowRules(mainWindow);
                windowRules.show();
            }});    
        
        /* Bouton de exit de l'application */
        // v1.getChildren().add(exit);  
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Stage stage = (Stage) exit.getScene().getWindow();
                stage.close();
        }});

        /* Insertion du layout StackPane dans le Vbox :) */
        v1.getChildren().addAll(play, regles, exit);
        /* Lancement de la scène */
        mainWindow.setTitle("QUARTO");
        Scene scene = new Scene(v1, 640, 480);
        mainWindow.setScene(scene);
        mainWindow.show();
    }

    /* LANCE LE PROGRAMME */
    public static void main(String[] args) {
        launch();
    }
}