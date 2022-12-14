package quarto.com;

import java.util.ArrayList;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Quarto {
    

    public static Stage quartoWindow(Stage mainWindow){
        
        GridPane layout = new GridPane();
        HBox a = new HBox();
        HBox b = new HBox();
        HBox c = new HBox();
        HBox d = new HBox();


        /* Placement automatique mais non fonctionnel a reprendre plus tard */
        // Button grille = new Button(" ");
        // ArrayList<Button> grilleCompleted = new ArrayList<>() ;
        // for(int i = 0 ; i < 4 ; i++)
	    //     for(int j = 0; j < 4 ; j++){
        //         grille = new Button("A" + i);
        //         grilleCompleted.add(grille);
        //         for (Button button : grilleCompleted) {
        //             for(int z = 0 ; z < 4 ; z++){
        //                 a.getChildren().addAll(button);
        //                 layout.addRow(z , a);
        //             }
        //         }
        // }
        /* Placemment deguelasse mais fonctionnel */
        
        Button a1 = new Button("A1");
        Button a2 = new Button("A2");
        Button a3 = new Button("A3");
        Button a4 = new Button("A4");
        
        a.getChildren().addAll(a1, a2, a3, a4);

        Button b1 = new Button("B1");
        Button b2 = new Button("B2");
        Button b3 = new Button("B3");
        Button b4 = new Button("B4");

        b.getChildren().addAll(b1, b2, b3, b4);

        Button c1 = new Button("C1");
        Button c2 = new Button("C2");
        Button c3 = new Button("C3");
        Button c4 = new Button("C4");   

        c.getChildren().addAll(c1, c2, c3, c4);

        Button d1 = new Button("D1");
        Button d2 = new Button("D2");
        Button d3 = new Button("D3");
        Button d4 = new Button("D4");

        d.getChildren().addAll(d1, d2, d3, d4);


        //Ajout des boutons au GridPane        
        layout.addRow(0 , a);
        layout.addRow(1 , b);
        layout.addRow(2 , c);
        layout.addRow(3 , d);



        
                    
        Scene secondScene = new Scene(layout, 640, 480);
        Stage playWindows = new Stage();
        playWindows.setTitle("QUARTO");
        playWindows.setScene(secondScene);
        
        return playWindows;
    }
}
