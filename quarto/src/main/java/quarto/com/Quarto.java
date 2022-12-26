package quarto.com;

import java.util.ArrayList;
import java.util.Scanner;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Quarto {
    


    public static Stage quartoWindow(Stage mainWindow){
        
        GridPane layout = new GridPane();

        double size = 100;

        /* Placement automatique mais non fonctionnel a reprendre plus tard */
        Button box = new Button(" ");
	    for(int i = 0; i < 4 ; i++){
            box = new Button(" ");  
            box.setPrefWidth(size);
            box.setPrefHeight(size);
            layout.addRow(0 , box);
            
            GridPane.setMargin(box, new Insets(10, 10, 10, 10));
        }
        for(int i = 0; i < 4 ; i++){
            box = new Button(" ");  
            box.setPrefWidth(size);
            box.setPrefHeight(size);    
            layout.addRow(1 , box);
            
            GridPane.setMargin(box, new Insets(10, 10, 10, 10));
        }
        for(int i = 0; i < 4 ; i++){
            box = new Button(" ");  
            box.setPrefWidth(size);
            box.setPrefHeight(size);
            layout.addRow(2 , box);

            GridPane.setMargin(box, new Insets(10, 10, 10, 10));
        }
        for(int i = 0; i < 4 ; i++){
            box = new Button(" ");  
            box.setPrefWidth(size);
            box.setPrefHeight(size);
            layout.addRow(3 , box);

            GridPane.setMargin(box, new Insets(10, 10, 10, 10));
        }

        layout.setAlignment(Pos.CENTER);
        GridPane.setHgrow(box, Priority.ALWAYS);

        // 'https://www.delftstack.com/fr/howto/java/javafx-square-button/'
        
        
        Scene secondScene = new Scene(layout, 640, 480);
        Stage playWindows = new Stage();
        playWindows.setTitle("QUARTO");
        playWindows.setScene(secondScene);
        
        return playWindows;
    }
}
