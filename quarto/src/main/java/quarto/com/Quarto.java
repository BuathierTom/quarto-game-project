package quarto.com;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.ContentDisplay;



public class Quarto {
    private static String pieceSignature = " ";
    public static Stage quartoWindow(Stage mainWindow){
        
        GridPane grid = new GridPane();
        VBox vBox = new VBox();
        BorderPane root = new BorderPane();

        // Listes de toutes les pièces du quarto
        List<Piece> pieces = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    for (int l = 0; l < 2; l++) {
                        pieces.add(new Piece(i == 1, j == 1, k == 1, l == 1));

                        
                    }
                }
            }
        }
        //On verifie en les printant
        System.out.println(pieces);
        // Pour toutes les pièces, on créé un boutons avec une signature
        for (Piece piece : pieces) {
            Button button = new Button(piece.toString());
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    pieceSignature = ((Button) event.getSource()).getText();
                }});
            vBox.getChildren().add(button);
            }
        // On créé une image pour chaque bouton
        // for (int i = 0; i < 4; i++) {
        //     for (int j = 0; j < 4; j++) {
        //         ImageView imageView = new ImageView();
        //         imageView.setFitWidth(50);
        //         imageView.setFitHeight(50);
        //         grid.add(imageView, i, j);
        //     }
        // }

        // Create buttons for the spaces on the board
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                Button space = new Button();
                space.setPrefSize(50, 50);

            
                // // imageView.setFitWidth(50);
                // imageView.setFitHeight(50);
                // imageView.setPreserveRatio(true);
                // space.setGraphic(imageView);
                // space.setContentDisplay(ContentDisplay.TOP);

                space.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    
                    public void handle(ActionEvent event) {
                        // ((Button) event.getSource()).setText(pieceSignature);
                        System.out.println(pieceSignature);

                        Image image = new Image(pieceSignature + ".png");
                        ImageView imageView = new ImageView(image);

                        imageView.setFitWidth(50);
                        imageView.setFitHeight(50);
                        space.setGraphic(imageView);
                    }
                });
                grid.add(space, i+1, j);
            }
        }
        root.setCenter(grid);
        root.setRight(vBox);

        /* Affichage de la scene : */
        Scene sceneWindow = new Scene(root, 1400, 700);
        Stage stageWindow = new Stage();
        /* Icone du jeu : */        
        stageWindow.getIcons().add(new Image("https://media.istockphoto.com/id/1171091296/vector/yellow-lines-geometric-vector-logo-letter-q.jpg?s=612x612&w=0&k=20&c=dHYiRhou9QfBogpOeHVgermyBixNl7dXYs6_ozrl69I="));
        stageWindow.setTitle("QUARTO");
        stageWindow.setScene(sceneWindow);
        
        return stageWindow;
    }
}
