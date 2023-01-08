package quarto.com;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import javafx.stage.Stage;





public class Quarto {
    


    public static Stage quartoWindow(Stage mainWindow){
        
        GridPane layout = new GridPane();

        
        


        /* Affichage de la scene : */
        Scene sceneWindow = new Scene(layout, 640, 480);
        Stage stageWindow = new Stage();
        /* Icone du jeu : */        
        stageWindow.getIcons().add(new Image("https://media.istockphoto.com/id/1171091296/vector/yellow-lines-geometric-vector-logo-letter-q.jpg?s=612x612&w=0&k=20&c=dHYiRhou9QfBogpOeHVgermyBixNl7dXYs6_ozrl69I="));
        stageWindow.setTitle("QUARTO");
        stageWindow.setScene(sceneWindow);
        
        return stageWindow;
    }
}
