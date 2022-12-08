package com.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import javafx.application.Application;
import javafx.css.Rule;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        /* Création des layouts pour les boutons */
        StackPane s1 = new StackPane();
        VBox v1 = new VBox();
        /* Création des boutons */
        Button play = new Button("PLAY");
        Button regles = new Button("REGLES");
        Button exit = new Button("EXIT");
        /* Insertion des boutons */
        v1.getChildren().add(play);    

        v1.getChildren().add(regles);
        /* Chargement des regles dans une autre fenetre */
        regles.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                Label secondLabel = new Label("YEAH ZBI");
                
                StackPane secondaryLayout = new StackPane();
				secondaryLayout.getChildren().add(secondLabel);

				Scene secondScene = new Scene(secondaryLayout, 230, 100);

				// New window (Stage)
				Stage newWindow = new Stage();
				newWindow.setTitle("Second Stage");
				newWindow.setScene(secondScene);

                newWindow.initModality(Modality.WINDOW_MODAL);

                // Specifies the owner Window (parent) for new window
                newWindow.initOwner(stage);

                newWindow.show();
            }});    
        
        

        /* Bouton de sorti de l'application */
        v1.getChildren().add(exit);  
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Stage stage = (Stage) exit.getScene().getWindow();
                stage.close();
        }});

        /* Insertion du layout StackPane dans le Vbox :) */
        s1.getChildren().addAll(v1);
        /* Lancement de la scène */
        stage.setTitle("QUARTO");
        Scene scene = new Scene(s1, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    
    /* LANCE LE PROGRAMME */
    public static void main(String[] args) {
        launch();
    }

}