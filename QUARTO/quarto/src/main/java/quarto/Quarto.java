package quarto;


import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Quarto {
    
    private Stage mainWindow;

    public Quarto(){
        this.mainWindow = new Stage();
    }

        //Constructeur par copie
    public Quarto(Quarto qua) { 
        this.mainWindow = qua.mainWindow;
    }
    
    public static Stage quartoWindow(Stage mainWindow){

        VBox layout = new VBox();

        











        Scene secondScene = new Scene(layout, 920, 740);
        Stage playWindows = new Stage();
        playWindows.setTitle("QUARTO");
        playWindows.setScene(secondScene);
        
        return playWindows;
    }
}
