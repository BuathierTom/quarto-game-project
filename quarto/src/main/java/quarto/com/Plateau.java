package quarto.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class Plateau {
    private static String pieceSignature = " ";
    private static Piece[][] board;


    public static Stage quartoWindow(Stage mainWindow){

        List<Button> buttons = new ArrayList<>();
        board = new Piece[4][4];
        
        GridPane grid = new GridPane();
        VBox vBox = new VBox();
        ScrollPane scroll = new ScrollPane();
        BorderPane centralLayout = new BorderPane();

        grid.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);
        // Listes de toutes les pièces du quarto
        List<Piece> pieces = new ArrayList<>();
        List<Boolean> verfiBool = Arrays.asList(false, true);

        for (Boolean estRond : verfiBool) {
            for (Boolean estPetit : verfiBool) {
                for (Boolean estCreux : verfiBool) {
                    for (Boolean estBlanc : verfiBool) {
                        pieces.add(new Piece(estRond, estPetit, estCreux, estBlanc));
            }}
        }}

        //On verifie en les printant
        System.out.println(pieces);
        // Pour toutes les pièces, on créé un boutons avec une signature
        for (Piece piece : pieces) {

            Image img = new Image(piece.toString() + ".png");
            ImageView imgView = new ImageView(img);
            imgView.setFitWidth(100);
            imgView.setFitHeight(100);
            

            Button button = new Button(piece.toString());
            buttons.add(button);

            button.setGraphic(imgView);

            button.setPadding(new Insets(10, 20, 10, 10));
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    pieceSignature = ((Button) event.getSource()).getText();
                }});
            vBox.getChildren().add(button);
            }
        scroll.setContent(vBox);



        // Create buttons for the spaces on the board
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                Button space = new Button();
                space.setPrefSize(100, 100);
                GridPane.setMargin(space, new Insets(10, 10, 10, 10));
                space.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        System.out.println(pieceSignature);
                        // Images des pieces une fois cliquer sur le plateau
                        Image image = new Image(pieceSignature + ".png");
                        ImageView imageView = new ImageView(image);
                        imageView.setFitWidth(100);
                        imageView.setFitHeight(100);
                        space.setGraphic(imageView);

                        // On supprime le button séléctionner pour pas pouvoir le reposer
                        int index = -1;
                        for (int i = 0; i < buttons.size(); i++) {
                            if (buttons.get(i).getText().equals(pieceSignature)) {
                                index = i;
                                break;
                            }
                        }
                        if (index != -1) {
                            buttons.get(index).setVisible(false);
                        }
                        pieceSignature = " ";
                    }
                });
                grid.add(space, i+1, j);
            }
        }
        
        // On place dans le centralLayout
        centralLayout.setCenter(grid);
        centralLayout.setRight(scroll);

        /* Ajout d'un fond d'écran */
        Image image = new Image("fond.jpg");
        BackgroundSize backgroundSize = new BackgroundSize(1400, 700, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        centralLayout.setBackground(background);

        centralLayout.setStyle("-fx-background-image: url('fond.jpg'); " +
        "-fx-background-size: cover; " +
        "-fx-background-repeat: no-repeat; " +
        "-fx-background-position: center;");

        /* Affichage de la scene : */
        Scene sceneWindow = new Scene(centralLayout, 1400, 700);
        Stage stageWindow = new Stage();
        /* Icone du jeu : */        
        stageWindow.getIcons().add(new Image("Q_Logo.jpg"));
        stageWindow.setTitle("QUARTO");
        stageWindow.setScene(sceneWindow);
        
        return stageWindow;
    }
}
