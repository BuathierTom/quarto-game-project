package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

        VBox v1 = new VBox();
        HBox h1 = new HBox();
        
        GridPane pane = new GridPane();

                
        Button play = new Button("PLAY");
        Button regles = new Button("REGLES");
        Button exit = new Button("EXIT");



        h1.getChildren().add(play);    
        h1.getChildren().add(regles);    
        h1.getChildren().add(exit);  


        v1.getChildren().addAll(h1);


        
        stage.setTitle("QUARTO");
        Scene scene = new Scene(v1, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    

    public static void main(String[] args) {
        launch();
    }

}