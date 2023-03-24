package quarto.com;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class WinWindow {

    public static Stage winWindow(String winner) {
        // Fenetre javafx avec bonjour ecrit dessus
        BorderPane centralLayout = new BorderPane();


        Scene sceneWindow = new Scene(centralLayout, 1400, 700);
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
