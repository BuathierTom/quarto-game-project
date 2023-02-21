package quarto.com;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImagePion {

    /**
     * Méthode qui va placer les images sur la grille de boutons
     * @param pieceSignature Signature de la pièce utilisé
     * @param buttonGrille La grille de boutons utlisé
     * @return La grille avec l'image dedans
     */
    public static Button placeImage(String pieceSignature, Button buttonGrille){
        Image image = new Image(pieceSignature + ".png");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(75);
        imageView.setFitHeight(75);
        buttonGrille.setGraphic(imageView);

        return buttonGrille;
    }
}
