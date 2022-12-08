package com.example;


import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
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
        // regles.setOnAction(new EventHandler<ActionEvent>() {
        //     @Override
        //     public void handle(ActionEvent e) {
        //         InputStream regle = new FileInputStream("regle.txt");
        //         Scanner obj = new Scanner(regle);
        //         while (obj.hasNextLine()) {
        //         System.out.println("\n"+obj.nextLine()+"\n");
        //         }
        //     }});    
        
        

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