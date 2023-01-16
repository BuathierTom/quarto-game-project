package quarto.com;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;





public class Quarto {
    public static Stage quartoWindow(Stage mainWindow){
        
        BorderPane root = new BorderPane();
        GridPane board = new GridPane();
        board.setPadding(new Insets(10, 10, 10, 10));
        board.setVgap(8);
        board.setHgap(8);
        
        // Create buttons for the spaces on the board
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Button space = new Button();
                space.setPrefSize(50, 50);
                board.add(space, i, j);
            }
        }
        root.setCenter(board);

        // Create buttons for the pieces on the side
        VBox pieces = new VBox();
        pieces.setSpacing(8);
        pieces.setPadding(new Insets(10, 10, 10, 10));
        for (int i = 0; i < 16; i++) {
            Button piece = new Button();
            piece.setPrefSize(50, 50);
            pieces.getChildren().add(piece);
        }
        root.setRight(pieces);


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
