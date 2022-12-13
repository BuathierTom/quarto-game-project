package quarto;


import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Quarto {
    
    private Stage mainWindow;
    private static Scene scene;


    public Quarto(){
        this.mainWindow = new Stage();
    }

        //Constructeur par copie
    public Quarto(Quarto qua) { 
        this.mainWindow = qua.mainWindow;
    }
    
    public static Stage quartoWindow(Stage mainWindow) throws IOException{




        
        Scene secondScene = new Scene(loadFXML("yes"), 640, 480);
        Stage playWindows = new Stage();
        playWindows.setTitle("QUARTO");
        playWindows.setScene(secondScene);
        
        return playWindows;
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
}
