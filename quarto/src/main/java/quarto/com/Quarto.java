package quarto.com;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import javafx.stage.Stage;

import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;



public class Quarto {
    


    public static Stage quartoWindow(Stage mainWindow){
        
        GridPane layout = new GridPane();

        double size = 100;

        /* Placement automatique mais non fonctionnel a reprendre plus tard */
        
        final Button box = new Button(" ");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                box.setPrefWidth(size);
                box.setPrefHeight(size);
                layout.add(box, j, i);
                GridPane.setMargin(box, new Insets(10, 10, 10, 10));
            }
        }


        layout.setAlignment(Pos.CENTER);
        GridPane.setHgrow(box, Priority.ALWAYS);

        /* Ajout d'un d'un drag and click */

        Button sourceButton = new Button("Bouton source");

        sourceButton.setOnDragDetected(event -> {
            /* Démarrez le processus de drag and drop en créant un objet Dragboard
            et en y ajoutant les données à transférer. Vous pouvez utiliser la
            méthode setDragView() pour définir une image à afficher pendant le
            drag and drop. */
            Dragboard dragboard = sourceButton.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();
            content.putString(sourceButton.getText());
            dragboard.setContent(content);
        });
        
        box.setOnDragOver(event -> {
            // Autorisez le drop si l'élément source est compatible avec le mode de transfert MOVE
            
            if (event.getGestureSource() != box && event.getDragboard().hasString()) {
                event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
        });

        box.setOnDragDropped(event -> {
            // Récupérez les données depuis le Dragboard et mettez à jour le bouton cible
            Dragboard dragboard = event.getDragboard();
            boolean success = false;
            if (dragboard.hasString()) {
                box.setText(dragboard.getString());
                success = true;
            }
            event.setDropCompleted(success);
            event.consume();
        });

        layout.getChildren().addAll(sourceButton, box);

        /* Affichage de la scene : */
        Scene secondScene = new Scene(layout, 640, 480);
        Stage playWindows = new Stage();
        /* Icone du jeu : */        
        playWindows.getIcons().add(new Image("https://media.istockphoto.com/id/1171091296/vector/yellow-lines-geometric-vector-logo-letter-q.jpg?s=612x612&w=0&k=20&c=dHYiRhou9QfBogpOeHVgermyBixNl7dXYs6_ozrl69I="));
        playWindows.setTitle("QUARTO");
        playWindows.setScene(secondScene);
        
        return playWindows;
    }
}
