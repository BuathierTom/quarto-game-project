package quarto.com;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Quarto {
    
    public static Stage quartoWindow(Stage mainWindow){
        
        GridPane layout = new GridPane();

        









            
        Scene secondScene = new Scene(layout, 640, 480);
        Stage playWindows = new Stage();
        playWindows.setTitle("QUARTO");
        playWindows.setScene(secondScene);
        
        return playWindows;
    }
}
